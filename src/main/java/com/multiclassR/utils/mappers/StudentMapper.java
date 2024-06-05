package com.multiclassR.utils.mappers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multiclassR.api.dto.request.StudentRequest;
import com.multiclassR.api.dto.response.StudentResponse;
import com.multiclassR.domain.entities.Class;
import com.multiclassR.domain.entities.Student;
import com.multiclassR.domain.repositories.ClassRepository;
import com.multiclassR.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StudentMapper {
  @Autowired
  private final ClassRepository classRepository;
  public StudentResponse toResponse(Student entity) {
    return StudentResponse.builder()
        .id(entity.getId())
        .name(entity.getName())
        .email(entity.getEmail())
        .createdAt(entity.getCreatedAt())
        .active(entity.getActive())
        .build();
  }

  public Student toEntity(StudentRequest request) {
    Class clazz = classRepository.findById(request.getClassId()).orElseThrow(() -> new IdNotFoundException("Class not found", request.getClassId()));
    return Student.builder()
        .name(request.getName())
        .email(request.getEmail())
        .createdAt(LocalDateTime.now())
        .active(request.getActive())
        .classEntity(clazz)
        .build();
  }
}
