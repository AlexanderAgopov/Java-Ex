<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Confirmation Title</title>
</head>
<body>
	The student is confirmed:
	<%=request.getParameter("firstName")%>
	<%=request.getParameter("lastName")%>
	<br />
	<br /> The student is confirmed (alternative version):
	${param.firstName} ${param.lastName}

</body>
</html>