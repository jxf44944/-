<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body class="ContentBody">
	<div id="title_bar">
		<s:if test='type=="fatory"'>
			<span id="title">系统管理&gt;&gt;库存管理&gt;&gt;修改库存药品别名</span>
		</s:if>
		<s:elseif test='type=="price"'>
			<span id="title">系统管理&gt;&gt;库存管理&gt;&gt;修改库存药品售价</span>
		</s:elseif>
	</div>
	<div align="center">
		<s:form action="MedicineFatory_Update" method="post">
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
							<s:if test='type=="fatory"'>
								<td height="20" colspan="13" align="center" bgcolor="#EEEEEE"
								class="tablestyle_title" style="text-align: center;"><b>修改库存药品别名</b></td>
							</s:if>
							<s:elseif test='type=="price"'>
								<td height="20" colspan="13" align="center" bgcolor="#EEEEEE"
								class="tablestyle_title" style="text-align: center;"><b>修改库存药品售价</b></td>
							</s:elseif>
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
																					<td><s:textfield name="medicinefatory.id" type="hidden" />
																					</td>
																				</tr>
																				<tr>
																					<s:if test='type=="fatory"'>
																					<td><s:textfield 	name="medicinefatory.medname"  label="药品名称"  value="%{medicinefatory.medname}" />
																					</td>
																					</s:if>
																					<s:elseif test='type=="price"'>
																					<td><s:textfield 	name="medicinefatory.medname" label="药品名称"  value="%{medicinefatory.medname}"   readonly="true"/>
																					</td>
																					</s:elseif>
																				</tr>
																				<tr>
																					<td><s:textfield name="medicinefatory.TProducter.name" label="供应商"  value="%{medicinefatory.TProducter.name}"  readonly="true"/>
																					</td>
																				</tr>
																				<s:if test='type=="price"'>
																				<tr>
																					<td><s:textfield name="medicinefatory.comeprice" label="入货价（元）"  value="%{medicinefatory.comeprice}"  readonly="true"/>
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="medicinefatory.sellpricenow" label="现售价（元）" />
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="medicinefatory.sellpricebef" label="原售价（元）"  value="%{medicinefatory.sellpricenow}"  readonly="true"/>
																					</td>
																				</tr>
																				</s:if>
																				<s:hidden name="medicinefatory.TProducter.id"  value="%{medicinefatory.TProducter.id}"  />
																			    <s:hidden name="medicinefatory.TMedicine.id"  value="%{medicinefatory.TMedicine.id}"  />
																			    <s:hidden name="medicinefatory.producttime"  value="%{medicinefatory.producttime}"  />
																			    <s:hidden name="medicinefatory.valuetime"  value="%{medicinefatory.valuetime}"  />
																			    <s:hidden name="medicinefatory.shengyuliang"  value="%{medicinefatory.shengyuliang}"  />
																			    <s:hidden name="medicinefatory.jinhuoliang"  value="%{medicinefatory.jinhuoliang}"  />
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
