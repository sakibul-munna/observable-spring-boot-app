#!/bin/bash

# This bash script -
# makes a clean build of maven
# download the opentelemetry agent(aws version)
# runs the application using opentelemetry agent
# exports traces and metrics to 5555 endpoint

mvn clean package -Dmaven.test.skip=true
AGENT_FILE=opentelemetry-javaagent-all.jar

if [ ! -f "${AGENT_FILE}" ]; then
  curl -L https://github.com/aws-observability/aws-otel-java-instrumentation/releases/download/v1.28.1/aws-opentelemetry-agent.jar --output ${AGENT_FILE}
fi

export OTEL_TRACES_EXPORTER=otlp
export OTEL_METRICS_EXPORTER=otlp
export OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:5555
export OTEL_RESOURCE_ATTRIBUTES=service.name=observable-spring-boot-app,service.version=1.0

java -javaagent:./${AGENT_FILE} -jar target/observable-spring-boot-app-0.0.1.jar
