<%-- 2차원 배열 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Lesson: JSP페이지 문제 풀이</title>
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
String[] subject = {"kor", "math", "eng", "java", "total", "avg"};
String[] name = {"김", "이", "박"};
int[][] jumsu = {
		{100, 90, 80, 70},
		{90, 100, 80, 85},
		{80, 100, 100, 85}
};

int[] sum=new int[3];
float[] avg=new float[3]; 

sum[0] = jumsu[0][0]+jumsu[0][1]+jumsu[0][2]+jumsu[0][3];
sum[1] = jumsu[1][0]+jumsu[1][1]+jumsu[1][2]+jumsu[1][3];
sum[2] = jumsu[2][0]+jumsu[2][1]+jumsu[2][2]+jumsu[2][3];
avg[0] = sum[0]/jumsu.length;
avg[1] = sum[1]/jumsu.length;
avg[2] = sum[2]/jumsu.length;

out.print("<br>***개별점수***<br>");
for(int i=0;i<jumsu.length;i++){
	out.print(i+"번째: "+name[i]+"<br>");
}

%>
</body>
</html>