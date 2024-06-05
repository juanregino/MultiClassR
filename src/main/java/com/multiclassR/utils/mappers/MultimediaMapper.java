package com.multiclassR.utils.mappers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multiclassR.api.dto.request.MultimediaRequest;
import com.multiclassR.api.dto.response.MultimediaResponse;
import com.multiclassR.domain.entities.Lesson;
import com.multiclassR.domain.entities.Multimedia;
import com.multiclassR.domain.repositories.LessonRepository;
import com.multiclassR.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MultimediaMapper {
  @Autowired
  private final LessonRepository lessonRepository;
  public MultimediaResponse toResponse(Multimedia entity) {
    return MultimediaResponse.builder()
        .id(entity.getId())
        .url(entity.getUrl())
        .type(entity.getType())
        .createdAt(entity.getCreatedAt())
        .active(entity.getActive())
        .build();
  }


  public Multimedia toEntity(MultimediaRequest request) {
    Lesson lesson = lessonRepository.findById(request.getLessonId()).orElseThrow(() -> new IdNotFoundException("Lesson not found", request.getLessonId()));
    return Multimedia.builder()
        .url(request.getUrl())
        .type(request.getType())
        .createdAt(LocalDateTime.now())
        .active(request.getActive())
        .lesson(lesson)
        .build();
  }
}
