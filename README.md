# Microservices: Communication between Departments and Employees
## Employee Service
-This has all the employee information, as well as address information for all employees. 
-The addresses are accessed via Spring Data JPA, and each address is displayed with it's corresponding employee.

## Departments Service
-This has department information.
-This service communicates with the Employee Service in order to obtain all the employees and their information depending on the department they belong to.
-The interservice communication happens via WebClient.

