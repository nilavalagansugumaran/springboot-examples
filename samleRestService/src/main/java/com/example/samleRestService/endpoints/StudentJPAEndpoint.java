package com.example.samleRestService.endpoints;

import com.example.samleRestService.resources.Student;
import com.example.samleRestService.service.StudentServiceWithJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // To expose endpoints or apis
@CrossOrigin
public class StudentJPAEndpoint {

    //DI
    @Autowired private StudentServiceWithJPA studentServiceWithJPA;

    @GetMapping(path = "/student") // TO CREATE A ENDPOINT/API
    public List<Student> getAllStudent() {

        return studentServiceWithJPA.getAllStudents();
    }

    // http://localhost:9002/student/102
    @GetMapping(path = "/student/{id}",headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    public Student getStudentByID(@PathVariable("id") Long id ) {

        return studentServiceWithJPA.getOneStudent(id);
    }


    // http://localhost:9002/student?empId=102
    @DeleteMapping(path = "/student", headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAndStudent(@RequestParam("empId") Long id) {

        studentServiceWithJPA.deleteStudent(id);

    }

    // http://localhost:9002/student // need to pass request body
    @PostMapping(path = "/student", headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student std) {

        studentServiceWithJPA.storeNewStudent(std);
    }

    // http://localhost:9002/student/{id} // need to pass request body
    @PutMapping(path = "/student/{id}", headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student updated) {

       return studentServiceWithJPA.updateClass(id, updated);
    }


}
