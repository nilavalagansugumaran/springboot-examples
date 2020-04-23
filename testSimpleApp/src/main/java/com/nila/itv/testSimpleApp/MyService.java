package com.nila.itv.testSimpleApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("hiService") // giving other name to bean
@Slf4j
//@Scope("prototype") // scope impacts how container creates/hands the bean
public class MyService implements  MyInterface {

    @Override
    public void sayHelloFromService() {

        log.debug("Hello from Service...");

        // This is to prove how scope is impacting
        log.debug("Hash code is ... " + this.hashCode());
    }
}
