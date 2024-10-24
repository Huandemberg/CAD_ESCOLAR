package com.cad_escolar.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cad_escolar.models.Aluno;
import com.cad_escolar.repositories.AlunoRepository;
import com.cad_escolar.services.exceptions.DataBindingViolationException;
import com.cad_escolar.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno findById(Long id){
        Aluno aluno = this.alunoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
            "Aluno não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()
            ));
        return aluno;   
    }

    @Transactional
    public Aluno create(Aluno obj) {
        obj.setId(null);
        obj = this.alunoRepository.save(obj);
        return obj;
    }

    @Transactional
    public Aluno update(Aluno obj) {

        Aluno newObj = findById(obj.getId());
        newObj.setDataNascimento(obj.getDataNascimento());
        newObj.setEmail(obj.getEmail());
        newObj.setNome(obj.getNome());
        newObj.setTurma(obj.getTurma());
        return this.alunoRepository.save(newObj);

    }

    public void delete(Long id) {

        findById(id);
        try {
            this.alunoRepository.deleteById(id);
        } catch(Exception e){
            throw new DataBindingViolationException("Não é possível excluir pois há entidades relacionadas!");
        }

    }
    

}
