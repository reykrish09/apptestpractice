FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/reyankrish-app-1.0.0.jar app.jar

EXPOSE 8080

CMD ["java", "--add-modules", "jdk.httpserver", "-cp", "app.jar", "com.reyankrish.App"]