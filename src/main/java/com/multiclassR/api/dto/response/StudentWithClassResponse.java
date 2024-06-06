package com.multiclassR.api.dto.response;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithClassResponse {
    private Long id;
  private String name;
  private String email;
  private LocalDateTime createdAt;

  private Boolean active;

  private ClassBasicResponse classes;
}
