<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" >
    <title>Update Author</title>
    <style>
      .tableformat table{border-right:1px solid #484891;
                         border-bottom:1px solid #484891} 
      .tableformat table td{border-left:1px solid #484891;
                           border-top:1px solid #484891; padding-left:10px;} 
      .tableformat table th{border-left:1px solid #484891;
                          border-top:1px solid #484891; padding-left:10px;} 
    </style>
  </head>
  <body>
  <div style="margin:auto ;position:absolute; left:0; top:0; width:100%; height:100%">  
  <img src="<%=basePath%>image/017.jpg" width=100% height=100%></div>    
  <div style="position:absolute;left:20%;width:60%">
    <h2 style="text-align: center">Please input the information of the author to be modified<br></h2>
    <h4 style="text-align: center">(Items that don't need to be modified can be blank)<br></h4>
    <form action="updateauthor" method="post">
  	<div align="center" style="margin:auto ;text-align:center" class=tableformat>
  	<table align="center" width="500" border="1" cellspacing="1" cellpadding="1">   
     <tr>
       <th align="center" colspan="2">Author Information</th>
     </tr>  
     <tr>
       <th>Attribute</th>
       <th>Description</th>
     </tr>  
     <tr>
     <td><s:hidden name="AuthorID" value="%{AuthorID}"/></td>
     </tr>
     <tr>
       <td>Name</td>
       <td><input style="width:250px" type="text" name="AuthorName"/></td>
     </tr>
     <tr>
       <td>Age</td>
       <td><input style="width:250px" type="text" name="AuthorAge"/></td>
     </tr>
     <tr>
       <td>Country</td>
       <td><input style="width:250px" type="text" name="AuthorCountry"/></td>
     </tr>
     
   </table>
   </div>
   <br>
   <span style="display:block;  text-align:center"><input type="submit" value="Confirm"  />
   </span>
   </form>
   <div style="text-align:center">
       <a href="javascript:history.go(-1)">1.Return to the previous page</a><br><br>
       <a href="Menu.jsp">2.Back to menu</a>
    </div>
    </div>
  </body>
</html>