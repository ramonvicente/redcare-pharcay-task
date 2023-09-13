package com.ramonvicente.redcarepharmacytask.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubItemResponse {
  private long id;
  private String name;
  private String description;
  private String url;
  @JsonProperty("stargazers_count")
  private int stargazersCount;
}
