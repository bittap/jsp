<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="date" class="java.util.Date"/>
	<p>
		<% out.print("������ ��¥ �� �ð�"); %>
	</p><%=date %>
</body>
</html>