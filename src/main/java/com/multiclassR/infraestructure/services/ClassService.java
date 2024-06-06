package com.multiclassR.infraestructure.services;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.multiclassR.api.dto.request.ClassRequest;
import com.multiclassR.api.dto.response.ClassBasicResponse;
import com.multiclassR.api.dto.response.ClassWithStudentsResponse;
import com.multiclassR.domain.entities.Class;
import com.multiclassR.domain.repositories.ClassRepository;
import com.multiclassR.infraestructure.abstract_services.IClassService;
import com.multiclassR.utils.mappers.ClassMapper;
import com.multiclassR.utils.mappers.StudentMapper;
@Service
public class ClassService implements IClassService {
   @Autowired
   private ClassRepository classRepository;
   @Autowired
   private ClassMapper classMapper;
   @Autowired
   private StudentMapper studentMapper;
   
  @Override
  public Page<ClassBasicResponse> findAll(String nombre, String descripcion, Pageable pageable) {
    if (nombre != null && descripcion != null) {
      return classRepository.findByNameContainingAndDescriptionContainingAndActiveTrue(nombre, descripcion, pageable).map(this.classMapper::toResponse);
    } else {
      return classRepository.findAllByActiveTrue(pageable).map(this.classMapper::toResponse);
    }
  }
  @Override
  public Optional<ClassWithStudentsResponse> findById(Long id) {
    
    return this.classRepository.findByIdAndActiveTrue(id).map(this::toResponseWithStudents);
  }
  @Override
  public ClassBasicResponse create(ClassRequest request) {
    Class clazz = this.classMapper.toEntity(request);
    return this.classMapper.toResponse(this.classRepository.save(clazz));
  }


  private ClassWithStudentsResponse toResponseWithStudents(Class classEntity) {
    return ClassWithStudentsResponse.builder()
        .id(classEntity.getId())
        .name(classEntity.getName())
        .description(classEntity.getDescription())
        .createdAt(classEntity.getCreatedAt())
        .active(classEntity.getActive())
        .students(classEntity.getStudents().stream().map(this.studentMapper::toResponse).collect(Collectors.toList()))
        .build();
  }
  
}
