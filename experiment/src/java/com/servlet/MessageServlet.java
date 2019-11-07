/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servlet;

import com.dao.MessageDao;
import com.javabean.Message;
import com.javabean.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xb
 */
public class MessageServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");
                
//                String title=new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8");            
//                String message=new String(request.getParameter("message").getBytes("iso-8859-1"),"utf-8");
                String title=request.getParameter("title");
                String message=request.getParameter("message");
                
                HttpSession session=request.getSession();
                String username= (String)session.getAttribute("username");
                
                Message msg=new Message();                
                Date date = new Date();
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String datetime = dateFormat.format(date);
                
                msg.setUsername(username);
                msg.setDatetimestamp(datetime);
                msg.setTitle(title);
                msg.setMessage(message);
                if(new MessageDao().addMessage(msg)){
                    List<Message> msgs=new MessageDao().getAllMessage();
                    session.setAttribute("msgs", msgs);
                    response.sendRedirect("message.jsp");
                }
                else
                    response.sendRedirect("login.jsp");
                

}

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
