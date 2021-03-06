﻿<%@ page contentType="text/html; charset=utf-8" language="java"
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
		//文本框
		var $name = $("#name").val();
		//不能为空格 
		if ($name.length == 0) {
			alert("医院药房名字不能为空！");
			return false;
		} else if (!$name.match("^[\u4e00-\u9fa5a-zA-Z]{3,15}$")) {
			alert("医院药房名字格式不对！\n【请输入3-15位的中文或英文字符】");
			return false;
		}
		
		var $manager = $("#manager").val();
		if ($manager.length == 0) {
			alert("负责人不能为空！");
			return false;
		} else if (!$manager.match("^[\u4e00-\u9fa5a-zA-Z]{1,5}$")) {
			alert("负责人格式不对！\n【请输入1-5位的中文或英文字符！】");
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
		if ($adress.length < 5) {
			alert("地址不少于5个字符！");
			return false;
		}else if ($adress.length > 30) {
			alert("地址不能大于30个字符！");
			return false;
		}
	}
</script>
</head>
<body class="ContentBody">
	<div id="title_bar">
		<span id="title">系统管理&gt;&gt;医院药房管理&gt;&gt;修改医院药房</span>
	</div>
	<div align="center">
		<s:form action="Hospital_Update" method="post"
			onsubmit="return clickForm(this)">
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
							class="tablestyle_title" style="text-align: center;"><b>修改医院药房信息</b></td>
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
																					<td><s:textfield name="hospital.id"
																							type="hidden" /></td>
																				</tr>
																				<tr>
																					<td><s:textfield name="hospital.name"
																							label="医院药房名称" id="name"/></td>
																				</tr>
																				<tr>
																					<td><s:textfield name="hospital.manager"
																							label="负责人" id="manager"/></td>
																				</tr>
																				<tr>
																					<td><s:textfield name="hospital.phone"
																							label="电话" id="phone"/></td>
																				</tr>
																				<tr>
																					<td><s:textfield name="hospital.time"
																							type="hidden" /></td>
																				</tr>
																				<tr>
																					<s:textarea name="hospital.adress" cols="45"
																						rows="5" label="地址" id="adress"/>
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
							</table> <s:submit align="center" value="修改" /> <s:reset align="center"
								value="重置" />
						</td>
					</tr>
				</table>
			</div>
		</s:form>
	</div>
</body>
</html>
