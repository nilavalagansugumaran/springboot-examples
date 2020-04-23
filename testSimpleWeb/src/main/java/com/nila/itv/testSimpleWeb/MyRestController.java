package com.nila.itv.testSimpleWeb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping(path = "/hello")
    public String sayHelloTo(@RequestParam("name") String name){

        return "Hello " + name + "!!!";
    }
}
