package com.studentmanagementproject.controller;

import com.studentmanagementproject.model.Student;
import com.studentmanagementproject.model.request.CreateStudentRequest;
import com.studentmanagementproject.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody CreateStudentRequest request) throws IOException {
        Student student = new Student(

                request.getName(),
                request.getSurname(),
                request.getAge(),
                request.getMomName(),
                request.getDadName(),
                request.getAddress(),
                request.getGender(),
                request.getCredit(),
                request.getMajor(),
                request.getSchool()
        );
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() throws IOException {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(studentService.getById(Integer.valueOf(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        try {
            studentService.deleteById(Integer.valueOf(id));
            return new ResponseEntity<>("Öğrenci başarıyla silindi.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

