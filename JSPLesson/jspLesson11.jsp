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
<title>Jsp Lesson11: JSP페이지 문법</title>
</head>
<body>
<h1>while 문장 활용하기 - 예제</h1>

<pre>
* 정수의 합을 반복해서 구하기

반복구문:
  while(true){
    //실행
  }
  
  for(;;){}
  
  do{
  }while(true);
</pre>
<p></p>
<%-- jsp comment --%>
<pre>
------------------------------------------
     id
      |_________>
  <___|         |______________________> OK
계정생성         pw                    로그인
비밀번호확인<____|           

</pre>
<div>
<h2> 로그인 상태: </h2>
</div>

<% 
int n1 = 0;
int sum = 0;
//                0+1 +2 + 3 + 4 +5 + 6 +7 +8 +9+10 = 
while(n1<=10){// 0 >1>2>3>4 >5 >6 >7 > 8>9 >10>11
	sum +=n1;
	n1++;
}

%>

최종 n1 = <%=n1 %> <br>
합계 sum = <%=sum %>
</body>
</html>