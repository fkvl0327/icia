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
<h1>배열사용하기 - 문제풀기</h1>
<pre>
배열
정의: 같은 데이터 타입에 하나의 변수이름을 사용하는 것
특징: 인덱스를 갖는다. 반복처리하기에 좋다.
표기방법:
1) 데이터타입[] 변수이름 = {1, 1, 2, 3, 4};
2) 데이터타입[] 변수이름;
   변수이름 = {1, 1, 2, 3, 4};
   
cf. 변수이름이 [] 앞에 오거나 뒤에 오거나 상관없지만 일반적으로 [] 뒤에 쓴다
int[] jumsu;
int jumsu2[];
</pre>
<%-- jsp comment --%>

<%!
// declaration은 전역변수를 생성

%>
<%
// 스크립트릿은 로컬변수를 생성
int[] jumsu;
jumsu = new int[3];

jumsu[0]=100;
jumsu[1]=90;
jumsu[2]=80;
// jumsu[3]=70; // err

for(int i=0;i<jumsu.length;i++){
	out.print("jumsu["+i+"]="+jumsu[i]+"<br>");
}

int[] jumsu3 = {100, 90, 80};
for(int i=0;i<jumsu3.length;i++){
	out.print("jumsu3["+i+"]="+jumsu3[i]+"<br>");
}
%>
</body>
</html>