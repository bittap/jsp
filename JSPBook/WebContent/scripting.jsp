<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Scripting tag</title>
</head>
<body>
	<!-- ��ũ��Ʈ ���� -->
	<%! int count = 3;
	
		String makeItLower(String data){
			return data.toLowerCase();
		}
	%>
	<!--  ��ũ��Ʋ�� -->
	<%
		for(int i=0; i<count; i++){
			out.println("welcome to jsp"+i+"<BR/>");
		}
	%>
	<!--  ǥ���� -->
	<%=makeItLower("ABD") %>
</body>
</html>