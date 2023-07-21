package com.jsp.jdbc_preparedStatement_Operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductInsertController {
	public static void main(String []args) {
//		global var banya connection ko 
		Connection connection=null;
		try {
			
//			step1 load/register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			Step2 create Connection
			String url="jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user="root";
			String pass="tiger";
			
			connection=DriverManager.getConnection( url,user,pass);
			
			 String insertQuery="insert into product values(?,?,?,?)";
//			 Step 3 Create statement
			 PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
			 
			 preparedStatement.setInt(1, 102);
			 preparedStatement.setString(2,"pencil");
			 preparedStatement.setDouble(3,205);
			 preparedStatement.setString(4, "white");
			 
			 preparedStatement.execute();
			 
			 System.out.println("Datat---------stored");
			
		}
		catch(ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch( SQLException e){
				e.printStackTrace();
				
			}
			
		}
	}

}
