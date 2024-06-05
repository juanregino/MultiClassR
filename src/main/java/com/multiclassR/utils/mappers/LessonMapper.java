package com.multiclassR.utils.mappers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multiclassR.api.dto.request.LessonRequest;
import com.multiclassR.api.dto.response.LessonResponse;
import com.multiclassR.domain.entities.Lesson;
import com.multiclassR.domain.repositories.ClassRepository;
import com.multiclassR.utils.exceptions.IdNotFoundException;
import com.multiclassR.domain.entities.Class;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LessonMapper {
  @Autowired 
  private final ClassRepository classRepository;
  public LessonResponse toResponse(Lesson entity) {
    return LessonResponse.builder()
        .id(entity.getId())
        .title(entity.getTitle())
        .content(entity.getContent())
        .createdAt(entity.getCreatedAt())
        .active(entity.getActive())
        .build();
  }

  public Lesson toEntity(LessonRequest request) {
    Class clazz = classRepository.findById(request.getClassId()).orElseThrow(() -> new IdNotFoundException("Class not found", request.getClassId()));
    
    return Lesson.builder()
        .title(request.getTitle())
        .content(request.getContent())
        .createdAt(LocalDateTime.now())
        .active(request.getActive())
        .clazz(clazz)
        .build();
  }
}
