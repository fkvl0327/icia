<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <meta name="description" content="Login Page">
    <meta name="author" content="Sookyeong">
    <link rel="icon" type="image/png" href="icia-logo.png">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body onLoad="init()">
    <!-- Header -->
    <header id="header">
        <h1><a href="https://www.icia.co.kr/"><img src="image/icia-logo.png" alt="어서와~~~~~"></a></h1>
    </header>
    <!-- Secion -->
    <section id="section">
        <div id="memberInfo" class="userInfo">
			<marquee>${memberInfo }에 로그인 하셨습니다.</marquee>              
        </div>
        <center><h1>Welcome to Main Page</h1></center>
        <input type="button" value="LOGIN" onClick="sendForm(this)" />
        <input type="button" value="JOIN" onClick="sendForm(this)" />   
    </section>
    <!-- Footer -->
    <footer id="footer">
        <span class="footer__icon"><a href="https://www.icia.co.kr/"><img src="image/icia-logo.png" alt="" id="footer__icon"></a></span>
        <span class="footer__rights">Copyright <b>ICIA.</b> All Rights Reserved.</span>
    </footer>
</body>
<script>
function init(){
	var message = "${memberInfo}";
	if(message == "" ){
		document.getElementById("memberInfo").style.display = "none";
	}else{
		document.getElementById("memberInfo").style.display = "block";
	}
}

function sendForm(obj){
	// Dynamic Element Creation
	var form = document.createElement("form");
	form.action = (obj.value == "LOGIN")? "LogInForm" : "JoinForm";
	form.method = "post";
	
	// Current Page정보
	var page = document.createElement("input");
	page.type = "hidden";
	page.name = "page";
	page.value = "Main";
	
	form.appendChild(page);
	
	document.body.appendChild(form);
	form.submit();
}
</script>
</html>