package com.example.samleRestService.repository;

import com.example.samleRestService.resources.Student;
import org.springframework.data.repository.CrudRepository;

// To wire your Table/Model object and your application
public interface StudentRepository extends CrudRepository<Student, Long> {

}
