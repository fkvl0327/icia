<%-- directive, page directive --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Lesson1: JSP페이지 문법</title>
</head>
<body>
<h1>JSP Lesson1: JSP페이지 문법</h1>
<%-- jsp comment --%>

<%!
// declaration
// java 변수, 함수 등의 선언
// 전역변수의 효력
int count = 0;
%>
<b>count변수: </b><%=count %>
<%
// 스크립트릿 scriptlet
String var1 = "jsp basic";
count ++;
%>
<h2><b>topic: </b><%=var1 %></h2>
<b>count변수: </b><%=count %>
</body>
</html>