<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Find Models by Electric Range</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find popular Car Models by range</title>
<body>
    <form action="FindModelByElectricRange" method="post">
        <h2>Find Models by Electric Range</h2>
        <p>
            <label for="minRange">Minimum Electric Range</label>
            <input id="minRange" name="minRange" type="number" value="${fn:escapeXml(param.minRange)}">
        </p>
        <p>
            <input type="submit">
        </p>
    </form>
<h2>Models with Electric Range up to ${param.minRange} miles</h2>
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
