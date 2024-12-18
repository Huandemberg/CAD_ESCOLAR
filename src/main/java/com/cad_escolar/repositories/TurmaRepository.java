package com.cad_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cad_escolar.models.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    
}
