<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./fileupload01_process.jsp" method="post" enctype="multipart/form-data" name = "fileForm">
		<input type="file" name = "filename"  />
		<input type="submit" value="파일 올리기" />
	</form>
</body>
</html>