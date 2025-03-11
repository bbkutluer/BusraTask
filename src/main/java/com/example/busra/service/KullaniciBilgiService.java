package com.example.busra.service;

import com.example.busra.entity.KullaniciBilgi;
import com.example.busra.model.KullaniciBilgiDto;

import java.util.UUID;

public interface KullaniciBilgiService  {

    KullaniciBilgi kullaniciKaydet(KullaniciBilgi kullaniciBilgi);

//    KullaniciBilgi kullaniciGuncelle(KullaniciBilgiDto kullaniciBilgiDto);
    KullaniciBilgi kullaniciGuncelle(KullaniciBilgi kullaniciBilgi);

    void kullaniciSil(UUID id);

}
