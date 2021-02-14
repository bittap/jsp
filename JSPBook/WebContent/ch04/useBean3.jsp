<%@page import="com.dto.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="mem" class="com.dto.MemberBean"/>
	<%
		out.println(mem.getId());
		out.println(mem.getName());
	%>
</body>
</html>