
    <%@ page import="java.sql.*" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<title>Edit Customer</title>
</head>
<body>

<%

	String customerID = request.getParameter("customerID");
	String customerFirstName = request.getParameter("customerFirstName");
	String customerLastName = request.getParameter("customerLastName");
	String customerPhone = request.getParameter("customerPhone");
	String customerEmail = request.getParameter("customerEmail");
	String customerAddress = request.getParameter("customerAddress");

%>



	<div class="container-fluid">
		<div class="row align-items-center justify-content-center">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div
					class="d-flex flex-column min-vh-100 justify-content-center align-items-center">
					<h1 class="justify-content-center">Edit Customer</h1>
					<!--  Get Access to PetController class -->
					<form action="CustController" method="POST">

 
						<div class="mb-3">
						
							<label for="customerIdInput" class="form-label">Customer
								ID</label> <input type="text" class="form-control" id="customerIdInput"
								name="customerIDText" value="<%=customerID%>" readonly>
						</div>
				
						<div class="mb-3">
						
							<label for="customerFirstNameInput" class="form-label">Customer 
							First Name</label> <input type="text" class="form-control" id="customerFirstNameInput"
								name="customerFirstNameText" value="<%=customerFirstName%>">
						</div>
						
						<div class="mb-3">
						
							<label for="customerLastNameInput" class="form-label">Customer 
							Last Name</label> <input type="text" class="form-control" id="customerLastNameInput"
								name="customerLastNameText" value="<%=customerLastName%>">
						</div>
						
						<div class="mb-3">
						
							<label for="customerPhoneInput" class="form-label">Customer 
							Phone</label> <input type="text" class="form-control" id="customerPhoneInput"
								name="customerPhoneText" value="<%=customerPhone%>">
						</div>
						
						<div class="mb-3">
						
							<label for="customerEmailInput" class="form-label">Customer 
							Email</label> <input type="text" class="form-control" id="customerEmailInput"
								name="customerEmailText" value="<%=customerEmail%>">
						</div>
						
						<div class="mb-3">
						
							<label for="customerAddressInput" class="form-label">Customer 
							Address</label> <input type="text" class="form-control" id="customerAddressInput"
								name="customerAddressText" value="<%=customerAddress%>">
						</div>
						

						<td><input type="submit" class="btn btn-primary btn-sm"
							name="editCustomer" value="Edit"></td>

		

					</form>
				</div>
			</div>
			<div class="col-lg-4"></div>
		</div>
	</div>

</body>
</html>