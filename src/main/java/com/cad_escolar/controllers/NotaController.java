package com.cad_escolar.controllers;

import java.net.URI;
import java.util.List;

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

import com.cad_escolar.models.Nota;
import com.cad_escolar.services.NotaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping("/{id}")
    public ResponseEntity<Nota> findById(@PathVariable Long id) {
        Nota obj = this.notaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/notas")
    public ResponseEntity<List<Nota>> findAllNotas() {
        List<Nota> objs = this.notaService.findAll();
        return ResponseEntity.ok().body(objs);
    }

    @GetMapping("/notas/{id}")
    public ResponseEntity<List<Nota>> findAllNotasAluno(@PathVariable Long id) {
        List<Nota> objs = this.notaService.findAllById(id);
        return ResponseEntity.ok().body(objs);
    }

    @PostMapping
    @Validated
    public ResponseEntity<Void> create(@Valid @RequestBody Nota obj) {

        Nota aluno = this.notaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<Void> update(@Valid @RequestBody Nota obj, @PathVariable Long id) {

        obj.setId(id);
        this.notaService.update(obj);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        this.notaService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
