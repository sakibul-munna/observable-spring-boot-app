package com.example.observablespringbootapp.demo;

import com.example.observablespringbootapp.observability.CustomMetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;
    @Autowired
    private CustomMetricsService customMetricsService;

    @GetMapping
    public DemoResponse sayHello() {
        log.info("Here inside controller");
        customMetricsService.updateNumberOfExecution();
        return demoService.buildResponseForSayHello();
    }
}
