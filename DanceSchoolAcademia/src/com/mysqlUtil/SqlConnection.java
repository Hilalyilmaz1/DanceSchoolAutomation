package com.mysqlUtil;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class SqlConnection {
	static Connection conn=null;
	
	public static Connection Baglan() {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/danceschool","root","");
			return conn;
		}
		catch(Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
	}
	


}
	
	public static String Md5sifreleme(String içerik) {
		try {
			MessageDigest md =MessageDigest.getInstance("md5");
			//byte olarak oku
			byte[] sifrelenmis=md.digest(içerik.getBytes());
			
			BigInteger no=new BigInteger(1,sifrelenmis);
			//hexadecimal hesapla
			String hashİcerik=no.toString(16);
			while (hashİcerik.length()<32) {
				hashİcerik="0"+hashİcerik;
			}
			return hashİcerik;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
		
	}

	
}
