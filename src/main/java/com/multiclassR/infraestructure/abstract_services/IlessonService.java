package com.multiclassR.infraestructure.abstract_services;

import com.multiclassR.api.dto.request.LessonRequest;
import com.multiclassR.api.dto.response.LessonResponse;

public interface IlessonService {
  public LessonResponse saveLesson(LessonRequest request) ;
  
  public LessonResponse disableLesson(Long id);
  public LessonResponse findById(Long id);

}
