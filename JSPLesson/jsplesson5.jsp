<%-- 1차원 배열, 총합과 평균 구하기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Lesson2: JSP페이지 문법</title>
</head>
<body>
<h1>배열사용하기 - 문제연습</h1>
<pre>
4과목의 점수와 과목명을 각각 1차원 배열로 정의하고
총점과 평균을 구하는 성적처리 프로그램을 작성합니다.
</pre>
<%-- jsp comment --%>
<%
int[] jumsu= {100, 90, 80, 70};
String[] subject= {"kor", "math", "eng", "java", "total", "avg"};

for(int i=0; i<jumsu.length; i++){
	out.print(subject[i]+": "+jumsu[i]+"<br>");
}

out.print(subject[jumsu.length]+": ");
int sum=0;
for(int i=0; i<jumsu.length; i++){
	sum+=jumsu[i];
}
out.print(sum+"<br>");

out.print(subject[5]+": ");
int avg=0;
avg=sum/jumsu.length;
out.print(avg);
//이중 for문으로도 쓸 수 있는지는 해보자

%>
</body>
</html>