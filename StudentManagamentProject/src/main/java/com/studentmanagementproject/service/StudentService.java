package com.studentmanagementproject.service;

import com.studentmanagementproject.model.Student;
import com.studentmanagementproject.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student newStudent) {
        if (newStudent.getAge() < 18) {
            throw new IllegalArgumentException("Öğrenci 18 yaşından küçük olduğu için sisteme kaydedilemez.");
        }
        return studentRepository.save(newStudent);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Integer id) throws Exception {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new Exception("Öğrenci bulunamadı");
        }
        return student.get();
    }

    public void deleteById(Integer id) throws Exception {
        if (!studentRepository.existsById(id)) {
            throw new Exception("Öğrenci bulunamadı.");
        }
        studentRepository.deleteById(id);
    }

    public Student getStudentById(Integer studentId) throws Exception {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isEmpty()) {
            throw new Exception("Öğrenci bulunamadı");
        }
        return student.get();
    }

}
