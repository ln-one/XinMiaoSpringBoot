# 🌱 XinMiao Campus System

> 🎨 Frontend project: [XinMiaoPlatformVue](https://github.com/ln-one/XinMiaoPlatformVue)

A Spring Boot-based campus system for managing student registration and authentication.

[📖 中文文档](README_zh.md)

## ✨ Features

- Student registration and authentication
- JWT-based secure authentication
- Password reset functionality
- Profile management
- RESTful API documentation with Swagger/Knife4j

## 🛠 Tech Stack

- Java 20
- Spring Boot 3.4.5
- Spring Security
- MyBatis
- MySQL
- JWT (JSON Web Tokens)
- Swagger/Knife4j for API documentation

## 🚀 Getting Started

### 📋 Prerequisites

- JDK 20+
- MySQL 8.0+
- Maven 3.9+

### ⚙ Configuration

Configure your database connection in `application.properties`:

```properties
spring.datasource.url = jdbc:mysql://localhost:3306/campus_system
spring.datasource.username = your_username
spring.datasource.password = your_password
```

### 🏗 Building

```bash
mvn clean install
```

### 🎯 Running

```bash
mvn spring-boot:run
```

The application will start on port 8087 by default.

## 📚 API Documentation

Access the API documentation at:
- Swagger UI: http://localhost:8087/swagger-ui.html
- Knife4j UI: http://localhost:8087/doc.html

## 🔒 Security

- JWT-based authentication
- Password hashing using BCrypt
- CORS configuration for secure cross-origin requests

## 👨‍💻 Developer Guide

### Project Structure
```
src/
├── main/
│   ├── java/com/xinmiao/
│   │   ├── config/      # Configuration classes
│   │   ├── controller/  # REST API endpoints
│   │   ├── model/       # Data models
│   │   ├── service/     # Business logic
│   │   └── repository/  # Database access
│   └── resources/
│       └── application.properties
```

### How to Add New Features

1. **Creating a New Entity**
   ```java
   // Example: Create a new entity in model package
   @Entity
   public class YourEntity {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       // Add your fields
   }
   ```

2. **Adding Repository Layer**
   ```java
   // Create in repository package
   @Repository
   public interface YourRepository extends JpaRepository<YourEntity, Long> {
   }
   ```

3. **Adding Service Layer**
   ```java
   // Create in service package
   @Service
   public class YourService {
       @Autowired
       private YourRepository repository;
   }
   ```

4. **Adding Controller**
   ```java
   // Create in controller package
   @RestController
   @RequestMapping("/api/your-endpoint")
   public class YourController {
       @Autowired
       private YourService service;
   }
   ```

### Integration Guidelines

1. **Database Integration**
   - Add your table definitions to `campus_system` database
   - Update entities with proper table mappings
   - Test connections using provided configuration

2. **Security Integration**
   - All new endpoints should be secured using JWT
   - Add security annotations to your controllers
   ```java
   @PreAuthorize("hasRole('ROLE_USER')")
   ```

3. **API Documentation**
   - Add Swagger annotations to all new endpoints
   ```java
   @Operation(summary = "Your API description")
   @ApiResponses(value = {
       @ApiResponse(responseCode = "200", description = "Success")
   })
   ```

4. **Testing**
   - Write unit tests for services
   - Write integration tests for controllers
   - Use provided test configuration

### ⚠ Common Pitfalls
- Always use constructor injection over field injection
- Follow existing package structure
- Use provided utility classes
- Handle exceptions properly using global exception handler

## 🎓 Detailed Development Tutorial

### Environment Setup
1. **IDE Configuration**
   - Download and install IntelliJ IDEA
   - Install required plugins:
     - Lombok
     - Spring Boot Assistant
     - Maven Helper

2. **Project Import**
   ```bash
   # 1. Clone the project
   git clone https://github.com/your-username/XinMiaoSpringBoot.git
   
   # 2. Open with IDEA
   # File -> Open -> Select project directory
   
   # 3. Wait for Maven dependencies
   # Progress shown in bottom-right corner
   ```

3. **Database Setup**
   ```sql
   -- 1. Create database
   CREATE DATABASE campus_system;
   USE campus_system;
   
   -- 2. Create example user table
   CREATE TABLE users (
       id BIGINT PRIMARY KEY AUTO_INCREMENT,
       username VARCHAR(50) NOT NULL,
       password VARCHAR(100) NOT NULL,
       -- other fields...
   );
   ```

### Practical Example: Adding New Feature
Using "Student Course Management" as an example

1. **Create Database Tables**
   ```sql
   -- Execute in MySQL
   CREATE TABLE courses (
       id BIGINT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(100) NOT NULL,
       credit INT NOT NULL,
       teacher VARCHAR(50)
   );
   
   CREATE TABLE student_courses (
       student_id BIGINT,
       course_id BIGINT,
       PRIMARY KEY (student_id, course_id)
   );
   ```

2. **Create Entity Class**
   ```java
   // Create Course.java in model package
   @Data
   @Entity
   @Table(name = "courses")
   public class Course {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       
       @NotBlank(message = "Course name cannot be empty")
       private String name;
       
       @Min(value = 1, message = "Credit must be greater than 0")
       private Integer credit;
       
       private String teacher;
   }
   ```

3. **Create Repository**
   ```java
   // Create CourseRepository.java in repository package
   @Repository
   public interface CourseRepository extends JpaRepository<Course, Long> {
       // Custom query methods
       List<Course> findByTeacher(String teacher);
       
       @Query("SELECT c FROM Course c WHERE c.credit >= :minCredit")
       List<Course> findCoursesWithMinCredit(@Param("minCredit") int minCredit);
   }
   ```

4. **Create Service**
   ```java
   // Create CourseService.java in service package
   @Service
   @Transactional
   public class CourseService {
       private final CourseRepository courseRepository;
       
       // Constructor injection
       public CourseService(CourseRepository courseRepository) {
           this.courseRepository = courseRepository;
       }
       
       // Add course
       public Course addCourse(Course course) {
           // Business validation
           if (course.getCredit() < 0) {
               throw new BusinessException("Credit cannot be negative");
           }
           return courseRepository.save(course);
       }
       
       // Other business methods...
   }
   ```

5. **Create Controller**
   ```java
   // Create CourseController.java in controller package
   @RestController
   @RequestMapping("/api/courses")
   @Tag(name = "Course Management", description = "Course CRUD APIs")
   public class CourseController {
       private final CourseService courseService;
       
       public CourseController(CourseService courseService) {
           this.courseService = courseService;
       }
       
       @PostMapping
       @Operation(summary = "Add course")
       public ResponseEntity<Course> addCourse(@RequestBody @Valid Course course) {
           return ResponseEntity.ok(courseService.addCourse(course));
       }
       
       // Other API endpoints...
   }
   ```

6. **Add Unit Tests**
   ```java
   // Create test class in test directory
   @SpringBootTest
   class CourseServiceTest {
       @Autowired
       private CourseService courseService;
       
       @Test
       void whenAddCourse_thenCourseShouldBeSaved() {
           Course course = new Course();
           course.setName("Test Course");
           course.setCredit(3);
           
           Course saved = courseService.addCourse(course);
           assertNotNull(saved.getId());
           assertEquals("Test Course", saved.getName());
       }
   }
   ```

### 🔍 Debugging and Testing Guide

1. **Local Debugging Steps**
   ```plaintext
   1. Add breakpoint by clicking on line number
   2. Click Debug button (green bug icon)
   3. Use F8 for step over, F7 for step into
   4. Check variable values in Variables window
   ```

2. **API Testing Method**
   - Using Swagger UI:
     1. Start the project
     2. Visit http://localhost:8087/swagger-ui.html
     3. Expand the API you want to test
     4. Click "Try it out"
     5. Enter test data
     6. Click "Execute"

3. **Common Issues Troubleshooting**
   ```plaintext
   Issue: API returns 500 error
   Debug steps:
   1. Check console error logs
   2. Verify database connection
   3. Validate request parameters
   4. Check SQL query correctness
   ```

### 🎯 Beginner's Guide

#### Prerequisites Knowledge
1. **Basic Requirements**
   - Java Basics:
     - Understanding OOP concepts
     - Basic syntax (if/else, loops)
     - Basic annotations (@Override etc.)
   - Database Basics:
     - Basic SQL queries (SELECT, INSERT)
     - Understanding primary/foreign keys
   - Recommended Resources:
     - Java Tutorial: https://www.tutorialspoint.com/java/
     - MySQL Tutorial: https://www.tutorialspoint.com/mysql/

2. **Tool Usage Guide**
   - IDEA Shortcuts:
     - `Ctrl + Click`: Go to definition
     - `Alt + Insert`: Generate getter/setter
     - `Ctrl + F9`: Build project
     - `Shift + F10`: Run project
   - MySQL Workbench:
     - How to connect database
     - How to execute SQL
     - How to view table structure

3. **Troubleshooting Guide**
   - Common Maven Issues:
     ```plaintext
     Dependency not found:
     1. Check network connection
     2. Delete .m2/repository folder
     3. Run mvn clean install again
     ```
   - Database Connection Issues:
     ```plaintext
     Cannot connect to database:
     1. Check if MySQL service is running
     2. Verify username and password
     3. Check database name
     ```

## 📄 License

This project is licensed under the Apache License 2.0.
