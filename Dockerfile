FROM ubuntu
RUN apt update
RUN apt install openjdk-17-jdk -y
ADD https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.26/bin/apache-tomcat-10.1.26.tar.gz .
RUN tar -zxvf apache-tomcat-10.1.26.tar.gz
EXPOSE 8080
COPY hello-world.war apache-tomcat-10.1.26/webapps/
ENTRYPOINT apache-tomcat-10.1.26/bin/startup.sh && /bin/bash