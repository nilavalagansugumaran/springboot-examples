package com.example.samleRestService;

import com.example.samleRestService.endpoints.SimpleEmployeeEndpoint;
import com.example.samleRestService.resources.Employee;
import com.example.samleRestService.service.EmployeeServiceWithMockDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTemplateTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	void testing_client() {

		ResponseEntity<List<Employee>> responseEntity = testRestTemplate.exchange(
				"/employeeJdbc",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Employee>>() {});

		List<Employee> responseBody = responseEntity.getBody();
		Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Assertions.assertEquals(3, responseBody.size());

	}

}
