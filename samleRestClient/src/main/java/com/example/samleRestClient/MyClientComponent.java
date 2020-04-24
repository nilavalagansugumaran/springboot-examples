package com.example.samleRestClient;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
@Data
@Slf4j
public class MyClientComponent {

    @Value("${rest.service.url:http://dummy-default-value}")
    private String serviceUrl;

    private RestTemplate restTemplate;

    public void invokeService(){

        // To create a resource
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/xml");
        HttpEntity<String> entity = new HttpEntity<>("<Employee>\n <id>9102</id>" +
                "<name>nila-9102</name>\n" +
                "<salary>9000.0</salary>\n" +
                " </Employee>", headers);
        ResponseEntity<String>  response = restTemplate.exchange(serviceUrl, HttpMethod.POST, entity, String.class);

        log.debug("response {}, response body{}", response.getStatusCode(), response.getBody());


        // To read a resource
        HttpHeaders headerOther = new HttpHeaders();
        headerOther.add("Content-Type", "application/json");
        headerOther.add("Accept", "application/json");
        HttpEntity<String> getEntity = new HttpEntity<>("", headerOther);
        response = restTemplate.exchange(serviceUrl+9102, HttpMethod.GET, getEntity, String.class);

        log.debug("response {}, response body{}", response.getStatusCode(), response.getBody());

    }

    @PostConstruct
    public void setUp(){

        restTemplate = new RestTemplate();
    }
}
