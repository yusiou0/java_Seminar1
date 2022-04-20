package garbagetruck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Scanner;

public class Create {

	private static final String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
	
	private static final String INSERT_SQL =
			"INSERT INTO GARBAGE_TRUCK VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";	

	public static void insertdata() {
	
				Connection conn = null;
				Scanner scanner = new Scanner(System.in);
				
				try {
					conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
					PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);
					
					System.out.println("請輸入要新增的城市名稱: ");
					while(scanner.hasNext()) {
						String city = scanner.nextLine();
						pstmt.setString(1, city);
						System.out.println("請輸入要新增的城市碼: ");
						String city_code = scanner.nextLine();
						pstmt.setInt(2, Integer.parseInt(city_code));
						System.out.println("請輸入要新增的地址: ");
						String address = scanner.nextLine();
						pstmt.setString(3, address);
						System.out.println("請輸入要新增里名: ");
						String villiage = scanner.nextLine();
						pstmt.setString(4, villiage);
						System.out.println("請輸入要新增的時間: ");
						String time = scanner.nextLine();
						pstmt.setTime(5, Time.valueOf(time));
						System.out.println("請輸入星期天 Y/N 收垃圾: ");
						String sunday = scanner.nextLine();
						pstmt.setString(6, sunday);
						System.out.println("請輸入星期一 Y/N 收垃圾: ");
						String monday = scanner.nextLine();
						pstmt.setString(7, monday);
						System.out.println("請輸入星期二 Y/N 收垃圾: ");
						String tuesday = scanner.nextLine();
						pstmt.setString(8, tuesday);
						System.out.println("請輸入星期三 Y/N 收垃圾: ");
						String wednesday = scanner.nextLine();
						pstmt.setString(9, wednesday);
						System.out.println("請輸入星期四 Y/N 收垃圾: ");
						String thursday = scanner.nextLine();
						pstmt.setString(10, thursday);
						System.out.println("請輸入星期五 Y/N 收垃圾: ");
						String friday = scanner.nextLine();
						pstmt.setString(11, friday);
						System.out.println("請輸入星期六 Y/N 收垃圾: ");
						String saturday = scanner.nextLine();
						pstmt.setString(12, saturday);
						break;
					}
					
					pstmt.executeUpdate();
					System.out.println("create成功");
					pstmt.close();
									
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					if (conn != null)
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
			
		}
	
	
}
