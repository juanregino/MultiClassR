package com.multiclassR.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiclassR.domain.entities.Lesson;

public interface LessonRepository  extends JpaRepository<Lesson, Long> {
   
}
