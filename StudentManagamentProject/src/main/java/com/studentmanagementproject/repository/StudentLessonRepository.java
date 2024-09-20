package com.studentmanagementproject.repository;

import com.studentmanagementproject.model.StudentLesson;
import com.studentmanagementproject.model.Student;
import com.studentmanagementproject.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentLessonRepository extends JpaRepository<StudentLesson, Long> {
    boolean existsByStudentAndLesson(Student student, Lesson lesson);

    Optional<StudentLesson> findByStudentAndLesson(Student student, Lesson lesson);
}
