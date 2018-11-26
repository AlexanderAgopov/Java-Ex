<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Training portal</title>
</head>
<body>
	<%
		String favLang = "Java";
		Cookie[] allCookies = request.getCookies();
		if (allCookies != null) {
			for (Cookie cookie : allCookies) {
				if ("news.langCookie".equals(cookie.getName())) {
					favLang = cookie.getValue();

				}
			}
		}
	%>

	<!-- show personalized page in accordance to the cookie -->

	<h4>
		New books for
		<%=favLang%></h4>
	<!-- ideally here should be used query in a db which retrieves book information, etc.. -->
	<ul>
		<li>first book</li>
		<li>second book</li>
		<li>third book</li>
	</ul>

	<h4>
		Latest news
		<%=favLang%></h4>
	<!-- ideally here should be used query in a db which retrieves book information, etc.. -->
	<ul>
		<li>first news</li>
		<li>second news</li>
		<li>third news</li>
	</ul>

	<h4>
		Hot jobs for
		<%=favLang%></h4>
	<!-- ideally here should be used query in a db which retrieves book information, etc.. -->
	<ul>
		<li>first book</li>
		<li>second book</li>
		<li>third book</li>
	</ul>
	<hr>
	<a href="cookies-personalize-form.html">Personalize this page</a>
</body>
</html>