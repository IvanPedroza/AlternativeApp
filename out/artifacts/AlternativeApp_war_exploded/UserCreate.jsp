<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a User</title>
</head>
<body>
	<h1>Create User</h1>
	<form action="usercreate" method="post">
		<p>
			<label for="userName">UserName</label>
			<input id="userName" name="username" value="">
		</p>
		<p>
			<label for="password">Password</label>
			<input id="password" name="password" value="">
		</p>
		<p>
			<label for="firstName">FirstName</label>
			<input id="firstName" name="firstname" value="">
		</p>
		<p>
			<label for="lastName">LastName</label>
			<input id="lastName" name="lastname" value="">
		</p>
		<p>
			<label for="email">Email</label>
			<input id="email" name="email" value="">
		</p>
		<p>
			<label for="phoneNumber">Phone Number</label>
			<input id="phoneNumber" name="phoneNumber" value="">
		</p>
		<p>
			<label for="addressLine1">Address Line 1</label>
			<input id="addressLine1" name="addressLine1" value="">
		</p>
		<p>
			<label for="addressLine2">Address Line 2</label>
			<input id="addressLine2" name="addressLine2" value="">
		</p>
		<p>
			<label for="county">County</label>
			<input id="county" name="county" value="">
		</p>
				<p>
			<label for="city">City</label>
			<input id="city" name="city" value="">
		</p>
				<p>
			<label for="state">State</label>
			<input id="state" name="state" value="">
		</p>
		<p>
			<label for="country">Country</label>
			<input id="country" name="country" value="">
		</p>
		<p>
			<label for="zipCode">Zipcode</label>
			<input id="zipCode" name="zipCode" value="">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
</body>
</html>