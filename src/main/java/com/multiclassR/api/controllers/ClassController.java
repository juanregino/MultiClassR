package com.multiclassR.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multiclassR.api.dto.request.ClassRequest;
import com.multiclassR.api.dto.response.ClassBasicResponse;
import com.multiclassR.api.dto.response.ClassWithStudentsResponse;
import com.multiclassR.infraestructure.abstract_services.IClassService;

@RestController
@RequestMapping("/class")
public class ClassController {
  @Autowired
  private IClassService classService;

  @GetMapping
    public ResponseEntity<Page<ClassBasicResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description) {

        Pageable pageable = PageRequest.of(page, size);

        return ResponseEntity.ok(classService.findAll(name, description, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClassWithStudentsResponse>> getById(@PathVariable Long id) {
            
        return ResponseEntity.ok( classService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClassBasicResponse> create(@Validated @RequestBody ClassRequest request) {
        return ResponseEntity.ok(classService.create(request));
    }
}
