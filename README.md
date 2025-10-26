#  Java Console Application — Shop Management (JDBC + Singleton + Lambdas)

This project is a **Java console application** that connects to a PostgreSQL database using **JDBC**.  
It demonstrates advanced Java concepts such as:

- **Singleton pattern** (`DbConnectionManager`)
- **Inner and local classes**
- **Anonymous classes**
- **Lambdas and functional interfaces** (`Predicate`, `Consumer`)
- **Generic Validator** interface extending `Predicate<T>`

---

##  Overview

The application simulates creating shops and saving them into a PostgreSQL database.  
Each shop has:
- `shopId`, `shopName`, `shopOwner`
- an inner `About` class containing: `city`, `address`, `email`

After inserting a shop, the program validates its email format using a `Predicate<String>` (`EmailFormatChecker`).  
A local class `ShopNotifier` prints the validation result and confirmation message using **lambda expressions**.
And provides worning that mail is not correct and to verify it manually later.

---

##  Technologies and Dependencies

| Library | Purpose | Why It’s Used |
|----------|----------|---------------|
| **PostgreSQL JDBC Driver** | Database connectivity | To connect Java to PostgreSQL |
| **Lombok** | Reduces boilerplate | Generates getters, setters, constructors |
| **JUnit 5** | Testing (optional) | Allows unit testing if needed |
| **Java 21** | Language features | Supports lambdas, records, try-with-resources |

## Java Imports Used

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import lombok.RequiredArgsConstructor;

### `pom.xml` Dependencies
```xml
<dependencies>
    <!-- PostgreSQL JDBC Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.4</version>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.34</version>
        <scope>provided</scope>
    </dependency>

    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.11.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>


# run this command to create Database
CREATE DATABASE "ShopList";
# run this command to Create table
CREATE TABLE shops (
    shop_id SERIAL PRIMARY KEY,
    shop_name VARCHAR(100) NOT NULL,
    shop_owner VARCHAR(100),
    city VARCHAR(100),
    address VARCHAR(255),
    email VARCHAR(100)
);
#In DbConnectionManager.java, update your PostgreSQL credentials:
private static final String URL = "jdbc:postgresql://localhost:5432/ShopList";
private static final String USER = "postgres";     // your username
private static final String PASSWORD = "yourPass"; // your password

#Compile
mvn clean compile

#run console
mvn exec:java -Dexec.mainClass="org.example.Main"
Or manually:
javac -d target/classes src/main/java/org/example/*.java
java -cp target/classes org.example.Main

#Build Executable JAR
1. Package the project:
mvn clean package
#This will create the JAR file:
target/first-Task-ClassTypes-1.0-SNAPSHOT.jar

#Run the JAR:
java -jar target/first-Task-ClassTypes-1.0-SNAPSHOT.jar

Example Output
When email is valid:
Shop ID: 1
Email 'irena@.gmail' is valid and saved for shop 'SomeShop'.
 When email is invalid :
Shop ID: 2
Email 'irena.gmail' seems invalid. Please verify it manually later.
 

