<%-- 
    Document   : updateSuccess
    Created on : Nov 1, 2019, 11:31:33 AM
    Author     : xb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
        if((String)session.getAttribute("username")==null)
            response.sendRedirect("login.jsp");
     %>
         <h3>修改成功,3秒后自动跳转......</h3>
         <% 
            response.setHeader("Refresh", "3;URL=user.jsp"); 
            %> 
    </body>
</html>
