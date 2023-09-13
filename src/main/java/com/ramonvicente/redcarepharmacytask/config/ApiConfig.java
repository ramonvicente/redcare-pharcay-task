package com.ramonvicente.redcarepharmacytask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.ramonvicente.redcarepharmacytask.service.ApiService;
import com.ramonvicente.redcarepharmacytask.service.GithubApiService;

@Configuration
public class ApiConfig {
  
  //Decided to create a bean in order to inject by constructor 
  //and be better to manage in the test class
  @Bean
  public ApiService apiService() {
    return new GithubApiService(new RestTemplate());
  }
}
