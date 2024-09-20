package com.studentmanagementproject.service;

import com.studentmanagementproject.model.Grade;
import com.studentmanagementproject.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade getGradeById(Long id) {
        return gradeRepository.findById(id).orElse(null);
    }

    public Grade addGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Long id, Grade updatedGrade) {
        Optional<Grade> existingGrade = gradeRepository.findById(id);
        if (existingGrade.isPresent()) {
            Grade grade = existingGrade.get();
            grade.setGrade(updatedGrade.getGrade());
            grade.setDate(updatedGrade.getDate());
            return gradeRepository.save(grade);
        } else {
            return null;
        }
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
