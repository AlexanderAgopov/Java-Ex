<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String writeMSG() {
		return "FOOFOOFOO";
	}%>

	<p><%=System.currentTimeMillis()%><br /><%=new java.util.Date()%><br /><%=123 * 123%><br />
		<%=10 > 30%><br /><%=new String("Hello World").toUpperCase()%>
	</p>

	<p>
		<%
			for (int i = 0; i < 10; i++) {
		%>
		<br>
		<%
			out.println("ho ");
			}
		%></br>
	</p>
	<p>
		<%
			for (int i = 0; i < 10; i++) {
				out.println("ho " + i + "<br />");
			}
		%>
	</p>
	<p><%= writeMSG() %></p>
</body>
</html>