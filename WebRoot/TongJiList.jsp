<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-2.0.3.js" ></script>
<title>无标题文档</title>
<script language="javascript">
 // function TongJiMedicine() {
    	// alert("testea-------15");
     	// var medicineid =document.getElementById('medicineid').value;
     	// var producterid =document.getElementById('producterid').value;
     	// var medicinetypeid =document.getElementById('medicinetypeid').value;
     	// var medicinetime =document.getElementById('medicinetime').value;
     	// alert("testea-------16");
        // location.href="<%=request.getContextPath()%>/TongJi_Search?medicineid="+medicineid+"&producterid"+producterid+"&medicinetypeid"+medicinetypeid+"&medicinetime"+medicinetime;
     //}   
 
 window.onload = function () {
		var len = ($("#list_table").find("tr").length - 1);
		$("#find-result").html(len);
 }
  </script>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>

<body>
<div id="title_bar">
	<span id="title" > 系统管理&gt;&gt;查询统计</span>
</div>
<s:form action="TongJi_Search" method="post">
<table align="center">
<tr>
<td><s:select name="tongji.medicineid"  label="药品名"   headerKey=""
		list="medicines"  listKey="id"  listValue="name" headerValue="-- 请选择 --"  value="%{tongji.medicineid}"></s:select></td>
<td>	<s:select name="tongji.producterid"  label="供应商"   headerKey=""
		list="producters"  listKey="id"  listValue="name" headerValue="-- 请选择 --"  value="%{tongji.producterid}"></s:select></td>
<td>	<s:select name="tongji.medicinetypeid"  label="药品品种"   headerKey=""
		list="medicinetypes"  listKey="protypeid"  listValue="protypename"  headerValue="-- 请选择 --"  value="%{tongji.medicinetypeid}">
		</s:select></td>
<td><s:textfield name="tongji.medicinetime" label="录入时间"   onclick="laydate()"  value="%{tongji.medicinetime}" /></td>
<td><s:submit align="center" value="查询" /></td></tr>
</table>
</s:form>
<table id="list_table" >
      <tr>     
        <th width="10%"   >批号</th>
        <th width="12%" >药品名称</th>
        <th width="10%"   >种类</th>
        <th width="8%"   >规格</th>
        <th width="8%"   >单位</th>
        <th width="12%"   >药品别名</th>
        <th width="14%"  >更新时间</th>
      </tr>
      <s:iterator value="MedicineList">
      <tr>
     	<td ><s:property value="number" /></td>
        <td ><s:property value="name" /></td>
        <td ><s:property value="TMedicinetype.protypename" /></td>
        <td ><s:property value="guige" /></td>
        <td ><s:property value="danwei" /></td>
        <td ><s:property value="othername" /></td>
        <td ><s:property value="time" /></td>
      </tr>
      </s:iterator>
    </table>

    <div align="center"><b>统计:&nbsp;<div id="find-result" style="color: red;display: inline;font-size: 30px"></div>&nbsp;条药品记录</b></div>
    
<!--<div id="page_bar">
		<div id="page">
			共 <s:property value="allRow" /> 条记录  
  		</div>
</div>
--><div>
  <p>&nbsp;</p>
</div>
</body>
</html>
