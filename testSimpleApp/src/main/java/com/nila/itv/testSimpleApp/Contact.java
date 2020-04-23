package com.nila.itv.testSimpleApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ConfigurationProperties(prefix = "contact")
public class Contact {

    private String name;
    private int age;
    private Address address;

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Address {
    private String postcode;
}
