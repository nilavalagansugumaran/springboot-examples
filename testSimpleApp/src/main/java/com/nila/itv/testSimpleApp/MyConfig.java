package com.nila.itv.testSimpleApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MyConfig {

    // To inject a value from property file to a bean
    @Value("${contact.name:default name}")
    private String contactName;
}
