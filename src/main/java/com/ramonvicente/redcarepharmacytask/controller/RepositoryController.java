package com.ramonvicente.redcarepharmacytask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ramonvicente.redcarepharmacytask.dto.RepositoryRequest;
import com.ramonvicente.redcarepharmacytask.dto.RepositoryResponse;
import com.ramonvicente.redcarepharmacytask.service.RepositoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("repositories")
public class RepositoryController {

  @Autowired
  private RepositoryService repositoryService;

  // First I added params with @RequestParam but since I have 3 params and thinling also about validation maybe use @ModelAttribute 
  // to bind the params would make the code better visual and to manage validation
  @GetMapping(value = "/github/most-popular", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public List<RepositoryResponse> getRepositories(@ModelAttribute @Valid RepositoryRequest request) {

    return repositoryService.getMostPopularRepositories(request.getSinceDate(), request.getLimit(), request.getLanguage());
  }
  
}
