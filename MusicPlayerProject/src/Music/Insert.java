package Music;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class Insert {
	
	public static void insert() {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
	PreparedStatement pstmt = null;
		
		

		try {

			// load the driver

			java.sql.Driver div = new Driver() ;
			DriverManager.registerDriver(div);
			System.out.println("Driver loaded...");

			// get connection via Driver

			String dbUrl = "jdbc:mysql://localhost:3306/musicplayer";
			String filePath = "C:\\\\Users\\\\Simran Goyal\\\\Desktop\\\\JDBC.properties";
			FileReader reader = new FileReader(filePath);

			Properties prop = new Properties();
			prop.load(reader);

			conn =  DriverManager.getConnection(dbUrl, prop);
			System.out.println("Connection estd...");

			// Issue the Sql query
						String query = "insert into MusicFiles values(?,?,?,?,?,?)";
						pstmt = conn.prepareStatement(query);
						
						System.out.println("enter the Song_ID = ");
						pstmt.setInt(1, Integer.parseInt(sc.nextLine())); 
						System.out.println("enter Song_Title=");
						pstmt.setString(2, sc.nextLine());
						System.out.println("enter the Artist_Name = ");
						pstmt.setString(3, sc.nextLine());
						System.out.println("enter the Album_Name = ");
						pstmt.setString(4, sc.nextLine());
						System.out.println("enter the Song_Location = ");
						pstmt.setString(5, sc.nextLine());
						System.out.println("enter the Description = ");
						pstmt.setString(6, sc.nextLine());
						
						int count = pstmt.executeUpdate();
						
						//Process the results
						
						if(count>0) {
							System.out.println("Song inserted");
						}else {
							System.out.println("Something went wrong...");
						}
						
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		
			
		}
	}

}
