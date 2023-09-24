package com.example.observablespringbootapp.observability;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenTelemetryConfig {

    @Value("otel.traces.api.version")
    private String tracesApiVersion;

    @Value("otel.metrics.api.version")
    private String metricsApiVersion;

    @Bean
    public Tracer tracer() {
        return GlobalOpenTelemetry.getTracer("io.opentelemetry.traces.hello", tracesApiVersion);
    }

    @Bean
    public Meter meter() {
        return GlobalOpenTelemetry.meterBuilder("io.opentelemetry.metrics.hello")
                .setInstrumentationVersion(metricsApiVersion)
                .build();
    }
}

