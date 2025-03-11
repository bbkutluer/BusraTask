package com.example.busra.repository;

import com.example.busra.entity.UrunBilgi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
@Repository
@Component
public interface UrunBilgiRepository extends JpaRepository<UrunBilgi, UUID> {

   List<UrunBilgi> findByKullaniciBilgiIdAndDurum(UUID kullaniciBilgiId, short durum);
}
