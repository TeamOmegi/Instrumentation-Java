# Instrumentation-Java
Java 언어의 계측기입니다.

# Dockerfile 예시

```Dockerfile
FROM openjdk:17-jdk-alpine

WORKDIR /app

# path/to/your-service.jar
COPY /build/libs/test-0.0.1-SNAPSHOT.jar /app/app.jar

# path/to/omegi-opentelemetry-javaagent.jar
COPY omegi-opentelemetry-javaagent.jar /app/omegi-opentelemetry-javaagent.jar

CMD ["java", \
     "-javaagent:omegi-opentelemetry-javaagent.jar", \
     "-Dotel.exporter.omegi.token=yourToken", \
     "-Dotel.traces.exporter=OmegiTraceSpanExporter", \
     "-Dotel.logs.exporter=none", \
     "-Dotel.metrics.exporter=none", \
     "-Dotel.service.name=service-yourServiceName", \
     "-Dotel.kafka.server=kafka:9092", \
     "-jar", "app.jar"]
```
