<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		Request user agent:
		<%=request.getHeader("host")%><br />
		<%=request.getHeader("User-Agent")%><br />
		<%=request.getHeader("accept")%><br />
		<%=request.getHeader("accpet-language")%><br />
		<%=request.getHeader("accept-encoding")%><br />
		<%=request.getHeader("accept-charset")%><br />
		<%=request.getHeader("keep-alive")%><br />
		<%=request.getHeader("connection")%><br />
		<%=request.getHeader("cookie")%><br />
		<%=request.getHeader("pragma")%><br />
		<%=request.getHeader("cache-control")%><br />
		Local address: <%=request.getLocalAddr()%><br />
		Local name: <%=request.getLocalName()%><br />
		Local Port: <%=request.getLocalPort()%><br />
		Method: <%=request.getMethod()%><br />
		Protocol: <%=request.getProtocol()%><br />
		Query String: <%=request.getQueryString()%><br />
		Remote address: <%=request.getRemoteAddr()%><br />
		Remote Host: <%=request.getRemoteHost()%><br />
		Remote Port: <%=request.getRemotePort()%><br />
		Remote User: <%=request.getRemoteUser()%><br />
		Scheme: <%=request.getScheme()%><br />
		Server Name: <%=request.getServerName()%><br />
		Server Port: <%=request.getServerPort()%><br />
		Servlet Path: <%=request.getServletPath()%><br />
		
	</p>
</body>
</html>