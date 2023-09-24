package com.example.observablespringbootapp.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private static final Logger log = LoggerFactory.getLogger(DemoService.class);

    public DemoResponse buildResponseForSayHello(){
        log.info("Here inside service");
        return new DemoResponse("Hello World");
    }

}
