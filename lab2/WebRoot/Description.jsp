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
    <title>Function Description</title>
  </head>
    
  <body>
  <div style="margin:auto ;position:absolute; left:0; top:0; width:100%; height:100%">  
  <img src="<%=basePath%>image/018.jpg" width=100% height=100%></div>    
  <div style="position:absolute; left:20%;width:60%">
  <br><br>
    <h2 style="text-align: center; color:#AE0000">部 分 功 能 使 用 说  明 <br></h2><br>
    <h4 style="text-align: center">1.检索 ：按作者姓名检索图书时，如果有多于一个作者姓名与此相符，他们所著图书将
                                   <br>都被显示，并以作者ID区分 </h4>
    <h4 style="text-align: center">2.删除：删除一本图书时，在该作者所著图书中也将删除此条目<br></h4>
    <h4 style="text-align: center">3.添加：添加时作者姓名、ID、ISBN、书名不能为空，其余信息可以为空，且ISBN不能重复<br></h4>
    <h4 style="text-align: center">4.更新图书：（1）作者姓名和书名不能为空<br> 
                                                                                                                                                        （2）作者ID为空时，视ID为保持原值，作者个人信息可以更改，视为更新操作<br>
                                                                                                                                                       （3）作者ID已经存在于作者表中时，视为对该作者个人信息进行更新操作<br>
                                                                                                                                                        （3）作者ID没有存在于作者表中时，向作者表中插入一条新条目<br></h4>
    <h4 style="text-align: center">5.年龄应符合整型格式，书目价格应符合浮点型要求<br></h4>                                                                                                                                                    
    <div style="text-align:center">
       <a href="Menu.jsp">1.Back to menu</a>
    </div>
    </div>
  </body>
</html>
