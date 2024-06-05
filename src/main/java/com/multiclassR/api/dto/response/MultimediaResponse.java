package com.multiclassR.api.dto.response;

import java.time.LocalDateTime;

import com.multiclassR.utils.enums.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor 
public class MultimediaResponse {
  private Long id;
  private Type type;
  private String url;
    private LocalDateTime createdAt;

  private Boolean active;
}
