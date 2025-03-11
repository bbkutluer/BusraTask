package com.example.busra.service;

import com.example.busra.entity.UrunBilgi;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UrunBilgiService {

    Set<UrunBilgi> urunKaydet(UUID kullaniciBilgiId, Set<UrunBilgi> urunBilgiler);
    UrunBilgi urunGuncelle(UrunBilgi yeniUrunBilgi);
    void urunSil(UUID urunId);
    List<UrunBilgi> kullaniciUrunleriniGetir(UUID kullaniciBilgiId);
}
