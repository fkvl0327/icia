<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 확인</title>
</head>
<body>
	${basket}
	<input type="hidden" id="fromBasket"/> 
</body>
<script>
	// 전역변수
	var checkCount = 0;
	
	// 개별체크
	function checkState(obj){
		checkCount += (obj.checked? 1: -1);
	}
	
	// 전체체크
	function checkAll(){
		var check = document.getElementsByName("check");
		var all = document.getElementById("all");
		if(all.checked){
			for(i=0;i<check.length;i++){
				check[i].checked=true;
				checkCount = check.length;
			}
		}else{
			for(i=0;i<check.length;i++){
				check[i].checked=false;
			}
		}
	}
	
	// 주문하기
	function order(gInfo){
		var goods = gInfo.split(":");
		var check = document.getElementsByName("check");
		
		if(checkCount>0){
			var count = 0;
			var orderInfo = "";
			for(i=0;i<check.length;i++){
				if(check[i].checked){
					count++;
					orderInfo += (goods[i] + (checkCount==count?"":":"));
				}
			}
		
			var form = document.createElement("form");
			form.action = "Order?gInfo="+orderInfo+"&fromBasket=true";
			form.method = "post";
			document.body.appendChild(form);
			form.submit();
		}
	}
</script>
</html>