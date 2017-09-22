<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" >
    <title>Menu</title>
  </head>
  
  <body>
  <div style="margin:auto ;position:absolute; left:0; top:0; width:100%; height:100%">  
  <img src="<%=basePath%>image/002.jpg" width=100% height=100%></div>    
  <div style="margin:auto ; position:absolute; left:20%;width:60%">
     <h2 style="text-align: center">Welcome to Use the Book Management System!</h2>
     <h3 style="text-align: center">Function Menu</h3>
     <div style="text-align:center">
        <a href="FindByAuthor.jsp">1.Input author name to index books written by him(her).</a><br>
     </div>
     <hr/><br>
     <div style="text-align:center">
        <a href="ListAllBooks.action">2.Find out all details of the book.</a><br>
     </div>
     <hr/><br>
     <div style="text-align:center">
        <a href="ListAllBooks.action">3.Delete books.</a><br>
     </div>
     <hr/><br>
     <div style="text-align:center">
        <a href="AddBook.jsp">4.Add books.</a><br>
     </div>
     <hr/><br>
     <div style="text-align:center">
        <a href="ListAllBooks.action">5.Update information of books.</a><br>
     </div>
     <hr/><br>
     <div style="text-align:center">
        <a href="ListAllBooks.action">6.List all books(Select the book to operate)</a><br>
     </div>
     <hr/><br>
     <div style="text-align:center">
        <a href="ListAllAuthors.action">7.List all authors(Select the author to view his books or operate)</a><br>
     </div>
     <hr/><br>
     <div style="text-align:center">
        <a href="ListAllAuthors.action">8.Update information of authors.</a><br>
     </div>
     <hr/><br>
     <div style="text-align:center">
        <a href="Description.jsp">*9.Function Description</a><br>
     </div>
     <hr/><br>
     </div>
  </body>
</html>
