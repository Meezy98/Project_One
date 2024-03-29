## Expense Reimbursement System
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can log in and submit requests for reimbursements and view their past tickets and pending requests. Managers can log in and view all reimbursement requests and past history for all employees in the company. Managers are authorized to approve and deny requests for expense reimbursements.
### Key features
- Employee
    - An employee can login to see their own reimbursements, past and pending
    - An employee can submit a reimbursement with an amount and a reason
   
- Manager
    - A Manager can view all reimbursements past and pending
    - A Manager can approve or deny any reimbursement
    - Managers can view a 'statistics' page. That includes information like what employee spends the most money, mean expenditure cost etc...
    
    --Needed for Runtime:
    -RDS has been terminated. I included a data.sql file with create and populate logic. After implementing H2, you should be able to log in and view/create/modify reimbursements

--Responsibilites--
-Persist user info using AWS Postgres RDS
-Setup Dao Layer and Repository layer using Hibernate and JPA
-Build frontend web application using HTML, CSS, and JavaScript
-Test service layer methods using Mockito with JUnit 5
-Develop backend using Javalin
-Log all transcations using Logback
-Setup frontend HTTP Requests using the Fetch API
-Ensure backend remains REST compliant


--Technologies Used--
-JavaScript 
-HTML
-CSS 
-SQL
-Postman
-AWS RDS
-Java
-Javalin
-Hibernate
