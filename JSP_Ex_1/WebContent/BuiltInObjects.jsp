<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSP Built-in Objects</h3>
	<hr>
	
	</br>
	
	Request user agent:
	<%=
		request.getHeader("User-Agent")
	%>
	</br>
	Request language:
	<%= request.getLocale() %>
</body>
</html>