package com.example.samleRestService.endpoints;

import com.example.samleRestService.resources.Employee;
import com.example.samleRestService.service.EmployeeServiceWithMockDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // To expose endpoints or apis
public class SimpleEmployeeEndpoint {

    //DI
    @Autowired private EmployeeServiceWithMockDB mockDBService;

    @GetMapping(path = "/simpleEmployee") // TO CREATE A ENDPOINT/API
    public Employee getOneEmployee() {

        return new Employee(101L,"Nila-101", 1000.00d);
    }

    // http://localhost:9002/simpleEmployee/102
    @GetMapping(path = "/simpleEmployee/{id}", headers = {"Content-Type: application/json","Accept: application/json"})
    public Employee getEmployeeByID(@PathVariable("id") Long id ) {

        return mockDBService.getOneEmployee(id);
    }


    // http://localhost:9002/simpleEmployee?empId=102
    @DeleteMapping(path = "/simpleEmployee", headers = {"Content-Type: application/json","Accept: application/json"})
    public void deleteAndEmployee(@RequestParam("empId") Long id) {

        mockDBService.deleteEmployee(id);

    }

    // http://localhost:9002/simpleEmployee // need to pass request body
    @PostMapping(path = "/simpleEmployee", headers = {"Content-Type: application/json","Accept: application/json"})
    public void createEmployee(@RequestBody Employee newEmployee) {

        mockDBService.storeNewEmployee(newEmployee);
    }

    // http://localhost:9002/simpleEmployee/{id} // need to pass request body
    @PutMapping(path = "/simpleEmployee/{id}", headers = {"Content-Type: application/json","Accept: application/json"})
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee updatedEmployee) {

       return mockDBService.updateSalary(id, updatedEmployee);
    }


}
