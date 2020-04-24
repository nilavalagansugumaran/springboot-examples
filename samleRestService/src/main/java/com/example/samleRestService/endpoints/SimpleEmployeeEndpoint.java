package com.example.samleRestService.endpoints;

import com.example.samleRestService.resources.Employee;
import com.example.samleRestService.service.EmployeeServiceWithMockDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // To expose endpoints or apis
@CrossOrigin
public class SimpleEmployeeEndpoint {

    //DI
    @Autowired private EmployeeServiceWithMockDB mockDBService;

    @GetMapping(path = "/simpleEmployee") // TO CREATE A ENDPOINT/API
    public List<Employee> getOneEmployee() {

        return mockDBService.getAllEmployees();
    }

    // http://localhost:9002/simpleEmployee/102
    @GetMapping(path = "/simpleEmployee/{id}",headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    public Employee getEmployeeByID(@PathVariable("id") Long id ) {

        return mockDBService.getOneEmployee(id);
    }


    // http://localhost:9002/simpleEmployee?empId=102
    @DeleteMapping(path = "/simpleEmployee", headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAndEmployee(@RequestParam("empId") Long id) {

        mockDBService.deleteEmployee(id);

    }

    // http://localhost:9002/simpleEmployee // need to pass request body
    @PostMapping(path = "/simpleEmployee", headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody Employee newEmployee) {

        mockDBService.storeNewEmployee(newEmployee);
    }

    // http://localhost:9002/simpleEmployee/{id} // need to pass request body
    @PutMapping(path = "/simpleEmployee/{id}", headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee updatedEmployee) {

       return mockDBService.updateSalary(id, updatedEmployee);
    }


}
