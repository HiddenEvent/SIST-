package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionHelper {
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://@211.197.18.246:3306/demoweb?serverTimezone=Asia/Seoul",
					"devuser", "mariadb");
			
		} catch (Exception ex) {
			return conn;
		}

		return conn;
	}
}
