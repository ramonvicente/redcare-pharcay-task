package com.ramonvicente.redcarepharmacytask.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ramonvicente.redcarepharmacytask.dto.RepositoryResponse;
import com.ramonvicente.redcarepharmacytask.dto.api.GithubItemResponse;
import com.ramonvicente.redcarepharmacytask.dto.api.GithubRepositoryResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RepositoryService {

  private final ApiService apiService;

  public List<RepositoryResponse> getMostPopularRepositories(String createdDate, Integer limit, String language) {
    if(createdDate.isBlank()) {
      throw new IllegalArgumentException();
    }

    GithubRepositoryResponse response = apiService.getAllPopularFromDate(createdDate, limit, language);

    List<RepositoryResponse> repositories = response.getItems().stream()
      .map( item -> toRepositories(item)).toList();

    return repositories;
  }

  private RepositoryResponse toRepositories(GithubItemResponse item) {
    return RepositoryResponse.builder()
      .id(item.getId())
      .name(item.getName())
      .description(item.getDescription())
      .url(item.getUrl())
      .stars(item.getStargazersCount())
      .build();
  }
  
}
