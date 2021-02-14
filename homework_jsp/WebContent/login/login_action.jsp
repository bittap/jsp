<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = (String)request.getAttribute("result");
%>
<script>
	var result = '<%=result%>';
	var msg = '';
	var url = '';
	
	switch (result) {
	case '01':
		msg = '존재하지 않는 아이디입니다.';
		url = '/login/login';
		break;
	case '02':
		msg = '패스워드가 일치하지 않습니다.';
		url = '/login/login';
		break;
	case '03':
		msg = '로그인 성공했습니다.';
		url = '/index';
		break;
	default:
		break;
	}
	
	alert(msg);
	location.href = url;
</script>
