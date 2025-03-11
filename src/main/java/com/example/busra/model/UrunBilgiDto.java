package com.example.busra.model;


import com.example.busra.base.BaseDto;
import com.example.busra.constant.MessageConstants;
import com.example.busra.entity.KullaniciBilgi;
import com.example.busra.entity.UrunBilgi;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class UrunBilgiDto extends BaseDto implements Serializable {

    private UUID id;
    private short durum;
    private Long versiyon;
    private UUID kullaniciBilgiId;
    @NotBlank(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    private String isim;
    @NotNull(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    private UUID urunTipiId;
    @Column(name = "adet")
    private int adet;

    @PositiveOrZero(message = MessageConstants.URUNTAKIP_POZITIF_DEGER)
    @NotNull(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    @Digits(integer = 18, fraction = 2)
    private BigDecimal fiyat;

}