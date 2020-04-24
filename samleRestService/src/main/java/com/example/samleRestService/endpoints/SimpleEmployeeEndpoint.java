package com.example.samleRestService.endpoints;

import com.example.samleRestService.resources.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // To expose endpoints or apis
public class SimpleEmployeeEndpoint {

    @GetMapping(path = "/simpleEmployee") // TO CREATE A ENDPOINT/API
    public Employee getOneEmployee() {

        return new Employee(101L,"Nila-101", 1000.00d);
    }
}
