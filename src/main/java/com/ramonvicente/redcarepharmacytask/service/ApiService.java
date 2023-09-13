package com.ramonvicente.redcarepharmacytask.service;

import com.ramonvicente.redcarepharmacytask.dto.api.GithubRepositoryResponse;

//I was thinking in create two methods one for only date and limit and the other to include language, 
//however I thought that would keep simpler make it in one single method and nullable params.
public interface ApiService {
  /**
   * Get all most popular {@link GithubRepositoryResponse} from a given creation date.
   * 
   * @param createdDate String that has the creation date of desired popular repositories. It should be in the format YYYY-MM-DD. 
   * @param limit {@link Integer} containing the amount of {@link GithubItemResponse} to be returned. Param is optional.
   * @param language {@link String} is the programing language of the repositories. Param is optional.
   * @return {@link GithubRepositoryResponse} that contains the list of items.
   */
  GithubRepositoryResponse getAllPopularFromDate(String createdDate, Integer limit, String language);
}
