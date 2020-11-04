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
<title>Jsp Lesson17: JSP페이지 문법</title>
</head>
<body>
<h1>continue, break 문장 활용하기 - 예제</h1>

<pre>
1부터 100까지 홀수의 합을 구하는 프로그램을 작성하세요
단, 홀수의 합이 25보다 크거나 같으면 프로그램을 중단하도록
continue 와 break을 사용하세요.
</pre>
<p></p>
<%-- jsp comment --%>
<pre>
</pre>
<div>
<h2> 로그인 상태: </h2>
</div>

<% 
int sum = 0;
int i = 0;
for(i=0;i<100;i++){
	if(i%2==0){
		//짝수
		continue;
	}else{
		//홀수
		sum += i;
	}
	%>
	홀수: <%=i%>, sum : <%=sum %> <br>
	<%
	
	if(sum >25){
		break;
	}
}
%>
<p>1부터 <%= i%>까지 홀수 합 = <%=sum %></p>
<%

%>
<br>
</body>
</html>