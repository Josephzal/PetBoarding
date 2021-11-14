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
<title>View Boarding Info</title>
</head>
<body>


<!-- Access MySQL db -->
<sql:setDataSource
	var="myDS"
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/petboardingdb"
    user="root" password="Sqlpassword" />

<!-- Perform SQL query to select all pets -->
<sql:query var="listBoarding" dataSource="${myDS}">
    SELECT * FROM Boarding;
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
        <a class="nav-link active" aria-current="page" href="showCustomers.jsp">Customers</a>
        <a class="nav-link active" href="showPets.jsp">Pets</a>
        <a class="nav-link active" href="showBoardingInfo.jsp">Boarding</a>
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
						<input type="button" class="btn btn-primary" value="Add Boarding" onclick="window.location='addBoarding.jsp'">
						</div>
						<!--  Get Access to TaskController class -->
						<form action="BoardingController" method="POST">
					    	<table class="table">
  								<thead>
   								 	<tr>
     							 	<th scope="col">Boarding ID</th>
      							 	<th scope="col">Pet ID</th>
      							 	<th scope="col">Owner ID</th>
      							 	<th scope="col">Drop Off Date</th>
      							 	<th scope="col">Pick Up Date</th>
      							 	<th scope="col">Boarding Status ID</th>
    								</tr>
								</thead>
								
  								<tbody>
  									<c:forEach var="Boarding" items="${listBoarding.rows}">
  									
								
    									<tr>
      									<td>${Boarding.boardingID}</td>
      									<td>${Boarding.petID}</td>
      									<td>${Boarding.customerID}</td>
      									<td>${Boarding.dropOffDate}</td>
      									<td>${Boarding.pickUpDate}</td>
      									<td>${Boarding.boardingStatusID}</td>

      									
      									<td><input type="button" class="btn btn-primary" value="Edit" onclick="window.location='editBoardingInfo.jsp?boardingID=${Boarding.boardingID}&petID=${Boarding.petID}&ownerID=${Boarding.customerID}&dropOffDate=${Boarding.DropOffDate}&pickUpDate=${Boarding.pickUpDate}&boardingStatusID=${Boarding.boardingStatusID}'"></td>
      									
      									<form action="BoardingController" method="POST">
      									
      									<input type="hidden" name="boardingID" value="${Boarding.boardingID}" />
      									<td><input type="submit" class="btn btn-primary" name="deleteBoarding" value="Delete" /></td>
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