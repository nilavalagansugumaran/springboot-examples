package com.example.samleRestService.service;

import com.example.samleRestService.resources.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmployeeServiceWithMockDB {

    private static ConcurrentHashMap<Long, Employee> mockDB = new ConcurrentHashMap();

    static {

        mockDB.put(101L, new Employee(101L,"Nila-101", 1000.00d));
        mockDB.put(102L, new Employee(102L,"Nila-102", 2000.00d));
        mockDB.put(103L, new Employee(103L,"Nila-103", 3000.00d));
        mockDB.put(104L, new Employee(104L,"Nila-104", 4000.00d));
    }

    public void storeNewEmployee(Employee e) {
        mockDB.put(e.getId(), e);
    }

    public Employee getOneEmployee(Long id) {
        Employee empfromDB =  mockDB.get(id);
        if(empfromDB !=null) {
            return empfromDB;
        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found " + id);
        }
    }


    public List<Employee> getAllEmployees() {

        return Collections.emptyList();
    }


    public Employee updateSalary(Long id, Employee e) {

        Employee empfromDB =  mockDB.get(id);
        if(empfromDB !=null) {
            empfromDB.setSalary(e.getSalary());
            mockDB.put(id, empfromDB);
        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found " + id);
        }

        return empfromDB;
    }

    public void deleteEmployee(Long id) {

        Employee empfromDB =  mockDB.get(id);
        if(empfromDB !=null) {
            mockDB.remove(id);
        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found " + id);
        }
    }

}
