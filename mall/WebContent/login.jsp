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
<body>
    <!-- Header -->
    <header id="header">
        <h1><a href="https://www.icia.co.kr/"><img src="image/icia-logo.png" alt="어서와~~~~~"></a></h1>
    </header>
    <!-- Secion -->
    <section id="section">
        <form action="LogIn" method="post">
            <div class="id">
                <h3 class="join__title"><label for="id">아이디</label></h3>
                <span class="input__space"><input type="text" name="accessInfo" id="id" minlength="3" maxlength="10" title="ID" required></span>
            </div>
            <div class="pw">
                <h3 class="join__title"><label for="password">비밀번호</label></h3>
                <span class="input__space"><input type="password" name="accessInfo" id="password" minlength="4" maxlength="10" title="비밀번호 입력" required></span>
            </div>
            <div id="message">${message }</div>
            <div class="submit">
                <button type="submit" id="submit">로그인</button>
            </div>
        </form>
    </section>
    <!-- Footer -->
    <footer id="footer">
        <span class="footer__icon"><a href="https://www.icia.co.kr/"><img src="image/icia-logo.png" alt="" id="footer__icon"></a></span>
        <span class="footer__rights">Copyright <b>ICIA.</b> All Rights Reserved.</span>
    </footer>
</body>
</html>