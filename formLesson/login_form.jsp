<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<style type="text/css">
	table{
	 width:200px;
	 text-align:center;
	 border-collapse:collapse;
	}
	caption{
	 font-size:20pt;
	 font-weight:bold;
	}
	th, td{
	 border:1px solid grey;
	 padding:3px;
	}
	th{
	 width:50%;
	 background-color:Coral;	
	}
	td{
	 background-color:Cornsilk;
	}
</style>
</head>
<body>
<form name="login_form" method="post" action="login_redirect_check.jsp">
<table>
<caption>로그인 폼</caption>
	<tr>
		<th>아이디</th>
		<td><input type="text" name="cust_id" size="10" maxlength="10" required autofocus></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="cust_pw" size="10" maxlength="10" required></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center">
			<input type="submit" value="확인">
			<input type="reset" value="취소">
		</td>
	</tr>

</table>
</form>
</body>
</html>