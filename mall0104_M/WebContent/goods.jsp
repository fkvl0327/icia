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
    <body onLoad="init()">
         <!-- Header -->
         <header id="header">
            <h1><a href="https://www.icia.co.kr/"><img src="image/icia-logo.png"></a></h1>
        </header>   
        <!-- Section -->
        <div id="search">
        	<input type="text" name="word" />
        	<input type="button" value="검색" onClick="searchGoods()"/>
        </div>
        <div id="section">
        	${gList }
        </div>  
        <!-- Footer -->
        <footer id="footer">
            <span class="footer__icon"><a href="https://www.icia.co.kr/"><img id="footer__icon" src="image/icia-logo.png" alt=""></a></span>
            <span class="footer__rights">Copyright <b>Sookyeong Lee.</b> All Rights Reserved.</span>
        </footer>
    </body>
    <script>
    	function init(){
    		if(msg != null){
    		alert("${msg }");
    		}
    	}
    	
     	function searchGoods(){
     		var form = document.createElement("form");
     		form.action = "Search";
     		form.method = "post";
     		
     		form.appendChild(document.getElementsByName("word")[0]);
     		
     		document.body.appendChild(form);
     		
     		form.submit();
     	}
     	
     	function goDetail(code){
     		var splitCode = code.split(":");
     		
     		var f = document.createElement("form");
     		f.action = "GoodsDetail";
     		f.method = "post";
     		
     		for(i=0;i<splitCode.length;i++){
         		var input = document.createElement("input");	
         		input.type= "hidden";
         		input.name = "code";
         		input.value = splitCode[i];
         		f.appendChild(input);
     		}
     		
     		document.body.appendChild(f);
     		
     		f.submit();
     		
     	}
    </script>
    </html>