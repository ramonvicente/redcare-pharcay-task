package com.ramonvicente.redcarepharmacytask.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryResponse {
  private long id;
  private String name;
  private String description;
  private String url;
  private int stars;
}
