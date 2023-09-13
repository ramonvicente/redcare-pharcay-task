package com.ramonvicente.redcarepharmacytask.service;

import com.ramonvicente.redcarepharmacytask.dto.GithubRepositoryResponse;

public interface ApiService {
  /**
   * Get all most popular {@link GithubRepositoryResponse} from a given creation date.
   * 
   * @param createdDate String that has the creation date of desired popular repositories. It should be in the format YYYY-MM-DD. 
   * @param limit int containing the amount of {@link GithubRepositoryResponse} to be returned.
   * @return {@link GithubRepositoryResponse} that contains the list of items.
   */
  GithubRepositoryResponse getAllPopularFromDate(String createdDate, int limit);
}
