package com.p.d.repository;

import com.p.d.model.Divida;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DividaRepository extends JpaRepository<Divida, Long> {
    List<Divida> findByDocumento(String documento); // Método de busca pelo documento
}