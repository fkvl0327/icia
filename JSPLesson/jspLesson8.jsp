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
<title>Jsp Lesson8: JSP페이지 문법</title>
</head>
<body>
<h1>if 문장 활용하기 - 예제</h1>

<pre>
사용자 아이디와 비밀번호를 비교하여 모두 일치하면
"아이디와 비밀번호가 맞습니다"

이외의 경우에는 
"아이디와 비밀번호가 맞지 않습니다"

메시지를 출력하는 
사용자 로그인 인증 프로그램을 if else를 사용해서 작성하세요.
   
</pre>
<p></p>
<%-- jsp comment --%>

<% 
if((user_id == login_id) && (user_pw == login_pw)){
	msg = "아이디와 비밀번호가 맞습니다";
	%>
	<h3>로그인 되었습니다.</h3>
	<%
}else{
	msg = "아이디와 비밀번호가 맞지 않습니다";
	%>
	<h3>로그인이 실패하였습니다.</h3>
	<%
}
%>

<div>
검증<br>
사용자 아이디 = <%=user_id %>, 사용자 비밀번호 = <%=user_pw %> <br>
로그인 아이디 = <%=login_id %>, 로그인 비밀번호 = <%=login_pw %> <br>
<br>
로그인 메시지 :  <%=msg %><p>
</div>
</body>
</html>