<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인 뷰</title>
</head>
<body>
<pre>
페이지 화면을 다른 서비스 화면으로 이동시켜주는 것을 리다이렉트(redirect)라고 합니다.
즉, 연속된 서비스 제공을 위해 지정된 페이지 URL로 이동시켜주는 것입니다.
</pre>
<%
String cust_id=request.getParameter("cust_id");
String cust_pw=request.getParameter("cust_pw");
%>
<ul>
<li>아이디:<%=cust_id %><br>
<li>패스워드:<%=cust_pw %><br>
</ul>
<br>
<h3>페이지 이동: 로그인ok이면=>현재 check뷰=>다음 서비스화면</h3>
<div>
<p>
<%
boolean isLoginSuccess = false;//초기화
isLoginSuccess = false;//jdbc db 가져와서 비교한 결과 false인 경우
//수업 중에는 생략됐지만 db와 비교하는 과정이 있어야 함
String params=null;
String encParam1 = URLEncoder.encode(cust_id, "utf-8");//한글이 들어온 경우 utf-8인코딩
if(isLoginSuccess){
	response.sendRedirect("main_service_view.jsp"+"?cust_id="+cust_id);
}else{
	response.sendRedirect("login_form.jsp"+"?cust_id="+cust_id);
}
%>
</p>
<!-- <p> -->
<!-- <a href="main_service_view.jsp">다음 서비스화면</a> -->
<!-- </p> -->
</div>
</body>
</html>