<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/main.css"/>
<script src="js/jquery-2.1.3.min.js"></script>
<title>无标题文档</title>
<script language="javascript">
	//验证表单
	function clickForm(submitform) {
		var $protypename = $("#protypename").val();
		if ($protypename.length == 0) {
			alert("品种名称不能为空！");
			return false;
		} else if (!$protypename.match("^[\u4e00-\u9fa5a-zA-Z]{1,10}$")) {
			alert("品种名称格式不对！\n【请输入1-10位的中文或英文字符！】");
			return false;
		}
	}
</script>
</head>

<body>
<div id="title_bar">
	<span id="title" >系统管理&gt;&gt;品种管理&gt;&gt;添加品种</span>
</div>
<div align="center">
	<s:form action="Medicinetype_Add" method="post" onsubmit="return clickForm(this)">
			<tr>
				<td bgcolor="#A0A0A0"></td>
			</tr>
			<tr>
				<td height="40" class="font42">
					<table width="600px" border="0" align="center" cellpadding="4"
						cellspacing="1" bgcolor="#DDD" class="newfont03" id="tblist" /></td>
			</tr>
			<tr>
				<td height="20" colspan="13" align="center" bgcolor="#EEEEEE"
					class="tablestyle_title" style="text-align: center;"><b>添加品种信息</b></td>
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
										<td><s:textfield name="medicinetype.protypename" label="*品种名称" id="protypename"/>
										</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td><s:textfield name="medicinetype.remark" label="备注说明" id="remark"/>
										</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<s:submit align="center" value="添加" />
										<s:reset align="center" value="重置" />
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</s:form>
</div>
</body>
</html>
