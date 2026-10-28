HRMS BACKEND - LOGIN AND ATTENDANCE DASHBOARD

Project folder name is unchanged: HrmsDatabase

Requirements:
- JDK compatible with the Java version configured in pom.xml
- MySQL Server running
- Database credentials configured in src/main/resources/application.properties

Run:
1. Open this HrmsDatabase folder in IntelliJ IDEA.
2. Check spring.datasource.username and spring.datasource.password in application.properties.
3. Ensure MySQL is running. The configured database name is abeshclhrms.
4. Run HrmsDatabaseApplication.java.

New endpoints:
- POST http://localhost:8080/v1/user/login
  JSON body: {"emp_email":"employee@example.com","emp_password":"password"}
- GET http://localhost:8080/v1/user/attendance/{emp_id}

Existing registration endpoint remains:
- POST http://localhost:8080/v1/user/addemp

Notes:
- Login compares the plain-text password saved in the existing Employee table, as requested for this basic demo.
- This is not production authentication. Do not deploy it publicly without adding proper password hashing and authorization.
