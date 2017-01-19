package com.alyenc.cnaps.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class DB {

	private static String username;
	private static String password;
	private static String driver;
	private static String url;

	private DataSource dataSource;
	
	public static Connection getConnection() {
		loadProperties();
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void loadProperties() {
        Properties props = new Properties();  
          
        try { 
        	props=PropertiesLoaderUtils.loadAllProperties("db.properties");
        	driver = props.getProperty("driverClassName");
        	username = props.getProperty("username");
        	password = props.getProperty("password");
        	url = props.getProperty("url");
        } catch (IOException e) {   
        	e.printStackTrace();
        }  
	}
}
