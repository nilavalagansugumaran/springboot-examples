package com.example.samleRestService.service;

import com.example.samleRestService.helper.EmployeeRowMapper;
import com.example.samleRestService.repository.StudentRepository;
import com.example.samleRestService.resources.Employee;
import com.example.samleRestService.resources.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceWithJPA {

    //DI StudentRepository
    @Autowired private StudentRepository studentRepository;

    public void storeNewStudent(Student e) {

        studentRepository.save(e);
    }

    public Student getOneStudent(Long id) {
        Optional<Student> stud =  studentRepository.findById(id);
        if(stud.isPresent()) {
            return stud.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found " + id);
        }
    }

    public Student getOneStudentByName(String name) {
        Optional<Student> stud =  studentRepository.findByName(name);
        if(stud.isPresent()) {
            return stud.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found " + name);
        }
    }

    public List<Student> getAllStudents()  {

        List<Student> stds = new ArrayList<>();
       Iterable<Student> stud = studentRepository.findAll();

      Iterator<Student> it = stud.iterator();

      while (it.hasNext()) {
          stds.add(it.next());
      }
      return stds;
    }


    public Student updateClass(Long id, Student e) {

        Optional<Student> stud =  studentRepository.findById(id);
        if(stud.isPresent()) {
            Student existingStudent = stud.get();
            existingStudent.setStd(e.getStd());
            return studentRepository.save(existingStudent);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found " + id);
        }
    }

    public void deleteStudent(Long id) {

        Optional<Student> stud =  studentRepository.findById(id);
        if(stud.isPresent()) {
            studentRepository.delete(stud.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found " + id);
        }
    }

    @PostConstruct
    public void setupDB(){

        studentRepository.save(new Student(-1L, "Nila-1", "6O"));
        studentRepository.save(new Student(-1L, "Nila-2", "5B"));
        studentRepository.save(new Student(-1L, "Nila-3", "4C"));
    }
}
