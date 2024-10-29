# Weather App
### Overview
This is a simple Weather Application built using Spring Boot and Thymeleaf that retrieves current weather information for a specified city using the Weatherstack API.

### Features
- Search for current weather by city name.
- Displays weather details such as temperature, humidity, wind speed, and more.
- Error handling for invalid city names.

### Technologies Used
- Spring Boot: For building the backend application.
- Thymeleaf: For rendering dynamic HTML content.
- RestTemplate: For making RESTful API calls.
- Weatherstack API: For fetching weather data.

### Getting Started
#### Prerequisites
- Java 11 or higher
- Maven
- An IDE (like IntelliJ IDEA or Eclipse)

### Installation
#### 1. Clone the repository:
```bash
git clone https://github.com/yourusername/weather-app.git
cd weather-app
```
#### 2. Add your Weatherstack API Key to application.properties:
```properties
weatherstack.api.key=YOUR_API_KEY
```
#### 3. Build and run the application:
```bash
mvn clean install
mvn spring-boot:run
```
#### 4. Access the application in your web browser:
```bash
http://localhost:8080/
```
### Usage
- Enter a city name in the search bar and click "Get Weather".
- If the city does not exist, an error message will be displayed.
- If the city is valid, the current weather information will be shown.

File Structure
```bash
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── Weather/
│   │               ├── App/
│   │               │   ├── controller/
│   │               │   │   └── MyController.java
│   │               │   ├── service/
│   │               │   │   └── WeatherService.java
│   │               └── ...
│   └── resources/
│       ├── static/
│       │   └── styles.css
│       ├── templates/
│       │   └── Searching.html
│       └── application.properties
└── ...
```


