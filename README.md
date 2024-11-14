
## Pincode Distance & Duration API

This project is a REST API to calculate the distance and duration between two pin codes using the Google Maps API, along with caching results to optimize calls and reduce costs. This API can be tested via Postman.

### Features

1.  **Fetch Distance and Duration** between two pin codes using Google Maps.
2.  **Cache Responses** to avoid repeated calls to Google Maps.
3.  **Store Route Data** including polyline information for visualization.
4.  **Pincode Information Storage** (latitude, longitude, and polygon data).
5.  **Test-Driven Development (TDD)** using JUnit.

### Tech Stack

-   **Java** (Spring Boot)
-   **MySQL** (Database)
-   **Google Maps API** (for distance and route data)
-   **Postman** (for testing API endpoints)

----------

### Table of Contents

-   [Requirements](#requirements)
-   [Setup](#setup)
-   [Project Structure](#project-structure)
-   [Configuration](#configuration)
-   [Running the Application](#running-the-application)
-   [API Endpoints](#api-endpoints)
-   [Testing with JUnit](#testing-with-junit)

----------

### Requirements

-   Java 11 or higher
-   MySQL
-   Maven
-   Google Maps API Key
-   Postman (for testing)

----------

### Setup

#### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/pincode-dist
cd pincode-dist
```

#### 2. MySQL Database Setup

1.  Open MySQL and create a new database:
    `CREATE DATABASE pincode_dist;` 
    
2.  Set up a MySQL user and password with full access to this database.
    

#### 3. Configure Application Properties
```bash
In `src/main/resources/application.properties`, add your database credentials and Google Maps API key:
spring.datasource.url=jdbc:mysql://localhost:3306/pincode_dist
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update

# Google Maps API Key
google.maps.api.key=YOUR_GOOGLE_MAPS_API_KEY

# Enable caching
spring.cache.type=simple

Replace  `YOUR_DB_USERNAME`, `YOUR_DB_PASSWORD`, and `YOUR_GOOGLE_MAPS_API_KEY` with your actual credentials.
```

#### 4. Install Dependencies

Run the following command in the project root to install dependencies:

```bash
mvn clean install
```

### Configuration

1.  **Database Connection**: Update the database connection details in `application.properties`.
2.  **Google Maps API Key**: Place your API key in `application.properties`.
3.  **Caching**: The `spring.cache.type=simple` enables in-memory caching, which optimizes Google Maps API calls.

----------

### Running the Application

1.  **Start the Application**
    
    ```bash
    mvn spring-boot:run
    ```
    
2.  **Access the API**
    
    By default, the API is accessible at `http://localhost:8080/api/routes`.
    

----------

### API Endpoints

The API can be tested via Postman or any other REST client.

#### Get Distance and Duration

**Request**: `GET /api/routes/distance-duration`

**Query Parameters**:

-   `fromPincode` - Starting pincode
-   `toPincode` - Destination pincode

**Example Request**:

```bash
GET http://localhost:8080/api/routes/distance-duration?fromPincode=141106&toPincode=110060
```

**Response**:

```json
{
  "fromPincode": "141106",
  "toPincode": "110060",
  "distance": "20 km",
  "duration": "30 min",
  "routePolyline": "encodedPolylineString"
}
``` 

This endpoint retrieves the distance, duration, and route information between the specified pin codes. If the request has been made before, the response is cached to avoid multiple calls to the Google Maps API.

----------

### Testing with JUnit

1.  **Run Tests**:
    
    ```bash
	   mvn test
	   ```
    
2.  **Test Coverage**: This project follows TDD principles with unit tests in `RouteServiceTest.java`.
    
3.  **Sample Test** in `RouteServiceTest.java`:
    
    ```java
    `@Test
    public void testGetRouteDetails_fromCache() {
        String fromPincode = "141106";
        String toPincode = "110060";
        RouteData routeData = new RouteData(fromPincode, toPincode, "20 km", "30 min", "encodedPolyline");
    
        Mockito.when(routeRepository.findByFromPincodeAndToPincode(fromPincode, toPincode))
                .thenReturn(Optional.of(routeData));
    
        RouteResponse response = routeService.getRouteDetails(fromPincode, toPincode);
    
        assertEquals("20 km", response.getDistance());
        assertEquals("30 min", response.getDuration());
    }
    ```
    

----------

### Notes

-   Ensure the **Google Maps API** is enabled in your Google Cloud Console.
-   The database must be running and accessible.
-   **Caching**: Cached responses are stored in memory for repeated calls to optimize API usage.
-   **Error Handling**: Error handling is minimal and can be expanded based on specific use cases.

----------

### Troubleshooting

-   **Invalid API Key**: Verify your Google Maps API key in the `application.properties` file.
-   **Database Connection Error**: Ensure MySQL is running, and the credentials are correct.
-   **Cache Issues**: Restarting the server clears the in-memory cache.