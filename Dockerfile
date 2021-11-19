FROM openjdk:11-jre

COPY ./build/libs/app-*.jar ./app-aws-terraform.jar

EXPOSE 8180

ENTRYPOINT ["java","-jar","app-aws-terraform.jar"]