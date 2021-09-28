FROM openjdk:11.0.7-slim as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN --mount=type=cache,target=/root/.m2 ./mvnw package -DskipTests

FROM openjdk:11.0.7-slim
# Copy the war file to the deployments folder
COPY --from=build /workspace/app/target/eureka-server.jar app.jar

EXPOSE 8761

# Start app
ENTRYPOINT ["java","-jar","/app.jar"]
