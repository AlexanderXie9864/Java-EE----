/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.helper.DbHelper;
import com.javabean.User;
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
public class UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
     public List<User> getAllUser(){  
            List<User> list = new ArrayList<User>();  
            Connection conn = DbHelper.getConnection();//连接数据库
            String sql  = "select * from user";  
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rst = pst.executeQuery();
                while (rst.next()) {
                    User user = new User();
                    user.setNickname(rst.getString("nickname"));
                     user.setUsername(rst.getString("username"));
                    user.setAge(rst.getInt("age"));
                    list.add(user);
                }
                rst.close();  
                pst.close();  
            } catch (SQLException e) {
                System.out.println(e);
            }
            return list;  
        }
     
        /**
         * 添加用户
         * @param user
         * @return
         */
        public boolean addUser(User user){ 
            String sql = "insert into user(username,nickname,age,password) values (?,?,?,?)";  
            Connection conn = DbHelper.getConnection();
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, user.getUsername());
                pst.setString(2, user.getNickname());
                pst.setInt(3, user.getAge());
                pst.setString(4, user.getPassword());              
                int count = pst.executeUpdate();
                
                pst.close();       
                return count>0; 
            } catch (SQLException e) {
                System.out.println(e);
            }
            return false;
        }
        
        /**
         * 修改消息信息
         * @param user
         * @return 是否成功修改
         */
        public boolean updateUser(User user){  
            String sql = "update user set nickname=?,age=?,password=? where username = ?"; 
            Connection conn = DbHelper.getConnection();
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, user.getNickname());
                pst.setInt(2, user.getAge());
                pst.setString(3, user.getPassword());
                pst.setString(4, user.getUsername());
                int count = pst.executeUpdate();
               
                pst.close(); 
                return count>0;  
            } catch (SQLException e) {
                System.out.println(e);
            }
            return false;
        }
        
        /**
         * 删除用户
     * @param username
         * @return
         */
        public boolean deleteUser(String username){  
            String sql = "delete from user where username = ?"; 
            Connection conn = DbHelper.getConnection();
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, username);
                int count = pst.executeUpdate();
                
                pst.close();
                return count>0;  
            } catch (SQLException e) {
                System.out.println(e);
            }
            return false;
        }
        
        /**
         * 根据username进行查询用户
         * @param username
         * @return
         */
        public User selectUserByUsername(String username ){  
            Connection conn = DbHelper.getConnection();
            String sql  = "select * from user where username = ?";
                      
            try {
                User user = new User(); 
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, username);
                ResultSet rst = pst.executeQuery();               
                rst.next();
                user.setUsername(rst.getString("username"));
                user.setNickname(rst.getString("nickname"));
                user.setAge(rst.getInt("age"));
                user.setPassword(rst.getString("password"));  
                
                rst.close();
                pst.close();
               
                return user;  
            } catch (SQLException e) {
                System.out.println(e);
                return new User();
            }
           
        
        }
        
         /**
         * 验证登录
         * @param username
         * @param password
         * @return 是否登陆成功
         */
        public boolean checkLogin(String username,String password){
            User user=new UserDao().selectUserByUsername(username);
            return password.equals(user.getPassword());
        }
        
        public static void main(String[] args) {  //测试数据库是否连通
//            User user=new User();
//            user.setAge(123);
//            user.setNickname("123");
//            user.setPassword("111");
//            user.setUsername("33");
//                          
//            System.out.println( new UserDao().addUser(user));
          //  System.out.println( new UserDao().checkLogin("123", "123"));
            // System.out.println( new UserDao().selectUserByUsername("123").getPassword());
    }
}
