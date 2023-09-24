package com.example.observablespringbootapp.demo;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public DemoResponse buildResponseForSayHello(){
        return new DemoResponse("Hello World");
    }

}
