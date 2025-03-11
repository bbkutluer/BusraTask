package com.example.busra.service.impl;

import com.example.busra.entity.KullaniciBilgi;
import com.example.busra.repository.KullaniciBilgiRepository;
import com.example.busra.service.KullaniciBilgiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service("kullaniciBilgiService")
@Transactional
@RequiredArgsConstructor
public class KullaniciBilgiServiceImpl implements KullaniciBilgiService {

     @Autowired
     KullaniciBilgiRepository kullaniciBilgiRepository;

    @Override
    @Transactional
    public KullaniciBilgi kullaniciKaydet(KullaniciBilgi kullaniciBilgi) {
        kullaniciBilgi.setDurum((short)1);
        return kullaniciBilgiRepository.save(kullaniciBilgi);
    }


@Transactional
@Override
public KullaniciBilgi kullaniciGuncelle(KullaniciBilgi kullaniciBilgi) {
    KullaniciBilgi mevcutKullanici = kullaniciBilgiRepository.findById(kullaniciBilgi.getId())
            .orElseThrow(() -> new RuntimeException("Kullanıcı Bulunamadı!"));

    mevcutKullanici.setAd(kullaniciBilgi.getAd());
    mevcutKullanici.setSoyad(kullaniciBilgi.getSoyad());
    mevcutKullanici.setAktifMi(kullaniciBilgi.getAktifMi());
    mevcutKullanici.setEposta(kullaniciBilgi.getEposta());
    mevcutKullanici.setCepTel(kullaniciBilgi.getCepTel());
    mevcutKullanici.setSifre(kullaniciBilgi.getSifre());

    return kullaniciBilgiRepository.save(mevcutKullanici);
}
    @Override
    public void kullaniciSil(UUID id) {
        KullaniciBilgi kullanici = kullaniciBilgiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kullanıcı Bulunamadı!"));

        kullanici.setDurum((short) 0); // 0: Pasif (Silinmiş)
        kullaniciBilgiRepository.save(kullanici);
    }
}
