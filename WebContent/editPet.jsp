
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
<title>Edit Pet</title>
</head>
<body>

<%


	String petID = request.getParameter("petID");
	String petOwnerID = request.getParameter("petOwnerID");
	String petName = request.getParameter("petName");
	String petSpecies = request.getParameter("petSpeciesID");
	String petBreed = request.getParameter("petBreedID");
	String petGender = request.getParameter("petSexID");
	String petAge = request.getParameter("petAge");
	//String petBoardingStatus = request.getParameter("petBoardingStatusID");

%>



	<div class="container-fluid">
		<div class="row align-items-center justify-content-center">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div
					class="d-flex flex-column min-vh-100 justify-content-center align-items-center">
					<h1 class="justify-content-center">Edit Pet</h1>
					<!--  Get Access to PetController class -->
					<form action="PetController" method="POST">

 
						<div class="mb-3">
						
							<label for="petIdInput" class="form-label">Pet
								ID</label> <input type="text" class="form-control" id="petIdInput"
								name="petIDText" value="<%=petID%>" readonly>
						</div>
				
						<div class="mb-3">
						
							<label for="petOwnerIdInput" class="form-label">Pet Owner
								ID</label> <input type="text" class="form-control" id="petOwnerIdInput"
								name="petOwnerIDText" value="<%=petOwnerID%>">
						</div>
						

						<div class="mb-3">
							<label for="petNameInput" class="form-label">Name</label> <input
								type="text" class="form-control" id="petNameInput"
								name="petNameText" value="<%=petName%>">
						</div>

						<div class="mb-3">
							<label for="petSpeciesInput" class="form-label">Species
								ID</label> <input type="text" class="form-control" id="petSpeciesInput"
								name="petSpeciesText" value="<%=petSpecies%>">
						</div>

						<div class="mb-3">
							<label for="petBreedInput" class="form-label">Breed ID</label> <input
								type="text" class="form-control" id="petBreedInput"
								name="petBreedText" value="<%=petBreed%>">
						</div>

						<div class="mb-3">
							<label for="petAgeInput" class="form-label">Age</label> <input
								type="text" class="form-control" id="petAgeInput"
								name="petAgeText" value="<%=petAge%>">
						</div>

						<div class="mb-3">
							<label for="petGenderInput" class="form-label">Sex ID</label> <input
								type="text" class="form-control" id="petGenderInput"
								name="petGenderText" value="<%=petGender%>">
						</div>

						<!--  
						<div class="mb-3 mt-3">
							<label for="petBoardingInput" class="form-label">Pet Boarding Status</label> <input
								type="text" class="form-control" id="petBoardingInput"
								name="petBoardingText" value="">
						</div>
						-->

						<td><input type="submit" class="btn btn-primary btn-sm"
							name="editPet" value="Edit"></td>

						<!--  
									<td>Pet OwnerID:</td>
									<td><input type="text" name="petOwnerIDText"></td>
							
								
									<td>Pet Name:</td>
									<td><input type="text" name="petNameText"></td>
									
									<td>Pet Species:</td>
									<td><input type="text" name="petSpeciesText"></td>
									
									<td>Pet Breed:</td>
									<td><input type="text" name="petBreedText"></td>
									
									<td>Pet Age:</td>
									<td><input type="text" name="petAgeText"></td>
									
									<td>Pet Gender:</td>
									<td><input type="text" name="petGenderText"></td>
									
									<td><input type="submit" class="btn btn-primary btn-sm" name="addPet" value="Add"></td>
									
								-->

					</form>
				</div>
			</div>
			<div class="col-lg-4"></div>
		</div>
	</div>

</body>
</html>