package com.ramonvicente.redcarepharmacytask.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RepositoryRequest {
  //I though in create a custom validation but to keep it clean I think use those two are more than necessary for now.
  @NotBlank
  @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "sinceDate should match the format YYYY-MM-DD")
  private String sinceDate;
  private String language;
  private Integer limit;
}
