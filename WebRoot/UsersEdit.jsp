<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script src="js/jquery-2.1.3.min.js"></script>
<script language="javascript">
	//验证表单
	function clickForm(submitform) {
		var $username = $("#username").val();
		//不能为空格 
		if ($username.length == 0) {
			alert("用户名不能为空！");
			return false;
		}  else if (!$username.match("^([a-zA-Z]{3,7})\([0-9]{0,5})$")) {
			alert("用户名格式不对！\n【只能输入由英文开头或加上数字组成的用户名！】\n【英文不小于3位，且不能大于7位】\n【数字不能大于5位】");
			return false;
		}
		
		var $name = $("#name").val();
		//不能为空格 
		if ($name.length == 0) {
			alert("姓名不能为空！");
			return false;
		}  else if (!$name.match("^[\u4e00-\u9fa5a-zA-Z]{1,6}$")) {
			alert("姓名的格式不对！\n【请输入1到6位的中文或英文！】");
			return false;
		}
		
		var $password = $("#password").val();
		//不能为空格 
		if ($password.length == 0) {
			alert("密码不能为空！");
			return false;
		}  else if (!$password.match("^[a-zA-Z0-9]{6,12}$")) {
			alert("密码格式不对！\n【只能输入由6到12位英文或数字组成的密码！】");
			return false;
		}
		
		var $phone = $("#phone").val();
		if ($phone.length == 0) {
			alert("电话不能为空！");
			return false;
		} else if (!$phone.match("^[0-9]{3,11}$")) {
			alert("电话格式不对！\n【请输入3-11位数字】");
			return false;
		}
		
		var $adress = $("#adress").val();
		if ($adress.length < 5 ) {
			alert("地址不能少于5个字符！");
			return false;
		}else if ($adress.length > 30) {
			alert("地址不能大于30个字符！");
			return false;
		}
		
		var $qq = $("#qq").val();
		if ($qq.length == 0) {
			alert("QQ不能为空！");
			return false;
		}else if (!$qq.match("^[0-9]{5,10}$")) {
			alert("QQ的格式不对！\n【请输入5-10位数字】");
			return false;
		}
		
		var $Email = $("#Email").val();
		if ($Email.length == 0) {
			alert("邮箱地址不能为空！");
			return false;
		}else if (!$Email.match("^[0-9a-zA-Z]+@(([0-9a-zA-Z]+)[.])+[a-z]{2,4}$")) {
			alert("邮箱地址的格式不对！\n【请输入正确的邮箱格式】");
			return false;
		}
			
	}
	
	
</script>
</head>
<body class="ContentBody">
	<div id="title_bar">
		<span id="title">系统管理&gt;&gt;用户管理&gt;&gt;查看修改用户信息</span>
	</div>
	<div align="center">
		<s:form action="Users_Update" method="post"  target="_top" onsubmit="return clickForm(this)">
			<div class="MainDiv">
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<td bgcolor="#A0A0A0"></td>
					</tr>
					<tr>
						<td height="40" class="font42">
							<table width="600px" border="0" align="center" cellpadding="4"
								cellspacing="1" bgcolor="#DDD" class="newfont03" id="tblist" />
						</td>
					</tr>
					<tr>
						<td height="20" colspan="13" align="center" bgcolor="#EEEEEE"
							class="tablestyle_title" style="text-align: center;"><b>查看修改用户信息</b></td>
					</tr>
					<tr>
						<td>
							<table width="95%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td height="40" class="font42">
										<table width="100%" border="0" align="center" cellpadding="4"
											cellspacing="1" bgcolor="#DDD" class="newfont03" id="tblist">
											<tr>
												<td class="CPanel">
													<table border="0" cellpadding="0" cellspacing="0"
														style="width:100%">
														<tr>
															<td class="CPanel">

																<table border="0" cellpadding="0" cellspacing="0"
																	style="width:100%">

																	<tr align="center">
																		<td width="100%">

																			<table border="0" cellpadding="2" cellspacing="1"
																				style="width:100%">
																				<tr>
																					<td>
																							<s:textfield name="user.id"  type="hidden" />
																							<s:textfield name="user.TActer.acterid"  type="hidden" />
																							<s:textfield name="user.remark"  type="hidden" />
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="user.username" label="用户名"  value="%{user.username}"  id="username"/>
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="user.name" label="姓名"  value="%{user.name}" id="name"/>
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="user.password"  label="密码"  value="%{user.password}" id="password"/>
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="user.phone" label="手机 "  value="%{user.phone}" id="phone"/>
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="user.adress" label="地址"  value="%{user.adress}" id="adress"/>
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="user.qq" label="QQ"  value="%{user.qq}" id="qq"/>
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="user.email" label="邮箱地址"  value="%{user.email}" id="Email"/>
																					</td>
																				</tr>
																				
																			</table> <br />
																		</td>
																	</tr>

																</table>
															</td>
														</tr>	
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>		
							</table>
							<s:submit align="center" value="修改" />
							<s:reset align="center" value="重置" />
						</td>
					</tr>
				</table>
			</div>
		</s:form>
	</div>
</body>
</html>
