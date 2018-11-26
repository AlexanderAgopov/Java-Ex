<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Registration confirmed. You are now logged in as
	<%=request.getParameter("firstName")%>
	<%=request.getParameter("lastName")%>.
	<br /> You are from
	<%=request.getParameter("country")%>.
	<br /> Your favorite programming language is:
	<%=request.getParameter("favoriteLanguage")%>.
	<br />
	<%
		if (request.getParameterValues("newsType") == null) {
			out.println("You didn't subscribe to any sections on our site.");
		} else {
			out.println("You subscribed to the following sections in our site:");
			String[] chosenSectionTypes = request.getParameterValues("newsType");
			for (int i = 0; i < chosenSectionTypes.length; i++) {
				if (i < (chosenSectionTypes.length - 1)) {
					out.print(" " + chosenSectionTypes[i] + ",");
				} else {
					out.print(" " + chosenSectionTypes[i]);
				}
			}
			out.println(".");
		}
	%>
	<!-- Another way to show simple text request parameters is as follows -->
	<br />
	<br /> Hello, ${param.firstName} ${param.lastName}. How is the weather
	in ${param.country}? What's your last project in
	${param.favoriteLanguage}? Visit the sections you subscribed to from
	time to time to see older posts which can give you valuable
	information.
	<%
 	if (request.getParameterValues("newsType") == null) {
 		out.println("You didn't subscribe to any sections.");
 	} else {
 		out.println("These are the sections you subscribed to:");
 		for (String section : request.getParameterValues("newsType")) {
 			out.println("<li>" + section + "</li>");
 		}
 	}
 %>
</body>
</html>