package com.ramonvicente.redcarepharmacytask.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramonvicente.redcarepharmacytask.dto.api.GithubRepositoryResponse;

import lombok.RequiredArgsConstructor;

/*
 * I decided to create an interface for the external APIs 
 * so if we have other sources can implement a class for each of them.
 * Also created DTOs specific for the github response structure.
 */
@RequiredArgsConstructor
public class GithubApiService implements ApiService {

  private static final String SEARCH_REPOSITORY_URL = "/search/repositories";
  private static final String BASE_URL = "https://api.github.com";

  private final RestTemplate restTemplate;

  @Override
  public GithubRepositoryResponse getAllPopularFromDate(String createdDate, Integer limit) {
    if(createdDate.isBlank()) {
      throw new IllegalArgumentException();
    }
    
    String fullUrl = String.format("%s%s?q=created:%s&sort=stars&order=desc", BASE_URL, SEARCH_REPOSITORY_URL, createdDate);
    if(limit != null) {
      fullUrl += String.format("&per_page=%s", limit);
    }
    String responseBody = restTemplate.getForObject(fullUrl, String.class);

    try {
      return new ObjectMapper().readValue(responseBody, new TypeReference<GithubRepositoryResponse>() {});
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
