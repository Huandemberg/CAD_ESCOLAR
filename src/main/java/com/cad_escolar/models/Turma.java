package com.cad_escolar.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Turma.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Turma {

    public static final String TABLE_NAME = "turma";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotBlank
    @Size(min = 5, max = 155)
    private String nome;

    @Column(name = "ano", nullable = false)
    private int ano;

    @ManyToMany
    @JoinColumn(name = "aluno_id", nullable = false, updatable = true)
    private List<Aluno> alunos;

    @ManyToMany
    @JoinColumn(name = "disciplina_id", nullable = false, updatable = true)
    private List<Disciplina> disciplinas;

}
