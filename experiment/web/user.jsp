<%-- 
    Document   : user
    Created on : Oct 19, 2019, 11:12:46 PM
    Author     : xb
--%>

<%@page import="com.dao.UserDao"%>
<%@page import="com.javabean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery-1.11.1.min"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>用户个人信息</title>
    </head>
    <body>
        <%
        if((String)session.getAttribute("username")==null)
            response.sendRedirect("login.jsp");
         %>
        
         
           <div class="container"> 
          <h1 class="text-center" style="margin-top: 100px;">个人用户信息</h1>
             <div class="row" style="margin-top: 50px;"></div>
       <form action="UpdateUserServlet" method="post" role="form" class="form-horizontal">
               <%
                        User user=new UserDao().selectUserByUsername((String)session.getAttribute("username"));
                    %>
                  <div class="form-group">
                  <label class="col-sm-4 control-label">用户名：</label>
                  <div class="col-sm-5">
                      <p style="font-size: 20px;"><%=(String)session.getAttribute("username")%></p>
                  </div>
                </div>
                  
              <div class="form-group">
                  <label class="col-sm-4 control-label">称呼：</label>
                  <div class="col-sm-5">
                 <input type="text" name="nickname" class="form-control" value="<%= user.getNickname()%>">
                  </div>
                </div>
                   <div class="form-group">
                  <label class="col-sm-4 control-label">密码：</label>
                  <div class="col-sm-5">
                 <input type="text" name="password" class="form-control" value="<%= user.getPassword()%>">
                  </div>
                </div>
            <div class="form-group">
                  <label class="col-sm-4 control-label">年龄：</label>
                  <div class="col-sm-5">
                 <input type="text" name="age" class="form-control" value="<%= user.getAge()%>">
                  </div>
                </div>
                <hr/>
         
           <div class="form-group text-center" style="margin-top: 60px">
                  <div class="col-sm-10">
                      <input class="btn btn-danger" type="submit" value="确      认" title="点击确认修改">
                      <a href="message.jsp" class="btn btn-primary" style="margin-left: 50px;">返回留言板</a>
                  </div>
                </div>    
          
        </form>
           </div>
              </div>
    </body>
</html>
