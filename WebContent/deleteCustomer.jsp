<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>Remove Customer</title>
</head>
<body>

	
	<div class="container-fluid">
		<div class="row align-items-center justify-content-center">
			<div class="col-lg-4"></div>
		  		<div class="col-lg-4">
		  			<div class="d-flex flex-column min-vh-100 justify-content-center align-items-center">
						<h1 class="justify-content-center">Delete Customer</h1>
						<!--  Get Access to PetController class -->
						<form action="PetController" method="POST">
							<table>
								<tr>
									<td>Customer ID:</td>
									<div class="pt-4">
									<td><input type="text" name="petIDText"></td>
									<td><input type="submit" class="btn btn-primary btn-sm" name="deleteCustomer" value="Delete"></td>
									</div>
								</tr>
							</table>
						</form>
					</div>
				</div>
			<div class="col-lg-4"></div>
		</div>
	</div>

</body>
</html>