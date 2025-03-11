package com.example.busra.model;

import com.example.busra.base.BaseDto;
import com.example.busra.constant.MessageConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder(toBuilder = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class KullaniciBilgiDto extends BaseDto implements Serializable {

    private UUID id;
    private short durum;
    private Integer versiyon;

    @NotBlank(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    private String ad;

     @NotBlank(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    private String soyad;

     @NotNull(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    private Boolean aktifMi;

     @NotBlank(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    private String eposta;

     @NotBlank(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    private String cepTel;

    @NotBlank(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    private String sifre;
    @JsonIgnore
    private Set<UrunBilgiDto> urunBilgiler;

}