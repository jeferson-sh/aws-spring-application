FROM alpine:latest
RUN apk --no-cache add curl
RUN apk --no-cache add openjdk21
VOLUME /tmp
ARG REGION_ARG=us-east-2
ARG ACCESS_ARG
ARG SECRET_ARG
ENV AWS_REGION=$REGION_ARG
ENV AWS_ACCESS_KEY=$ACCESS_ARG
ENV AWS_SECRET_KEY=$SECRET_ARG
ARG JAR_FILE=target/app.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar", "-XX:+HeapDumpOnOutOfMemoryError", "-XX:OnOutOfMemoryError='java --version'"]
