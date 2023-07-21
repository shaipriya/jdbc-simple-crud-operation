package com.jsp.jdbc_preparedStatement_Operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductUpdateController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
//			step1 load /register to Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			step2
			String url="jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user="root";
			String pass="tiger";
			
			connection=DriverManager.getConnection(url,user,pass);
//			step3
			String updateColorQuery="update product set productcolor =? where productid=? ";
			PreparedStatement preparedStatement=connection.prepareStatement(updateColorQuery);
			preparedStatement.setString(1,"white");
			preparedStatement.setInt(2, 100);
			
			int a=preparedStatement.executeUpdate();
			if(a==1) {
			System.out.println("======data updated===");
			}else {
				System.err.println("given id is not present");
			}
			
		}catch(Exception e) {
		e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
