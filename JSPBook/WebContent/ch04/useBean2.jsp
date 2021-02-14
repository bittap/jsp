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
	<%--<jsp:useBean id="member" class="com.dto.MemberBean" scope="page"/> --%>
	<%
		MemberBean member = (MemberBean)request.getAttribute("member");
		if(member == null){
			member = new MemberBean();
			request.setAttribute("member", member);
		}
	%>
</body>
</html>