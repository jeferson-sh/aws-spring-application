FROM alpine:latest
RUN apk --no-cache add curl openjdk21 aws-cli

VOLUME /tmp

ARG REGION_ARG=us-east-2
ARG ACCESS_ARG
ARG SECRET_ARG

ENV AWS_REGION=$REGION_ARG
ENV AWS_ACCESS_KEY_ID=$ACCESS_ARG
ENV AWS_SECRET_ACCESS_KEY=$SECRET_ARG

ARG JAR_FILE=target/app.jar
COPY ${JAR_FILE} app.jar

COPY upload.sh /usr/local/bin/upload.sh
RUN chmod +x /usr/local/bin/upload.sh

EXPOSE 8080

ENTRYPOINT ["java", "-XX:+HeapDumpOnOutOfMemoryError", "-XX:HeapDumpPath=/tmp", "-XX:OnOutOfMemoryError=/usr/local/bin/upload.sh", "-jar", "app.jar"]
