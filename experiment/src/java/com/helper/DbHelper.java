/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.helper;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author xb
 */
public class DbHelper {
 

    private static String url = "jdbc:mysql://localhost:3306/message?useUnicode=true&characterEncoding=utf-8";
    private static String userName = "root";
    private static String passWord = "";
    private static Connection conn = null;
     
    private DbHelper(){
         
    }
     
    public static Connection getConnection(){
        if(null == conn){
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, userName, passWord);
            } catch (Exception e) {
              System.out.println(e);
            }
        }
        return conn;
    }
     
    public static void main(String[] args) { 
        
    }
}
