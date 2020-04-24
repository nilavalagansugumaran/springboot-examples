package com.example.samleRestClient;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
@Data
public class MyClientComponent {

    @Value("${rest.service.url:http://dummy-default-value}")
    private String serviceUrl;

    @Autowired private RestTemplate restTemplate;

    public void invokeService(){


    }
    
    @PostConstruct
    public void setUp(){

        restTemplate = new RestTemplate();
    }
}
