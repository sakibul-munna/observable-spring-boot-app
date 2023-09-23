package com.example.observablespringbootapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok().body("Hello There");
    }
}
