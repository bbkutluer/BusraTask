package com.example.busra.service.impl;

import com.example.busra.entity.UrunBilgi;
import com.example.busra.repository.KullaniciBilgiRepository;
import com.example.busra.repository.UrunBilgiRepository;
import com.example.busra.service.UrunBilgiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("urunBilgiService")
@Transactional
@RequiredArgsConstructor
public class UrunBilgiServiceImpl implements UrunBilgiService {

    @Autowired
    UrunBilgiRepository urunBilgiRepository;
    @Autowired
    private KullaniciBilgiRepository kullaniciBilgiRepository;

    @Override
    @Transactional
    public Set<UrunBilgi> urunKaydet(UUID kullaniciBilgiId, Set<UrunBilgi> urunBilgiler) {

        kullaniciVarMiKontrol(kullaniciBilgiId);

        // Kullanıcı ID'sini her ürüne set et
        urunBilgiler.forEach(urun -> {
            urun.setKullaniciBilgiId(kullaniciBilgiId);
            urun.setDurum((short) 1); // Durumu 1 olarak set et
        });

        // Set -> List dönüşümü
        List<UrunBilgi> urunBilgiList = new ArrayList<>(urunBilgiler);

        // `saveAll` çağrısı
        List<UrunBilgi> savedList = urunBilgiRepository.saveAll(urunBilgiList);

        // Sonucu tekrar Set olarak döndür
        return new HashSet<>(savedList);
    }

    @Override
    @Transactional
    public UrunBilgi urunGuncelle(UrunBilgi yeniUrunBilgi) {
        // Güncellenecek ürünü bul
        UrunBilgi mevcutUrun = urunBilgiRepository.findById(yeniUrunBilgi.getId())
                .orElseThrow(() -> new RuntimeException("Ürün Bulunamadı!"));

        // Alanları güncelle
        mevcutUrun.setIsim(yeniUrunBilgi.getIsim());
        mevcutUrun.setUrunTipiId(yeniUrunBilgi.getUrunTipiId());
        mevcutUrun.setAdet(yeniUrunBilgi.getAdet());
        mevcutUrun.setFiyat(yeniUrunBilgi.getFiyat());

        // Kaydet ve döndür
        return urunBilgiRepository.save(mevcutUrun);
    }

    @Override
    @Transactional
    public void urunSil(UUID urunId) {
        UrunBilgi urun = urunBilgiRepository.findById(urunId)
                .orElseThrow(() -> new RuntimeException("Ürün Bulunamadı!"));

        urun.setDurum((short) 0); // 0: Pasif (Silinmiş)
        urunBilgiRepository.save(urun);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UrunBilgi> kullaniciUrunleriniGetir(UUID kullaniciBilgiId) {
        return urunBilgiRepository.findByKullaniciBilgiIdAndDurum(kullaniciBilgiId, (short) 1);
    }

    protected void kullaniciVarMiKontrol(UUID kullaniciBilgiId) {
      kullaniciBilgiRepository.findById(kullaniciBilgiId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı Bulunamadı!"));
    }

}
