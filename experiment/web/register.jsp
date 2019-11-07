<%-- 
    Document   : register
    Created on : Oct 19, 2019, 11:12:33 PM
    Author     : xb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery-1.11.1.min"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>家庭留言板</title>
    </head>
    <body>
       <%
        if((String)session.getAttribute("username")!=null)
            response.sendRedirect("message.jsp");
         %>
         <div class="container"> 
          <h1 class="text-center" style="margin-top: 100px;">欢迎登录家庭留言板</h1>
          <div class="row" style="margin-top: 50px;"></div>
       <form action="RegisterServlet" class="form-horizontal" method="post"  role="form">
             <div class="form-group">
                  <label class="col-sm-4 control-label">称呼：</label>
                  <div class="col-sm-5">
                 <input type="text" name="nickname" class="form-control" placeholder="请输入昵称">
                  </div>
                </div>
           
            <div class="form-group">
                  <label class="col-sm-4 control-label">用户名：</label>
                  <div class="col-sm-5">
                 <input type="text" name="username" class="form-control" placeholder="请输入用户名">
                  </div>
                </div>
            <div class="form-group">
                  <label class="col-sm-4 control-label">密码：</label>
                  <div class="col-sm-5">
                 <input type="text" name="password" class="form-control" placeholder="请输入密码">
                  </div>
                </div>
            <div class="form-group">
                  <label class="col-sm-4 control-label">年龄：</label>
                  <div class="col-sm-5">
                 <input type="text" name="age" class="form-control" placeholder="请输入年龄">
                  </div>
                </div>
           <hr/>
           
           <div class="form-group text-center" style="margin-top: 60px">
                  <div class="col-sm-10">
                      <input class="btn btn-success" type="submit" value="注 册">  已有账号？<a href="login.jsp">点击登录</a>
                  </div>
                </div>
        </form>
             
          
            </div>
    </body>
</html>
