package com.fiap.apifiap.controller;

import com.fiap.apifiap.model.Professor;
import com.fiap.apifiap.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("professor")
public class ProfessorResource {
    @Autowired
    private ProfessorRepository professorRepository;
    @GetMapping
    public List<Professor> listar() {
        return professorRepository.findAll();
    }
    @GetMapping("{codigo}")
    public Professor buscar(@PathVariable int codigo) {
        return professorRepository.findById(codigo).get();
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Professor cadastrat(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }
    @PutMapping("{id}")
    public Professor atualizar(@RequestBody Professor professor, @PathVariable int id) {
        professor.setCodigo(id);
        return professorRepository.save(professor);
    }
    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo) {
        professorRepository.deleteById(codigo);
    }
    @GetMapping("pesquisa")
    public List<Professor> buscar(@RequestParam(required = false)String nome, @RequestParam(defaultValue = "false") String curso) {
        return nome != null ? professorRepository.findByNomeAndCurso(nome, curso) : professorRepository.findByCurso(curso);
    }
}

