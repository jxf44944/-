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
	<s:if test='allorder.ordertype=="1"||allorder.ordertype=="2"'>
	<span id="title" > 系统管理&gt;&gt;入库管理&gt;&gt;入库单详情（审核）</span>
	</s:if>
	<s:elseif test='allorder.ordertype=="3"||allorder.ordertype=="4"'>
	<span id="title" > 系统管理&gt;&gt;出库管理&gt;&gt;出库单详情（审核）</span>
	</s:elseif>
	</div>
	<div align="center">
		<s:form action="Allorder_Update"  method="post">
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
						<s:if test='allorder.ordertype=="1"||allorder.ordertype=="2"'>
							<td height="20" colspan="13" align="center" bgcolor="#EEEEEE"
								class="tablestyle_title" style="text-align: center;"><b>入库单详情信息</b></td>
						</s:if>
						<s:elseif test='allorder.ordertype=="3"||allorder.ordertype=="4"'>
							<td height="20" colspan="13" align="center" bgcolor="#EEEEEE"
								class="tablestyle_title" style="text-align: center;"><b>出库单详情信息</b></td>
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
																					<td><s:textfield name="allorder.id" type="hidden" />
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield 	name="allorder.ordercode" label="单号"  value="%{allorder.ordercode}"  readonly="true" />
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield 	name="allorder.sum" label="总计"  value="%{allorder.sum}"    readonly="true" />
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield 	name="allorder.paytype" label="结算方式"  value="%{allorder.paytype}"    readonly="true" />
																					</td>
																				</tr>
																				<tr>
																					<td><s:textfield 	 label="经办人"  value="%{allorder.TUser.name}"    readonly="true" />
																							<s:textfield 	name="allorder.TUser.id"   type="hidden"  value="%{allorder.TUser.id}"    readonly="true" />
																					</td>
																				</tr>
																				<tr>
																				<s:if test='allorder.ordertype=="3"'>
																					<td><s:textfield 	label="采购医院"  value="%{allorder.THospital.name}"    readonly="true" />
																							<s:textfield 	name="allorder.THospital.id"   type="hidden"  value="%{allorder.THospital.id}"    readonly="true" />
																					</td>
																				</s:if>
																				</tr>
																			    <tr>
																					<td><s:textfield 	name="allorder.time" label="创建时间"  value="%{allorder.time}"   readonly="true" />
																					</td>
																				</tr>
																				<tr>
																					<td>
																						<s:select  name="allorder.ordertype"  label="订单状态" 
																				    	 list="#{'1':'药库采购单','2':'医院退货单','3':'医院采购单','4':'药品清库单'}"  value="%{allorder.ordertype}"  disabled = "true" >
																				    	</s:select>
																				    	<s:textfield name="allorder.ordertype" type="hidden"  value="%{allorder.ordertype}" />
																				    </td>
																				</tr>
																				<tr>
																					<td><s:textarea 	name="allorder.orderreason"  label="订单描述"  value="%{allorder.orderreason}" cols="20" rows="3"   readonly="true" />
																					</td>
																				</tr>
																				<table id="list_table" >
																						<tr>
																				        <th>药品</th>
																				        <th>供应商</th>
																				        <th>单价</th>
																				        <th>数量</th>
																				        <th>总价</th>
																				        </tr>
																				         <s:iterator value="allorderdetails">
																				        <tr>
																				     	<td ><s:property value="TMedicine.name" /></td>
																				        <td ><s:property value="TProducter.name" /></td>
																				        <td ><s:property value="price" /></td>
																				        <td ><s:property value="num" /></td>
																				        <td ><s:property value="sum" /></td>
																				        </tr>
																				        </s:iterator>
																				</table>
																				<tr>
																				    <td>
																				    <s:if test='allorder.status=="审核通过"'>
																				    	<s:select  name="allorder.status"  label="订单状态" 
																				    	 list="#{'未审核':'未审核','审核通过':'审核通过','审核不通过':'审核不通过'}"  value="%{allorder.status}"  disabled = "true" >
																				    	</s:select>
																				   </s:if>
																				   <s:else>
																				   		<s:select  name="allorder.status"  label="订单状态" 
																				    	 list="#{'未审核':'未审核','审核通过':'审核通过','审核不通过':'审核不通过'}"  value="%{allorder.status}"  >
																				    	</s:select>
																				   </s:else>
																				    </td>
																				</tr>
																			</table> <br />
																		</td>
																	</tr>
																				<s:if test='allorder.status!="审核通过"'>
																						<s:submit align="center" value="提交" />
																					</s:if>
																					<s:reset align="center" value="重置" />
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

						</td>
					</tr>
				</table>
			</div>
		</s:form>
	</div>
</body>
</html>
