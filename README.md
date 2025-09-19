# Spring Boot JDBC Example — Products App

A simple Spring Boot application using **Spring JDBC** with **PostgreSQL** to manage products.  
This project demonstrates how to connect to a database, insert data, and fetch records using `JdbcTemplate`.

---

## Project Structure

src/main/java/com/smit/web/
 
 ├── SpringWebJdbcApplication.java         # Main class
 
 ├── models/
 
 │   └── Products.java                     # Product entity
 
 ├── repository/
 
 │   └── ProductRepo.java                  # Repository with JdbcTemplate
 
 └── service/
 
 | └── ProductService.java                 # Service layer

---

## Requirements

- **Java 21** (**updated to Java 25)
- **Maven 3.9+**
- **PostgreSQL 15+**
- IDE (IntelliJ / Eclipse / VS Code)

---

## Setup

### 1. Database Setup
Create a database in PostgreSQL:
CREATE DATABASE productsdb;

Make sure your Postgres server is running and you know your username/password.

### 2. Configure Spring Boot
Edit `src/main/resources/application.properties`:

spring.datasource.url=jdbc:postgresql://localhost:5432/productsdb  
spring.datasource.username=yourusername  
spring.datasource.password=yourpassword  
spring.datasource.driver-class-name=org.postgresql.Driver  

# Ensure schema.sql and data.sql always run  
spring.sql.init.mode=always  

# Optional logging  
spring.jpa.show-sql=true  
logging.level.org.springframework.jdbc.datasource.init=DEBUG  

### 3. Schema & Seed Data
Spring Boot automatically executes these on startup:

**schema.sql**
CREATE TABLE products (
    pid INT PRIMARY KEY,
    pname VARCHAR(50),
    pprice INT
);

**data.sql**
INSERT INTO products (pid, pname, pprice) VALUES (1, 'Adidas Running Shoes', 4500);
INSERT INTO products (pid, pname, pprice) VALUES (2, 'Nike AirJordan Shoes', 7800);
INSERT INTO products (pid, pname, pprice) VALUES (3, 'Adidas Football Shoes', 6500);

---

## Running the App

1. Build the project:
   mvn clean install

2. Run the application:
   mvn spring-boot:run

3. The `main` method in `SpringWebJdbcApplication` will:
   - Create a new product
   - Insert it into the DB via `ProductService` and `ProductRepo`
   - Print confirmation to the console

---

## Example Output

1 row(s) effected  
Product Saved: Products{pid=101, pname='Puma White Sneakers', pprice=2900}

---

## Verify in PostgreSQL

SELECT * FROM products;

Output:
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title>Products Output</title>
</head>
<body>
  <h1>Output</h1>

  <table>
    <thead>
      <tr>
        <th>pid</th>
        <th>pname</th>
        <th>pprice</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>Adidas Running Shoes</td>
        <td>4500</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Nike AirJordan Shoes</td>
        <td>7800</td>
      </tr>
      <tr>
        <td>3</td>
        <td>Adidas Football Shoes</td>
        <td>6500</td>
      </tr>
      <tr>
        <td>101</td>
        <td>Puma White Sneakers</td>
        <td>2900</td>
      </tr>
    </tbody>
  </table>
</body>
</html>

---

## Notes

- Use **lowercase table names** in PostgreSQL to avoid case-sensitivity issues.
- `ProductService` uses constructor injection for cleaner code.
- This project is set to `WebApplicationType.NONE` since it runs as a CLI demo.

---

## Future Improvements

- Add REST endpoints to expose CRUD operations
- Implement update & delete methods
- Add unit tests with an H2 in-memory database

---

## License

This project is open source and available under the [MIT License](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/licensing-a-repository).
