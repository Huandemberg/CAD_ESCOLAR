package com.cad_escolar.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cad_escolar.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    
}
