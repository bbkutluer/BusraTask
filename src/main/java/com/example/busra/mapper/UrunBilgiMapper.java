package com.example.busra.mapper;

import com.example.busra.entity.UrunBilgi;
import com.example.busra.model.UrunBilgiDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UrunBilgiMapper {

    //UrunBilgiMapper INSTANCE = Mappers.getMapper(UrunBilgiMapper.class);

    UrunBilgiDto toDto(UrunBilgi urunBilgi);

    UrunBilgi toEntity(UrunBilgiDto dto);

    default Set<UrunBilgiDto> toDtoSet(Set<UrunBilgi> entitySet) {
        return entitySet.stream().map(this::toDto).collect(Collectors.toSet());
    }

    default Set<UrunBilgi> toEntitySet(Set<UrunBilgiDto> dtoSet) {
        return dtoSet.stream().map(this::toEntity).collect(Collectors.toSet());
    }
}