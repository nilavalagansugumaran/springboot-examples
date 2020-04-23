package com.nila.itv.testSimpleApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyComponent {

    // Dependency injunction
    @Autowired
    @Qualifier("hiService") // use of qualifier
    private MyInterface service;

    // Include all dependencies
    @Autowired
    private List<MyInterface> allServices;

    public void sayHello() {

        log.debug("Hello world!!!");

        service.sayHelloFromService();
    }

    public void sayHelloFromAllService() {

        for(MyInterface in : allServices) {
            log.debug("calling individual services from list ");
            in.sayHelloFromService();
        }

    }
}
