/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Function;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Anggi
 */
public class User {
	private int uidToDelete;
	private String username;
	private String password;
	private String role;
	private int userID;
	
	public int getUidToDelete(){
		return uidToDelete;
	}
	public int getUserID(){
		return userID;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getRole(){
		return role;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setRole(String role){
		this.role = role;
	}
	public void setUserID(int userID){
		this.userID = userID;
	}
	public void setUidToDelete(int id){
		this.uidToDelete = id;
	}
	
	public void updateUser(){
	
	}
	public String deleteUser(){
		String url = "jdbc:mysql://localhost:3306/datapost";
	   String driver = "com.mysql.jdbc.Driver";
	   String userName = "root"; 
	   String password = "";
		try {
		   Class.forName(driver).newInstance();
		   Connection conn = DriverManager.getConnection(url,userName,password);
		   String insertToDB = "delete from user where username_id = ?";
		   PreparedStatement preparedStatement = conn.prepareStatement(insertToDB);
		   preparedStatement.setInt(1,uidToDelete);
		   preparedStatement.executeUpdate();
		   conn.close();
		  // FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
	   } catch (ClassNotFoundException /*| IOException*/ | InstantiationException | IllegalAccessException | SQLException e) {
	   }
		return "usermanagement?faces-redirect=true";
    }
	public String createUser(){
		String url = "jdbc:mysql://localhost:3306/datapost";
	   String driver = "com.mysql.jdbc.Driver";
	   String userName = "root"; 
	   String password = "";
		try {
		   Class.forName(driver).newInstance();
		   Connection conn = DriverManager.getConnection(url,userName,password);
		   String insertToDB = "insert into user (`username`, `password`, `role`) value (?,?,?)";
		   PreparedStatement preparedStatement = conn.prepareStatement(insertToDB);
		   preparedStatement.setString(1, this.username);
		   preparedStatement.setString(2, this.password);
		   preparedStatement.setString(3, this.role);
		   preparedStatement.executeUpdate();
		   conn.close();
	   } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
	   }
	   return "usermanagement?faces-redirect=true";
	}
}