package com.example.busra.controller;

import com.example.busra.entity.KullaniciBilgi;
import com.example.busra.mapper.KullaniciBilgiDtoMapper;
import com.example.busra.mapper.KullaniciBilgiMapper;
import com.example.busra.model.KullaniciBilgiDto;
import com.example.busra.service.KullaniciBilgiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Component
@RequestMapping("/kullanicilar")
public class KullaniciController {


    private final KullaniciBilgiService kullaniciBilgiService;
    private final KullaniciBilgiMapper kullaniciBilgiMapper;
    private final KullaniciBilgiDtoMapper kullaniciBilgiDtoMapper;

    @Autowired
    public KullaniciController(KullaniciBilgiService kullaniciBilgiService, KullaniciBilgiMapper kullaniciBilgiMapper,KullaniciBilgiDtoMapper kullaniciBilgiDtoMapper) {
        this.kullaniciBilgiService = kullaniciBilgiService;
        this.kullaniciBilgiMapper = kullaniciBilgiMapper;
        this.kullaniciBilgiDtoMapper=kullaniciBilgiDtoMapper;
    }
    @PostMapping("/save")
    public ResponseEntity<KullaniciBilgiDto> kullaniciKaydet(@RequestBody KullaniciBilgiDto kullaniciBilgiDto) {
        KullaniciBilgi mappedKullaniciBilgi = kullaniciBilgiMapper.toKullaniciBilgi(kullaniciBilgiDto);
        KullaniciBilgi savedKullanici = kullaniciBilgiService.kullaniciKaydet(mappedKullaniciBilgi);
        KullaniciBilgiDto resultDto = kullaniciBilgiMapper.fromKullaniciBilgi(savedKullanici);
        return ResponseEntity.ok(resultDto);
    }

@PutMapping("/update")
public ResponseEntity<KullaniciBilgiDto> kullaniciGuncelle(@RequestBody KullaniciBilgiDto kullaniciBilgiDto) {
    KullaniciBilgi kullaniciBilgiEntity = kullaniciBilgiDtoMapper.toEntity(kullaniciBilgiDto);
    KullaniciBilgi updatedKullanici = kullaniciBilgiService.kullaniciGuncelle(kullaniciBilgiEntity);
    KullaniciBilgiDto resultDto = kullaniciBilgiDtoMapper.toDto(updatedKullanici);
    return ResponseEntity.ok(resultDto);
}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> kullaniciSil(@PathVariable UUID id) {
        kullaniciBilgiService.kullaniciSil(id);
        return ResponseEntity.ok("Kullanıcı başarıyla silindi.");
    }

}
