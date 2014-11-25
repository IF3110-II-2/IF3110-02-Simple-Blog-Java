/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Function;

import java.util.Date;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

/**
 *
 * @author ASUS
 */
@ManagedBean(name = "viewPost", eager = true)
@SessionScoped
public class ViewPost {
    public int postid;
    public String judul;
    public String konten;
    public Date tanggal;
    
    public int getPostid(){
    return postid;}
    
    public String getJudul(){
    return judul;}
    
    public String getKonten(){
    return konten;}
    
    public Date getTanggal(){
    return tanggal;}

    public ViewPost(){
        String url = "jdbc:mysql://localhost:3306/datapost";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root"; 
	String password = "";
	 try {
		  Class.forName(driver).newInstance();
		  Connection conn = DriverManager.getConnection(url,userName,password);
		  Statement st = conn.createStatement();
		/*  ResultSet res = st.executeQuery("SELECT * FROM  post");
		  while (res.next()) {
		  int id = res.getInt("id");
                  String msg = res.getString("msg");
		  System.out.println(id + "\t" + msg);
		  }
		  int val = st.executeUpdate("INSERT into event VALUES("+1+","+"'Easy'"+")");
		  if(val==1)
			  System.out.print("Successfully inserted value");*/
                  ResultSet res= st.executeQuery("Select * from posts");
                  
                  if(res.next()){ 
                  judul=res.getString("Judul");
                  tanggal = res.getDate("Tanggal");                
                  konten = res.getString("Konten");
                  postid=res.getInt("PID");}
		  conn.close();
		  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
		  }
    }
 }
