<%-- 
    Document   : index
    Created on : Oct 16, 2019, 8:48:34 PM
    Author     : xb
--%>

<%@page import="com.javabean.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.javabean.Message" %>
<%@page import="com.dao.*" %>
 
<html>
  <head>      
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery-1.11.1.min"></script>
        <script src="js/bootstrap.min.js"></script>
    <title>家庭留言板</title>
  </head>
 
  <body>
        <%
        if((String)session.getAttribute("username")==null)
            response.sendRedirect("login.jsp");
     %>
     <nav class="navbar navbar-default" role="navigation">
         <div class="container-fluid">
             <div class="navbar-header">
                 <h2 class="text-info">欢迎您，<span class="text-warning"><%=(String)session.getAttribute("username")%></span></h2>
             </div>  
             <ul class="nav navbar-nav navbar-right" style="font-size: 20px">
                 <li><a href="user.jsp" title="点击查看修改用户信息"><span  class="glyphicon glyphicon-user"></span>用户信息</a></li>
                 <li> <a href="LogoutServlet" title="点击退出登录"><span  class="glyphicon glyphicon-log-out"></span>退出</a></li>
             </ul>
         </div>
     </nav>
             
            
        
          <div class="container"> 
         
                
                <table class="table table-hover" style="margin-top: 50px">
                    <thead>
                    <tr><th>留言人</th>                     
                        <th>留言标题</th>
                        <th>留言时间</th>
                        <th>留言内容</th>
                        <th>操作</th></tr>
                    </thead>
                    <tbody>
  		<%
  			List<Message> msgs=(List)session.getAttribute("msgs");
                       
  			if(msgs!=null){
  				Iterator iter=msgs.iterator();
  				while(iter.hasNext()){
                                    Message msg=(Message)iter.next();
                                    String nickname=new UserDao().selectUserByUsername(msg.getUsername()).getNickname();
                                    int age=new UserDao().selectUserByUsername(msg.getUsername()).getAge();
  		%>
                    <tr style="height:30px;"><td><a href="#" style="text-decoration:none;" title="<%=nickname%>   年龄：<%=age%>"><%= msg.getUsername() %></a></td>
                            <td><%= msg.getTitle() %></td>
                            <td><%= msg.getDatetimestamp()%></td>                         
                            <td><%= msg.getMessage() %></td>
                            <td>
                                <% if(msg.getUsername().equals((String)session.getAttribute("username"))){%>
                                <a href="DeleteMessageServlet?datetimestamp=<%= msg.getDatetimestamp() %>">删除</a>
                            <%
                          ; }
                            %>
                            </td>
                        </tr>
  		<% 
                           
  			}
  			}
  		 %>
                 </tbody>
  		</table>
 
                
   <div class="row">    
       <center>
   <form action="MessageServlet" method="post">
            <table border="2">
            <caption>填写留言信息</caption>
            <tbody>
            <tr><td>留言标题</td>
                    <td><input type="text" name="title"/></td></tr>
            <tr><td>留言内容</td>
                    <td><textarea name="message" rows="5" cols="35"></textarea></td>
            </tr>
            </tbody>
            </table>
       <br/>
       <input class="btn btn-success" type="submit" value="提 交"/>
       <input class="btn btn-primary" type="reset" style="margin-left: 20px" value="清 空"/>
  	</form>

       </center>
    </div>
  
          </div>
          </body>

</html>

