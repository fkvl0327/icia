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
<title>Jsp Lesson1a45: JSP페이지 문법</title>
</head>
<body>
<h1>for-for 문장 활용하기 - 예제</h1>

<pre>
구구단을 출력해주세요
</pre>
<p></p>
<%-- jsp comment --%>
<pre>
</pre>
<div>
<h2> 로그인 상태: </h2>
</div>

<% 
int arr1[] = {1,2,3,4,5,6,7,8,9};
int arr2[] = {1,2,3,4,5,6,7,8,9};

for(int i=0;i<9;i++){
	for(int j=0;j<9;j++){
		%> 
		<%= arr1[i]%>x<%= arr2[j] %> = <%=arr1[i]*arr2[j] %> <br> 
		<%
	}
	%><br><br> <%	
}
%>
<br>
</body>
</html>