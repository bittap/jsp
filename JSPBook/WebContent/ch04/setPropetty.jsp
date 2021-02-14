<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.dto.MemberBean" scope="request"/>
	<jsp:setProperty property="id" name="member" value = "123"/>
	<jsp:setProperty property="name" name="member" value = "김태영"/>
	<p><%=member.getId() %></p>
	<p><%=member.getName() %></p>
</body>
</html>