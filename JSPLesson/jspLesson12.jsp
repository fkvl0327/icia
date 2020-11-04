<%-- jsp 지시문, directive, page directive --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%
String user_id = "admin";
String user_pw = "pass";

String login_id = "admin";
String login_pw = "pass1";

String msg="";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jsp Lesson12: JSP페이지 문법</title>
</head>
<body>
<h1>while 문장 활용하기 - 예제</h1>

<pre>
3과목의 점수와 과목명을 각각 1찬원 배열로 정의하고 
총점과 평균을 구하는 
성적처리 프로그램을 while반복문을 사용하여 작성하세요.
</pre>
<p></p>
<%-- jsp comment --%>
<pre>
</pre>
<div>
<h2> 로그인 상태: </h2>
</div>

<% 
int jumsu[] = {89, 91, 90};
String title[] = {"국어", "영어","수학", "총점", "평균"};

int total = 0;
int i = 0;
float avg = 0;

while(i<3){// 0 > 1 > 2 > 3
	out.print("과목: "+ title[i] + "점수: " + jumsu[i] +"<br>");
	
	%>
	<%=title[i] %> = <%= jumsu[i] %>
	<% 
	
	total = total + jumsu[i];
	i++;
}

avg =  total / 3; 
%>
<br>
<%=title[i] %> = <%=total %> <br>
<%=title[i+1] %> = <%=avg %>
</body>
</html>