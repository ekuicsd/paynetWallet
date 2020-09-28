<%@ page import = "javax.servlet.http.HttpSession" %>
<%@ page import = "com.paynet.wallet.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Money</title>
<link type="text/css" rel="stylesheet" href="bootstrap-4.0.0-dist/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type ="text/css" rel="stylesheet" href="css/login.css">
<link type ="text/css" rel="stylesheet" href="css/common.css">

<script src="jquery3-4-1.js"></script>
<script type="text/javascript" src="bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>

</head>
<body>
<% HttpSession session1 = request.getSession();
	User user = (User) session1.getAttribute("user"); 
	System.out.println(user);
	if(user == null) {
		response.sendRedirect(request.getContextPath()+"/login");
	}
	String errorMessage = (String)request.getAttribute("errorMessage");
%>
	
	<nav class="navbar navbar-light bg-light justify-content-between">
	  <a class="navbar-brand" href="/home">Paynet Wallet</a>
	  <a href="/logout">Logout</a>
	</nav>
	
	<div class="container-fluid bg">
		<div class="row login-form bottomShadow">
			<div class="login-container">
				<h1 class="text-center mb-4">
					<a class="float-left" href="/home">
						<i class="material-icons" style="font-size:36px">arrow_back</i>
					</a>
					Add Money to Wallet
				</h1>
				<%if(errorMessage != null) { %>
				<div class="alert alert-danger" role="alert">
				  <%= errorMessage %>
				</div>
				<% } %>
				<form method="post" action="/addMoney">
					<div class="row">
						<div class="col-12">
							<div class="form-group">
								<label for="cardno">Card Number : </label> 
								<input
								class="input0 form-control" type="text" id="cardno" name="cardNumber"
								placeholder="Enter card number" required />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<div class="form-group">
								<label for="name">Card holder name : </label> 
								<input
								class="input0 form-control" type="text" id="name" name="name"
								placeholder="Enter card holder name" required />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label for="mon">Month : </label> 
								<input
								class="input0 form-control" type="text" id="mon" name="month"
								placeholder="MM" required />
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label for="yr">Year : </label> 
								<input
								class="input0 form-control" type="text" id="yr" name="year"
								placeholder="YYYY" required />
								<small class="text-muted">Enter year in YYYY only</small>
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label for="cvv">CVV : </label> 
								<input
								class="input0 form-control" type="password" id="cvv" name="cvv"
								placeholder="CVV" required />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<div class="form-group">
								<label for="amount">Amount : </label> 
								<input
								class="input0 form-control" type="text" id="amount" name="amount"
								placeholder="Enter amount to add" required />
							</div>
						</div>
						<div class="col-6" style="margin-top: 29px">
							<div class="form-group ">
								<button class="btn btn-info float-right" type="submit">
									Add
								</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>