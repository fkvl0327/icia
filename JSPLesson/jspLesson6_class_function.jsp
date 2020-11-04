<%-- jsp 지시문, directive, page directive --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jsp Lesson7: JSP페이지 문법</title>
</head>
<body>
<h1>스트링String 클래스 - 예제</h1>
<pre>
// String names = "abcd1234";
// names.toLowerCase(); 으로 사용합니다. 

String replace(char arg0, char arg1);
String replaceAll(char arg0, char arg1);
String[] split(String arg0); // 문자열을 분할해서 리턴
String substring(int n1, int n2); // n1부터 n2번째까지의 문자열을 잘라서 리턴
String toLowerCase(); //소문자로 바꿔주는 함수
String toUpperCase();
String trim(); // 문자열에서 앞, 뒤 빈공백을 없애준다
boolean equals();
int length();
int compareTo(String arg0);
boolean isEmpty();
boolean matches(String arg0);

</pre>

<% 
String univ = "first Univ";
String UNIV = "FIRST UNIV";
String msg = "";

int str_len = univ.length();
String sub_str1 = univ.substring(0, 4);
String sub_str2 = univ.substring(4);
%>
<ul>
<li>주어진문자열: <%= univ%> <br> 
<li>문자열길이(length) : <%= str_len %> <br>
<li>출력문(sub_str1): <%= sub_str1%> <br>
<li>출력문(sub_str2): <%= sub_str2%> <br>
</ul>
<% 
if(univ.equals(UNIV.toLowerCase())){
	msg = "문자열이 같아요";
%>
<h3>문자열이 같아요</h3><br>	
<% 
}else{
	msg = "문자열이 달라요";
	%>
<h3>문자열이 달라요</h3><br>
	<% 
}
%>

문자열비교 univ와 UNIV 결과: <%=msg %> <p>

<% 
out.print("equals: " + univ.equals(univ) +"<br>");
out.print("matches: " + univ.matches("university") +"<br>");
out.print("compareTo: " + univ.compareTo("first UniV") +"<br>");
out.print("replace: " + univ.replace("i", "-") +"<br>");
out.print("replaceAll: " + UNIV.replaceAll("NI", "12") +"<br>");
out.print("replaceFirst: " + UNIV.replaceFirst("I", "*") +"<br>");

%>               
</body>
</html>