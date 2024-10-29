package com.cad_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cad_escolar.models.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    
}
