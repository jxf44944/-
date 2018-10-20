<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="js/jquery-2.1.3.min.js"></script>
<title>无标题文档</title>
<script language="javascript">
   function deleteMedicinefatory(paraproid)
     {
	var msg = "您确认要删除该库存药品吗?";
    var r =window.confirm(msg);
    if (r==true)
        {
         location.href="<%=request.getContextPath()%>/MedicineFatory_Del?medicinefatory.id="+paraproid;
        }
      }
   function getMedicinefatory(paraproid)
     {
         location.href="<%=request.getContextPath()%>/MedicineFatorytoUpdate?medicinefatory.id="+paraproid;
      }
   function SearchMedicineFatory()
     {
     	 var hpvalue =document.getElementById('searchtype').value;
         location.href="<%=request.getContextPath()%>/MedicineFatory_Search?hpvalue="+ hpvalue;
	}

	/*全选*/
	function checkAll(checkboxName) {
		var objs = document.getElementsByName(checkboxName);
		for (i = 0; i < objs.length; i++) {
			if (objs[i].type.toLowerCase() == "checkbox") {
				objs[i].checked = true;
			}
		}
	}

	/*取消选择*/
	function cancelCheck(checkboxName) {
		var objs = document.getElementsByName(checkboxName);
		for (i = 0; i < objs.length; i++) {
			if (objs[i].type.toLowerCase() == "checkbox") {
				objs[i].checked = false;
			}
		}
	}

	/*反选*/
	function reverseCheck(checkboxName) {
		var objs = document.getElementsByName(checkboxName);
		for (i = 0; i < objs.length; i++) {
			if (objs[i].type.toLowerCase() == "checkbox") {
				if (objs[i].checked) {
					objs[i].checked = false;
				} else {
					objs[i].checked = true;
				}
			}
		}
	}

	/*删除所选项*/
	function deleteChecked(checkboxName) {
		var objs = document.getElementsByName(checkboxName);

		var param = '';
		for (i = 0; i < objs.length; i++) {
			if (objs[i].type.toLowerCase() == "checkbox") {
				if (objs[i].checked) {
					param += (objs[i].value + ',');
				}
			}
		}

		if (param.length > 0) {
			var bool = window.confirm('您确定删除所选的项吗？');
			if (bool) {
				//这里提交到删除的地方
				window.location.href = "${pageContext.request.contextPath}/MedicineFatory_DelMore?ID="
						+ param;
			}
		}

	}
	
	// 库存报警
	window.onload = function yanzhengsyl() {
		var len = ($("#list_table").find("tr").length - 1);
		var input_no = $("#list_table").find("input[type=hidden]");
		var tr_no = $("#list_table").find("tr");
		var number_min = 0;
		var number_max = 0;
		for (var i = 0; i < len; i++){
			var sylid = "sylid" + i;
			var trid = "trid" + i;
			var temp_input_id = "#" + sylid;
			var temp_tr_id = "#" + trid;
			input_no[i].id = sylid;
			tr_no[i + 1].id = trid;
			if ($(temp_input_id).val() < 30) {
				$(temp_tr_id).find("td").css("font-weight", "bold").css("color", "#FF0000").css("font-size", "13px");
				number_min = number_min+1;
			}
			if ($(temp_input_id).val() > 100) {
				$(temp_tr_id).find("td").css("font-weight", "bold").css("color", "#00AA00").css("font-size", "13px");
				number_max = number_max+1;
			}
		}
		var str = "-------------------------库存报警-----------------------------";
		if(number_min!=0){
			str=str+"\n\n（红标）当前有【"+number_min+"】条药品库存量紧张，建议及时采购！";
		}
		if(number_max!=0){
			str=str+"\n\n（绿标）当前有【"+number_max+"】条药品库存积压过多，建议及时清理！";
		}
// 		alert(str.length);
		if(str.length>58){
			alert(str);
		}
	}
</script>
<link rel="stylesheet" type="text/css" href="css/main.css" />
</head>

