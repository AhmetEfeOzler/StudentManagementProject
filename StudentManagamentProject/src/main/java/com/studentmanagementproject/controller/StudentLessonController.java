package com.studentmanagementproject.controller;

import com.studentmanagementproject.model.request.CreateStudentLessonRequest;
import com.studentmanagementproject.service.StudentLessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/student-lessons")
public class StudentLessonController {

    private final StudentLessonService studentLessonService;

    public StudentLessonController(StudentLessonService studentLessonService) {
        this.studentLessonService = studentLessonService;
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollStudentInLesson(@RequestBody CreateStudentLessonRequest request) {
        try {
            studentLessonService.enrollStudentInLesson(request);
            return new ResponseEntity<>("Student successfully enrolled in the lesson!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/unenroll")
    public ResponseEntity<String> unenrollStudentFromLesson(@RequestBody CreateStudentLessonRequest request) {
        try {
            studentLessonService.unenrollStudentFromLesson(request);
            return new ResponseEntity<>("Student's enrollment in the lesson was successfully deleted!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.OK);
        }
    }
}
