<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paynet Signup</title>
<link type="text/css" rel="stylesheet" href="bootstrap-4.0.0-dist/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type ="text/css" rel="stylesheet" href="css/login.css">
<link type ="text/css" rel="stylesheet" href="css/common.css">

<script type="text/javascript" src="bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>

</head>
<body>

<%String errorMessage = (String)request.getAttribute("errorMessage"); %>


	<div class="container-fluid bg">
		<div class="row login-form bottomShadow">
			<div class="login-container">
				<h1 class="text-center">Sign Up</h1>
				<%if(errorMessage != null) { %>
				<div class="alert alert-danger" role="alert">
				  <%= errorMessage %>
				</div>
				<% } %>
				<form method="post" action="/signup">
					<div class="form-group">
						<label for="name">Name : </label> 
						<input
						class=" form-control" type="text" id="name" name="name"
						placeholder="Enter name" required />
					</div>
					<div class="form-group">
						<label for="phno">Phone Number : </label> 
						<input
						class="form-control" type="text" id="phno" name="phoneNumber"
						placeholder="Enter phone number" required />
					</div>
					<div class="form-group">
					<label for="pwd">Password : </label> 
						<input class=" form-control"
						type="password" id="pwd" name="password" placeholder="Enter Password"
						required />
						<small class="text-muted">Password should be atleast 6 characters long</small>
					</div>
					<div class="form-group">
						<button class="btn btn-info float-right" type="submit">
							Sign Up
						</button>
					</div>
					<p class="text-center mb-0" style="margin-top: 70px;"><a href="/login" >Back to login </a></p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>