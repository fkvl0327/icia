<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문서</title>
</head>
<body>
	${orders} 
	${msg }
</body>
<script>
	// 결제하기
	function order(gInfo){
		var goods = gInfo.split(":");
		var count = 0;
		var orderInfo = "";
		
		for(i=0;i<goods.length;i++){
				orderInfo += (goods[i] + (i==goods.length-1?"":":"));
			}
		
			var form = document.createElement("form");
			form.action = "SendOrder?gInfo="+orderInfo;
			form.method = "post";
			document.body.appendChild(form);
			form.submit();
		}
</script>
</html>