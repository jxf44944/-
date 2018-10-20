<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script language="javascript">
   function deleteAllorder(paraproid,type)
     {
     var msg ;
     if(type=="in")
		 msg= "您确认要删除该入库单吗?";
	else
		msg = "您确认要删除该出库单吗?";
    var r =window.confirm(msg);
    if (r==true)
        {
         location.href="<%=request.getContextPath()%>/Allorder_Del?allorder.id="+paraproid;
        }
      }
   function getAllorder(paraproid)
     {
         location.href="<%=request.getContextPath()%>/AllordertoUpdate?allorder.id="+paraproid;
      }
      
   function Allorderdetail(paraproid)
     {
         location.href="<%=request.getContextPath()%>/Allorderdetail?allorder.id="+paraproid;
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
				window.location.href="${pageContext.request.contextPath}/Allorder_DelMore?ID="+param;
			}
		}
		
	}
  </script>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>

<body>
<div id="title_bar">
	<s:if test='type=="in"'>
	<span id="title" > 系统管理&gt;&gt;入库管理</span>
	</s:if>
	<s:elseif test='type=="out"'>
	<span id="title" > 系统管理&gt;&gt;出库管理</span>
	</s:elseif>
    <ul id="operation">
    	<li><a href="#" class="like_btn" onclick="checkAll('id')">全选</a></li>
        <li><a href="#" class="like_btn" onclick="cancelCheck('id')"> 取消选择</a></li>
        <li><a href="#" class="like_btn" onclick="reverseCheck('id')">反选</a></li>
        <li><a href="#" class="like_btn" onclick="deleteChecked('id')"> &nbsp;删除&nbsp; </a></li>
        <s:if test='type=="in"'>
        <li><img src="images/add.gif" width="10" height="10"  /><a href="${pageContext.request.contextPath }/Allorderdetailadd"> 添加入库单</a></li>
		</s:if>
		<s:elseif test='type=="out"'>
		<li><img src="images/add.gif" width="10" height="10"  /><a href="${pageContext.request.contextPath }/AllordertoAddOut"> 添加出库单</a></li>
		</s:elseif>
    </ul>
</div>


<table id="list_table" >
      <tr>
        <th width="4%"   >选择</th>
        <th width="14%"   >单号</th>
        <th width="10%" >总价</th>
        <th width="10%"   >结算方式</th>
        <th width="10%"   >状态</th>
        <th width="10%"   >经办人</th>
        <th width="12%"   >创建时间</th>
       	<s:if test='type=="in"'>
		<th width="10%"  >入库类型</th>
		</s:if>
		<s:elseif test='type=="out"'>
        <th width="10%"  >出库类型</th>
        </s:elseif>
        <th width="16%" >基本操作</th>
      </tr>
      <s:iterator value="allorderList">
      <tr>
     	<td><input type="checkbox" name="id" value="<s:property value="id"/>" /></td>
     	<td ><s:property value="ordercode" /></td>
        <td ><s:property value="sum" /></td>
        <td ><s:property value="paytype" /></td>
        <td ><s:property value="status" /></td>
        <td ><s:property value="TUser.name" /></td>
        <td ><s:property value="time" /></td>
        <s:if test='ordertype==1'>
        	<td >药库采购单</td>
        </s:if>
        <s:if test='ordertype==2'>
       		<td >医院退货单</td>
        </s:if>
        <s:if test='ordertype==3'>
       		<td >医院采购单</td>
        </s:if>
        <s:if test='ordertype==4'>
       		<td >药品清库单</td>
        </s:if>
        <s:if test='status=="未审核"'>
        	<td>
       		 	<a href="javascript:Allorderdetail('<s:property value="id" />')">详情(审核)</a>|
	        	<a href="javascript:getAllorder('<s:property value="id" />')">修改</a>|
	         	<a href="javascript:deleteAllorder('<s:property value="id" />','<s:property value="type" />')">删除</a>
         	 </td> 
         </s:if>
         <s:else>
        	<td>
        		 <a href="javascript:Allorderdetail('<s:property value="id" />')">详情</a>|
          		<a href="javascript:deleteAllorder('<s:property value="id" />','<s:property value="type" />')">删除</a>
          	</td> 
         </s:else>
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
						<a href="${pageContext.request.contextPath}/AllorderList?page=1">第一页</a>
						<a href="${pageContext.request.contextPath}/AllorderList?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
					</s:else>
					<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
						<a
							href="${pageContext.request.contextPath}/AllorderList?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
						<a
							href="${pageContext.request.contextPath}/AllorderList?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
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
