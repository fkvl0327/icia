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
<title>Jsp Lesson10: JSP페이지 문법</title>
</head>
<body>
<h1>if if 중첩 문장 활용하기 - 예제</h1>

<pre>
사용자 아이디를 비교해서 일치하면 비밀번호를 비교하고
아이디> 비밀번호가 모두 일치하면
"방문을 환영합니다" 메시지 출력
그렇지 않으면 "비밀번호가 맞지않습니다."
아이디가 일치하지 않으면
"회원 가입 후 방문하세요"
메시지를 출력하도록 if if 문을 작성하세요.

</pre>
<p></p>
<%-- jsp comment --%>
------------------------------------------
     id
      |_________>
  <___|         |______________________> OK
계정생성         pw                    로그인
비밀번호확인<____|           


<div>
<h2> 로그인 상태: </h2>
</div>



</body>
</html>