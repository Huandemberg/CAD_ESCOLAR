package com.cad_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cad_escolar.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}
