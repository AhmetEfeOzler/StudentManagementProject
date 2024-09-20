package com.studentmanagementproject.service;

import com.studentmanagementproject.model.StudentLesson;
import com.studentmanagementproject.model.Student;
import com.studentmanagementproject.model.Lesson;
import com.studentmanagementproject.model.request.CreateStudentLessonRequest;
import com.studentmanagementproject.repository.StudentLessonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentLessonService {

    private final StudentLessonRepository studentLessonRepository;
    private final StudentService studentService;
    private final LessonService lessonService;

    public StudentLessonService(StudentLessonRepository studentLessonRepository, StudentService studentService, LessonService lessonService) {
        this.studentLessonRepository = studentLessonRepository;
        this.studentService = studentService;
        this.lessonService = lessonService;
    }

    public void enrollStudentInLesson(CreateStudentLessonRequest request) throws Exception {

        // Öğrenci var mı kontrol et, yoksa hata fırlat
        Student student = studentService.getStudentById(request.getStudentId());
        if (student == null) {
            throw new IllegalStateException("Böyle bir öğrenci yok.");
        }

        Lesson lesson = lessonService.getLessonById(request.getLessonId());

        if (studentLessonRepository.existsByStudentAndLesson(student, lesson)) {
            throw new IllegalStateException("Öğrenci zaten bu derse kayıt olmuş.");
        }

        StudentLesson studentLesson = new StudentLesson();
        studentLesson.setStudent(student);
        studentLesson.setLesson(lesson);
        studentLessonRepository.save(studentLesson);
    }

    public void unenrollStudentFromLesson(CreateStudentLessonRequest request) throws Exception {

        Student student = studentService.getStudentById(request.getStudentId());
        if (student == null) {
            throw new IllegalStateException("Böyle bir öğrenci yok.");
        }

        Lesson lesson = lessonService.getLessonById(request.getLessonId());

        Optional<StudentLesson> studentLessonOptional = studentLessonRepository.findByStudentAndLesson(student, lesson);

        StudentLesson studentLesson = studentLessonOptional
                .orElseThrow(() -> new IllegalStateException("Öğrenci bu derse kayıtlı değil."));

        studentLessonRepository.delete(studentLesson);
    }
}
