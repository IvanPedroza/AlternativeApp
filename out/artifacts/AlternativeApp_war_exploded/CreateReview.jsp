<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Review</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Review</title>
<body>
<%
    String message = (String) request.getAttribute("message");
    if (message != null) { %>
<p style="color: red;"><%= message %></p>
<% } %>
<form action="createReview" method="post">
    <h2>Create a Review</h2>
    <p>
        <label for="modelId">Model ID:</label>
        <input id="modelId" name="modelId" type="number" value="${param.modelId != null ? fn:escapeXml(param.modelId) : ''}">
    </p>
    <p>
        <label for="userName">Username:</label>
        <input type="text" id="userName" name="userName" value="${fn:escapeXml(param.userName)}">
    </p>
    <p>
        <label for="rating">Rating:</label>
        <input type="number" id="rating" name="rating" min="1" max="5" value="${param.modelId != null ? fn:escapeXml(param.rating): ''}">
    </p>
    <p>
        <label for="reviewTitle">Review Title:</label>
        <input type="text" id="reviewTitle" name="reviewTitle" value="${fn:escapeXml(param.reviewTitle)}">
    </p>
    <p>
        <label for="reviewComment">Review Comment:</label>
        <textarea id="reviewComment" name="reviewComment" rows="4" cols="50" value="${fn:escapeXml(param.reviewComment)}"></textarea>
    </p>
    <input type="submit">

</form>
<h2>Review</h2>
    <table border="1">
        <tr>
            <th>Review ID</th>
            <th>Model ID</th>
            <th>User Name</th>
            <th>Rating</th>
            <th>Review Title</th>
            <th>Review Comment</th>
        </tr>
        <c:set var="review" value="${review}"/>
            <tr>
                <td style="text-align:center"><c:out value="${review.getReviewId()}" /></td>
                <td style="text-align:center"><c:out value="${review.getModelId()}" /></td>
                <td><c:out value="${review.getUserName()}" /></td>
                <td style="text-align:center"><c:out value="${review.getRating()}" /></td>
                <td><c:out value="${review.getReviewTitle()}" /></td>
                <td><c:out value="${review.getReviewComment()}" /></td>
            </tr>
    </table>
</body>
</html>