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
<title>Jsp Lesson9: JSP페이지 문법</title>
</head>
<body>
<h1>if else if 문장 활용하기 - 예제</h1>

<pre>

1)예시
---------------------------------
          A<10      15< A
  <________|         |___________>
   A > 10             15< A
     
if (A<10){

} else if(A>15){


} else {
   //( 10<=A &&  A<=15 )
}  

2)예시
--------------------------------------------
100         90      80       70      60
        A > 90
  <_________| 
  "A"
            |_____________________> 그밖에
            <________|
            "B"      |____________> 그밖에2
           
                     <_______|
                     "C"     |________>그밖에3
                           
if (A>90){
   "A" 성적입니다.
}else {
    if(A>80){
       "B" 성적입니다.
       
    }else{
      if(A>70){
        "C" 성적입니다.
        
      }else{
         "F" 입니다.
      }
      
    }
}
</pre>
<p></p>
<%-- jsp comment --%>
<%

// int jumsu = 91;
 String hakjum = "A";

// if(){
// }else{
	
// }


%>

<b>성적 등급: <%=hakjum %></b>


</body>
</html>