package com.cad_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cad_escolar.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}
