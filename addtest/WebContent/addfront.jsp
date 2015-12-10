<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.*,java.text.*,org.json.simple.JSONObject"%>
    <%@ page import="cal.add.AddServlet2" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	function add_action() {
		var mForm = document.addform; // form의 값을 가져오기 위함
		var obj = new Object(); // JSON형식으로 변환 할 오브젝트
		obj['num1'] = mForm.num1.value;
		obj['num2'] = mForm.num2.value;	 
		
		console.log(obj);
		var json_data = JSON.stringify(obj); // form의 값을 넣은 오브젝트를 JSON형식으로 변환
		var request = $.ajax({
			url : "AddServlet2",
			type : "POST",
			data : obj,
			dataType : "json"
		});
	}
</script>
	<form action="" method="post" name="addform">

	<input type="text" name="num1"></input> + <input type="text" name="num2"></input> 
	<input type="submit" onclick="add_action()" value="더하기">
	
	<br>
	결과는 
	${requestScope.jsonStr }
	
	</form>
</body>
</html>