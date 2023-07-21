package com.jsp.jdbc_preparedStatement_Operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDisplayController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection=null;
		try {
			
//			step1 load/register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			Step2 create Connection
			String url="jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user="root";
			String pass="tiger";
			
			connection=DriverManager.getConnection( url,user,pass);
			String displayQuery="Select * from product";			
//			 Step 3 Create statement
			 PreparedStatement preparedStatement=connection.prepareStatement(displayQuery);
			 ResultSet resultSet=preparedStatement.executeQuery();
			 
			 while(resultSet.next()) {
				 
				 int id =resultSet.getInt("productid");
				 String name=resultSet.getString("productname");
				 double price =resultSet.getDouble("productprice");
				 String color=resultSet.getString("productcolor");
				 System.out.println("id="+ id);
				 System.out.println("name="+name);
				 System.out.println("price="+price);
				 System.out.println("color="+color);
				 System.out.println("=======================");
				 
				 
				 }
			 }catch(Exception e) {
				 e.printStackTrace();
			 }finally {
				 try {
					 connection.close();
				 }catch(SQLException e) {
					 e.printStackTrace();
				 }
			 }
	}

}
