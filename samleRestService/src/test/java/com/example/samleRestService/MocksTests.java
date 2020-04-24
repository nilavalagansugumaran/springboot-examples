package com.example.samleRestService;

import com.example.samleRestService.component.BankAccountBean;
import com.example.samleRestService.endpoints.SimpleEmployeeEndpoint;
import com.example.samleRestService.resources.Employee;
import com.example.samleRestService.service.EmployeeServiceWithMockDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MocksTests {

	@Autowired
	SimpleEmployeeEndpoint simpleEmployeeEndpoint;

	@MockBean
	EmployeeServiceWithMockDB mockedBeanl;


	@Test
	void testing_mocked_beans() {

		Mockito.when(mockedBeanl.getAllEmployees()).thenReturn(Collections.emptyList());
		List<Employee> emps = simpleEmployeeEndpoint.getAllEmployee();

		Assertions.assertTrue(emps !=null);
		Assertions.assertTrue(emps.size() == 0);
	}

}
