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
    <title>Detailed information</title>
    <style>
      .tableformat table{border-right:1px solid #484891;
                         border-bottom:1px solid #484891;
                         border-collapse:collapse;
                         empty-cell:show;}  
      .tableformat table td{border-left:1px solid #484891;
                           border-top:1px solid #484891; padding-left:10px;} 
      .tableformat table th{border-left:1px solid #484891;
                          border-top:1px solid #484891; padding-left:10px;} 
    </style>
  </head>
  
  <body>
  <div style="margin:auto ;position:absolute; left:0; top:0; width:100%; height:100%">  
  <img src="<%=basePath%>image/015.jpg" width=100% height=100%></div>    
  <div style="position:absolute; left:20%;width:60%">
     <h2 style="text-align: center">Detailed Information</h2>
     <div style="margin:auto width:700px;" class=tableformat>
  	<table align="center" width="700" border="1" cellspacing="1" cellpadding="1">  
     <tr>
         <th align="center" colspan="2">Book Information</th>
     </tr>  
     <tr>
       <th>Attribute</th>
       <th>Description</th>
     </tr>  
     <tr>
       <td>ISBN</td>
       <td><s:property value="BookISBN"/></td>
     </tr>
     <tr>
       <td>Title</td>
       <td><s:property value="BookTitle"/></td>
     </tr>
     <tr>
       <td>Publisher</td>
       <td><s:property value="BookPublisher"/></td>
     </tr>
     <tr>
       <td>PublishDate</td>
       <td><s:property value="BookPublishDate"/></td>
     </tr>
     <tr>
       <td>Price</td>
       <td><s:property value="BookPrice"/></td>
     </tr>
     <tr>
         <th align="center" colspan="2">Author Information</th>
     </tr>
     <tr>
        <th>Attribute</th>
        <th>Description</th>
     </tr>
     <tr>
       <td>AuthorID</td>
       <td><s:property value="AuthorID"/></td>
     </tr>
     <tr>
       <td>Name</td>
       <td><s:property value="AuthorName"/></td>
     </tr>
     <tr>
       <td>Age</td>
       <td><s:property value="AuthorAge"/></td>
     </tr>
     <tr>
       <td>Country</td>
       <td><s:property value="AuthorCountry"/></td>
     </tr>
    </table>
    </div>
    <br>
    <div style="text-align:center">
       <a href="javascript:history.go(-1)">1.Return to the previous page</a><br><br>
       <a href="Menu.jsp">2.Back to menu</a>
    </div>
    </div>
  </body>
</html>
