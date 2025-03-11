package com.example.busra.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {

    @CreationTimestamp
    @Column(name = "olusturulma_zamani", updatable = false)
    private LocalDateTime olusturulmaZamani; // Otomatik oluşturulma zamanı

    @UpdateTimestamp
    @Column(name = "guncellenme_zamani")
    private LocalDateTime guncellenmeZamani; // Otomatik güncelleme zamanı

    @Column(name = "olusturan_kullanici", updatable = false)
    private String olusturanKullanici; // Kaydı oluşturan kullanıcı

    @Column(name = "guncelleyen_kullanici")
    private String guncelleyenKullanici; // Kaydı güncelleyen kullanıcı

    @PrePersist
    protected void onCreate() {
        this.olusturanKullanici = "Büşra Varışlı"; // Varsayılan kullanıcı
        this.guncelleyenKullanici = "Büşra Varışlı";
    }

    @PreUpdate
    protected void onUpdate() {
        this.guncelleyenKullanici = "Büşra Varışlı";
    }

}