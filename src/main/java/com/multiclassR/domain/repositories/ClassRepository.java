package com.multiclassR.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.multiclassR.domain.entities.Class;

public interface ClassRepository  extends JpaRepository<Class, Long> {
  Page<Class> findByNameContainingAndDescriptionContainingAndActiveTrue(String nombre, String descripcion, Pageable pageable);
  Page<Class> findAllByActiveTrue(Pageable pageable);
  
  Optional<Class> findByIdAndActiveTrue(Long id);
}
