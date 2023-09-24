package com.example.observablespringbootapp.observability;

import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.observablespringbootapp.utils.Constants.*;
import static com.example.observablespringbootapp.utils.Constants.HEAP_MEMORY_DESCRIPTION;
import static java.lang.Runtime.getRuntime;
import javax.annotation.PostConstruct;

@Service
public class CustomMetricsService {

    @Autowired
    private Meter meter;

    @Autowired
    private Tracer tracer;

    private LongCounter numberOfExecutions;

    @PostConstruct
    public void generateCustomMetrics() {
        //a synchronous metric
        numberOfExecutions =
                meter
                        .counterBuilder(NUMBER_OF_EXEC_NAME)
                        .setDescription(NUMBER_OF_EXEC_DESCRIPTION)
                        .setUnit("int")
                        .build();

        //an asynchronous metric
        meter
                .gaugeBuilder(HEAP_MEMORY_NAME)
                .setDescription(HEAP_MEMORY_DESCRIPTION)
                .setUnit("byte")
                .buildWithCallback(
                        r -> {
                            r.record(getRuntime().totalMemory() - getRuntime().freeMemory());
                        });
    }
}
