package com.example.samleRestService.repository;

import com.example.samleRestService.resources.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// To wire your Table/Model object and your application
public interface StudentRepository extends CrudRepository<Student, Long> {

    //Select * from student where and name = ?
    Optional<Student> findByName(String name);


    //Select * from student where id = ? and name = ?
    //  Student findByIdAndName(Long id, String name);

    //Select * from student where and name = ?
    //Student findByNameHaving(String name);

    // To write your own query
   // @Query("Select * from student where id = ? and name = ?")
    //Student mycustomerQuery(String name);

}

