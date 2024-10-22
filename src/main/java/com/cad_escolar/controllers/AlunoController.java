package com.cad_escolar.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cad_escolar.models.Aluno;
import com.cad_escolar.services.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
 
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/id")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        Aluno obj = this.alunoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Validated
    public ResponseEntity<Void> create(@Valid @RequestBody Aluno obj) {

        Aluno aluno = this.alunoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<Void> update(@Valid @RequestBody Aluno obj, @PathVariable Long id) {

        obj.setId(id);
        this.alunoService.update(obj);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        
        this.alunoService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
