 
# Use the official Maven image to build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and the source code to the container
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package

# Use the official Tomcat image to run the application
FROM tomcat:jdk17

# Copy the WAR file to the webapps directory in Tomcat
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose the port on which Tomcat runs
EXPOSE 8081

# Define the command to run Tomcat
CMD ["catalina.sh", "run"]


