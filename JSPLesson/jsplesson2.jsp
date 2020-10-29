<%-- directive, page directive --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Lesson2: JSP페이지 문법</title>
</head>
<body>
<h1>변수 만들기 - 전역변수, 지역변수</h1>
<%-- jsp comment --%>

<%!
// declaration은 전역변수를 생성
int count = 0;
int global_var = 0;
%>
<b>count변수: </b><%=count %>
<%
// 스크립트릿은 로컬변수를 생성
String var1 = "jsp basic";
count ++;
int local_var = 0;
%>
<h2><b>topic: </b><%=var1 %></h2>
<b>count변수: </b><%=count %>
<p>
<%
out.print("global_var = " + (global_var++) + "<br>");
out.print("local_var = " + (local_var++) + "<br>");
// 위에서 count, global_var는 다른 페이지로 이동하더라도
// 증가수가 유지되는 속성이 있다
%>
</body>
</html>