package com.cad_escolar.services;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.cad_escolar.models.Aluno;
import com.cad_escolar.models.Turma;
//import com.cad_escolar.repositories.AlunoRepository;
import com.cad_escolar.repositories.TurmaRepository;
import com.cad_escolar.services.exceptions.DataBindingViolationException;
import com.cad_escolar.services.exceptions.ObjectNotFoundException;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    //@Autowired
    //private AlunoRepository alunoRepository;

    public Turma findById(Long id){
        Turma turma = this.turmaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Turma não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()
        ));

        return turma;
    }

    public List<Turma> findAll(){
        
        List<Turma> turmas = this.turmaRepository.findAll();
        return turmas;
    }

    @Transactional
    public Turma create(Turma obj) {

        /*List<Aluno> alunos = obj.getAlunos();
        for (Aluno aluno : alunos) {
            aluno.setTurma(obj);
            this.alunoRepository.save(aluno);
        }
        */
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
