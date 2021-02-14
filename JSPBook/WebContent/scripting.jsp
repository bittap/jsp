<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Scripting tag</title>
</head>
<body>
	<!-- 스크립트 선언문 -->
	<%! int count = 3;
	
		String makeItLower(String data){
			return data.toLowerCase();
		}
	%>
	<!--  스크립틀릿 -->
	<%
		for(int i=0; i<count; i++){
			out.println("welcome to jsp"+i+"<BR/>");
		}
	%>
	<!--  표현문 -->
	<%=makeItLower("ABD") %>
</body>
</html>