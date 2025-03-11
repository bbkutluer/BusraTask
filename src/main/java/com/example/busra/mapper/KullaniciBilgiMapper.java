package com.example.busra.mapper;

import com.example.busra.entity.KullaniciBilgi;
import com.example.busra.model.KullaniciBilgiDto;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface KullaniciBilgiMapper {

   // KullaniciBilgiMapper INSTANCE = Mappers.getMapper(KullaniciBilgiMapper.class);

    KullaniciBilgiDto fromKullaniciBilgi(KullaniciBilgi entity);

    @InheritInverseConfiguration
    KullaniciBilgi toKullaniciBilgi(KullaniciBilgiDto dto);

}