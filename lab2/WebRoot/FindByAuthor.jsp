<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%      
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1      
response.setHeader("Pragma","no-cache"); //HTTP 1.0      
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server      
%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" >
    <title>Index book by author name</title>
  </head>
  
 <body>
 <center>
 <div style="margin:auto ;position:absolute; left:0; top:0; width:100%; height:100%">  
  <img src="<%=basePath%>image/017.jpg" width=100% height=100%></div>    
  <div style="position:absolute; left:20%;width:60%">
       <br><br>
       <h2 style="text-align: center">Book Index</h2>
       <div align="center"style="margin:auto">
       <form action="searchbook" method="post">
           <br>
           Please input name of the author you want to index<br/><br/>
           <br>
           <input type="text" name="AuthorName" onfocus="this.value=''"/><br/><br/>
           <input type="submit" value="Confirm"/><br>	
       </form>
       </div>
       <div style="text-align:center">
       <a href="Menu.jsp">Back to menu</a>
    </div>
    </div>
    </center>
</body>
</html>
