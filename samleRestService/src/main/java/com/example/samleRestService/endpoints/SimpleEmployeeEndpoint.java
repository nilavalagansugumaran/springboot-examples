package com.example.samleRestService.endpoints;

import com.example.samleRestService.resources.Employee;
import org.springframework.web.bind.annotation.*;

@RestController // To expose endpoints or apis
public class SimpleEmployeeEndpoint {

    @GetMapping(path = "/simpleEmployee") // TO CREATE A ENDPOINT/API
    public Employee getOneEmployee() {

        return new Employee(101L,"Nila-101", 1000.00d);
    }

    // http://localhost:9002/simpleEmployee/102
    @GetMapping(path = "/simpleEmployee/{id}")
    public Employee getEmployeeByID(@PathVariable("id") Long id ) {

        return null;
    }


    // http://localhost:9002/simpleEmployee?empId=102
    @DeleteMapping(path = "/simpleEmployee")
    public void deleteAndEmployee(@RequestParam("empId") Long id) {


    }

    // http://localhost:9002/simpleEmployee // need to pass request body
    @PostMapping(path = "/simpleEmployee")
    public Employee createEmployee(@RequestBody Employee newEmployee) {


        return null;
    }

    // http://localhost:9002/simpleEmployee/{id} // need to pass request body
    @PutMapping(path = "/simpleEmployee/{id}")
    public void updateEmployee(@PathVariable("id") Long id, @RequestBody Employee updatedEmployee) {


    }


}
