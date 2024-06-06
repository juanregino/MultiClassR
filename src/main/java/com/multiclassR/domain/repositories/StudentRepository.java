package com.multiclassR.domain.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.multiclassR.domain.entities.Student;

public interface StudentRepository  extends JpaRepository<Student, Long> {
  Page<Student> findByNameContainingAndActiveTrue(String name, 
      Pageable pageable);

  List<Student> findByClassEntityId(Long classId);
}
