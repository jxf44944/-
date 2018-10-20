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
		//文本框
		var $number = $("#number").val();
		//不能为空格 
		if ($number.length == 0) {
			alert("批准文号不能为空！");
			return false;
		} else {
			var $tou = $number.substring(0, 1);
			var $zhong = $number.substring(1, 2);
			var $hou = $number.substring(2, 10);
			if($tou!="H"){
				alert("批准文号格式不对！请严格按照国家药品编号来填写！\n【国药准字+1位大写字母+8位数字】");
				return false;
			}
			else if(!$zhong.match("^[A-Z]{1}$")){
				alert("批准文号格式不对！请严格按照国家药品编号来填写！\n【国药准字+1位大写字母+8位数字】");
				return false;
			}
			else if(!$hou.match("^[0-9]{8}$")){
				alert("批准文号格式不对！请严格按照国家药品编号来填写！\n【国药准字+1位大写字母+8位数字】");
				return false;
			}
			else if ($number.length != 10) {
				alert("批准文号格式不对！超过13位字符");
				return false;
			}	
		}
		
		var $name = $("#name").val();
		if ($name.length == 0) {
			alert("药品名字不能为空！");
			return false;
		} else if (!$name.match("^[\u4e00-\u9fa5a-zA-Z]{1,15}$")) {
			alert("药品名字格式不对！\n【请输入1-15位的中文或英文字符！】");
			return false;
		}
		
		var $protypename=$("#protypename").val();
		if($protypename == 0){
			alert("请选择药品品种！");
			return false;
		}
		
		var $guige = $("#guige").val();
		if ($guige.length == 0) {
			alert("规格不能为空！");
			return false;
		}else if  ($guige.length > 15) {
			alert("规格不能大于15个字符！");
			return false;
		}
		
		var $danwei = $("#danwei").val();
		if ($danwei.length == 0) {
			alert("单位不能为空！");
			return false;
		}else if  ($danwei.length > 3) {
			alert("单位不能大于3个字符！");
			return false;
		}
	}
</script>
</head>
<body class="ContentBody">
	<div id="title_bar">
		<span id="title">系统管理&gt;&gt;药品管理&gt;&gt;修改药品</span>
	</div>
	<div align="center">
		<s:form action="Medicine_Update" method="post" onsubmit="return clickForm(this)">
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
							class="tablestyle_title" style="text-align: center;"><b>修改药品信息</b></td>
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
																					<td><s:textfield name="medicine.id" type="hidden" />
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield 	name="medicine.number" label="批准文号"  value="%{medicine.number}"  id="number"/>
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="medicine.name" label="药品名称"  value="%{medicine.name}" id="name"/>
																					</td>
																				</tr>
																				<tr>
																				    <td>
																				    	<s:select  name="medicine.TMedicinetype.protypeid"  label="药品种类" 
																				    	 list="medicinetypes"  listKey="protypeid"  listValue="protypename"  value="%{medicine.TMedicinetype.protypeid}" id="protypename" >
																				    	</s:select>
																				    </td>
																				</tr>
																				<tr>
																					<td><s:textfield name="medicine.guige" label="规格"  value="%{medicine.guige}" id="guige"/>
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="medicine.danwei" label="单位"  value="%{medicine.danwei}" id="danwei"/>
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="medicine.othername" label="别名"  value="%{medicine.othername}" id="othername"/>
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="medicinetype.time" type="hidden" />
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
