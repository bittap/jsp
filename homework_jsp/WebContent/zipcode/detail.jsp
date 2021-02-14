<%@page import="common.vo.BoardVO"%>
<%@page import="zipcode.vo.ZipCodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../include/top.jsp" />
<%
	ZipCodeVO zipCodeVO = (ZipCodeVO)request.getAttribute("result");
	String path = (String)request.getAttribute("path");
	
	
%>
<c:set value="<%=zipCodeVO %>" var="zipcode"/>
<c:set value="<%=path %>" var="path"/>
<div class="container" style="width:800px">
	<form action="detail_action.do" method="post">
		<input name="type" type="hidden" value="<%=path %>"/>
		<c:if test="${path eq 'modify' || path eq 'detail'}">
			<div class="form-group row">
			    <label for="uid_no" class="col-sm-2 col-form-label">번호</label>
			    <div class="col-sm-10">
			  		<input type="text" value='<%=zipCodeVO.getUid_no() %>' name="uid_no" class="form-control" id="uid_no" placeholder="num" readonly>  
			    </div>
		  	</div>
		</c:if>
	  <div class="form-group row">
	    <label for="zipcode" class="col-sm-2 col-form-label">우편번호</label>
	    <div class="col-sm-10">
	      	 <c:choose>
	  			<c:when test="${path eq 'detail'}">
	  				<input type="text" value="<%=zipCodeVO.getZipcode() %>" class="form-control" name="zipcode" id="zipcode" placeholder="우편번호" readonly="readonly">
	  			</c:when>
	  			<c:when test="${path eq 'write'}">
	  				<input type="text" value="" class="form-control" name="zipcode" id="zipcode" placeholder="우편번호">
	  			</c:when>
	  			<c:otherwise>
	  				 <input type="text" value="<%=zipCodeVO.getZipcode() %>" class="form-control" name="zipcode" id="zipcode" placeholder="우편번호">
	  			</c:otherwise>
	  		</c:choose>
	    </div>
	  </div>
	  <div class="form-group row">
	    <label for="address" class="col-sm-2 col-form-label">주소</label>
	    <div class="col-sm-10">
	    	<c:choose>
	  			<c:when test="${path eq 'detail'}">
	  				<input type="text" value="<%=zipCodeVO.getAddress() %>" class="form-control" id="address" name="address" placeholder="주소" readonly="readonly">
	  			</c:when>
	  			<c:when test="${path eq 'write'}">
	  				<input type="text" value="" class="form-control" id="address" name="address" placeholder="주소">
	  			</c:when>
	  			<c:otherwise>
	  				 <input type="text" value="<%=zipCodeVO.getAddress() %>" class="form-control" id="address" name="address" placeholder="주소">
	  			</c:otherwise>
	  		</c:choose>     
	    </div>
	  </div>
	  <div class="row" >
	  	<div class="col-sm-12" style="text-align: center;">
	  		<c:choose>
	  			<c:when test="${path ne 'detail'}">
	  				<button type="submit"  class="btn btn-primary" style="margin-left:10px;">수정</button> 
	  			</c:when>
	  			<c:when test="${path ne 'write'}">
	  				<button type="submit"  class="btn btn-primary" style="margin-left:10px;">쓰기</button> 
	  			</c:when>
	  		</c:choose>
	  		<a href="#" onclick="javascript:history.back();" class="btn btn-info" role="button">뒤로</a>
	  	</div>
	  </div>
	</form>
</div>
<jsp:include page="../include/bottom.jsp" />