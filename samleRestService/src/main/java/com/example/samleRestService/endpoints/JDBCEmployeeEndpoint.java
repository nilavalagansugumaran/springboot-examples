package com.example.samleRestService.endpoints;

import com.example.samleRestService.resources.Employee;
import com.example.samleRestService.service.EmployeeServiceWithJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // To expose endpoints or apis
@CrossOrigin
public class JDBCEmployeeEndpoint {

    //DI
    @Autowired private EmployeeServiceWithJDBC employeeServiceWithJDBC;

    @GetMapping(path = "/employeeJdbc") // TO CREATE A ENDPOINT/API
    public List<Employee> getAllEmployee() {

        return employeeServiceWithJDBC.getAllEmployees();
    }

    // http://localhost:9002/employeeJdbc/102
    @GetMapping(path = "/employeeJdbc/{id}",headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    public Employee getEmployeeByID(@PathVariable("id") Long id ) {

        return employeeServiceWithJDBC.getOneEmployee(id);
    }


    // http://localhost:9002/employeeJdbc?empId=102
    @DeleteMapping(path = "/employeeJdbc", headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAndEmployee(@RequestParam("empId") Long id) {

        employeeServiceWithJDBC.deleteEmployee(id);

    }

    // http://localhost:9002/employeeJdbc // need to pass request body
    @PostMapping(path = "/employeeJdbc", headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody Employee newEmployee) {

        employeeServiceWithJDBC.storeNewEmployee(newEmployee);
    }

    // http://localhost:9002/employeeJdbc/{id} // need to pass request body
    @PutMapping(path = "/employeeJdbc/{id}", headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee updatedEmployee) {

       return employeeServiceWithJDBC.updateSalary(id, updatedEmployee);
    }


}
