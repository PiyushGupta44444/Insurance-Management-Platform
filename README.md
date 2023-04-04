<h1>Insurance Management Platform with Spring Boot and Java</h1>
<h1>Objective:</h1>
<p>Build an insurance management platform that allows users to manage insurance
policies, clients, and claims using Spring Boot and Java.</p>

<h1>Tech Stack</h1>
  <ul>
    <li>Java</li>
    <li>Spring Boot</li>
    <li>Spring Security</li>
    <li>Spring Data JPA</li>
    <li>MySQL</li>
  </ul>
  
<h1>How to Run Locally</h1>
<ol>
<li>Clone the repository.</li>
<li>Open the project in your preferred IDE.</li>
<li>Update the application.properties file with your MySQL database credentials.</li>
<li>Run the InsurancePolicyApplication class.</li>
<li>Navigate to <a href="http://localhost:1200">http://localhost:1200</a> in your web browser to access the application.</li>
</ol> 

 <h1>Project Structure</h1>
    <ul>
      <li>src/main/java/com.insurancePolicy: This package contains the spring boot application class.</li>
      <li>src/main/java/com.insurancePolicy.Config: This package contains the configuration class.</li>
      <li>src/main/java/com.insurancePolicy.Controller: This package contains the RESTful API controllers for managing clients, policies, and claims.</li>
      <li>src/main/java/com.insurancePolicy.Exception: This package contains custom exception classes.</li>
      <li>src/main/java/com.insurancePolicy.Model: This package contains the domain models for the clients, policies, and claims.</li>
      <li>src/main/java/com.insurancePolicy.Payloads:  This package contains request and response payload classes.</li>
      <li>src/main/java/com.insurancePolicy.Repository: This package contains the repository interfaces that interact with the MySQL database.</li>
      <li>src/main/java/com.insurancePolicy.Security: This package contains security related classes. For eg-JwtFilter class.</li>
      <li>src/main/java/com.insurancePolicy.Service: This package contains business logic and data processing.</li>
    </ul>
    
 <h1>Features</h1>
     <ul>
    <li>Create, read, update, and delete clients, insurance policies, and claims.</li>
    <li>Each policy is associated with a client, and each claim is associated with a policy.</li>
    <li>JWT-based authentication to secure the APIs and Role-based access control.</li>
    <li>Policy creation, view and management.</li>
    <li>Exception handling and validation are implemented to ensure proper API usage and data integrity.</li>
     </ul>
    
<h1>API Documentation using Swagger</h1>
 <p>Navigate to <a href="http://localhost:1200/swagger-ui/index.html">http://localhost:1200/swagger-ui/index.html</a> in your web browser to access the documentation.</p>
 
 <h1>Accessing the APIs</h1>
 <p>In order to access the /api/clients, /api/policies, and /api/claims endpoints, one needs to generate a JWT token with the username and password set as ADMIN.</p>
 
