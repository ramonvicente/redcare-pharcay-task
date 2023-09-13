package com.ramonvicente.redcarepharmacytask.dto.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepositoryResponse {
  private List<GithubItemResponse> items;
}
