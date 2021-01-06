<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Goods Page</title>
        <link rel="icon" type="image/png" href="image/icia-logo.png">
        <link rel="stylesheet" href="css/style_goods.css">
    </head>
    <body>
         <!-- Header -->
         <header id="header">
            <h1><a href="https://www.icia.co.kr/"><img src="image/icia-logo.png"></a></h1>
        </header>   
        <!-- Section -->
        <div id="search">
        	<input type="text" name="word" />
        	<input type="button" value="검색" onClick="searchGoods()"/>
        </div>
        <!-- 상품정보 -->
        <div id="section">
        	<!-- 상품주요정보 -->
        	<div id="title">
        		<!-- 상품이미지 -->
        		<div id="goodsImg">${goodsImage }</div>
        		<!-- 상품개요 -->
        		<div id="goodsSummary">
        			<!-- 상품명 -->
					<div id="item">${item }</div>
					<!-- 상품가격 -->
					<div id="item">${price }</div>
					<!-- 상품옵션선택 -->
					<div id="opt"></div>
					<!--  장바구니 | 구매하기 -->
					<div id="order">
						<!-- 서버전송데이터 -->
						<input type="button" value="장바구니" onClick="order(true, '${gInfo}')"/>
						<input type="button" value="구매하기" onClick="order(false, '${gInfo}')"/>
					</div>        		
        		</div>
        	</div>
        	<!-- 상품상세정보 :: image -->
        	<div id="detail">
        		<div>${seller }</div>
        		<div>${detailImage }</div>
        	</div>
        </div>
        <!-- Footer -->
        <footer id="footer">
            <span class="footer__icon"><a href="https://www.icia.co.kr/"><img id="footer__icon" src="image/icia-logo.png" alt=""></a></span>
            <span class="footer__rights">Copyright <b>Sookyeong Lee.</b> All Rights Reserved.</span>
        </footer>
    </body>
    <script>
    	function order(type, gInfo){
    		var form = document.createElement("form");
    		form.method = "post";
    		form.action = (type)? "Basket" : "Order";
    		
    		//gInfo --> id:gocode:secode
    		var info = gInfo.split(":");
    		for(i=0;i<info.length;i++){
         		var input = document.createElement("input");	
         		input.name = "gInfo";
         		input.value = info[i];
         		form.appendChild(input);
     		}
    		
    		document.body.appendChild(form);
    		alert(form.info[0].value);
    		
    	}
    </script>
    
    </html>