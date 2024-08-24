## How to RUN the Application
1. Open the code(program/application) in the Eclipse IDE.
2. Clcik open the SuppliersInfoApplication.java in the com.search.suppliers package.
3. In this file, right click in the file, go to Run As and then java Application.
4. Or run the application directly by clicking the Run Button on the top.
5. Open the Talend API Tester or Postman, I am using Talend.
6. Select the method as POST.
7. Hit this URL:http://localhost:8080/api/supplier/query
8. Add query parameter like location, natureOfBusiness or manufacturingProcess.
9. Add Authorization:- Username:dummy, Password:dummy
10. Hit the "send" button of the API tester to see the resultt

## Security Implementation.
1. I used the Basic Authentication of Spring Boot Security for the securing the end point.
2. I add the following Dependency to enable the Spring Boot Security.
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

I have implement the SecurityFilterChain interface to provide the Basic Authentication.
We can also provide the robust authentication that is the JWT Role Based Authentication.
A detail illustration of implementing JWT Role Based Authentication is given below:

1-> ADD DEPENDENCY.
```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
   <groupId>io.jsonwebtoken</groupId>
   <artifactId>jjwt</artifactId>
   <version>0.9.1</version>
</dependency>
```

2-> CONFIGURE SPRING SECURITY.
- Create a custom SecurityConfig class that extends WebSecurityConfigurerAdapter.
- Override configure(HttpSecurity http) to define security rules.
- Disable CSRF for stateless sessions.
- Permit /login and /register endpoints and secure others based on roles.

3-> CREATE JWT Utility Class
- Implement a JwtUtil class for generating and validating JWT tokens.
- Implement methods to:
- Generate JWT tokens with roles.
- Validate JWT tokens.
- Extract roles and other claims from the token.

4-> CREATE UserDetailsService Implementation
- Implement a UserDetailsService that loads user details based on username.
- Fetch the user's roles and encode them in the UserDetails object.

5-> CREATE JWT Filter
- Implement a JwtRequestFilter that extends OncePerRequestFilter.
- Extract and validate the JWT from the Authorization header.
- Set the Authentication in the Spring Security context if the token is valid.

6-> CONFIGURE Role-Based Access Control
- Define role-based access control in SecurityConfig using http.authorizeRequests().
- Ensure that different endpoints require different roles (e.g., ADMIN, USER).

7-> CREATE LOGIN AND REGISTRATION ENDPOINTS
- Implement a LoginController to handle authentication requests.
- Validate user credentials, generate JWT, and return it in the response.
- Implement a RegistrationController for user registration, assigning roles to users.

## Database Configuration
```
spring.datasource.url=jdbc:mysql://localhost:3306/searchapi
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=abc
spring.datasource.password=abc123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

## Exception Handling
We can use the Spring Boot's inbuilt GlobaLExceptionHandler Feature to handle the exceptions seamlessly.
I did not used this feature in this given application rather just use a try-catch block.

## Input Validation
We can validate the various inputs provided by the user by adding the following dependency.
```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
