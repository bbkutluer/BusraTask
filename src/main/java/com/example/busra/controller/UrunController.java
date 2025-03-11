package com.example.busra.controller;

import com.example.busra.constant.MessageConstants;
import com.example.busra.entity.UrunBilgi;
import com.example.busra.mapper.UrunBilgiMapper;
import com.example.busra.model.UrunBilgiDto;
import com.example.busra.service.UrunBilgiService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@Component
@Validated
@RequestMapping("/urunler")
public class UrunController {


    private final UrunBilgiService urunBilgiService;
    private final UrunBilgiMapper urunBilgiMapper;

    @Autowired
    public UrunController(UrunBilgiService urunBilgiService, UrunBilgiMapper urunBilgiMapper) {
        this.urunBilgiService = urunBilgiService;
        this.urunBilgiMapper = urunBilgiMapper;
    }
    @PostMapping("/save/{kullaniciBilgiId}")
    public ResponseEntity<Set<UrunBilgiDto>> kullaniciKaydet(@PathVariable @NotNull(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS) UUID kullaniciBilgiId,
                                                             @RequestBody Set<UrunBilgiDto> dtoSet) {
        Set<UrunBilgi> urunBilgiler = urunBilgiMapper.toEntitySet(dtoSet);
        Set<UrunBilgi> savedUrunBilgiler = urunBilgiService.urunKaydet(kullaniciBilgiId, urunBilgiler);
        return ResponseEntity.ok(urunBilgiMapper.toDtoSet(savedUrunBilgiler));
    }

    @PutMapping("/update")
    public ResponseEntity<UrunBilgiDto> urunGuncelle(@RequestBody UrunBilgiDto urunBilgiDto) {
        UrunBilgi urunBilgi = urunBilgiMapper.toEntity(urunBilgiDto);
        UrunBilgi guncellenmisUrun = urunBilgiService.urunGuncelle(urunBilgi);
        return ResponseEntity.ok(urunBilgiMapper.toDto(guncellenmisUrun));
    }

    @DeleteMapping("/delete/{urunId}")
    public ResponseEntity<String>  urunSil(@PathVariable UUID urunId) {
        urunBilgiService.urunSil(urunId);
        return ResponseEntity.ok("Urun başarıyla silindi.");
    }
    @GetMapping("/kullanici/{kullaniciBilgiId}")
    public ResponseEntity<Set<UrunBilgiDto>> kullaniciUrunleriniGetir(
            @PathVariable @NotNull(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS) UUID kullaniciBilgiId) {
        List<UrunBilgi> urunList = urunBilgiService.kullaniciUrunleriniGetir(kullaniciBilgiId);
        // Listeyi Set'e çevirerek döndürüyoruz
        return ResponseEntity.ok(urunBilgiMapper.toDtoSet(new HashSet<>(urunList)));
    }
}
