<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paynet Login</title>
<link type="text/css" rel="stylesheet" href="bootstrap-4.0.0-dist/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type ="text/css" rel="stylesheet" href="css/login.css">
<link type ="text/css" rel="stylesheet" href="css/common.css">

<script src="jquery3-4-1.js"></script>
<script type="text/javascript" src="bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>

</head>
<body>
<%
	String errorMessage = (String)request.getAttribute("errorMessage"); 
%>


	<div class="container-fluid bg">
		<div class="row login-form bottomShadow">
			<div class="login-container">
				<h1 class="text-center">Login</h1>
				<%if(errorMessage != null) { %>
				<div class="alert alert-danger" role="alert">
				  <%= errorMessage %>
				</div>
				<% } %>
				<form method="post" action="/login">
					<div class="form-group">
						<label for="phno">Phone Number : </label> 
						<input
						class="input0 form-control" type="text" id="phno" name="phoneNumber"
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
							Login
						</button>
					</div>
				</form>
				<p class="text-center mb-0" style="margin-top: 70px;">Not a member? <a href="/signup" >Create Account </a></p>
			</div>
		</div>
	</div>
	
	<script>
		
	</script>
</body>
</html>