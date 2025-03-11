package com.example.busra.mapper;

import com.example.busra.entity.KullaniciBilgi;
import com.example.busra.model.KullaniciBilgiDto;
import org.springframework.stereotype.Component;

@Component
public class KullaniciBilgiDtoMapper {

    // Entity'den DTO'ya dönüşüm
    public KullaniciBilgiDto toDto(KullaniciBilgi kullaniciBilgi) {
        KullaniciBilgiDto dto = new KullaniciBilgiDto();
        dto.setId(kullaniciBilgi.getId());
        dto.setDurum(kullaniciBilgi.getDurum());
        dto.setVersiyon(kullaniciBilgi.getVersiyon());
        dto.setAd(kullaniciBilgi.getAd());
        dto.setSoyad(kullaniciBilgi.getSoyad());
        dto.setAktifMi(kullaniciBilgi.getAktifMi());
        dto.setEposta(kullaniciBilgi.getEposta());
        dto.setCepTel(kullaniciBilgi.getCepTel());
        dto.setSifre(kullaniciBilgi.getSifre());
        return dto;
    }

    // DTO'dan Entity'ye dönüşüm
    public KullaniciBilgi toEntity(KullaniciBilgiDto dto) {
        KullaniciBilgi entity = new KullaniciBilgi();
        entity.setId(dto.getId());
        entity.setDurum(dto.getDurum());
        entity.setVersiyon(dto.getVersiyon());
        entity.setAd(dto.getAd());
        entity.setSoyad(dto.getSoyad());
        entity.setAktifMi(dto.getAktifMi());
        entity.setEposta(dto.getEposta());
        entity.setCepTel(dto.getCepTel());
        entity.setSifre(dto.getSifre());
        return entity;
    }
}
