package com.multiclassR.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiclassR.domain.entities.Class;

public interface ClassRepository  extends JpaRepository<Class, Long> {
  
}
