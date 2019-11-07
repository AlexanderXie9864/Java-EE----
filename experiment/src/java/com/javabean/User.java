/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javabean;

/**
 *
 * @author xb
 */
public class User {
   
    private String nickname;
    private int age;
    private String username;
    private String password;
    
    public User(){}
    
    public String getNickname(){
        return nickname;
    }
    
    public void setNickname(String nickname){
        this.nickname=nickname;
    }
    
     public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    } 
    
    
  public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password=password;
    }

    
}
