package com.mkp.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mkp.connection.MysqlCon;

public class InsertEquity {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("args length:" + args.length);
			throw new RuntimeException("Equity argument required");
		}
		
		try {
			Connection con = MysqlCon.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into equity(equity) values(?)");
			stmt.setString(1, args[0]);
			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
