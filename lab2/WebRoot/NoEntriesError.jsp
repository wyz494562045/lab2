<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Error</title>
  </head>
    
  <body>
  <div style="margin:auto ;position:absolute; left:0; top:0; width:100%; height:100%">  
  <img src="<%=basePath%>image/020.jpg" width=100% height=100%></div>    
  <div style="position:absolute; left:20%;width:60%">
  <br><br>
    <h2 style="text-align: center; color:#AE0000">Error! <br></h2>
    <h2 style="text-align: center">The item doesn't exist! <br></h2>
    <div style="text-align:center">
       <a href="javascript:history.go(-1)">1.Return to the previous page</a><br><br>
       <a href="Menu.jsp">2.Back to menu</a>
    </div>
    </div>
  </body>
</html>
