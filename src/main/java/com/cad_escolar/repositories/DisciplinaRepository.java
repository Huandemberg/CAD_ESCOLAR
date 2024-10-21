package com.cad_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cad_escolar.models.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    
    
}
