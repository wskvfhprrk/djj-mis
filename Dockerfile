FROM frolvlad/alpine-oraclejdk8
COPY target/*.jar app.jar
#启动时的端口号
EXPOSE 8080
RUN echo "Asia/Shanghai" > /etc/timezone;
ENTRYPOINT ["java","-jar","/app.jar"]
