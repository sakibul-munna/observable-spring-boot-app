package com.example.observablespringbootapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping
    public DemoResponse sayHello(){
        return demoService.buildResponseForSayHello();
    }
}
