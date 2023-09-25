# Observable Spring Boot App
- Nowadays, Observability is crucial for understanding how our applications behave in real-world environments. It provides insights into performance, errors, and user experiences, enabling us to proactively identify and resolve issues. There are three pillars of Observability. They are **Metrics, Logs,** and **Traces**.

- This repository consists of an almost complete setup of observable spring boot applications. It is well-instrumented with the tools and backends that are needed to observe what the heck is going on inside your application.

### Tools:
#### Opentelemetry Agent and the OpenTelemetry Collector: 
- Spring boot application sends metrics and traces data to the Opentelemetry agent. The agent then forwards those to the Opentelemetry collector. The OpenTelemtry collector then processes this data and exports it to the observability backends.

#### Logback:  
- Logback is one of the most widely used logging frameworks for Java and Spring Boot frameworks. It has been used in this repository for logging.

#### Filelog Receiver: 
- The Filelog receiver in OpenTelemetry is configured to tail the log files. It continuously reads the log files and sends the new log events to the OpenTelemetry collector

### Observability Backends:
#### Grafana Tempo: 
- Tempo has been used to store the traces data. After processing, the OpenTelemetry collector stores traces data to this backend.

#### Prometheus: 
- It has been used to store the metrics data. After processing, the OpenTelemetry collector stores metrics data to this backend.

#### Grafana Loki: 
- It has been used to store the log data. After processing, the OpenTelemetry collector stores log data to this backend.

### Visualization Frontend:
#### Grafana:
- Grafana is a popular visualization frontend. It has been configured with our three observability backends. You can see insightful information from the observability data in a structured way from Grafana.

### Workflow Diagram:

![image](https://github.com/sakibul-munna/observable-spring-boot-app/assets/60852484/5fd3498b-a93b-427c-822f-26cf9c96445f)


### How to run this application:
- There is a docker compose file. That is for running OpenTelemetry Collector, Tempo, Prometheus and Loki. So open an terminal and run,
``` docker compose up ```
- There is shell script file named `run-app-with-otel-agent.sh`. This file contains command to bind our application and the OpenTelemetry collector together. So after starting all the required services on docker, start your application by running this script file.