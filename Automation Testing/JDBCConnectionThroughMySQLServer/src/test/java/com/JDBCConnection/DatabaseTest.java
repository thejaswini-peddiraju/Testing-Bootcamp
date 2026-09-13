package com.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseTest {

	@Test
	
	public void testDatabaseConnection() throws SQLException, ClassNotFoundException {
		
		String dbURL = "jdbc:mysql://localhost:3306/SeleniumAutomation";

        String user = "root";
        String password = "Thejaswini@123";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbURL, user, password);
        Statement stmt = con.createStatement();
        
        String query = "SELECT * FROM SeleniumAutomation.book_detl;";
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
        	String auth = rs.getString("author");
        	String tit = rs.getString("title");
        	System.out.println("author:" + auth + ", title: " + tit);
        	
        }
        
        con.close();
	}
}
