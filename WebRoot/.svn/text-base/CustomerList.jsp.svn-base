<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css"/>
  <script language="javascript">
   function deleteClients(parastuid)
     {
	var msg = "您确认要删除id为" + parastuid + "的客户吗?";
    var r =window.confirm(msg);
    if (r==true)
        {
         location.href="<%=request.getContextPath()%>/clientsModel/deleteAction?clients.clientId="+parastuid;
        }
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
				window.location.href="${pageContext.request.contextPath}/clientsModel/deleteAction2?ID="+param;
			}
		}
		
	}

  </script>
</head>
<body>
<div id="title_bar">
	<span id="title" > 客户管理&gt;&gt;客户列表</span>
    <ul id="operation">
    	<li><a href="#" class="like_btn" onclick="checkAll('id')">全选</a></li>
        <li><a href="#" class="like_btn" onclick="cancelCheck('id')"> 取消选择</a></li>
           <li><a href="#" class="like_btn" onclick="reverseCheck('id')">反选</a></li>
          <li><a href="#" class="like_btn" onclick="deleteChecked('id')"> &nbsp;删除&nbsp; </a></li>
    </ul>
</div>
<div>
<table width="100%" id="list_table" >
      <tr>
        <th width="5%"   >
          选择
        </th>
        <th width="4%"  >编号</th>
        <th width="7%"  >客户名</th>
        <th width="7%" >在职状况</th>
        <th width="7%" >产品需求</th>
	<th width="10%" >客户状态</th>
	    <th width="9%" >客户类型</th>
	<th width="8%" >跟进人</th>
        <th width="11%"  >手机</th>
        <th width="9%" >QQ</th>
        <th width="12%">来源渠道</th>
	<th width="10%" >基本操作</th>
      </tr>
      <s:iterator value="cliList" var="c">
      <tr>
        <td  >
          <input type="checkbox" name="id" value="<s:property value="clientId"/>" />
        
        </td>
        <td>  <s:property value="clientId"/></td>
        <td ><s:property value="#c.clientName"/></td>
        <td ><s:property value="clientJob"/></td>
        <td ><s:property value="product.productName"/></td>
		<td ><s:property value="clientState"/></td>
	    <td >
	    	<s:property value="clienttypes.ctypeName"/>
	    </td>
		<td ><s:property value="users.username"/></td>
        <td ><s:property value="clientPhone"/></td>
        <td ><s:property value="clientQq"/></td>
        <td ><s:property value="channels.channelName"/></td>
        <td><a href="javascript:deleteClients('<s:property value="clientId" />')">删除</a>|
      		<s:a href="toEditAction?clients.clientId=%{clientId }" >查看修改</s:a></td>
      </tr>
      </s:iterator>
</table>
</div>   
 
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
						<a href="${pageContext.request.contextPath}/clientsModel/toListAction.action?page=1">第一页</a>
						<a href="${pageContext.request.contextPath}/clientsModel/toListAction.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
					</s:else>
					<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
						<a
							href="${pageContext.request.contextPath}/clientsModel/toListAction.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
						<a
							href="${pageContext.request.contextPath}/clientsModel/toListAction.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
					</s:if>
					 <s:else>下一页 最后一页
              		</s:else>
  		</div>
</div>
<div>
  <p>&nbsp;</p>
</div>
<div id="search" align="left">
  <s:form name="form1" id="form1" method="post" action="/clientsModel/searchAction">
    <table width="100%" border="1" bordercolor="#006699" >
      <tr>
        <td colspan="3"><div align="center"><strong>按条件查询客户----
                  <input type="submit" name="Submit" value="搜索" />
                  <a href="${pageContext.request.contextPath }/clientsModel/toListAction">返回</a>
        </strong></div></td>
      </tr>
      <tr>
        <td>按客户状态：
            <select name="clients.clientState">
              <option  value="">===请选择===</option>
              <option value="未报名">未报名</option>
              <option value="已报名">已报名</option>
              <option value="已毕业">已毕业</option>
              <option value="已就业">已就业</option>
          </select></td>
        <td width="33%">按照跟进人：
            <select name="clients.users.userId">
            <option  value="">===请选择===</option>
            <c:forEach items="${userlist}" var="u">
            	<option value="${u.userId}">${u.username}</option>
            </c:forEach>
          </select></td>
        <td width="34%">按产品需求：
            <select name="clients.product.productId">
            <option  value="">===请选择===</option>
        	 <c:forEach items="${prolist}" var="p">
         		 	<option value="${p.productId}">${p.productName}</option>
         	</c:forEach>
          </select></td>
      </tr>
      <tr>
        <td>按客户类型：
            <select name="clients.clienttypes.ctypeId">
            	<option  value="">===请选择===</option>
            	 <c:forEach items="${clitypelist}" var="c">
         		 	<option value="${c.ctypeId}">${c.ctypeName}</option>
         		</c:forEach>
          </select></td>
        <td>按来源渠道：
            <select name="clients.channels.channelId">
            	<option  value="">===请选择===</option>
            	<c:forEach items="${chalist}" var="ch">
            		<option value="${ch.channelId }">${ch.channelName }</option>
            	</c:forEach>
          </select></td>
        <td>按职业状况：
            <select name="clients.clientJob">
           	  <option  value="">===请选择===</option>
              <option value="在职">在职</option>
              <option value="学生">学生</option>
              <option value="待业">待业</option>
          </select></td>
      </tr>
      <tr>

                  <td width="33%">按客户名称：
            <input type="text" name="clients.clientName" /></td>
        <td>按毕业学校：
			<input type="text" name="clients.clientSchool" />
		</td>
        <td>按最高学历：
          <input type="text" name="clients.clientEducate" /></td>
      </tr>
    </table>
  </s:form>
</div>
</body>
</html>
