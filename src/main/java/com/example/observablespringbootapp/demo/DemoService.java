package com.example.observablespringbootapp.demo;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private static final Logger log = LoggerFactory.getLogger(DemoService.class);

    /**
     * This function shows the annotation way to create custom span.
     */
    @WithSpan
    public DemoResponse buildResponseForSayHello(){
        log.info("Here inside service");
        return new DemoResponse("Hello World");
    }

}
