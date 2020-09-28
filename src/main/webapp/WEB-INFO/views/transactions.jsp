<%@ page import = "javax.servlet.http.HttpSession" %>
<%@ page import = "com.paynet.wallet.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
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
	  <a>Logout</a>
	</nav>
	
	<div class="container">
		<div class="row">
			<div class="col table-responsive">
				<h1 class="mt-4 text-center">Your Transactions</h1>
				<table class="table table-hover table-striped mt-4">
				  <thead>
				    <tr>
				      <th scope="col">Sr No.</th>
				      <th scope="col">Time</th>
				      <th scope="col">Transaction type</th>
				      <th scope="col">Amount</th>
				      <th scope="col">Balance</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th>1</th>
				      <td>Mark</td>
				      <td>Otto</td>
				      <td>@mdo</td>
				      <td>@mdo</td>
				    </tr>
				  </tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>