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
<s:if test='type=="pro"'>
	<span id="title" > 系统管理&gt;&gt;供应商管理</span>
	</s:if>
	<s:elseif test='type=="proo"'>
			<span id="title"> 系统管理&gt;&gt;供应商查询统计</span>
		</s:elseif>
    <s:if test='type=="pro"'><ul id="operation">
    	<li><a href="#" class="like_btn" onclick="checkAll('id')">全选</a></li>
        <li><a href="#" class="like_btn" onclick="cancelCheck('id')"> 取消选择</a></li>
        <li><a href="#" class="like_btn" onclick="reverseCheck('id')">反选</a></li>
        <li><a href="#" class="like_btn" onclick="deleteChecked('id')"> &nbsp;删除&nbsp; </a></li>
        <li><img src="images/add.gif" width="10" height="10"  /><a href="${pageContext.request.contextPath }/ProductertoAdd"> 添加</a></li>
    </ul></s:if>
</div>

<s:if test='type=="pro"'><table align="left">
<tr><td>请输入供应商名字：<input id="searchtype" /></td>
<td><a href="javascript:SearchProducter()"/>搜索</td></tr>
</table></s:if>

<s:elseif test='type=="proo"'><table align="center">
<tr><td>请输入供应商名字：<input id="searchtype" /></td>
<td><s:submit align="center" value="查询" onclick="javascript:SearchProducter()"/></td></tr>
</table></s:elseif>

<table id="list_table" >
      <tr>
        <s:if test='type=="pro"'><th width="4%"   >选择</th></s:if>
        <th width="15%" >供应商名称</th>
        <th width="16%" >电话</th>
        <th width="15%"  >邮政编号</th>
        <th width="27%">地址</th>
        <th width="14%"  >更新时间</th>
        <s:if test='type=="pro"'><th width="14%" >基本操作</th></s:if>
      </tr>
      <s:iterator value="ProducterList">
      <tr>
     	<s:if test='type=="pro"'><td><input type="checkbox" name="id" value="<s:property value="id"/>" /></td></s:if>
        <td ><s:property value="name" /></td>
        <td ><s:property value="phone" /></td>
        <td ><s:property value="code" /></td>
        <td ><s:property value="adress" /></td>
        <td ><s:property value="time" /></td>
        <s:if test='type=="pro"'><td><a href="javascript:getProducter('<s:property value="id" />')">修改</a>|
          <a href="javascript:deleteProducter('<s:property value="id" />')">删除</a></td> </s:if>
      </tr>
      </s:iterator>
    </table>
    
   	<s:elseif test='type=="proo"'> <div align="center"><b>统计:&nbsp;<div style="color: red;display: inline;font-size: 30px"><s:property value="pageBean.allRow" /></div>&nbsp;条供应商记录</b></div></s:elseif>	 
   	
<div id="page_bar">
	
	<s:if test='type=="pro"'>	<div id="page">
			共 <s:property value="pageBean.allRow" /> 条记录  共
					<s:property value="pageBean.totalPage" /> 页 当前第 <s:property
						value="pageBean.currentPage" /> 页 
			</div> </s:if>
			
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
