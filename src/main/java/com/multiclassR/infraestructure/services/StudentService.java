package com.multiclassR.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.multiclassR.api.dto.request.StudentRequest;
import com.multiclassR.api.dto.response.StudentResponse;
import com.multiclassR.api.dto.response.StudentWithClassResponse;
import com.multiclassR.domain.entities.Student;
import com.multiclassR.domain.repositories.StudentRepository;
import com.multiclassR.infraestructure.abstract_services.IStudentService;
import com.multiclassR.utils.exceptions.IdNotFoundException;
import com.multiclassR.utils.mappers.StudentMapper;
@Service
public class StudentService implements IStudentService {
@Autowired
private StudentRepository studentRepository;
@Autowired
private StudentMapper studentMapper;
  @Override
  public StudentResponse create(StudentRequest request) {
    Student student =  this.studentMapper.toEntity(request);

    return this.studentMapper.toResponse(this.studentRepository.save(student));
   
  }

  @Override
  public StudentResponse disableStudent(Long id) {
    Student student = this.find(id);
    student.setActive(false);
    student.setId(id);
    return this.studentMapper.toResponse(this.studentRepository.save(student));
  }

  @Override
  public StudentWithClassResponse findById(Long id) {
    
    return this.studentMapper.toResponseWithClassResponse(this.find(id));
  }

  @Override
  public Page<StudentResponse> findByNameOrDescription(String name,  Pageable pageable) {
    
    return this.studentRepository.findByNameContainingAndActiveTrue(name,  pageable).map(student -> this.studentMapper.toResponse(student));
  }

  @Override
  public StudentResponse update(StudentRequest request, Long id) {
    Student student = this.find(id);
    student = this.studentMapper.toEntity(request);
    student.setId(id);
    return this.studentMapper.toResponse(this.studentRepository.save(student));
  }

  private Student find(Long id) {

   return this.studentRepository.findById(id).orElseThrow(() -> new IdNotFoundException("id not found", id)) ;
  }
  
}
