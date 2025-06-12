# 🌱 新苗校园系统

> 🎨 前端项目：[XinMiaoPlatformVue](https://github.com/ln-one/XinMiaoPlatformVue)

基于 Spring Boot 的校园管理系统，用于学生注册和身份认证。

## ✨ 功能特性

- 学生注册与认证
- 基于 JWT 的安全认证
- 密码重置功能
- 个人资料管理
- 使用 Swagger/Knife4j 的 RESTful API 文档

## 🛠 技术栈

- Java 20
- Spring Boot 3.4.5
- Spring Security
- MyBatis
- MySQL
- JWT (JSON Web Tokens)
- Swagger/Knife4j API 文档

## 🚀 快速开始

### 📋 环境要求

- JDK 20+
- MySQL 8.0+
- Maven 3.9+

### ⚙ 配置

在 `application.properties` 中配置数据库连接：

```properties
spring.datasource.url = jdbc:mysql://localhost:3306/campus_system
spring.datasource.username = 你的用户名
spring.datasource.password = 你的密码
```

### 🏗 构建项目

```bash
mvn clean install
```

### 🎯 运行项目

```bash
mvn spring-boot:run
```

应用程序默认将在 8087 端口启动。

## 📚 API 文档

访问以下地址查看 API 文档(在本地运行后)：
- Swagger UI：http://localhost:8087/swagger-ui.html
- Knife4j UI：http://localhost:8087/doc.html

## 🔒 安全特性

- 基于 JWT 的身份认证
- 使用 BCrypt 进行密码加密
- 安全的跨域请求配置

## 👨‍💻 开发指南

### 📦 项目结构
```
src/
├── main/
│   ├── java/com/xinmiao/
│   │   ├── config/      # 配置类
│   │   ├── controller/  # REST API接口
│   │   ├── model/       # 数据模型
│   │   ├── service/     # 业务逻辑
│   │   └── repository/  # 数据库访问
│   └── resources/
│       └── application.properties
```

### 🔧 如何添加新功能

1. **创建新的实体类**
   ```java
   // 在model包中创建新实体
   @Entity
   public class 你的实体类 {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       // 添加你的字段
   }
   ```

2. **添加数据访问层**
   ```java
   // 在repository包中创建
   @Repository
   public interface 你的Repository extends JpaRepository<你的实体类, Long> {
   }
   ```

3. **添加服务层**
   ```java
   // 在service包中创建
   @Service
   public class 你的Service {
       @Autowired
       private 你的Repository repository;
   }
   ```

4. **添加控制器**
   ```java
   // 在controller包中创建
   @RestController
   @RequestMapping("/api/你的接口")
   public class 你的Controller {
       @Autowired
       private 你的Service service;
   }
   ```

### 🎯 面向新手的补充说明

#### 开发前的准备工作
1. **基础知识要求**
   - Java基础：
     - 理解面向对象概念
     - 掌握基本语法（if/else, for循环等）
     - 了解注解的基本概念（@Override等）
   - 数据库基础：
     - 会使用基本的SQL语句（SELECT, INSERT等）
     - 理解主键和外键的概念
   - 推荐学习资源：
     - Java入门：https://www.runoob.com/java/java-tutorial.html
     - MySQL入门：https://www.runoob.com/mysql/mysql-tutorial.html

2. **工具使用指南**
   - IDEA快捷键：
     - `Ctrl + 左键`: 跳转到定义
     - `Alt + Insert`: 生成getter/setter
     - `Ctrl + F9`: 编译项目
     - `Shift + F10`: 运行项目
   - MySQL Workbench使用：
     - 如何连接数据库
     - 如何执行SQL语句
     - 如何查看表结构

3. **报错解决方案**
   - 常见Maven报错：
     ```plaintext
     找不到依赖：
     1. 检查网络连接
     2. 删除 .m2/repository 文件夹
     3. 重新执行 mvn clean install
     ```
   - 常见数据库连接报错：
     ```plaintext
     无法连接数据库：
     1. 检查MySQL服务是否启动
     2. 确认用户名密码正确
     3. 检查数据库名称是否正确
     ```

#### 代码编写流程详解

1. **创建数据库表**
   ```sql
   -- 1. 先写表结构
   CREATE TABLE your_table (
       id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
       name VARCHAR(50) NOT NULL COMMENT '名称',
       create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
   ) COMMENT='你的表说明';
   
   -- 2. 插入测试数据
   INSERT INTO your_table (name) VALUES ('测试数据1');
   ```

2. **编写实体类注意事项**
   ```java
   @Data   // 自动生成getter/setter
   @Entity // 标记这是一个实体类
   @Table(name = "your_table") // 指定表名
   public class YourEntity {
       // 必须有空构造函数
       public YourEntity() {}
       
       // 字段注释很重要
       /**
        * 主键ID
        */
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       
       // 添加字段约束
       @NotBlank(message = "名称不能为空")
       @Length(max = 50, message = "名称最大长度为50")
       private String name;
   }
   ```

#### 调试技巧补充

1. **控制台日志分析**
   ```plaintext
   [ERROR] com.xinmiao.XXX - 发生错误
   错误分析步骤：
   1. 看第一行错误信息
   2. 找到报错的类和行号
   3. 设置断点进行调试
   ```

2. **断点调试说明**
   - 断点类型：
     - 行断点：点击行号添加
     - 异常断点：Debug窗口中设置
     - 条件断点：右键断点设置条件
   
3. **测试数据准备**
   ```java
   // 准备测试数据的例子
   @Test
   void testYourFeature() {
       // 1. 准备测试数据
       YourEntity entity = new YourEntity();
       entity.setName("测试数据");
       
       // 2. 调用被测试方法
       YourEntity result = service.yourMethod(entity);
       
       // 3. 验证结果
       assertNotNull(result.getId());
       assertEquals("测试数据", result.getName());
   }
   ```

### ⚠ 新手开发教程

#### 环境搭建详解
1. **IDE配置**
   - 下载并安装 IntelliJ IDEA
   - 安装必要插件：
     - Lombok
     - Spring Boot Assistant
     - Maven Helper
     
2. **项目导入**
   ```bash
   # 1. 克隆项目
   git clone https://github.com/your-username/XinMiaoSpringBoot.git
   
   # 2. 使用IDEA打开项目
   # File -> Open -> 选择项目目录
   
   # 3. 等待Maven下载依赖
   # 右下角会显示下载进度
   ```

3. **数据库配置**
   ```sql
   -- 1. 创建数据库
   CREATE DATABASE campus_system;
   USE campus_system;
   
   -- 2. 创建示例用户表
   CREATE TABLE users (
       id BIGINT PRIMARY KEY AUTO_INCREMENT,
       username VARCHAR(50) NOT NULL,
       password VARCHAR(100) NOT NULL,
       -- 其他字段...
   );
   ```

#### 实战示例：添加新功能
以添加"学生课程管理"功能为例

1. **创建数据表**
   ```sql
   -- 在MySQL中执行
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

2. **创建实体类**
   ```java
   // 在 model 包中创建 Course.java
   @Data
   @Entity
   @Table(name = "courses")
   public class Course {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       
       @NotBlank(message = "课程名称不能为空")
       private String name;
       
       @Min(value = 1, message = "学分必须大于0")
       private Integer credit;
       
       private String teacher;
   }
   ```

3. **创建Repository**
   ```java
   // 在 repository 包中创建 CourseRepository.java
   @Repository
   public interface CourseRepository extends JpaRepository<Course, Long> {
       // 自定义查询方法
       List<Course> findByTeacher(String teacher);
       
       @Query("SELECT c FROM Course c WHERE c.credit >= :minCredit")
       List<Course> findCoursesWithMinCredit(@Param("minCredit") int minCredit);
   }
   ```

4. **创建Service**
   ```java
   // 在 service 包中创建 CourseService.java
   @Service
   @Transactional
   public class CourseService {
       private final CourseRepository courseRepository;
       
       // 使用构造器注入
       public CourseService(CourseRepository courseRepository) {
           this.courseRepository = courseRepository;
       }
       
       // 添加课程
       public Course addCourse(Course course) {
           // 业务验证
           if (course.getCredit() < 0) {
               throw new BusinessException("学分不能为负数");
           }
           return courseRepository.save(course);
       }
       
       // 其他业务方法...
   }
   ```

5. **创建Controller**
   ```java
   // 在 controller 包中创建 CourseController.java
   @RestController
   @RequestMapping("/api/courses")
   @Tag(name = "课程管理", description = "课程的CRUD接口")
   public class CourseController {
       private final CourseService courseService;
       
       public CourseController(CourseService courseService) {
           this.courseService = courseService;
       }
       
       @PostMapping
       @Operation(summary = "添加课程")
       public ResponseEntity<Course> addCourse(@RequestBody @Valid Course course) {
           return ResponseEntity.ok(courseService.addCourse(course));
       }
       
       // 其他API端点...
   }
   ```

6. **添加单元测试**
   ```java
   // 在 test 目录下创建测试类
   @SpringBootTest
   class CourseServiceTest {
       @Autowired
       private CourseService courseService;
       
       @Test
       void whenAddCourse_thenCourseShouldBeSaved() {
           Course course = new Course();
           course.setName("测试课程");
           course.setCredit(3);
           
           Course saved = courseService.addCourse(course);
           assertNotNull(saved.getId());
           assertEquals("测试课程", saved.getName());
       }
   }
   ```

### 🔍 调试与测试指南

1. **本地调试步骤**
   ```plaintext
   1. 在代码行号旁边点击添加断点
   2. 点击 Debug 按钮（绿色小虫图标）
   3. 使用 F8 单步执行，F7 步入方法
   4. 在 Variables 窗口查看变量值
   ```

2. **接口测试方法**
   - 使用Swagger UI：
     1. 启动项目
     2. 访问 http://localhost:8087/swagger-ui.html
     3. 展开想要测试的接口
     4. 点击"Try it out"
     5. 输入测试数据
     6. 点击"Execute"

3. **常见问题排查**
   ```plaintext
   问题：接口返回500错误
   排查步骤：
   1. 查看控制台错误日志
   2. 检查数据库连接配置
   3. 验证请求参数格式
   4. 检查SQL语句正确性
   ```

## 📄 开源协议

本项目采用 Apache License 2.0 协议开源。
