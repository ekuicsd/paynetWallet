<%@ page import = "javax.servlet.http.HttpSession" %>
<%@ page import = "com.paynet.wallet.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Money</title>
</head>
<body>
<% HttpSession session1 = request.getSession();
	User user = (User) session1.getAttribute("user"); 
	System.out.println(user); %>
	<h1>Transfer Money</h1>
</body>
</html>