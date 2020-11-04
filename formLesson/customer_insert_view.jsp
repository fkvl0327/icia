<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인 페이지</title>
<link rel="stylesheet" href="../formLesson/customer_insert.css">
</head>
<body>
<h2>회원가입 확인 뷰</h2>
<h3>입력내용</h3>
<ul>
<li>아이디: <%=request.getParameter("id") %><br>
<li>이름: <%=request.getParameter("name") %><br>
<li>성별: <%=request.getParameter("gender") %><br>
<li>취미: <%
String[] hobby = request.getParameterValues("hobby");
if(hobby!=null){
	for(int i=0; i<hobby.length;i++){
		out.print(hobby[i]+" ");
	}
}
else{
	out.println("취미를 선택하지 않았습니다.");
}
%>
</ul>
<h3>테이블 출력</h3>
<table>
	<tr>
		<th>아이디</th>
		<td><%=request.getParameter("id") %></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><%=request.getParameter("name") %></td>
	</tr>
	<tr>
		<th>성별</th>
		<td><%String[] gender=request.getParameterValues("gender");
		boolean g1 = false;
		boolean g2 = false;
		boolean g3 = false;
		for(String ss:gender){
			if(ss.equals("등산")){
				g1 = true;
			}
			if(ss.equals("낚시")){
				g2 = true;
			}
			if(ss.equals("독서")){
				g3 = true;
			}
		}
		if(g1){
			%>
			<input type="radio" name="gender" value="M" checked>남
			<%
		}else{
			%>
			<input type="radio" name="gender" value="M">남
			<%
		}if(g2){
			%>
			<input type="radio" name="gender" value="F" checked>여
			<%
		}else{
			%>
			<input type="radio" name="gender" value="F">여
			<%
		}if(g3){
			%>
			<input type="radio" name="gender" value="N" checked>선택 안 함
			<%
		}else{
			%>
			<input type="radio" name="gender" value="N">선택 안 함
		<%
		}
		%>
		</td>
	</tr>
	<tr>
		<th>취미</th>
		<td><%
			String[] hobby1 = request.getParameterValues("hobby");
			boolean hob1 = false;
			boolean hob2 = false;
			boolean hob3 = false;
			boolean hob4 = false;
			for(String s:hobby1){
				if(s.equals("등산")){
					hob1 = true;
				}
				if(s.equals("낚시")){
					hob2 = true;
				}
				if(s.equals("독서")){
					hob3 = true;
				}
				if(s.equals("뮤직")){
					hob4 = true;
				}
			}
			if(hob1){
				%>
				<input type="checkbox" name="hobby" value="등산" checked>등산
				<%
			}else{
				%>
				<input type="checkbox" name="hobby" value="등산">등산
				<%
			}if(hob2){
				%>
				<input type="checkbox" name="hobby" value="낚시" checked>낚시
				<%
			}else{
				%>
				<input type="checkbox" name="hobby" value="낚시">낚시
				<%
			}if(hob3){
				%>
				<input type="checkbox" name="hobby" value="독서" checked>독서
				<%
			}else{
				%>
				<input type="checkbox" name="hobby" value="독서">독서
				<%
			}if(hob4){
				%>
				<input type="checkbox" name="hobby" value="음악" checked>음악
				<%
			}else{
				%>
				<input type="checkbox" name="hobby" value="음악">음악
			<%
			}
			%>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center">
			<input type="submit" value="확인">
			<input type="reset" value="취소">
			</td>
		</tr>
	
	<caption>
		회원가입 입력정보
	</caption>
</table>
<p>
<a href="customer_insert_form.jsp">회원가입페이지로 이동</a>
</p>
</body>
</html>