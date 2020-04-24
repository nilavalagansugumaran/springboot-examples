package com.example.samleRestService.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement
public class Employee {

    private Long id;
    private String name;
    private Double salary;

}
