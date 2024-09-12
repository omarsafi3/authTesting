package com.example.authTesting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/admin/test")
@RestController
public class TestController {
    @GetMapping("/hello/{id}")
    public ResponseEntity<String> hello(@PathVariable String id){
        System.out.println("Hello World");
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
