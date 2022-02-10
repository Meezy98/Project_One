## Expense Reimbursement System
You are tasked with creating an expense reimbursement system. For a small company/group. This program will allow employees to create reimbursement requests. All managers can view these requests and approve or deny them. When they approve/deny a request, they can optionally leave a message.
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
