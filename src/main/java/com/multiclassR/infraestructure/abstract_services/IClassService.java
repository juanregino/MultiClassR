package com.multiclassR.infraestructure.abstract_services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.multiclassR.api.dto.request.ClassRequest;
import com.multiclassR.api.dto.response.ClassBasicResponse;
import com.multiclassR.api.dto.response.ClassWithStudentsResponse;

public interface IClassService {
  public Page<ClassBasicResponse> findAll(String nombre, String descripcion, Pageable pageable);
  public Optional<ClassWithStudentsResponse> findById(Long id);
  public ClassBasicResponse create(ClassRequest request);
}
