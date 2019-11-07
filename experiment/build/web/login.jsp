<%-- 
    Document   : message
    Created on : Oct 17, 2019, 9:26:21 PM
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
            <div class="row" style="margin-top: 100px;">
            <form action="LoginServlet" class="form-horizontal" method="post" role="form">
                <div class="form-group">
                  <label for="username" class="col-sm-4 control-label">用户名：</label>
                  <div class="col-sm-5">
                 <input type="text" name="username" class="form-control" placeholder="请输入用户名">
                  </div>
                </div>
                <br>
                <div class="form-group">
                  <label for="username" class="col-sm-4 control-label">密码：</label>  
                  <div class="col-sm-5">
                    <input type="password" name="password" class="form-control" placeholder="请输入密码">
                </div>
                </div>
                <hr>
             <input class="btn btn-default center-block" type="submit" value="登   录">
             <br>
             <p class="text-center">没有账号？<a href="register.jsp">点击注册</a></p>
        </form>
          
           
       </div>
               
           
    </div> 
    </body>
</html>
