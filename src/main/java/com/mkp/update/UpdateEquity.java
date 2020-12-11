package com.mkp.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mkp.connection.MysqlCon;

public class UpdateEquity {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("args length:" + args.length);
			throw new RuntimeException("Equity argument required");
		}
		int id = Integer.parseInt(args[0]);
		String equity = args[1];

		try {
			Connection con = MysqlCon.getConnection();
			PreparedStatement stmt = con.prepareStatement("update equity set equity=? where id=?");
			stmt.setString(1, equity);
			stmt.setInt(2, id);
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
