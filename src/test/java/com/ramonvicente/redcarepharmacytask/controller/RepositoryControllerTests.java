package com.ramonvicente.redcarepharmacytask.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ramonvicente.redcarepharmacytask.dto.RepositoryRequest;

//The idea here was create a kind of acceptance test focus in the happy path since already has unit test
@SpringBootTest
@AutoConfigureMockMvc
public class RepositoryControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("Return status ok when get all repositories.")
  public void returnStatusOkWhenGetAllRepositories() throws Exception {

      RepositoryRequest request = new RepositoryRequest();
      request.setSinceDate("2019-10-11");
      request.setLimit(3);
    

      mockMvc.perform(MockMvcRequestBuilders
                      .get("/repositories/github/most-popular")
                      .contentType(MediaType.APPLICATION_JSON)
                      .param("sinceDate", "2019-10-11"))
              .andExpect(MockMvcResultMatchers
                      .status()
                      .isOk());
  }
  
}
