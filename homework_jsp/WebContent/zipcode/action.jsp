<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<%
	String type = request.getParameter("type");
	String msg = "";
	switch(type){
		case "write":
			msg = "쓰기 완료됐습니다.";
			break;
		case "delete":
			msg = "삭제 완료됐습니다.";
			break;
		case "modify":
			msg = "수정 완료됐습니다.";
			break;
		default:
			break;
	}
	String pageVal = request.getParameter("page");
	String searchKind = request.getParameter("searchKind");
	String serach = request.getParameter("search");
%>
<script>
	alert('<%=msg%>');
	location.href = "list.do?page=<%=pageVal%>&searchKind=<%=searchKind%>&serach=<%=serach%>";
</script>