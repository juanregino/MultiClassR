package com.multiclassR.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassBasicResponse {
  private Long id;
  private String name;
  private String description;
  private Boolean active;
}
