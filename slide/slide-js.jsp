<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" session="true"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="slide-js.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="navbar">
  <a href="#home">Home</a>
  <a href="#news">News</a>
  <div class="dropdown">
    <button class="dropbtn">Dropdown
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#">Link 1</a>
      <a href="#">Link 2</a>
      <a href="#">Link 3</a>
    </div>
  </div>
</div>
<div class="slideshow-container">

<!-- class 정의 시 class 이름을 "dog cat"처럼 띄어쓰기를 포함해서 쓰면 -->
<!-- 독립적인 클레스가 두개라는 의미 -->
<!-- dog와 cat으로 클레스 참조 가능하고요 style도 두 가지 다 영향받는다 -->
<div class="mySlides fade">
  <div class="numbertext">1 / 4</div>
  <img src="../img/spring.jpg" style="width:100%">
  <div class="text">Spring</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 4</div>
  <img src="../img/summer.jpg" style="width:100%">
  <div class="text">Summer</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 4</div>
  <img src="../img/fall.jpg" style="width:100%">
  <div class="text">Fall</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">4 / 4</div>
  <img src="../img/winter.jpg" style="width:100%">
  <div class="text">Winter</div>
</div>

<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
<a class="next" onclick="plusSlides(1)">&#10095;</a>

</div>
<br>

<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span> 
  <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span> 
  <span class="dot" onclick="currentSlide(4)"></span> 
</div>

<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}
</script>
<footer>
    <p>Copyright ©A All rights reserved.</p>
    <address>인천 032-000-0000</address>
</footer>
</body>
</html> 