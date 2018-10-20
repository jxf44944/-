<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>医药管理系统</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/jquery-2.0.3.js" ></script>
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
<div id="top"> </div>
<s:form id="login" name="login" action="Login_check" method="post" theme="simple">
  <div id="center">
    <div id="center_left"></div>
    <div id="center_middle" >
      <div class="user">
        <label>用户名：
        <!-- <input type="text" name="user" id="user" /> -->
        <s:textfield name="user.username" label="用户名：" />
        </label>
      </div>
      <div class="user">
        <label>密　码：
        <!--<input type="password" name="pwd" id="pwd" /> -->
        <s:password name="user.password" label="密码：" />
        </label>
      </div>

    </div>
    <input type="hidden" name="hasuser" id="hasuser" value="<s:property value="#session.loginUser.username" />"/>
    <div id="center_middle_right"></div>
    <div id="center_submit">
      <div class="button" align="center"> 
      	<img src="images/dl.gif" width="57" height="20" id="submitBtn" />
      </div>
      <div class="button" align="center"> 
      	<img src="images/cz.gif" width="57" height="20" onclick="form_reset()" /> 
      </div>
    </div>
    <div id="center_right"></div>
  </div>
</s:form>
<div id="footer"></div>
</body>
</html>
