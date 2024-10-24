package com.cad_escolar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cad_escolar.models.Turma;
import com.cad_escolar.repositories.TurmaRepository;
import com.cad_escolar.services.exceptions.DataBindingViolationException;
import com.cad_escolar.services.exceptions.ObjectNotFoundException;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma findById(Long id){
        Turma turma = this.turmaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Turma não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()
        ));

        return turma;
    }

    @Transactional
    public Turma create(Turma obj) {

        obj.setId(null);
        obj = this.turmaRepository.save(obj);
        return obj;

    }

    @Transactional
    public Turma update(Turma obj){

        Turma newObj = findById(obj.getId());
        newObj.setAlunos(obj.getAlunos());;
        newObj.setAno(obj.getAno());
        newObj.setDisciplinas(obj.getDisciplinas());
        newObj.setNome(obj.getNome());
        return this.turmaRepository.save(newObj);

    }

    public void delete(Long id){
        findById(id);
        try {
            this.turmaRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataBindingViolationException("Não é possível excluir devido a entidades relacionadas");
        }
    }
    
}
