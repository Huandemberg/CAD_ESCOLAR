package com.cad_escolar.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cad_escolar.models.Disciplina;
import com.cad_escolar.repositories.DisciplinaRepository;
import com.cad_escolar.services.exceptions.DataBindingViolationException;
import com.cad_escolar.services.exceptions.ObjectNotFoundException;

public class DisciplinaService {
    
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina findById(Long id) {
        Disciplina disciplina = this.disciplinaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
            "Disciplina não encontrada! Id: " + id + ", Tipo: " + Disciplina.class.getName()
        ));

        return disciplina;
    }

    @Transactional
    public Disciplina create(Disciplina obj) {
        obj.setId(null);
        obj = this.disciplinaRepository.save(obj);
        return obj;
    }

    @Transactional
    public Disciplina update(Disciplina obj) {
        Disciplina newObj = findById(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setCargaHoraria(obj.getCargaHoraria());
        newObj.setProfessor(obj.getProfessor());
        return this.disciplinaRepository.save(newObj);
    }

    public void delete(Long id) {
        
        findById(id);
        try{
            this.disciplinaRepository.deleteById(id);
        } catch(Exception e) {
            throw new DataBindingViolationException("Não é possivel excluir devido a entidades relacionadas!");
        }
 
    }

    


}
