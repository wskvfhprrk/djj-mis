FROM frolvlad/alpine-oraclejdk8
COPY /target/*.jar app.jar
EXPOSE 8888
RUN echo "Asia/Shanghai" > /etc/timezone;
ENTRYPOINT ["java","-jar","/app.jar"]
