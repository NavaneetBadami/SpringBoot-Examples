package com.group.eurekaapplication.controller;

import com.group.eurekaapplication.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    private static Map<String, List<Student>> schoolDb = null;
    static  {
        schoolDb = new HashMap<>();
        schoolDb.put("pdj", Arrays.asList(new Student("Navaneet", "6th"), new Student("Rahul", "7th")));
        schoolDb.put("darbar", Arrays.asList(new Student("Kiran", "8th"), new Student("Mahesh", "9th")));
    }

    @RequestMapping(value ="/getStudents/{schoolName}", method = RequestMethod.GET, produces="application/json")
    public List<Student>getStudents(@PathVariable String schoolName) {
        System.out.println("Getting Student details for " + schoolName);
        return schoolDb.get(schoolName);
    }


    @RequestMapping(value = "/")
    public String home() {
        return "Eureka Client application";
    }
}
