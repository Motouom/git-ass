# Use the official GraalVM Community Edition runtime as the base image
FROM ghcr.io/graalvm/graalvm-ce:22.3.2 as build-backend

# Set the working directory in the container
WORKDIR /app/PackIt-app-backend

# Copy the Gradle wrapper and build files to the working directory
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Copying the application code to the container
COPY src src

# Building the Spring Boot application using GraalVM
RUN ./gradlew clean build -x test

# Using the official Node.js runtime as the base image for the frontend
FROM node:18 as build-frontend

# Seting up the working directory in the container
WORKDIR /app/frontend

# Copying package.json and package-lock.json to the working directory
COPY package*.json ./

# Installing dependencies
RUN npm ci

# Copying the React application code to the container
COPY . .

# Building the React application using Vite
RUN npm run build

# Using the Nginx stable-alpine image as the production server
FROM nginx:stable-alpine

# Copying the built Spring Boot application to the container
COPY --from=build-backend /app/backend/build/libs/*.jar /app/backend.jar

# Copying the built React application to Nginx's web server directory
COPY --from=build-frontend /app/frontend/dist /usr/share/nginx/html

# Copying the Nginx configuration file
COPY nginx/nginx.conf /etc/nginx/conf.d/default.conf

# Exposing port 80 for the Nginx server
EXPOSE 80

# Starting Nginx and the Spring Boot application when the container runs
CMD ["sh", "-c", "java -jar /app/backend.jar & nginx -g 'daemon off;'"]