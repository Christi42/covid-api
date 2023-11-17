FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

EXPOSE 8080

COPY build/libs/covid-api-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-jar","covid-api-0.0.1-SNAPSHOT.jar"]


#RUN composer update
#RUN composer install



