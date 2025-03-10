# Use an OpenJDK JDK base image
FROM openjdk:11-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Java application code
COPY DatabaseLister.java /app

# Download and install necessary libraries (Gson and MySQL Connector/J)
RUN apt-get update && apt-get install -y wget && \
    wget https://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.8/gson-2.8.8.jar && \
    wget https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.28/mysql-connector-java-8.0.28.jar && \
    apt-get clean

# Compile the Java application
RUN javac -cp gson-2.8.8.jar:mysql-connector-java-8.0.28.jar DatabaseLister.java

# Command to run the application
CMD ["java", "-cp", ".:gson-2.8.8.jar:mysql-connector-java-8.0.28.jar", "DatabaseLister"]