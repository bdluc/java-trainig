package com.tma.RestApiConnectDB.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	private static String url = "jdbc:postgresql://localhost:5432/demo";
	private static String username = "postgres";
	private static String password = "dinhtai";
	
	Connection getConnection() {
		Connection cnt = null;
		try {
			cnt = DriverManager.getConnection(url, username, password);
			System.out.println("Connect SuccessFullyL");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cnt;
	}
}
