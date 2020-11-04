<%-- jsp 지시문, directive, page directive --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>try-catch</title>
</head>
<body>
<%
int n1 = 100;
int n2 = 0;
int m = 0;
try{
m = n1/n2;
}catch(Exception e){
	out.print("에러가 발생했습니다.");
}
%>
</body>
</html>