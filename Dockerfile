FROM openjdk:11
EXPOSE 8087
ADD target/daily-poem.jar daily-poem.jar
ENTRYPOINT ["java","-jar","/daily-poem.jar"]