<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
</head>
<%
	String favoriteLang = request.getParameter("favoriteLanguage");
	Cookie langCookie = new Cookie("news.langCookie", favoriteLang);
	langCookie.setMaxAge(60 * 60 * 24 * 365);
	response.addCookie(langCookie);
%>
<body>
Thanks! We set your favorite language to: ${param.favoriteLanguage}
<br /><br />
<a href="cokies-homepage.jsp">Return to homepage<a>
</body>
</html>