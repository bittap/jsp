<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
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
		String fileUploadPath = "C:/Temp";
	
		DiskFileUpload upload = new DiskFileUpload();
		
		List items = upload.parseRequest(request);
		
		Iterator params = items.iterator();
		
		while(params.hasNext()){
			FileItem item = (FileItem) params.next();
			if(item.isFormField()){
				String title = item.getString("UTF-8");
				out.println(title);
			} else {
				String fileName = item.getName();
				System.out.println(fileName.lastIndexOf("\\")+1);
				fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
				File file = new File(fileUploadPath + "/" + fileName);
				item.write(file);
				out.println("파일 이름 + "+ fileName);
			}
		}
		
		
	%>
</body>
</html>