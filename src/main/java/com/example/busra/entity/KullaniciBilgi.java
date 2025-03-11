package com.example.busra.entity;

import com.example.busra.base.BaseEntity;
import com.example.busra.constant.MessageConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Table(name = "kullanici_bilgi")
@NoArgsConstructor
public class KullaniciBilgi extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id; // ✅ Artık tüm entity'ler ID'yi BaseEntity'den alacak.

    // ✅ ENUM olarak kaydediyoruz (VARCHAR olarak saklanır)
    @Column(name = "durum", nullable = false)
    private short durum = 1;// Varsayılan olarak AKTIF atanıyor.

    @Version
    @Column(name = "versiyon")
    private Integer versiyon; // Hibernate tarafından otomatik artırılır.

    @NotBlank(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    @Column(name = "ad", length = 50, nullable = false)
    private String ad;

    @NotBlank(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    @Column(name = "soyad", length = 50, nullable = false)
    private String soyad;

    @NotNull(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    @Column(name = "aktif_mi", nullable = false)
    private Boolean aktifMi;

    @NotBlank(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    @Column(name = "eposta", length = 256, nullable = false)
    private String eposta;

    @NotBlank(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    @Column(name = "cep_tel", length = 11, nullable = false)
    private String cepTel;

    @NotBlank(message = MessageConstants.URUNTAKIP_ANAHTAR_BOS)
    @Column(name = "sifre", length = 11, nullable = false)
    private String sifre;

     @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
     @JoinColumn(name = "kullanici_bilgi_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
     private Set<UrunBilgi> urunBilgiler;

    public KullaniciBilgi(UUID id, short durum,Integer versiyon, String ad, String soyad,
                          Boolean aktifMi, String eposta, String cepTel, String sifre) {
        this.id = id;
        this.durum = durum;
        this.versiyon = versiyon;
        this.ad = ad;
        this.soyad = soyad;
        this.aktifMi = aktifMi;
        this.eposta = eposta;
        this.cepTel = cepTel;
        this.sifre = sifre;
    }
}
