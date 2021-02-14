<%@page import="common.vo.BoardVO"%>
<%@page import="zipcode.vo.ZipCodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	List<ZipCodeVO> list = (List<ZipCodeVO>)request.getAttribute("list");
	BoardVO boardVO = (BoardVO)request.getAttribute("board");
	
	// list.jsp
	String url = request.getRequestURI().split("\\.")[0];
	String doUrl = url+".do";
	
	String id = (String)request.getSession().getAttribute("id");
%>
<c:set value="<%=id%>" var="id"/>
<c:set value="<%=doUrl%>" var="nowUrl"/>
<c:set value="<%=list%>" var="zipList"/>
<c:set value="<%=boardVO%>" var="boardVO"/>
<c:set value="<%=boardVO.getSearchKind()%>" var="searchKind"/>
<c:set value="<%=boardVO.getPageS()%>" var="pages"/>
<c:set value="<%=boardVO.getSearchMap()%>" var="searchs"/>
<c:set value="${fn:length(searchs)}" var="searchLenth"/>
<c:set value="${fn:length(pages)}" var="pageLenth"/>
<c:set value="${fn:length(zipList)}" var="zipListLenth"/>
<jsp:include page="../include/top.jsp" />
<table class="table">
  <thead>
    <tr>
      <th class="text-center">번호</th>
      <th class="text-center">우편번호</th>
      <th class="text-center">주소</th>
      <th class="text-center">상세</th>
      <th class="text-center">삭제</th>
    </tr>
  </thead>
  <tbody>
 	<c:if test="${zipListLenth != 0}">
 		<c:forEach var="zip" items="${zipList}" varStatus="status">
 			<tr>
		      <th class="text-center" scope="row">${zip.uid_no}</th>
		      <td class="text-center">${zip.zipcode}</td>
		      <td class="text-center">${zip.address}</td>
		      <th class="text-center">
			      <c:choose>
			      	<c:when test="${id eq 'root' }">
			      		<a href="modify.do?page=${boardVO.nowPage}&searchKind=${boardVO.searchKind}&search=${boardVO.searchString}&num=${zip.uid_no}" class="btn btn-info" role="button">수정</a>
			      	</c:when>
			      	<c:otherwise>
			      		<a href="detail.do?page=${boardVO.nowPage}&searchKind=${boardVO.searchKind}&search=${boardVO.searchString}&num=${zip.uid_no}" class="btn btn-info" role="button">상세</a>
			      	</c:otherwise>
			      </c:choose>    	
		      </th>
		      <th class="text-center"><a href="delete.do?page=${boardVO.nowPage}&searchKind=${boardVO.searchKind}&search=${boardVO.searchString}&num=${zip.uid_no}" class="btn btn-primary" role="button">삭제</a></th>
		    </tr>
 		</c:forEach>
 	</c:if>
	<c:if test="${zipListLenth == 0}">
		<tr>
			<th colspan="3">조회 결과가 없습니다.</th>
		</tr>
	</c:if>
  </tbody>
</table>
<form action="${nowUrl}" method="post" name="myForm">
	<div class="container" style="text-align: center;">
	    <div class="row text-center">    
	        <div class="col" style="float:none; margin:0 auto; width:600px;">
			    <div class="input-group">
			    	<select class="selectpicker" name="searchKind" id="select"> 
	                      <c:forEach var="search" items="${searchs}" varStatus="status" begin="0" end="${searchLenth}" >
	                      	  <c:if test="${search.key == searchKind}">
	                      	  	<option selected="selected" value="${search.key}">${search.value }</option>
	                      	  </c:if>
	                      	  <c:if test="${search.key != searchKind}">
	                      	  	<option value="${search.key}">${search.value }</option>
	                      	  </c:if>
	                      </c:forEach> 
			    	</select>        
	                <input type="text" class="form-control" name="search" placeholder="검색어를 입력해주세요" value="${boardVO.searchString}">
	                <span class="input-group-btn" id="searchBtn">
	                    <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
	                    <c:if test="${id eq 'root'}">
	                    	 <a href="write.do" class="btn btn-info" role="button">쓰기</a>
	                    </c:if>    
	                </span>
	            </div>
	        </div>
		</div>
	</div>
</form>
<div class="container">
	<div class="row text-center">
		<div class="col" style="float:none; margin:0 auto">
			<ul class="pagination">
				<c:if test="${boardVO.prevBtnPage != 0}">
					<li class="page-item"><a class="page-link" href="${nowUrl}?page=${boardVO.prevBtnPage}&searchKind=${boardVO.searchKind}&search=${boardVO.searchString}">Previous</a></li>
				</c:if>
				<c:if test="${pageLenth != 0 }">
					<c:forEach var="page" items="${pages}" varStatus="status">
						<c:if test="${page == boardVO.nowPage}">
							<li class="page-item"><a style="color:red" onclick="return false;"  class="page-link" href="#">${page}</a></li>
						</c:if>
						<c:if test="${page != boardVO.nowPage}">
							<li class="page-item"><a class="page-link" href="${nowUrl}?page=${page}&searchKind=${boardVO.searchKind}&search=${boardVO.searchString}">${page}</a></li>
						</c:if>
						
					</c:forEach>
				</c:if>
				<c:if test="${boardVO.nextBtnPage != 0}">
					<li class="page-item"><a class="page-link" href="${nowUrl}?page=${boardVO.nextBtnPage}">Next</a></li>
				</c:if>
				
			</ul>
		</div>
	</div>
</div>
<jsp:include page="../include/bottom.jsp" />
