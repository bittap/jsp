<%@page import="ch18.com.controller.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<p>로그인 성공했습니다.</p>
	<%
		LoginBean bean = (LoginBean)request.getAttribute("bean");
		out.println("아이디 : "+bean.getId());
	%>
</body>
</html>