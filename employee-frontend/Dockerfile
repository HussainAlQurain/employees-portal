# Use a base image with Node.js version 20
FROM node:20-alpine

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

# Use a base image with Nginx
FROM nginx:alpine

# Copy the build artifacts from the previous stage
COPY --from=0 /app/dist/employee-frontend /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Command to run the application
CMD ["nginx", "-g", "daemon off;"]
