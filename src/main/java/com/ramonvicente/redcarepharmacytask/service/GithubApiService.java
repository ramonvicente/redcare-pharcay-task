package com.ramonvicente.redcarepharmacytask.service;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramonvicente.redcarepharmacytask.dto.GithubRepositoryResponse;

import lombok.RequiredArgsConstructor;

/*
 * I decided to create an interface for the external APIs 
 * so if we have other sources can implement a class for each of them.
 * Also created DTOs specific for the github response structure.
 */
@RequiredArgsConstructor
public class GithubApiService implements ApiService {

  private final RestTemplate restTemplate;

  @Override
  public GithubRepositoryResponse getAllPopularFromDate(String createdDate, int limit) {
    if(createdDate.isBlank()) {
      throw new IllegalArgumentException();
    }

    if(limit < 1) {
      throw new IllegalArgumentException();
    }
    
    String fullUrl = String.format("https://api.github.com/search/repositories?q=created:%s&sort=stars&order=desc&per_page=%s&q=name:blablads", createdDate, limit);
    String responseBody = restTemplate.getForObject(fullUrl, String.class);

    try {
      return new ObjectMapper().readValue(responseBody, new TypeReference<GithubRepositoryResponse>() {});
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
