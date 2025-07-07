# 📄 Employee Attendance Management System

A Spring Boot–based backend system for managing employee attendance with PDF report generation and RESTful APIs.

---

## 📌 Task Option Chosen
**Option 3 – Desktop/Backend Software**

---

## 🛠️ Technologies Used
- Java 17
- Spring Boot
- MySQL
- Lombok
- iText (for PDF generation)
- Maven

---

## 🔑 Features Implemented
1. Add / View / Update / Delete Employees
2. Mark daily attendance (In/Out times)
3. View attendance records (daily / all)
4. Download PDF attendance reports
5. REST API compatible with frontend or Postman

---

## ⚙️ How to Run

1. Clone or download this repository
2. Open the project in your IDE (e.g., IntelliJ, VS Code, Eclipse)
3. Create a MySQL database named `employee`
4. Update your database credentials in `src/main/resources/application.properties`:

```properties
spring.datasource.username=your_username
spring.datasource.password=your_password
```

5. Run the project:

```bash
mvn spring-boot:run
```

6. Use Postman or your own frontend to test the endpoints

---

## 📸 Screenshots  
🔗 [View Screenshots Here](#https://drive.google.com/drive/folders/1VIeOxTR_ZKXVnrIn93kztQ0aVerQye3P?usp=sharing) 

---

## 🎥 Demo Video  
🔗 [Watch Demo Video](#https://drive.google.com/file/d/17GBjV9nTWOTu4wQYRVx7EhKzhgVuTP2k/view?usp=sharing) 

---

## 📡 API Endpoints

### 👤 Employee Management APIs

| Action            | Method | URL                    |
|-------------------|--------|------------------------|
| Create Employee   | POST   | `/api/employees`       |
| Get All Employees | GET    | `/api/employees`       |
| Get Employee by ID| GET    | `/api/employees/{id}`  |
| Update Employee   | PUT    | `/api/employees/{id}`  |
| Delete Employee   | DELETE | `/api/employees/{id}`  |

📦 Sample Request for Create:

```json
{
  "name": "Kamal Perera",
  "role": "Software Engineer",
  "department": "IT"
}
```

---

### ⏰ Attendance Management APIs

| Action                            | Method | URL                                             |
|-----------------------------------|--------|--------------------------------------------------|
| Mark Attendance                   | POST   | `/api/attendance/mark`                          |
| Get Today's Attendance            | GET    | `/api/attendance/today`                         |
| Get All Attendance Records        | GET    | `/api/attendance/all`                           |
| Update Attendance                 | PUT    | `/api/attendance/{id}`                          |
| Delete Attendance                 | DELETE | `/api/attendance/{id}`                          |
| Download Today's Attendance Report| GET    | `/api/attendance/report/pdf`                    |
| Download All Attendance Report    | GET    | `/api/attendance/all/report/pdf`                |

📦 Sample Request for Mark Attendance:

```json
{
  "employeeId": 1,
  "timeIn": "08:30:00",
  "timeOut": "17:30:00"
}
```

---

## 📁 Project Structure

```
employee-attendance-system/
 ├── src/
 │   └── main/
 │       ├── java/com/example/attendance/
 │       │   ├── controller/
 │       │   ├── service/
 │       │   ├── repository/
 │       │   ├── entity/
 │       │   └── AttendanceApplication.java
 │       └── resources/
 │           ├── application.properties
 │           └── templates/
 └── pom.xml
```



© 2025 – Developed by Dileepa Abeykoon
