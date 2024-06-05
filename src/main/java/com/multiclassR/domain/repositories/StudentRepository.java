package com.multiclassR.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiclassR.domain.entities.Student;

public interface StudentRepository  extends JpaRepository<Student, Long> {
  
}
