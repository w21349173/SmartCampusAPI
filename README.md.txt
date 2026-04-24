# Smart Campus Sensor and Room Management API

## Overview
This project is a RESTful API developed for managing rooms and sensors in a smart campus environment. It allows users to create rooms, assign sensors to rooms, and store sensor readings.

The system is built using Java with Jersey (JAX-RS) and runs on an embedded Grizzly HTTP server. All data is stored in memory using HashMaps (no database used as per requirements).

---

## Features

### 1. Discovery Endpoint
- Base URL: /api/v1
- Provides API information and available endpoints

### 2. Room Management
- Create a new room
- View all rooms
- Get a room by ID
- Delete a room (only if no sensors are linked)

### 3. Sensor Management
- Add sensors to rooms
- View all sensors
- Filter sensors by type

### 4. Sensor Readings
- Add sensor readings
- Retrieve readings for a sensor
- Automatically updates current sensor value

### 5. Exception Handling
- Custom exceptions implemented:
  - RoomNotEmptyException
  - LinkedResourceNotFoundException
  - SensorUnavailableException

---

## Technologies Used
- Java
- Maven
- Jersey (JAX-RS)
- Grizzly HTTP Server
- JSON

---

## Project Structure
- Main.java → Starts the server  
- Room.java → Room model  
- Sensor.java → Sensor model  
- SensorReading.java → Reading model  
- DataStore.java → In-memory data storage  
- DiscoveryResource.java → API root endpoint  
- RoomResource.java → Room endpoints  
- SensorResource.java → Sensor endpoints  
- SensorReadingResource.java → Reading endpoints  
- Exception classes → Custom error handling  

---

## How to Run

1. Open project in NetBeans  
2. Right click Main.java  
3. Click Run File  
4. Server starts at:  
   http://localhost:8080/api/v1/

---

## Example Endpoints

- GET /api/v1 → API info  
- GET /api/v1/rooms → List rooms  
- POST /api/v1/rooms → Create room  
- GET /api/v1/sensors → List sensors  
- POST /api/v1/sensors → Create sensor  
- GET /api/v1/sensors/{id}/readings → Get readings  
- POST /api/v1/sensors/{id}/readings → Add reading  

---

## Data Storage
All data is stored in memory using Java HashMaps. Data will be lost when the server stops.

---

## Author
Name: Oalin Zakaria  
Student ID: w2134917  
Course: BSc Computer Science  
University: University of Westminster

---

## Conclusion
This API demonstrates RESTful design principles including resource management, data handling, and modular structure. It simulates a smart campus system using Java backend development.