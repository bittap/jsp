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
	zVO.setADDRESS("서울시 영등포구 당산6구");
	ZipCodeVO zVO1 = new ZipCodeVO();
	zVO1.setZIPCODE(12575);
	zVO1.setADDRESS("서울시 영등포구 당산7구");
	ZipCodeVO zVO2 = new ZipCodeVO();
	zVO2.setZIPCODE(12576);
	zVO2.setADDRESS("서울시 영등포구 당산8구");
	
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
			console.log("우편번호 찾기 성공");
			location.href="/zipcode.bab";
		}
	</script>
</head>
<body>
	우편번호 찾기<br/>
	<input type="text" name="dong" />
	<button onClick="zipcode()">찾기</button>
	<table border="1" borderColor="red" width="600px">
		<tr>
			<th>우편번호</th>
			<th>주소</th>
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
				<th colspan="2">조회 결과가 없습니다.</th>
			</tr>
		</c:if>
	</table>
</body>
</html>