package com.multiclassR.infraestructure.abstract_services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.multiclassR.api.dto.request.StudentRequest;
import com.multiclassR.api.dto.response.StudentResponse;

public interface IStudentService {
  public Page<StudentResponse> findByNameOrDescription(String name, String description, Pageable pageable);
  public StudentResponse findById(Long id);
  public StudentResponse create(StudentRequest student); 
  public StudentResponse disableStudent (Long id);
  public StudentResponse update(StudentRequest student, Long id);
}