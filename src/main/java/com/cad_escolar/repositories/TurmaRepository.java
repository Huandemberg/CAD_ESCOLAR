package com.cad_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cad_escolar.models.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    
}
