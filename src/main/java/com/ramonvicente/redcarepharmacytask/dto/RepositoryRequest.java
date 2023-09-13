package com.ramonvicente.redcarepharmacytask.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RepositoryRequest {
  @NotBlank
  @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
  private String sinceDate;
  private Integer limit;
}
