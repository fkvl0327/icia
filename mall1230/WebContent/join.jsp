<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up Page</title>
    <meta name="description" content="Sign Up Page">
    <meta name="author" content="Sookyeong">
    <link rel="icon" type="image/png" href="image/icia-logo.png">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <!-- Header -->
    <header id="header">
        <h1><a href="https://www.icia.co.kr/"><img src="image/icia-logo.png" alt=""></a></h1>
    </header>
    <div id="message">${message }</div>
    <!-- Secion -->
    <section id="section">
        <form action="Join" method="post">
            <div class="id">
                <h3 class="join__title"><label for="id">아이디</label></h3>
                <span class="input__space"><input type="text" name="joinInfo" minlength="3" maxlength="10" title="ID" required></span>
            </div>
            <div class="pw">
                <h3 class="join__title"><label for="password">비밀번호</label></h3>
                <span class="input__space"><input type="password" name="joinInfo" minlength="4" maxlength="10" title="비밀번호 입력" required></span>
            </div>
            <div class="pw2">
                <h3 class="join__title"><label for="password">비밀번호 재확인</label></h3>
                <span class="input__space"><input type="password" id="password" minlength="4" maxlength="10" title="비밀번호 재확인 입력" required onBlur="pwdCheck()"></span>
            </div>
            <div class="name">
                <h3 class="join__title"><label for="name">이름</label></h3>
                <span class="input__space"><input type="text" name="joinInfo" title="이름" required></span>
            </div>
            
            <!-- 
            <div class="birthday">
                <h3 class="join__title"><label for="birthday">생년월일</label></h3>
                <div class="bir__wrap">
                    <div class="bir__wrap__item">
                        <span class="input__space"><input type="text" id="birthday" maxlength="4" placeholder="년(4자)"></span>
                    </div>
                    <div class="bir__wrap__item">                   
                        <select name="birthday" id="birthday">
                                <option value="Month">월</option>
                                <option value="January">1</option>
                                <option value="Febuary">2</option>
                                <option value="March">3</option>
                                <option value="April">4</option>
                                <option value="May">5</option>
                                <option value="June">6</option>
                                <option value="July">7</option>
                                <option value="Agust">8</option>
                                <option value="September">9</option>
                                <option value="October">10</option>
                                <option value="November">11</option>
                                <option value="December">12</option>
                        </select>                        
                    </div>
                    <div class="bir__wrap__item">
                        <span class="input__space"><input type="text" id="birthday" maxlength="2" placeholder="일"></span>
                    </div>
                </div>
            </div>
            <div class="gender">
                <h3 class="join__title"><label for="gender">성별</label></h3>
                <div class="radio__gender">
                    <span class="radio__gender__item"><input type="radio" name="gender" id="gender" value="Male">남자</span>
                    <span class="radio__gender__item"><input type="radio" name="gender" id="gender" value="Female">여자</span>
                    <span class="radio__gender__item"><input type="radio" name="gender" id="gender" value="
                        Not selected">선택 안함</span>
                </div>
            </div>
            <div class="email">
                <h3 class="join__title"><label for="email">본인 확인 이메일</label><small style="color:#bdbdbd;">(선택)</small></h3>
                <span class="input__space"><input type="email" id="email" placeholder="선택입력"></span>
            </div>
             -->
            <div class="tel">
                <h3 class="join__title"><label for="tel">휴대전화</label></h3>
                <div class="tel__wrap">
                	<!-- 
                    <div class="tel__wrap__select">                       
                        <select name="tel" id="tel">
                            <option value="233">가나 +233</option>
                            <option value="674">나우루 +674</option>
                            <option value="82" selected>대한민국 +82</option>
                            <option value="856">라오스 +856</option>
                            <option value="52">멕시코 +52</option>
                            <option value="32">벨기에 +32</option>
                            <option value="65">싱가포르 +65</option>
                            <option value="353">아일랜드 +353</option>
                        </select>                       
                    </div>
                     -->
                    <div class="tel__wrap__input">
                        <span class="input__space"><input type="tel" name="joinInfo" placeholder="전화번호 입력"></span>
                        <!-- 
                        <span class="button"><button>인증번호 받기</button></span>
                         -->
                    </div>
                    <!-- 
                    <div class="tel__wrap__input2">
                        <input type="tel" id="tel" placeholder="인증번호 입력하세요">
                    </div>
                     -->
                </div>
            </div>
            <div class="submit">
                <button type="submit" id="submit">가입하기</button>
            </div>
        </form>
        <span onClick="movePage(true)">[LogIn]</span>
        <span onClick="movePage(false)">[Previous]</span>
    </section>
    <!-- Footer -->
    <footer id="footer">
        <span class="footer__icon"><a href="https://www.icia.co.kr/"><img src="image/icia-logo.png" alt="" id="footer__icon"></a></span>
        <span class="footer__rights">Copyright <b>ICIA.</b> All Rights Reserved.</span>
    </footer>
</body>
<script>
function pwdCheck(){
	// 패스워드와 패스워드재확인의 데이터가 일치하는지 확인
	var pwd = document.getElementsByName("joinInfo")[1];
	var pwdCopy = document.getElementById("password");
	
	if(pwd.value != pwdCopy.value){
		pwd.value = "";
		pwdCopy.value = "";
		pwd.placeholder = "패스워드가 일치하지 않아요~ 다시 입력 부탁드려요"
		pwd.focus();
	}
}

function movePage(selection){
	var form = document.createElement("form");
	
	form.action = (selection)? "LogInForm" : "${prev}";
	form.method = "post";

	// 현재 페이지 정보
	var page = document.createElement("input");
	page.type = "hidden";
	page.name = "page";
	page.value = "JoinForm";
	form.appendChild(page);
	
	document.body.appendChild(form);
	form.submit();
	
}
</script>
</html>