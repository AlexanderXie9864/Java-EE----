/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.helper.DbHelper;
import com.javabean.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author xb
 */
public class MessageDao {
     /**
     * 查询所有留言信息
     * @return
     */
     public List<Message> getAllMessage(){  
            List<Message> list = new ArrayList<Message>();  
            Connection conn = DbHelper.getConnection();//连接数据库
            String sql  = "select * from message";  
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rst = pst.executeQuery();
                while (rst.next()) {
                    Message userMessage = new Message();
                    userMessage.setTitle(rst.getString("title"));
                    userMessage.setUsername(rst.getString("username"));
                     userMessage.setMessage(rst.getString("message"));
                    userMessage.setDatetimestamp(rst.getString("datetimestamp"));
                    list.add(userMessage);
                }
                rst.close();  
                pst.close();  
               
                
            } catch (SQLException e) {
                System.out.println(e);
            }
              return list;
        }
     
        /**
         * 添加消息
         * @param message
         * @return
         */
        public boolean addMessage(Message message){ 
            String sql = "INSERT INTO message(message,username,title,datetimestamp) VALUES (?,?,?,?)";  
            Connection conn = DbHelper.getConnection();
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, message.getMessage());
                pst.setString(2, message.getUsername());
                pst.setString(3, message.getTitle());
                pst.setString(4, message.getDatetimestamp());
                int count = pst.executeUpdate();
                pst.close();
                
                return count>0; 
            } catch (SQLException e) {
                System.out.println(e);
            }
            return false;
        }
        
       
        /**
         * 删除消息
     * @param username
     * @param datetimestamp
         * @return
         */
        public boolean deleteMessage(String username,String datetimestamp){  
            String sql = "delete from message where username = ? and datetimestamp=?"; 
            Connection conn = DbHelper.getConnection();
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, datetimestamp);
                int count = pst.executeUpdate();
                pst.close();
                return count>0;  
            } catch (SQLException e) {
                System.out.println(e);
            }
            return false;
        }
        
        /**
         * 根据username进行查询留言
         * @param username
         * @return
         */
        public List<Message> selectMessagesByUsername(String username ){ 
              List<Message> list = new ArrayList<Message>();  
            Connection conn = DbHelper.getConnection();
            String sql  = "select * from message where username = "+username;
            Message message = null;
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rst = pst.executeQuery();
                while (rst.next()) {
                    message = new Message();
                    message.setUsername(rst.getString("username"));
                    message.setTitle(rst.getString("title"));
                    message.setMessage(rst.getString("message"));
                    message.setDatetimestamp(rst.getString("datetimestamp"));
                }
                rst.close();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();  
            }
            return list;  
        }
        public static void main(String[] args) { 
//            List<Message> list;
//            MessageDao dao =new MessageDao();
//         list = dao.getAllMessage();
//            for(Message m:list)
//            System.out.println(m.getUsername());
//            Message message=new Message();
//            message.setMessage("123");
//             Date date = new Date();
//                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String datetime = dateFormat.format(date);
//            message.setDatetimestamp(datetime);
//            message.setTitle("222");
//            message.setUsername("123");
//          System.out.println(new MessageDao().addMessage(message));
    }
}
