package com.cad_escolar.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = Aluno.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aluno extends Pessoa {

    public static final String TABLE_NAME = "aluno";
    
    @Column(name = "matricula", nullable = false, unique = true)
    @NotBlank
    private String matricula;

    @Column(name = "dataNasc", nullable = false)
    public LocalDate dataNascimento;

}
