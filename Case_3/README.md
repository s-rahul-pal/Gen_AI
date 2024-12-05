# Gone Gourmet App

This is a full-stack application that allows users to select a restaurant brand and city, and view a list of unavailable items for that selected combination. The app is built using **React** for the frontend and **Spring Boot** for the backend.

## Features

- **Brand Selection**: Dropdown to select a restaurant brand.
- **City Selection**: Dropdown to select a city based on the selected brand.
- **Submit Button**: Allows the user to confirm their selection of a restaurant brand and city.
- **Unavailable Items Card**: Displays unavailable items for the selected brand and city, including the reason for unavailability.
- **Search Functionality**: Search for unavailable items by name.

## Tech Stack

- **Frontend**: React, HTML, CSS
- **Backend**: Spring Boot (Java)
- **Database**: PostgreSQL

## Table of Contents

1. [Frontend Setup](#frontend-setup)
2. [Backend Setup](#backend-setup)
3. [Database Setup](#database-setup)
4. [API Endpoints](#api-endpoints)
5. [Folder Structure](#folder-structure)
6. [Screenshots](#screenshots)
7. [Contributing](#contributing)
8. [License](#license)

---

## Frontend Setup

1. Clone the frontend repository:
   ```bash
   git clone https://github.com/your-username/gone-gourmet-frontend.git
   cd gone-gourmet-frontend

2. Install dependencies:
    npm install

3. Start the development server:
    npm start

This will run the React app at http://localhost:3000.


## Backend Setup

1. Clone the backend repository:
    git clone https://github.com/your-username/gone-gourmet-backend.git
    cd gone-gourmet-backend

2. Install dependencies and run the backend:
    mvn spring-boot:run

The Spring Boot application will run at http://localhost:8080.

## Database Setup

1. You will need a PostgreSQL instance running.
2. Create a new database for the app (e.g., gone_gourmet).
3. Use the following SQL queries to create the required tables and insert sample data:
    ```bash
    CREATE TABLE brand (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
    );

    CREATE TABLE city (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    brand_id INT REFERENCES brand(id)
    );

    CREATE TABLE unavailable_item (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    reason VARCHAR(100),
    city_id INT REFERENCES city(id)
    );

    -- Insert sample data
    INSERT INTO brand (id, name) VALUES (1, 'Arby\'s Restaurant'), (2, 'Gone Gourmet');

    INSERT INTO city (id, name, brand_id) VALUES 
    (1, 'Rome', 1),
    (2, 'Geneva', 1),
    (3, 'Hamburg', 2),
    (4, 'New York', 2);

    INSERT INTO unavailable_item (id, name, reason, city_id) VALUES
    (1, 'Market Fresh Peach Lemonade', 'Out of Stock', 1),
    (2, 'Roast Beef Sandwich', 'Seasonal Item', 2),
    (3, 'Vegan Burger', 'Discontinued', 3),
    (4, 'Classic Fries', 'Out of Stock', 4);


4. CORS Configuration: Make sure to configure CORS in the Spring Boot application to allow          communication from the React frontend (running on http://localhost:3000):
    ```bash
    @CrossOrigin(origins = "http://localhost:3000")


### API Endpoints
-** GET /api/brands: Fetches all restaurant brands.
-** GET /api/cities?brandId={brandId}: Fetches cities based on the selected brand.
-** GET /api/unavailable-items?brandId={brandId}&cityId={cityId}: Fetches unavailable items for the selected brand and city.
