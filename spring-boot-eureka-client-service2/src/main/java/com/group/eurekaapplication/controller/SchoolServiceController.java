package com.group.eurekaapplication.controller;

import com.group.eurekaapplication.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SchoolServiceController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getStudData/{schoolName}", method = RequestMethod.GET, produces = "application/json")
    public String getStudentDetails(@PathVariable String schoolName) {
        String url = String.format("http://%s%s","eureka-client-student-service","/getStudent/{schoolName}");

        System.out.println("Getting School details for " + schoolName +" URL "+ url );
        String response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, schoolName).getBody();

        System.out.println("Response Received as " + response);

        return "School Name -  " + schoolName + " \n Student Details " + response;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
