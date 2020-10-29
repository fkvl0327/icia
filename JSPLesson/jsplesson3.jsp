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
<h1>계산식을 수행하기 - 문제풀기</h1>
<p>2개의 정수를 비교,
수1이 수2보다 크거나 같으면 정수 덧셈.
그렇지 않으면 정수 교환 후에 수2-수1 빼기</p>
<%-- jsp comment --%>

<%!
// declaration은 전역변수를 생성

%>
<%
// 스크립트릿은 로컬변수를 생성
int n1=2000, n2=1000, n3=100, n4=150;

if(n1>=n2){
	out.print("n1+n2="+(n1+n2));
}else{
	out.print("n2-n1="+(n2-n1));
}

out.print("<br>");

if(n3>=n4){
	out.print(n3+n4);
}else{
	out.print(n4-n3);
}
%>
</body>
</html>