<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>View Customers</title>
</head>
<body>


<!-- Access MySQL db -->
<sql:setDataSource
	var="myDS"
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/petboardingdb"
    user="root" password="Sqlpassword" />

<!-- Perform SQL query to select all pets -->
<sql:query var="listCustomers" dataSource="${myDS}">
    SELECT * FROM Customer;
</sql:query>

<!-- Loop through each pet and display  -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
   
         <a class="nav-link" href="showCustomers.jsp">Customers</a>
        <a class="nav-link" href="showPets.jsp">Pets</a>
        
        <a class="nav-link" href="showBoardingInfo.jsp">Boarding</a>
      </div>
    </div>
  </div>
</nav>

<div class="container-fluid">
		<div class="row align-items-center justify-content-center">
			<div class="col-lg-4"></div>
		  		<div class="col-lg-4">
		  			<div class="d-flex flex-column min-vh-100 justify-content-center align-items-center">
		  			<div class=mb-3>
						<input type="button" class="btn btn-primary" value="Add Customer" onclick="window.location='addCustomer.jsp'">
						</div>
						<!--  Get Access to TaskController class -->
						<form action="CustController" method="POST">
					    	<table class="table">
  								<thead>
   								 	<tr>
     							 	<th scope="col">Customer ID</th>
      							 	<th scope="col">Customer First Name</th>
      							 	<th scope="col">Customer Last Name</th>
      							 	<th scope="col">Customer Phone</th>
      							 	<th scope="col">Customer Email</th>
      							 	<th scope="col">Customer Address</th>
      							 
      
    								</tr>
								</thead>
  								<tbody>
  									<c:forEach var="Customer" items="${listCustomers.rows}">
    									<tr>
      									<td>${Customer.customerID}</td>
      									<td>${Customer.customerFirstName}</td>
      									<td>${Customer.customerLastName}</td>
      									<td>${Customer.customerPhone}</td>
      									<td>${Customer.customerEmail}</td>
      									<td>${Customer.customerAddress}</td>
      									
      								
      									
      									<td><input type="button" class="btn btn-primary" value="Edit" onclick="window.location='editCustomer.jsp?customerID=${Customer.customerID}&customerFirstName=${Customer.customerFirstName}&customerLastName=${Customer.customerLastName}&customerPhone=${Customer.customerPhone}&customerEmail=${Customer.customerEmail}&customerAddress=${Customer.customerAddress}'"></td>
      									
      									<form action="CustController" method="POST">
      									
      									<input type="hidden" name="customerID" value="${Customer.customerID}" />
      									<td><input type="submit" class="btn btn-primary" name="deleteCustomer" value="Delete" /></td>
      									</form>
      									
    									</tr>
    									
									</c:forEach>

  								</tbody>
							</table>
						</form>
					</div>
				</div>
			<div class="col-lg-4"></div>
		</div>
	</div>
	
</body>
</html>