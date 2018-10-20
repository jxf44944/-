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
	<s:if test='type=="in"'>
	<span id="title" > 系统管理&gt;&gt;入库管理&gt;&gt;修改入库单</span>
	</s:if>
	<s:elseif test='type=="out"'>
	<span id="title" > 系统管理&gt;&gt;出库管理&gt;&gt;修改出库单</span>
	</s:elseif>
	<div align="center">
		<s:form action="Allorder_Update" method="post">
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
							class="tablestyle_title" style="text-align: center;">修改药品</td>
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
																					<td><s:textfield 	name="medicine.number" label="批号"  value="%{medicine.number}"  />
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="medicine.name" label="药品名称"  value="%{medicine.name}"/>
																					</td>
																				</tr>
																				<tr>
																				    <td>
																				    	<s:select  name="medicine.TMedicinetype.protypeid"  label="药品种类" 
																				    	 list="medicinetypes"  listKey="protypeid"  listValue="protypename"  value="%{medicine.TMedicinetype.protypeid}"  >
																				    	</s:select>
																				    </td>
																				</tr>
																				<tr>
																					<td><s:textfield name="medicine.danwei" label="单位"  value="%{medicine.danwei}" />
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="medicine.guige" label="规格"  value="%{medicine.guige}" />
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield name="medicine.othername" label="别名"  value="%{medicine.othername}" />
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
