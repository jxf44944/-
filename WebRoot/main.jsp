<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-2.0.3.js" ></script>
<title>医院药库管理系统</title>
<script type="text/javascript">
		$("document").ready(function(){
			//alert("testea-------15");
			var name =document.getElementById('hasuser').value;
			//2018-04-25
			//alert("testea-------15"+name);
			if(name==null){
				location.href="<%=request.getContextPath()%>/Login_To";
			}
		});
	</script>
</head>
<frameset rows="127,*,11" frameborder="no" border="0" framespacing="0">
	<frame src="top.jsp" name="topFrame" scrolling="no"
		noresize="noresize" id="topFrame" />
	<frame src="center.jsp" name="mainFrame" id="mainFrame" />
	<frame src="down.html" name="bottomFrame" scrolling="no"
		noresize="noresize" id="bottomFrame" />
</frameset>
<noframes>
<body>
	<input type="hidden" name="hasuser" id="hasuser" value="<s:property value="#session.loginUser.username" />"/>
</body>
</noframes>
</html>