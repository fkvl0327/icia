<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>table 만들기</title>
</head>
<link rel="stylesheet" href="../formLesson/customer_insert.css">
<body>
<h2>html table 만들기 예</h2>
<div>
<pre>
3줄x4칸 표를 만듭니다.
-----------------
</pre>
<br>
<table>
	<caption>ICIA</caption>
	<tr>
		<th colspan="4">출석부</th>
	</tr>
	<tr>
		<th>순번</th>
		<th>이름</th>
		<th>나이</th>
		<th>성별</th>
	</tr>
	<tr>
		<td rowspan="2">0</td>
		<td>김</td>
		<td>20</td>
		<td>남</td>
	</tr>
	<tr>
		<td>이</td>
		<td>22</td>
		<td>여</td>
	</tr>
</table>
</div>
</body>
</html>