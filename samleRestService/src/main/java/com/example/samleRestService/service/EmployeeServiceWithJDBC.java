package com.example.samleRestService.service;

import com.example.samleRestService.helper.EmployeeRowMapper;
import com.example.samleRestService.resources.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class EmployeeServiceWithJDBC {

    @Autowired private JdbcTemplate jdbcTemplate;

    public void storeNewEmployee(Employee e) {

        jdbcTemplate.update("insert into EMPLOYEES (name, salary) " +
                        "values (?, ?)",
                new Object[]{e.getName(), e.getSalary() });
    }

    public Employee getOneEmployee(Long id) {

        String sql = "SELECT * FROM EMPLOYEES where EMPLOYEEID = ?";

        Employee e =  jdbcTemplate.queryForObject(sql,  new Object[]{id}, new EmployeeRowMapper());

        if (e !=null ) {
            return e;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found " + id);
        }

    }


    public List<Employee> getAllEmployees() throws DataAccessException {

        String sql = "SELECT * FROM EMPLOYEES";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());

    }


    public Employee updateSalary(Long id, Employee e) {

        Employee existingEmployee = getOneEmployee(id);

        if(existingEmployee !=null ){
            jdbcTemplate.update("update EMPLOYEES set salary = ? where EMPLOYEEID = ? ",
                    new Object[]{e.getSalary(), id});
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found " + id);
        }

        return getOneEmployee(id);

    }

    public void deleteEmployee(Long id) {

        Employee existingEmployee = getOneEmployee(id);

        if(existingEmployee !=null ){
            jdbcTemplate.update("delete from EMPLOYEES where employeeid =  ? ",
                    new Object[]{ id});
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found " + id);
        }

    }

    @PostConstruct
    public void setupDB(){

        //DDL statements
        jdbcTemplate.execute("create table EMPLOYEES(" +
                "employeeid int auto_increment, " +
                "name varchar(50), " +
                "salary double, " +
                "primary key (employeeid) )");

        // DML statement
        jdbcTemplate.update("insert into EMPLOYEES (name, salary) " +
                        "values (?, ?)",
                new Object[]{"James-1", 21000});

        jdbcTemplate.update("insert into EMPLOYEES (name, salary) " +
                        "values (?, ?)",
                new Object[]{"James-2", 22000 });

        jdbcTemplate.update("insert into EMPLOYEES (name, salary) " +
                        "values (?, ?)",
                new Object[]{"James-3", 23000});

    }
}
