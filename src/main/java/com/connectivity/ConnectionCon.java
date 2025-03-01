package com.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionCon {
	static Connection con;

	public static Connection getConnectivity() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdvJava", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}

		return con;
	}

}
