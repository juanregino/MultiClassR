package com.multiclassR.api.dto.request;

import java.time.LocalDateTime;



import com.multiclassR.utils.enums.Type;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaRequest {
  @NotNull(message = "El tipo de multimedia no puede ser nulo")
  @Pattern(regexp = "VIDEO|AUDIO|DOCUMENT", message = "The type must be one of the following: VIDEO, AUDIO, DOCUMENT")
  private Type type;
  @NotBlank(message = "El url de la multimedia no puede estar vacío")

  private String url;

  @NotNull(message = "La actividad de la multimedia no puede ser nula")
  private Boolean active;   

}
