package com.example.busra.repository;

import com.example.busra.entity.KullaniciBilgi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Component
public interface KullaniciBilgiRepository extends CrudRepository<KullaniciBilgi, UUID>
{
    @Query("SELECT new KullaniciBilgi(k.id, k.durum, k.versiyon, k.ad, k.soyad, k.aktifMi, k.eposta, k.cepTel, k.sifre) FROM KullaniciBilgi k WHERE k.id = :id")
    Optional<KullaniciBilgi> findByIdWithoutUrunBilgiler(@Param("id") UUID id);
}
