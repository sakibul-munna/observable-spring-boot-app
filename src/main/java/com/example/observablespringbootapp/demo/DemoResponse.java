package com.example.observablespringbootapp.demo;

import java.util.Objects;

public record DemoResponse (String message) {
    public DemoResponse {
        Objects.requireNonNull(message);
    }
    private boolean isValid() {
        return true;
    }
}