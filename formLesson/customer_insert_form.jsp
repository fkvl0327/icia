<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<link rel="stylesheet" href="../formLesson/customer_insert.css">
</head>
<body>
<form name="customer_form" method="post" action="customer_insert_view.jsp">
	<table>
		<caption>회원가입</caption>
		<tr>
			<td style="text-align:center; background-color:LavenderBlush">ColorTest</td>
		</tr>
		
		<tr>
			<th><span class="msg_red">*</span>ID</th>
			<td><input type="text" name="id" size="20" maxlength="10" required autofocus></input></td>
		</tr>
		<tr>
			<th><span class="msg_red">*</span>PW</th>
			<td><input type="password" name="pw" size="20" maxlength="10"></input></td>
		</tr>
		<tr>
			<th><span class="msg_red">*</span>PW CHECK</th>
			<td><input type="password" name="pw2" size="20" maxlength="10"></input></td>
		</tr>
		<tr>
			<th><span class="msg_red">*</span>이&nbsp;&nbsp;&nbsp;&nbsp;름</th>
			<td><input type="text" name="name" size="10" maxlength="10"></input></td>
		</tr>
		<tr>
			<th>&nbsp;성&nbsp;&nbsp;별</th>
			<td><input type="radio" name="gender" value="M">남
				<input type="radio" name="gender" value="F">여
				<input type="radio" name="gender" value="N" checked>선택 안 함
			</td>
		</tr>
		<tr>
			<th>&nbsp;취&nbsp;&nbsp;미</th>
			<td><input type="checkbox" name="hobby" value="등산">등산
				<input type="checkbox" name="hobby" value="낚시">낚시
				<input type="checkbox" name="hobby" value="독서">독서
				<input type="checkbox" name="hobby" value="음악">음악
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:center">
				<input type="submit" value="전송">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>

</body>
</html>