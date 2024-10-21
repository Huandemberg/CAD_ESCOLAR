package com.cad_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cad_escolar.models.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    
}
