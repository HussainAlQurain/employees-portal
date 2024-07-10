# Use a base image with Node.js version 20
FROM node:20-alpine as build

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Build the application
RUN npm run build

# Debug: List the contents of the build directory
RUN ls -al /app/dist/employee-frontend
RUN ls -al /app/dist/employee-frontend/browser

# Use a base image with Nginx
FROM nginx:alpine

# Copy the build artifacts from the previous stage
COPY --from=build /app/dist/employee-frontend/browser /usr/share/nginx/html

# Debug: List the contents of the Nginx html directory
RUN ls -al /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Command to run the application
CMD ["nginx", "-g", "daemon off;"]
