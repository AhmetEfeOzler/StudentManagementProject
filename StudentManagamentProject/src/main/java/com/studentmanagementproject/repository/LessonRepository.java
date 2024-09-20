package com.studentmanagementproject.repository;

import com.studentmanagementproject.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
