<%-- 2차원 배열 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Lesson: JSP페이지 문법</title>
</head>
<body>
<h1>2차원 배열</h1>
<pre>

</pre>
<%!
// declaration은 전역변수를 생성

%>

<%
// scriptlet은 로컬변수를 생성
out.print("*** ICIA 전체 건물 강의실 구조 ***");
String[][] icia = new String[6][5];
for(int i=0;i<icia.length;i++){
	out.print("<br>"+(i+1)+"층"+"<br>");
	for(int j=0;j<icia[i].length;j++){
		icia[i][j]= ((i+1)+"0"+(j+1))+"강의실";
		out.print(icia[i][j]+"<br>");
	}
}
%>
</body>
</html>