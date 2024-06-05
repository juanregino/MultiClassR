package com.multiclassR.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiclassR.domain.entities.Multimedia;

public interface MultimediaRepository  extends JpaRepository<Multimedia, Long> {
  
}
