package com.studentmanagementproject.service;

import com.studentmanagementproject.model.Lesson;
import com.studentmanagementproject.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }


    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }


    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }


    public Lesson getLessonById(Integer id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ders bu idye göre bulunamamıştır " + id));
    }


    public void deleteLesson(Integer id) {
        if (!lessonRepository.existsById(id)) {
            throw new RuntimeException("Ders bu idye göre bulunamamıştır " + id);
        }
        lessonRepository.deleteById(id);
    }
}
