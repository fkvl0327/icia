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
<title>Jsp Lesson18: JSP페이지 문법</title>
</head>
<body>
<h1>try-catch-finally 문장 활용하기 - 예제</h1>

<pre>
예외가 발생하는 문장에 오류 메시지 처리를 하세요.
</pre>
<p></p>
<%-- jsp comment --%>
<pre>
</pre>
<div>
<h2> 로그인 상태: </h2>
</div>

<%
int n1 = 100;
int n2 = 0;
int m = 0;
try{
m = n1/n2;
}catch(Exception e){
	out.print(e.getCause());
	out.print(e.getMessage());
}finally{
    out.print("<br>0으로 나눌 수 없습니다. <br>");	
}
		%>
<p><%=n1 %>/<%=n2 %> = <%= m %></p>		
		<%
%>
<br>
</body>
</html>