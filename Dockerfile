FROM adoptopenjdk/openjdk11:alpine-jre
COPY ./build/libs/composer-program-0.0.1-SNAPSHOT.jar app.jar
#RUN chmod +x entrypoint.sh
ENTRYPOINT ["java", "-jar", "app.jar"]