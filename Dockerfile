# Use an OpenJDK runtime as a parent image
FROM adoptopenjdk/openjdk11:alpine-jre

# Set the working directory to /app
WORKDIR /app

# Copy the packaged application and any dependencies into the container
COPY target/product-management-0.0.1-SNAPSHOT.jar /app

# Set the command to run the application when the container starts
CMD ["java", "-jar", "product-management-0.0.1-SNAPSHOT.jar"]
