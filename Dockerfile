FROM maven:3.9.9-amazoncorretto-21-debian AS builder
WORKDIR /app
COPY . /app/.
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

FROM tomcat:10-jdk21
WORKDIR /usr/local/tomcat
COPY --from=builder /app/target/app.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]