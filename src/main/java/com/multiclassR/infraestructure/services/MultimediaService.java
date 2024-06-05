package com.multiclassR.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.multiclassR.api.dto.request.MultimediaRequest;
import com.multiclassR.domain.entities.Multimedia;
import com.multiclassR.domain.repositories.LessonRepository;
import com.multiclassR.domain.repositories.MultimediaRepository;
import com.multiclassR.utils.exceptions.IdNotFoundException;
import com.multiclassR.utils.mappers.MultimediaMapper;

public class MultimediaService {
  @Autowired
  private MultimediaRepository multimediaRepository;
  @Autowired
  private MultimediaMapper multimediaMapper;

  @Autowired
  private LessonRepository lessonRepository;

  public void createMultimediaFromLesson(Long lessonId, List<MultimediaRequest> requests) {
    for (MultimediaRequest request : requests) {
      Multimedia multimedia = multimediaMapper.toEntity(request);
      
      multimedia.setLesson(
          lessonRepository.findById(lessonId).orElseThrow(() -> new IdNotFoundException("Lesson not found", lessonId)));

      multimediaRepository.save(multimedia);
    }
  }

 public void updateMultimediaFromLesson(Long lessonId, List<MultimediaRequest> requests) {
    for (MultimediaRequest request : requests) {
      Multimedia multimedia = multimediaMapper.toEntity(request);
      multimedia.setLesson(
          lessonRepository.findById(lessonId).orElseThrow(() -> new IdNotFoundException("Lesson not found", lessonId)));

      multimediaRepository.save(multimedia);
    }
  }

}
