package com.example.samleRestService.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement
@Entity // additional
@Table(name = "Student") // Additional
public class Student {

    @Id  // Additional
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Additional
    private Long id = -1l;

    private String name;

    @Column(name = "class")  // Additional, optional
    private String std;
}
