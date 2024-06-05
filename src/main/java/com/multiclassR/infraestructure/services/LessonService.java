package com.multiclassR.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiclassR.api.dto.request.LessonRequest;
import com.multiclassR.api.dto.response.LessonResponse;
import com.multiclassR.domain.entities.Lesson;
import com.multiclassR.domain.repositories.LessonRepository;
import com.multiclassR.utils.mappers.LessonMapper;

@Service
public class LessonService {
  @Autowired
  private LessonRepository lessonRepository;
  @Autowired
  private MultimediaService multimediaService;
  @Autowired
  private LessonMapper lessonMapper;


  public LessonResponse saveLesson(LessonRequest request) {
   Lesson lesson = lessonMapper.toEntity(request);
    this.multimediaService.createMultimediaFromLesson(lesson.getId(), request.getMultimedias());
    return lessonMapper.toResponse(lessonRepository.save(lesson));
  }

  
}

/*
 * 
 * 
 * public Lesson saveLesson(Lesson lesson) {
 * validateLesson(lesson);
 * Lesson savedLesson = lessonRepository.save(lesson);
 * saveMultimediaContent(savedLesson.getId(), lesson.getMultimediaContent());
 * return savedLesson;
 * }
 * 
 * private void validateLesson(Lesson lesson) {
 * // Implementar validaciones para el título, descripción, etc.
 * }
 * 
 * private void saveMultimediaContent(Long lessonId, List<MultimediaContent>
 * multimediaContentList) {
 * for (MultimediaContent multimediaContent : multimediaContentList) {
 * multimediaContent.setLesson(lessonRepository.findById(lessonId).orElseThrow()
 * );
 * multimediaContentRepository.save(multimediaContent);
 * }
 * }
 */
