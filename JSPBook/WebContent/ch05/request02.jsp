<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Enumeration enumeration = request.getHeaderNames();
		while(enumeration.hasMoreElements()){
			String key = (String)enumeration.nextElement();
			String value = request.getHeader(key);
			
			out.print(key+" "+value+"<br/>");
		}
	%>
</body>
</html>