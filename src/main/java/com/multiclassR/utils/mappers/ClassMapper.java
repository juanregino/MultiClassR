package com.multiclassR.utils.mappers;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

import com.multiclassR.api.dto.request.ClassRequest;
import com.multiclassR.api.dto.response.ClassBasicResponse;
import com.multiclassR.domain.entities.Class;

import lombok.AllArgsConstructor;
import lombok.Data;


@Component
@AllArgsConstructor
@Data
public class ClassMapper {
  

  public ClassBasicResponse toResponse(Class classEntity) {
  return ClassBasicResponse.builder()
      .id(classEntity.getId())
      .name(classEntity.getName())
      .description(classEntity.getDescription())
      .createdAt(classEntity.getCreatedAt())
      .active(classEntity.getActive())
      .build();
  }

  public Class toEntity(ClassRequest request) {
    return Class.builder()
        .name(request.getName())
        .description(request.getDescription())
        .createdAt(LocalDateTime.now())
        .active(request.getActive())
        .build();
  }

  
}
