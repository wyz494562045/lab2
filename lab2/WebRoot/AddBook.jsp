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
    <title>Add Book</title>
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
    <img src="<%=basePath%>image/015.jpg" width=100% height=100%></div>    
    <div style="position:absolute;left:20%;width:60%">
    <h2 align="center" style="text-align: center">Please input the information of the book to be added<br></h2>
    <h4 align="center"style="text-align: center">(If the author has been recorded,his personal information won't be affected,<br>you can change it by operation upload author.)<br></h4>
    <form action="addbook" method="post">
     <div align="center" style="margin:auto ;text-align:center" class=tableformat>
  	<table align="center" width="500" border="1" cellspacing="1" cellpadding="1">  
     <tr>
       <th align="center" colspan="2">Book Information</th>
     </tr>  
     <tr>
       <th>Attribute</th>
       <th>Description</th>
     </tr>  
     <tr>
       <td>ISBN</td>
       <td><input style="width:250px" type="text" name="BookISBN"/></td>
     </tr>
     <tr>
       <td>Title</td>
       <td><input style="width:250px" type="text" name="BookTitle"/></td>
     </tr>
     <tr>
       <td>Publisher</td>
       <td><input style="width:250px" type="text" name="BookPublisher"/></td>
     </tr>
     <tr>
       <td>PublishDate</td>
       <td><input style="width:250px" type="text" name="BookPublishDate"/></td>
     </tr>
     <tr>
       <td>Price</td>
       <td><input style="width:250px" type="text" name="BookPrice"/></td>
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
        <td><input style="width:250px" type="text" name="AuthorID"/></td>
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
   <span style="display:block;  text-align:center" ><input type="submit" value="Confirm"  />
   </span>
   </form>
   <div style="text-align:center">

       <a href="Menu.jsp">Back to menu</a>
    </div>
    </div>
  </body>
</html>
