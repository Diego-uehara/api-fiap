package com.fiap.apifiap.controller;

import javax.validation.Valid;

import com.fiap.apifiap.model.Professor;
import com.fiap.apifiap.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("professor")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("cadastrar")
    public String abrirFormulario(Professor professor, Model model){
        model.addAttribute("professores", professorRepository.findAll());
        return "professor/form";
    }

    @PostMapping("cadastrar")
    public String processarForm(@Valid Professor professor, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()) {
            return "professor/form";
        }

        redirectAttributes.addFlashAttribute("msg", "Cadastrado!");
        professorRepository.save(professor);
        return "redirect:listar";
    }



    @GetMapping("listar")
    public String listarProfessores(Model model){
        model.addAttribute("professores", professorRepository.findAll());
        return "professor/lista";
    }



    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("professor",professorRepository.findById(codigo));
        return "professor/form";
    }



    @PostMapping("excluir")
    public String remover(int codigo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Removido!");
        professorRepository.deleteById(codigo);
        return "redirect:listar";
    }

}
