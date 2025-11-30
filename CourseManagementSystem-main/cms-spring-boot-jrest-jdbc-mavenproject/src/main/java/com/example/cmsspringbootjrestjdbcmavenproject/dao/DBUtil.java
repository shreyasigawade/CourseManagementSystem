package com.example.cmsspringbootjrestjdbcmavenproject.dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {

		static private Connection conn;
		
        static private String connectionUrl ="jdbc:mysql://localhost:3306/course_management";
        static private String root ="root";
        static private String password ="Shrey@21";
        
        static Connection makeConnection() {
        	// singleton design pattern to obtain the same connection again and again
    		if(conn == null) {
    			try {
					conn =DriverManager.getConnection(connectionUrl, root, password);
					 System.out.println("Connected to the database successfully!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    		}
			return conn;
        	
        }
        static void closeConnection() {
        	try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	

}
