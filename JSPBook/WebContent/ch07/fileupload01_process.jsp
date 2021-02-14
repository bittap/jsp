<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MultipartRequest multipartRequest = new MultipartRequest(request,"C:\\Temp",5*1024*1024,"utf-8",new DefaultFileRenamePolicy());
	
		Enumeration params = multipartRequest.getParameterNames();
		
		while(params.hasMoreElements()){
			String key = (String)params.nextElement();
			String value = multipartRequest.getParameter(key);
			
			out.println(key + " "+ value +"<br/>");
		}
		
		out.println("------------------------"+"<br/>");
		
		Enumeration files = multipartRequest.getFileNames();
		
		while(files.hasMoreElements()){
			String name = (String)files.nextElement();
			String fileName = multipartRequest.getFilesystemName(name);
			String original =  multipartRequest.getOriginalFileName(name);
			String type = multipartRequest.getContentType(name);
			File file = multipartRequest.getFile(name);
			
			out.println("파일 네임 "+ name +"<br/>");
			out.println("실제 파일 이름 "+ original +"<br/>");
			out.println("저장 파일 이름 "+ fileName +"<br/>");
			out.println("파일 콘텐츠 유형 "+ type +"<br/>");
		}
	%>
</body>
</html>