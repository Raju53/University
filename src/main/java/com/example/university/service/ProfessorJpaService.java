package com.example.university.service;

import com.example.university.model.Professor;
import com.example.university.repository.ProfessorJpaRepository;
import com.example.university.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorJpaService implements ProfessorRepository {

    @Autowired
    private ProfessorJpaRepository professorJpaRepository;

    @Override
    public ArrayList<Professor> getProfessors() {
        List<Professor> professorsList = professorJpaRepository.findAll();
        ArrayList<Professor> professors = new ArrayList<>(professorsList);
        return professors;
    }

    @Override
    public Professor getProfessorById(int professorId) {
        try {
            return professorJpaRepository.findById(professorId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Professor addProfessor(Professor professor) {
        return professorJpaRepository.save(professor);
    }

    @Override
    public Professor updateProfessor(int professorId, Professor professor) {
        try {
            Professor newProfessor = professorJpaRepository.findById(professorId).get();
            if (professor.getProfessorName() != null) {
                newProfessor.setProfessorName(professor.getProfessorName());
            }
            if (professor.getDepartment() != null) {
                newProfessor.setDepartment(professor.getDepartment());
            }
            return professorJpaRepository.save(newProfessor);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteProfessor(int professorId) {
        try {
            professorJpaRepository.deleteById(professorId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}