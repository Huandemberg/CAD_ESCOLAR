package com.cad_escolar.services;


import org.springframework.beans.factory.annotation.Autowired;

import com.cad_escolar.models.Aluno;
import com.cad_escolar.repositories.AlunoRepository;
import com.cad_escolar.services.exceptions.ObjectNotFoundException;

public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno findById(Long id){
        Aluno aluno = this.alunoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
            "Aluno não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()
            ));
        return aluno;   
    }

}
