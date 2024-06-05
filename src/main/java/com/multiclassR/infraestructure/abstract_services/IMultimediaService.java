package com.multiclassR.infraestructure.abstract_services;

import java.util.List;

import com.multiclassR.api.dto.request.MultimediaRequest;

public interface IMultimediaService {
  public void createMultimediaFromLesson(Long lessonId, List<MultimediaRequest> requests);
  public void updateMultimediaFromLesson(Long lessonId, List<MultimediaRequest> requests);
}
