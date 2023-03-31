<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Car Models By Make</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Car Models By Make</title>
</head>
<body>
<%
    String message = (String) request.getAttribute("message");
    if (message != null) { %>
<p style="color: red;"><%= message %></p>
<% } %>
	<form action="findModelsByMake" method="post">
		<h2>Search for Car Models by Make</h2>
		<p>
			<br/>
			<label for="makeName">Make Name</label>
			<input id="makeName" name="makeName" value="${param.modelId != null ? fn:escapeXml(param.makeName) : ''}">
			<input type="submit">
		</p>
		<p>
			<br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<h2>Result from Car Models by Make</h2>
	<table border="1">
            <tr>
                <th>Model Name</th>
                <th>Year</th>
                <th>Base Price</th>
                <th>Electric Range</th>
                <th>Description</th>
                <th>Vehicle Type</th>
                <th>Fuel Eligibility</th>
            </tr>
            <c:forEach items="${carModels}" var="carModel" >
                <tr>
                    <td><c:out value="${carModel.getModelName()}" /></td>
                    <td style="text-align:center"><c:out value="${carModel.getYear()}" /></td>
                    <td style="text-align:center"><c:out value="${carModel.getBasePrice()}" /></td>
                    <td style="text-align:center"><c:out value="${carModel.getElectricRange()}" /></td>
                    <td><c:out value="${carModel.getDescription()}" /></td>
                    <td><c:out value="${carModel.getElectricVehicleType()}" /></td>
                    <td><c:out value="${carModel.getCleanFuelEligibility()}" /></td>
                </tr>
            </c:forEach>
       </table>
</body>
</html>
