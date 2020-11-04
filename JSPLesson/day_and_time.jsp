<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@ page errorPage="error.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날짜와 시간 활용하기 - 예제</title>
</head>
<body>
<pre>
1)
java.util.Date
java.sql.Date를 이용해 날짜를 출력할 수 있다.

2)
java 8 이후에는 java.time 패키지를 이용해 날짜를 출력할 수 있다.
</pre>
<!-- 날짜 -->
<div>
<h2>---날짜 표시하기---</h2>
<h3>java.util 패키지 사용</h3>
<%
java.util.Date util_date = new java.util.Date();
out.print("java.util.Date: " + util_date + "<br>");
%>
<h3>java.sql 패키지 사용</h3>
<%
java.sql.Date sql_date = new java.sql.Date(util_date.getTime());
out.print("java.sql.Date: " + sql_date);
%>
<h3>java.time 패키지 사용</h3>
<%
LocalDate localdate = LocalDate.now();
out.print("LocalDate: " + localdate + "<br>");
%>
<h3>DateTimeFormatter를 사용해서 날짜 표시하기</h3>
<%
DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
String date1 = localdate.format(date);
String date2 = localdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
%>
날짜1: <%=date1 %> <br>
날짜2: <%=date2 %> <br>
<h3>날짜 메소드 사용하기</h3>
<%
String strDate = localdate.getYear()+"년";
strDate += localdate.getMonthValue()+"월";
strDate += localdate.getDayOfMonth()+"일";
%>
strDate: <%=strDate %><br>
</div>
<!-- 시간 표시하기 -->
<div>
<h2>---시간 표시하기---</h2>
<%
LocalTime localtime = LocalTime.now();
out.println("LocalTime: " + localtime + "<br>");
%>
<%
DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
String time1 = localtime.format(time);
String time2 = localtime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
%>
시간1: <%=time1 %> <br>
시간2: <%=time2 %> <br>
<h3>시간 메소드 사용하기</h3>
<%
String strTime = localtime.getHour()+"시";
strTime += localtime.getMinute()+"분";
strTime += localtime.getSecond()+"초";
%>
strTime: <%=strTime %><br>
</div>
<br>
<div>
<h2>날짜와 시간을 동시에 사용하기</h2>
<%
LocalDateTime localDateTime = LocalDateTime.now();
out.println("localDateTime: " + localDateTime + "<br>");
%>
<h3>날짜와 시간을 formatter로 표시하기</h3>
<%
String pattern1 = "yyyy-MM-dd HH:mm:ss";
DateTimeFormatter dateTime = DateTimeFormatter.ofPattern(pattern1);
String dateTime1 = localDateTime.format(dateTime);
String dateTime2 = localDateTime.format(DateTimeFormatter.ofPattern(pattern1));
%>
1) <%=dateTime1 %> <br>
2) <%=dateTime2 %> <br>
<h3>날짜와 시간을 method로 표시하기</h3>
<%
String strDateTime = localDateTime.getYear()+"년";
strDateTime += localDateTime.getMonthValue()+"월";
strDateTime += localDateTime.getDayOfMonth()+"일";
strDateTime += localDateTime.getHour()+"시";
strDateTime += localDateTime.getMinute()+"분";
strDateTime += localDateTime.getSecond()+"초";
strDateTime += localDateTime.getNano()+"나노초";
%>
strDateTime: <%=strDateTime %><br>
</div>
<h2>날짜시간 응용하기</h2>
<div>
<h3>특정 날짜 생성하기</h3>
<h4>myDate 날짜 생성</h4>
<%
int year = 2020;
int month = 11;
int dayOfMonth = 3;
LocalDate myDate = LocalDate.of(year, month, dayOfMonth);
String strMyDate = myDate.getYear() + "년";
strMyDate += myDate.getMonthValue() + "월";
strMyDate += myDate.getDayOfMonth() + "일";
out.println("myDate: " + myDate.toString() + "<br>");
out.println("메소드myDate: " + strMyDate + "<br>");
%>
<h4>myTime 시간 생성</h4>
<%
int hour = 13;
int minute = 50;
int second = 53;
LocalTime myTime = LocalTime.of(hour, minute, second);
String strMyTime = myTime.getHour() + "시";
strMyTime += myTime.getMinute() + "분";
strMyTime += myTime.getSecond() + "초";
%>
myTime: <%=myTime %><br>
strMyTime: <%=strMyTime %><br>
<h4>날짜시간 동시 생성</h4>
<%
LocalDateTime myLocalDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
// String strMyLocalDateTime = myLocalDateTime.getYear() + "년";
// strMyLocalDateTime += myLocalDateTime.getMonthValue() + "월";
// strMyLocalDateTime += myLocalDateTime.getDayOfMonth() + "일";
// strMyLocalDateTime += myLocalDateTime.getHour() + "시";
// strMyLocalDateTime += myLocalDateTime.getMinute() + "분";
// strMyLocalDateTime += myLocalDateTime.getSecond() + "초";
%>
<%=myLocalDateTime %><br>
<%-- <%=strMyLocalDateTime %><br> --%>
</div>
</body>
</html>