package com.mkp.connection;

import java.sql.*;

public class MysqlCon {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "devdev");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}