# Step 1: Use Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set working directory inside container
WORKDIR /app

# Step 3: Copy Maven wrapper and pom.xml first (for caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Step 4: Give execute permission to mvnw
RUN chmod +x mvnw

# Step 5: Download dependencies
RUN ./mvnw dependency:go-offline -B

# Step 6: Copy source code
COPY src ./src

# Step 7: Build the JAR file
RUN ./mvnw clean package -DskipTests

# Step 8: Expose port
EXPOSE 8080

# Step 9: Run the application
ENTRYPOINT ["java", "-jar", "target/Banking-Application-0.0.1-SNAPSHOT.jar"]