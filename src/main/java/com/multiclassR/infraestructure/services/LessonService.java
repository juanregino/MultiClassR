package com.multiclassR.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiclassR.api.dto.request.LessonRequest;
import com.multiclassR.api.dto.response.LessonResponse;
import com.multiclassR.domain.entities.Lesson;
import com.multiclassR.domain.repositories.LessonRepository;
import com.multiclassR.infraestructure.abstract_services.IlessonService;
import com.multiclassR.utils.exceptions.IdNotFoundException;
import com.multiclassR.utils.mappers.LessonMapper;

@Service
public class LessonService implements IlessonService {
  @Autowired
  private LessonRepository lessonRepository;
  @Autowired
  private MultimediaService multimediaService;
  @Autowired
  private LessonMapper lessonMapper;

  @Override
  public LessonResponse saveLesson(LessonRequest request) {
    Lesson lesson = lessonMapper.toEntity(request);
    Lesson save = lessonRepository.save(lesson);
    this.multimediaService.createMultimediaFromLesson(save.getId(), request.getMultimedias());
    
    return lessonMapper.toResponse(save);

  }

  @Override
  public LessonResponse disableLesson(Long id) {
    Lesson lesson = this.find(id);
    lesson.setActive(false);
    lesson.setId(id);
    return lessonMapper.toResponse(lessonRepository.save(lesson));
  }

  @Override
  public LessonResponse findById(Long id) {
    return lessonMapper.toResponse(this.find(id));
  }

  private Lesson find(Long id) {
    return lessonRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Lesson not found", id));
  }
}


