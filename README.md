# TransactionService 
This microserice is created for demo purpose. 

# Technologies used
 1. spring boot
 2. java
 3. h2 database (data persistence.)


# connect to h2 database
 1. open :  http://localhost:8083/h2-console
 
 2. provide JDBC URL as http://localhost:8083/h2-console and password is blank.
 
 3. click on connect

# REST API's

1. **GET /rest/v1/transaction/**

   - get the transaction history
   
2. **GET /rest/v1/transaction/categorywise?category=**\<**category**\>
  
   - get the total transaction history for a given category 
  
3. **GET /rest/v1/transaction/totaloutgoing/**
  
   - get the total outgoing for all categories.
  
4. **GET /rest/v1/transaction/avgspending?category=**\<**category**\>
  
   - get monthly avarage spening for a given category.
  
5. **GET /rest/v1/transaction/highspending?category=**\<**category**\>**&year=**\<**year**\>
  
   - get highest spending for a given category in a given year.
  
6. **GET /rest/v1/transaction/lowspending?category=**\<**category**\>**&year=**\<**year**\>
  
   - get lowest spending for a given category in a given year.
 
