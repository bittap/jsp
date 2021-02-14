<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
		int all = 10;
	%>
	<%
		int i = 5;
	%>
	<form method="POST" action="ControllerServlet">
		<p>아이디 : <input type="text" name = "id" /></p>
		<p>비밀번호 : <%=i %></p>
		<p><input type="submit" value = "보내기" /></p>
	</form>
	<%
		out.println(i+3);
	%>
</body>
</html>