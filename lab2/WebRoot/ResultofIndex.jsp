<%@ page contentType="text/html; charset=UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" >
    <title>Index Result</title>
    <style>
      .tableformat table{border-right:1px solid #484891;
                         border-bottom:1px solid #484891;} 
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
       <h2 style="text-align: center">Following are the books written by <br>
       <b><s:property value="AuthorName"/></b></h2>
       <h4 style="text-align: center">(If two or more authors share the same name,distinguish them by AuthorID)</h4>
        <div style="margin:auto width:700px; height:400px; overflow:scroll;overflow-x:hidden" class=tableformat>
       <table style="border-collapse:collapse;empty-cell:show;" align="center" width="700" border="1" cellspacing="1" cellpadding="1">
          
         <caption align="top"><b>BookList</b></caption>
         <tr>
           <th><b>AuthorID</b></th>
           <th><b>BookISBN</b></th>
           <th><b>BookTitle</b></th>
           <th><b>Edit</b></th>
         </tr>
         <s:iterator value="BookList" var="list">
         <tr>
           <td>
              <s:property value="#list.AuthorID" />
           </td>
           <td>
              <s:property value="#list.BookISBN" />
           </td>
           <td>
               <a href="showbook.action?BookISBN=<s:property value="#list.BookISBN" />"><s:property value="#list.BookTitle" /></a>
           </td>
           <td>
              <a href="deletebook.action?BookISBN=<s:property value="#list.BookISBN"/>">delete</a>
              <a href="update.action?BookISBN=<s:property value="#list.BookISBN"/>">update</a>
           </td>
         </tr>
       </s:iterator>
       </table>
       </div>

       <div style="text-align:center">
       <a href="javascript:history.go(-1)">1.Return to the previous page</a><br><br>
       <a href="Menu.jsp">2.Back to menu</a>
    </div>
    </div>
  </body>
</html>
