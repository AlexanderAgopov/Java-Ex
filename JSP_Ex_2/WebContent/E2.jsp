<%@page import="jsppack1.E1java"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.html"></jsp:include>
<%= E1java.makeItLower("LOW LOW LOW") %>
</body>
<footer><jsp:include page="Footer.jsp"></jsp:include></footer>
</html>