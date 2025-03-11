package com.example.busra.entity;


import com.example.busra.base.BaseEntity;
import com.example.busra.constant.MessageConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "urun_bilgi")
public class UrunBilgi extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id; // ✅ Artık tüm entity'ler ID'yi BaseEntity'den alacak.

    // ✅ ENUM olarak kaydediyoruz (VARCHAR olarak saklanır)
    @Column(name = "durum", nullable = false)
    private short durum = 1;// Varsayılan olarak AKTIF atanıyor.

    @Version
    @Column(name = "versiyon")
    private Long versiyon; // Hibernate tarafından otomatik artırılır.

    @Column(name = "kullanici_bilgi_id", nullable = false)
    private UUID kullaniciBilgiId;

    @NotBlank(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    @Column(name = "isim", length = 50, nullable = false)
    private String isim;
    @NotNull(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    @Column(name = "urun_tipi_id", nullable = false)
    private UUID urunTipiId;

    @Column(name = "adet")
    private int adet;

    @PositiveOrZero(message = MessageConstants.URUNTAKIP_POZITIF_DEGER)
    @NotNull(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    @Digits(integer = 18, fraction = 2)
    @Column(name = "fiyat", precision = 18, scale = 2, nullable = false)
    private BigDecimal fiyat;

}

