

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" /> 

<!--Font Awesome (added because you use icons in your prepend/append)-->
<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />

<!-- Inline CSS based on choices in "Settings" tab -->
<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}</style>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<title>Add Boarding</title>
</head>

<body>
	<div class="container-fluid">
		<div class="row align-items-center justify-content-center">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div
					class="d-flex flex-column min-vh-100 justify-content-center align-items-center">
					<h1 class="justify-content-center">Add Boarding</h1>
					<!--  Get Access to BoardingController class -->
					<form action="BoardingController" method="POST">

						<div class="mb-3 mt-3">
							<label for="boardingIDInput" class="form-label">Boarding ID</label> <input
								type="text" class="form-control" id="BoardingIdInput"
								name="boardingIDText">
						</div>

						<div class="mb-3">
							<label for="petIdInput" class="form-label">Pet ID</label> <input 
							type="text" class="form-control" id="petIdInput"
								name="petIDText">
						</div>

						<div class="mb-3">
							<label for="ownerIDInput" class="form-label">Owner ID</label> <input
								type="text" class="form-control" id="ownerIdInput"
								name="ownerIDText">
						</div>

						<!--  
						<div class="mb-3">
							<label for="dropOffDateInput" class="form-label">Drop Off Date </label> <input 
							type="text" class="form-control" id="dropOffDateInput"
								name="dropOffDateText">
						</div>

						<div class="mb-3">
							<label for="pickUpDateInput" class="form-label">Pick Up Date</label> <input
								type="text" class="form-control" id="pickUpDateInput"
								name="pickUpDateText">
						</div>
						-->
						
						
						<div class="mb-3 bootstrap-iso">

   
					      <label class="control-label font-weight-normal" for="date1">
					       Drop Off Date
					      </label>
					      <div class="input-group">
					       <div class="input-group-addon">
					        <i class="fa fa-calendar">
					        </i>
					       </div>
					       <input class="form-control" id="date1" name="dropOffDateText" placeholder="MM/DD/YYYY" type="text"/>
					      </div>
					
					     
					
					   </div>
					   
					   <div class="mb-3 bootstrap-iso">
					
					   
					      <label class="control-label font-weight-light" for="date2">
					       Pick Up Date
					      </label>
					      <div class="input-group">
					       <div class="input-group-addon">
					        <i class="fa fa-calendar">
					        </i>
					       </div>
					       <input class="form-control" id="date2" name="pickUpDateText" placeholder="MM/DD/YYYY" type="text"/>
					      </div>
					   </div>
						

						<div class="mb-3">
							<label for="boardingStatusIDInput" class="form-label">Boarding Status ID</label> <input
								type="text" class="form-control" id="boardingStatusIdInput"
								name="boardingStatusIDText">
						</div>


						<td><input type="submit" class="btn btn-primary btn-sm"
							name="addBoarding" value="Add"></td>


					</form>
				</div>
			</div>
			<div class="col-lg-4"></div>
		</div>
	</div>
<!-- Extra JavaScript/CSS added manually in "Settings" tab -->
<!-- Include jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

<script>
    $(document).ready(function(){
        var date_input=$('input[name="dropOffDateText"]'); //our date input has the name "date"
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'mm/dd/yyyy',
            container: container,
            todayHighlight: true,
            autoclose: true,
        })
    })
    $(document).ready(function(){
        var date_input=$('input[name="pickUpDateText"]'); //our date input has the name "date"
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'mm/dd/yyyy',
            container: container,
            todayHighlight: true,
            autoclose: true,
        })
    })
</script>
</body>
</html>