<body>
	<div id="title_bar">
		<s:if test='type=="fatory"'>
			<span id="title"> 系统管理&gt;&gt;库存管理</span>
		</s:if>
		<s:elseif test='type=="price"'>
			<span id="title"> 系统管理&gt;&gt;售价管理</span>
		</s:elseif>
		<ul id="operation">
			<li><a href="#" class="like_btn" onclick="checkAll('id')">全选</a></li>
			<li><a href="#" class="like_btn" onclick="cancelCheck('id')">
					取消选择</a></li>
			<li><a href="#" class="like_btn" onclick="reverseCheck('id')">反选</a></li>
			<li><a href="#" class="like_btn" onclick="deleteChecked('id')">
					&nbsp;删除&nbsp; </a></li>
			<!--<li><img src="images/add.gif" width="10" height="10"  /><a href="${pageContext.request.contextPath }/MedicineFatorytoAdd"> 添加</a></li>
    -->
		</ul>
	</div>

	<table align="left">
			<tr>
				<td>请输入药品名字：<input id="searchtype" /></td>
				<td><a href="javascript:SearchMedicineFatory()" />搜索</td>
			</tr>
		</table>
		
	<table id="list_table">
		<tr>
			<th width="4%">选择</th>
			<s:if test='type=="fatory"'>
				<th width="6%">库存量</th>
			</s:if>
			<th width="15%">药品名称</th>
			<th width="13%">供应商</th>
			<th width="6.5%">入货价（元）</th>
			<th width="6.5%">现售价（元）</th>
			<th width="6.5%">原售价（元）</th>
			<s:if test='type=="fatory"'>
				<th width="8%">生产日期</th>
				<th width="8%">有效期</th>
			</s:if>
			<th width="15%">入库时间</th>
			<th width="10%">基本操作</th>
		</tr>
		<s:iterator value="medicinefatoryList" status="st">
			<tr>
				<td><input type="checkbox" name="id"
					value="<s:property value="id"/>" /></td>
				<s:if test='type=="fatory"'>
					<td><input type="hidden"
						value="<s:property value="shengyuliang" />" /> <s:property
							value="shengyuliang" /></td>
				</s:if>
				<td><s:property value="medname" /></td>
				<td><s:property value="TProducter.name" /></td>
				<td><s:property value="comeprice" /></td>
				<td><s:property value="sellpricenow" /></td>
				<td><s:property value="sellpricebef" /></td>
				<s:if test='type=="fatory"'>
					<td><s:property value="producttime" /></td>
					<td><s:property value="valuetime" /></td>
				</s:if>
				<td><s:property value="updatetime" /></td>
				<td><s:if test='type=="fatory"'>
						<a
							href="javascript:getMedicinefatory('<s:property value="id" />')">修改别名</a>|
          <a
							href="javascript:deleteMedicinefatory('<s:property value="id" />')">删除</a>
					</s:if> <s:elseif test='type=="price"'>
						<a
							href="javascript:getMedicinefatory('<s:property value="id" />')">修改售价</a>
					</s:elseif></td>
			</tr>
		</s:iterator>
	</table>

	<div id="page_bar">

		<div id="page">
			共
			<s:property value="pageBean.allRow" />
			条记录 共
			<s:property value="pageBean.totalPage" />
			页 当前第
			<s:property value="pageBean.currentPage" />
			页
		</div>
		<div id="tool">
			<s:if test="%{pageBean.currentPage == 1}">第一页 上一页</s:if>
			<s:else>
				<a
					href="${pageContext.request.contextPath}/MedicineFatoryList?page=1">第一页</a>
				<a
					href="${pageContext.request.contextPath}/MedicineFatoryList?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
			</s:else>
			<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
				<a
					href="${pageContext.request.contextPath}/MedicineFatoryList?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
				<a
					href="${pageContext.request.contextPath}/MedicineFatoryList?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
			</s:if>
			<s:else>下一页 最后一页
              		</s:else>
		</div>
	</div>
	<div>
		<p>&nbsp;</p>
	</div>

</body>
</html>
