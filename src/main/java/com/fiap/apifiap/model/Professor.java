package com.fiap.apifiap.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "professor", sequenceName = "SQ_PROFESSOR", allocationSize = 1)
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professor")
    private int codigo;

    @NotBlank(message = "Nome obrigatório!")
    @Size(max = 40)
    private String nome;

    @NotBlank(message = "Curso obrigatório")
    @Size(max = 15)
    private String curso;

    @Size(max = 15)
    private String telefone;

    @Size(max = 50)
    private String email;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
