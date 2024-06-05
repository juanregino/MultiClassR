package com.multiclassR.utils.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.multiclassR.api.dto.request.MultimediaRequest;
import com.multiclassR.api.dto.response.MultimediaResponse;

import com.multiclassR.domain.entities.Multimedia;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MultimediaMapper {

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

    return Multimedia.builder()
        .url(request.getUrl())
        .type(request.getType())
        .createdAt(LocalDateTime.now())
        .active(request.getActive())

        .build();
  }
}
