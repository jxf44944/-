<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script language="javascript">
   function deleteProducter(paraproid)
     {
	var msg = "您确认要删除该供应商吗?";
    var r =window.confirm(msg);
    if (r==true)
        {
         location.href="<%=request.getContextPath()%>/Producter_Del?producter.id="+paraproid;
        }
      }
   function getProducter(paraproid)
     {
         location.href="<%=request.getContextPath()%>/ProductertoUpdate?producter.id="+paraproid;
      }
   function SearchProducter()
     {
     	 var hpvalue =document.getElementById('searchtype').value;
         location.href="<%=request.getContextPath()%>/Producter_Search?hpvalue="+hpvalue;
     } 
	/*全选*/
	function checkAll(checkboxName){
		var objs = document.getElementsByName(checkboxName);
		for(i=0;i<objs.length;i++){
			 if(objs[i].type.toLowerCase() == "checkbox" ){
			 	objs[i].checked = true;
			 }
		}
	}
	
	/*取消选择*/
	function cancelCheck(checkboxName){
		var objs = document.getElementsByName(checkboxName);
		for(i=0;i<objs.length;i++){
			 if(objs[i].type.toLowerCase() == "checkbox" ){
			 	objs[i].checked = false;
			 }
		}
	}
	
	/*反选*/
	function reverseCheck(checkboxName){
		var objs = document.getElementsByName(checkboxName);
		for(i=0;i<objs.length;i++){
			 if(objs[i].type.toLowerCase() == "checkbox" ){
			 	if(objs[i].checked){
					objs[i].checked= false;
				}else{
					objs[i].checked = true;	
				}
			 }
		}
	}
	
	/*删除所选项*/
	function deleteChecked(checkboxName){
		var objs = document.getElementsByName(checkboxName);
		
		var param = '';
		for(i=0;i<objs.length;i++){
			 if(objs[i].type.toLowerCase() == "checkbox" ){
			 	if(objs[i].checked){
					param += (objs[i].value+',');
				}
			 }
		}
		
		if(param.length >0){
			var bool = window.confirm('您确定删除所选的项吗？');
			if(bool){
				//这里提交到删除的地方
				window.location.href="${pageContext.request.contextPath}/Producter_DelMore?ID="+param;
			}
		}
		
	}
  </script>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>

<body>
<div id="title_bar">
	<span id="title" > 系统管理&gt;&gt;供应商查询统计</span>
</div>

<table align="center">
<tr><td>请输入供应商名字：<input id="searchtype" /></td>
<td><a href="javascript:SearchProducter()"/>搜索</td></tr>
</table>

<table id="list_table" >
      <tr>
        <th width="15%" >供应商名称</th>
        <th width="16%" >电话</th>
        <th width="15%"  >邮政编号</th>
        <th width="27%">地址</th>
        <th width="14%"  >更新时间</th>
      </tr>
      <s:iterator value="ProducterList">
      <tr>
     	<td><input type="checkbox" name="id" value="<s:property value="id"/>" /></td>
        <td ><s:property value="name" /></td>
        <td ><s:property value="phone" /></td>
        <td ><s:property value="code" /></td>
        <td ><s:property value="adress" /></td>
        <td ><s:property value="time" /></td>

      </tr>
      </s:iterator>
    </table>
    
<div id="page_bar">
	
		<div id="page">
			共 <s:property value="pageBean.allRow" /> 条记录  共
					<s:property value="pageBean.totalPage" /> 页 当前第 <s:property
						value="pageBean.currentPage" /> 页 
			</div>
			<div id="tool">
					 <s:if
						test="%{pageBean.currentPage == 1}">第一页 上一页</s:if> 
					<s:else>
						<a href="${pageContext.request.contextPath}/ProducterList?page=1">第一页</a>
						<a href="${pageContext.request.contextPath}/ProducterList?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
					</s:else>
					<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
						<a
							href="${pageContext.request.contextPath}/ProducterList?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
						<a
							href="${pageContext.request.contextPath}/ProducterList?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
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
