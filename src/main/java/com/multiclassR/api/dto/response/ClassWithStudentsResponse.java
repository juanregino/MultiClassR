package com.multiclassR.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassWithStudentsResponse {
   private Long id;
  private String name;
  private String description;
  private LocalDateTime createdAt;
  private Boolean active;
  private List<StudentResponse> students;
}
