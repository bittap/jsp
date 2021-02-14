<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mvc.step1.vo.ZipCodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
	
	List<ZipCodeVO> zipList = null;
	zipList = new ArrayList<ZipCodeVO>();
	ZipCodeVO zVO = new ZipCodeVO();
	zVO.setZIPCODE(12574);
	zVO.setADDRESS("����� �������� ���6��");
	ZipCodeVO zVO1 = new ZipCodeVO();
	zVO1.setZIPCODE(12575);
	zVO1.setADDRESS("����� �������� ���7��");
	ZipCodeVO zVO2 = new ZipCodeVO();
	zVO2.setZIPCODE(12576);
	zVO2.setADDRESS("����� �������� ���8��");
	
	zipList.add(zVO);
	zipList.add(zVO1);
	zipList.add(zVO2);

--%>
<%
	List<ZipCodeVO> zipcodeVO = (List<ZipCodeVO>)request.getAttribute("result");

%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<script>
		function zipcode(){
			console.log("�����ȣ ã�� ����");
			location.href="/zipcode.bab";
		}
	</script>
</head>
<body>
	�����ȣ ã��<br/>
	<input type="text" name="dong" />
	<button onClick="zipcode()">ã��</button>
	<table border="1" borderColor="red" width="600px">
		<tr>
			<th>�����ȣ</th>
			<th>�ּ�</th>
		</tr>
		<c:set value="<%=zipcodeVO %>" var="zipList"/>
		<c:set value="${fn:length(zipList)}" var="zipListLenth"/>
		<c:if test="${zipListLenth != 0}">
			<c:forEach var="zip" items="${zipList}" varStatus="status">
				<tr>
					<th>${zip.ZIPCODE}</th>
					<th>${zip.ADDRESS}</th>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${zipListLenth == 0}">
			<tr>
				<th colspan="2">��ȸ ����� �����ϴ�.</th>
			</tr>
		</c:if>
	</table>
</body>
</html>