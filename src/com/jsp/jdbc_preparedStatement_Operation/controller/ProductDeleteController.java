package com.jsp.jdbc_preparedStatement_Operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDeleteController {
	public static void main(String []args) {

		Connection connection=null;
		try {
			
//			step1 load/register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			Step2 create Connection
			String url="jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user="root";
			String pass="tiger";
			
			connection=DriverManager.getConnection( url,user,pass);
			String deleteQuery="delete from product where productid=?";
			
//			 Step 3 Create statement
			 PreparedStatement preparedStatement=connection.prepareStatement(deleteQuery);
			 
			 preparedStatement.setInt(1, 100);
			 int a=preparedStatement.executeUpdate();		
			 if(a==1) {
				 System.out.println("data is deleted");
			 }else {
				 System.err.println("given id is not preseent");
			 }
		}
		catch(Exception e) {
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
