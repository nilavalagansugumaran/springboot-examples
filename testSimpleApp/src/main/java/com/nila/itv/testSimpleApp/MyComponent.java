package com.nila.itv.testSimpleApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
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

    // Adding configuration bean
    @Autowired
    private MyConfig config;

    // To access commandline argument
    @Autowired
    private ApplicationArguments args;

    @Autowired
    private Contact contact;

    public void sayHello() {

        log.debug("Hello world!!!");
        service.sayHelloFromService();
        log.debug("Value from config is {}", config.getContactName());
    }

    public void printContact() {
        log.debug("Contacts from properties {}", contact.toString());
    }


    public void printApplicationArgs(){
        log.debug("Value from getOptionNames is {}", args.getOptionNames());
        log.debug("Value from getNonOptionArgs is {}", args.getNonOptionArgs());
        log.debug("Value from getSourceArgs is {}", args.getSourceArgs());
        log.debug("Value from getOptionValues is {}", args.getOptionValues("target"));
    }

    public void sayHelloFromAllService() {

        for(MyInterface in : allServices) {
            log.debug("calling individual services from list ");
            in.sayHelloFromService();
        }

    }
}
