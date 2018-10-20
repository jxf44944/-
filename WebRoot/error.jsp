<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>药库管理系统</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/jquery-2.0.3.js"></script>
<script type="text/javascript">
		
		$("document").ready(function(){
	//alert("testea-------15");
			$("#submitBtn").click(function(){
				
				$("#login").submit();
			});
			var name =document.getElementById('hasuser').value;
			if(name!=null&&name.length>0){
				location.href="<%=request.getContextPath()%>/Login_En";
			}
		});
		
		
		
		
	</script>

</head>
<body>
	<div id="top"></div>
	<s:form id="login" name="login" action="Login_To" method="post"
		theme="simple">
		<div id="center">
			<div id="center_left"></div>
			<div id="center_middle">
				<h1>登录失败</h1>
				<s:submit value="返回"></s:submit>
			</div>
			<div id="center_right"></div>
		</div>
	</s:form>
	<div id="footer"></div>
</body>
</html>
