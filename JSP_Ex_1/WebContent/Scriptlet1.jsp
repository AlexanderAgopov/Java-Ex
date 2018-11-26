<%@page import="com.java.FunUtils"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.*" %> %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int fontSize;
%>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello World
	</br> Converting a string to uppercase
	<%=new String("Hello World").toUpperCase()%>
	</br> 20 * 5 =
	<%=20 * 5%>
	</br> Is 75 less than 100?
	</br>
	<%=75 < 100%>
	<p>
		<%
			for (int i = 0; i < 10; i++) {
				out.println("</br>i");
			}
		%>
	
	<p>
		<%!String toLowerCase(String string) {
		return string.toLowerCase();
	}%>
		Lower case "Hello World"
		<%=toLowerCase("Hello World")%>
	<p>
		Let's have some fun:
		<%=FunUtils.toLowerCase("FUN FUN FUN")%>
	<p>
		<%-- This is an old school scriptlet (rarely used nowadays) --%>
		<%
			out.println("Your IP address is: " + request.getRemoteAddr());
		%>
		<%-- This is deprecated method --%>
	<p>
		Today's date is :
		<%=(new java.util.Date()).toLocaleString()%>
	</p>
	<%!int day = 5;%>
	<%!String name = "GG";%>
	<%
		if (day == 1 || day == 7) {
	%>
	<p>Weekend</p>
	<%
		} else {
	%>
	<p>Working day</p>
	<%
		}
	%>

	<%
		switch (day) {
		case 1:
			out.println("Sunday");
			break;
		case 2:
			out.println("Monday");
			break;
		case 3:
			out.println("Tuesday");
			break;
		case 4:
			out.println("Wednesday");
			break;
		case 5:
			out.println("Thursday");
			break;
		case 6:
			out.println("Friday");
			break;
		default:
			out.println("Sunday");
		}
	%>

	<%
		for (fontSize = 1; fontSize <= 3; fontSize++) {
	%>
	<font color="green" size="<%=fontSize%>"> Just a test. </font>
	<br />
	<%
		}
	%>
</body>
</html>