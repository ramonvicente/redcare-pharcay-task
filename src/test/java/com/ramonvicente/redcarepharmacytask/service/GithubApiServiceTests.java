package com.ramonvicente.redcarepharmacytask.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.ramonvicente.redcarepharmacytask.dto.api.GithubRepositoryResponse;

@SpringBootTest
public class GithubApiServiceTests {
	private static final long ID_1 = 165041732;
	private static final long ID_2 = 165092572;  
	private static final long ID_3 = 165110580;  

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private GithubApiService gitHubApiService;

	@Test
	@DisplayName("return GithubApiResponse when get all popular repositories")
	public void returnGithubApiResponseWhenGetAllPopularRepositories() throws IOException {
		//given
		String response = String.format(
			"{\"items\":[{\"id\":%s,\"name\":\"text\",\"description\":\"text\",\"url\":\"url\",\"stargazers_count\":21341}," +
			"{\"id\":%s,\"name\":\"text\",\"description\":\"text\",\"url\":\"url\",\"stargazers_count\":5609}," + 
			"{\"id\":%s,\"name\":\"text\",\"description\":\"text\",\"url\":\"url\",\"stargazers_count\":4375}]}", 
			ID_1, ID_2, ID_3);

		when(restTemplate.getForObject(any(String.class), eq(String.class))).thenReturn(response);
		
		//when
		GithubRepositoryResponse result = gitHubApiService.getAllPopularFromDate("2019-10-11", 3, null);

		//then
		assertNotNull(result);
		assertEquals(3, result.getItems().size());
		assertEquals(ID_1, result.getItems().get(0).getId());
		assertEquals(ID_2, result.getItems().get(1).getId());
		assertEquals(ID_3, result.getItems().get(2).getId());
	}

	@Test
	@DisplayName("return empty items when get all popular repositories does not have items")
	public void returEmptyItemsWhenDoesNotHaveItems() throws IOException {
		//given
		when(restTemplate.getForObject(any(String.class), eq(String.class))).thenReturn("{\"items\":[]}");

		//when
		GithubRepositoryResponse result = gitHubApiService.getAllPopularFromDate("2019-10-11", 3, null);

		//then
		assertEquals(0, result.getItems().size());
	}
}
