<%@ page import = "javax.servlet.http.HttpSession" %>
<%@ page import = "com.paynet.wallet.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paynet Home Page</title>
<link type="text/css" rel="stylesheet" href="bootstrap-4.0.0-dist/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
%>
	
	
	<nav class="navbar navbar-light bg-light justify-content-between">
	  <a class="navbar-brand" href="/home">Paynet Wallet</a>
	  <a href="/logout">Logout</a>
	</nav>
	
	<div class="container">
		<h1 class="text-center mt-4">Paynet Wallet</h1>
		<hr>
		<div class="row mt-4">
			<div class="col-12 col-md-4">
				<div class="card">
				  <div class="card-body text-center">
				  	<img src="assets/wallet.png" alt="">
				    <h4 class="card-title mt-3"><a href="/addMoney">Add Money</a></h4>
				  </div>
				</div>
			</div>
			<div class="col-12 col-md-4">
				<div class="card">
				  <div class="card-body text-center">
				  	<img src="assets/peer-to-peer.png" alt="">
				    <h4 class="card-title mt-3"><a href="/transferMoney">Transfer Money</a></h4>
				  </div>
				</div>
			</div>
			<div class="col-12 col-md-4">
				<div class="card">
				  <div class="card-body text-center">
				  	<img src="assets/transaction.png" alt="">
				    <h4 class="card-title mt-3"><a href="/transactions">Transactions</a></h4>
				  </div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>