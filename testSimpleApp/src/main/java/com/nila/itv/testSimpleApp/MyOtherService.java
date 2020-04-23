package com.nila.itv.testSimpleApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
//@Scope("prototype") // scope impacts how container creates/hands the bean
public class MyOtherService implements  MyInterface {

    @Override
    public void sayHelloFromService() {

        log.debug("Hello from other Service...");

        // This is to prove how scope is impacting
        log.debug("Hash code is ... " + this.hashCode());
    }
}
