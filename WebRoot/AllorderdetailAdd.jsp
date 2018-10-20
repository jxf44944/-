<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage="" isELIgnored="true"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	// TODO 2018-04-25添加这个获取全局访问路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="js/jquery-2.1.3.min.js"></script>
<script src="js/jquery.form.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>无标题文档</title>
<script language="javascript">
	//jquery
	jQuery(function($) {

		var priceArr = null;

		$("#medicineid")
				.change(
						function() {
							var checkValue = $("#medicineid").val(); //获取Select选择的Value
							$("#producterid").empty();
							$
									.ajax({
										type : "POST",// 指定是post还是get
										data : {
											"medicineid" : checkValue
										},//发送到服务器的数据
										url : "AllorderdetailHuo",//发送请求的地址
										dataType : "JSON",
										error : function(xmlHttpRequest, error) {//如果确定能正确运行,可不写
										},
										success : function(data) {
											priceArr = new Array();
											var sproducterNameArr = "<option value='-1'>---供应商报价---</option>";
											//初始化一个默认值
											priceArr[0] = 0;
											for (var i = 0; i < data.msg.length; i++) {
												console.log(data.msg[i]);
												priceArr[i + 1] = data.msg[i].price;
												sproducterNameArr += "<option value='"+data.msg[i].TProducter.id+"'>&nbsp;&nbsp;"
														+ data.msg[i].TProducter.name
														+ "→报价为"
														+ data.msg[i].price
														+ "元&nbsp;&nbsp;</option>"
											}
											$("#producterid").append(
													sproducterNameArr);
										}
									});
						});//$("#medicineid").change(function(){

		//供应商获取
		$("#producterid").change(function() {
			//var checkValue=$("#producterid").val();//获取Select选择的索引值
			var checkIndex = $("#producterid").get(0).selectedIndex; //获取Select选择的索引值
			//判断是否为0
			if (checkIndex == 0) {
				return;
			}
			if (priceArr != null && priceArr.length > 0) {
				$("#price").attr("value", priceArr[checkIndex]);// 填充内容
			} else {
				$("#price").attr("value", "");// 填充内容
			}
		});//$("#producterid").change(function(){

	});//jQuery(function($) {

	function setNumChange() {
		var num = document.getElementById("num").value;
		if (num == "" || num == null) {
			num = 0;
		}
		var price = document.getElementById("price").value;
		if (num != null && price != null)
			document.getElementById("sum").value = num * price;
	}//function setNumChange(){
</script>

<script language="javascript">
	//验证表单
	function clickForm(submitform) {
		var $medicineid = $("#medicineid").val();
		if ($medicineid == 0) {
			alert("请选择需要入库的药品!");
			return false;
		}

		var $price = $("#price").val();
		if ($price.length == 0) {
			alert("价格不能为空！");
			return false;
		}

		var $num = $("#num").val();
		if ($num.length == 0) {
			alert("数量不能为空！");
			return false;
		} else if (!$num.match("^([1]{1})\([0-9]{0,2})$")
				&& !$num.match("^([2]{1})\([0]{2})$")
				&& !$num.match("^([1-9]{1})\([0-9]{0,1})$")) {
			alert("数量的格式或规则不对！\n【请输入数量不大于200的数字】");
			return false;
		}

		var $sum = $("#sum").val();
		if ($sum.length == 0) {
			alert("总价不能为空！");
			return false;
		} else if (!$sum.match("^[0-9]{0,}$")) {
			alert("总价的格式不对！");
			return false;
		}
	}
</script>

</head>

<body>
	<s:if test='type=="in"'><div id="title_bar">
		<span id="title">系统管理&gt;&gt;入库管理&gt;&gt;添加入库单药品</span>
	</div></s:if>
	<s:elseif test='type=="out"'><div id="title_bar">	
	    <span id="title">系统管理&gt;&gt;出库管理&gt;&gt;添加出库单药品</span></div>
		</s:elseif>
	<div align="center">
		<s:form id="allorder-detail-add" action="AllordertoAdd" method="POST"
			onsubmit="return clickForm(this)">
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
					class="tablestyle_title" style="text-align: center;">
					<b>
					<s:if test='type=="in"'>添加入库单药品</s:if>
					<s:elseif test='type=="out"'>添加出库单药品</s:elseif>
					</b></td>
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
										<td colspan="5">以下带*为必填项：</td>
									</tr>
									<tr>
										<td align="center">
											
												<s:if test='type=="in"'>
												<s:select
														name="allorderdetail.TMedicine.id" label="*药品名"
														headerKey="0" list="medicines" listKey="id" listValue="name"
														headerValue="-- 请选择 --" id="medicineid"
														value="%{allorderdetail.TMedicine.id}">
												</s:select>	
												
												</s:if>
												
										
												 <s:elseif test='type=="out"'>
												<s:select
														name="allorderdetail.TMedicine.id" label="*药品名"
														headerKey="0" list="medicinefatory" listKey="id" listValue="medname"
														headerValue="-- 请选择 --" id="medicineid"
														value="${list.medname}">
												</s:select>	
												
											
											</s:elseif>							
										
										</td>
										
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td class="tdLabel"><label for="medicineid" class="label">*供应商:</label></td>
										<td id="p-tip"><select
											name="allorderdetail.TProducter.id" id="producterid"></select>
										</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td><s:textfield name="allorderdetail.price"
												label="*入库单价（元）" readonly="true" id="price" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td><s:textfield name="allorderdetail.num" label="*数量"
												onchange="setNumChange()" id="num"
												value="%{allorderdetail.num}" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td><s:textfield name="allorderdetail.sum" label="*总价格（元）"
												readonly="true" id="sum" value="%{allorderdetail.sum}" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<s:if test='type=="in"'>
										<s:submit align="center" value="添加" id="allorder_to_add" /></s:if>
										<s:elseif test='type=="out"'><s:submit align="center" value="添加" id="allorder_to_out" /></s:elseif>
										<s:reset align="center" value="重置" />
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</s:form>
	</div>
</body>
</html>
