package com.accp.shop.connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
public class Connect {

	public static Connection getConnection(){
		Connection conn=null;
		Properties prpt=new Properties();

		try {
			prpt.load(new FileInputStream("F:/workspace/supermarket/WebRoot/WEB-INF/classes/dataInf.properties"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url=prpt.getProperty("url");
		String driver =prpt.getProperty("driver");
		String user=prpt.getProperty("user");
		String pwd=prpt.getProperty("pwd");

		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return conn;
		
	}

}
