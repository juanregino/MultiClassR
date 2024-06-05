package com.multiclassR.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiclassR.api.dto.request.LessonRequest;
import com.multiclassR.api.dto.response.LessonResponse;
import com.multiclassR.infraestructure.abstract_services.IlessonService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/lesson")
public class LessonController {
  @Autowired
  private IlessonService lessonService;
 
  @PostMapping
  public ResponseEntity<LessonResponse> createLesson(@Validated @RequestBody LessonRequest request) { 
  
    return ResponseEntity.ok(lessonService.saveLesson(request));
  }

  @PatchMapping("/{id}/disable")
  public ResponseEntity<LessonResponse> disableLesson(@PathVariable Long id) {
    return ResponseEntity.ok(lessonService.disableLesson(id));
  }

  @GetMapping("/{id}")
  public ResponseEntity<LessonResponse> getLesson(@PathVariable Long id) {
    return ResponseEntity.ok(lessonService.findById(id));
  }
}
