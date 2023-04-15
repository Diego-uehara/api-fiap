package com.fiap.apifiap.repository;

import com.fiap.apifiap.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    List<Professor> findByNome(String prof);
    List<Professor> findByCurso(String curs);
    List<Professor> findByNomeAndCurso(String prof, String curs);
}
