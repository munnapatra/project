package com.mkp.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mkp.connection.MysqlCon;

public class DeleteEquity {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("args length:" + args.length);
			throw new RuntimeException("Equity argument required");
		}

		int id = Integer.parseInt(args[0]);

		try {
			Connection con = MysqlCon.getConnection();
			PreparedStatement stmt = con.prepareStatement("delete from equity where id=?");
			stmt.setInt(1, id);

			int i = stmt.executeUpdate();
			System.out.println(i + " records deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
