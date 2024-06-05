package com.multiclassR.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multiclassR.api.dto.response.ClassBasicResponse;
import com.multiclassR.infraestructure.abstract_services.IClassService;

@RestController
@RequestMapping("/class")
public class ClassController {
  @Autowired
  private IClassService classService;

  @GetMapping
    public Page<ClassBasicResponse> getClases(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description) {

        Pageable pageable = PageRequest.of(page, size);

        return classService.findAll(name, description, pageable);
    }
}
