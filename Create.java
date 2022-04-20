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
					
					System.out.println("�п�J�n�s�W�������W��: ");
					while(scanner.hasNext()) {
						String city = scanner.nextLine();
						pstmt.setString(1, city);
						System.out.println("�п�J�n�s�W�������X: ");
						String city_code = scanner.nextLine();
						pstmt.setInt(2, Integer.parseInt(city_code));
						System.out.println("�п�J�n�s�W���a�}: ");
						String address = scanner.nextLine();
						pstmt.setString(3, address);
						System.out.println("�п�J�n�s�W���W: ");
						String villiage = scanner.nextLine();
						pstmt.setString(4, villiage);
						System.out.println("�п�J�n�s�W���ɶ�: ");
						String time = scanner.nextLine();
						pstmt.setTime(5, Time.valueOf(time));
						System.out.println("�п�J�P���� Y/N ���U��: ");
						String sunday = scanner.nextLine();
						pstmt.setString(6, sunday);
						System.out.println("�п�J�P���@ Y/N ���U��: ");
						String monday = scanner.nextLine();
						pstmt.setString(7, monday);
						System.out.println("�п�J�P���G Y/N ���U��: ");
						String tuesday = scanner.nextLine();
						pstmt.setString(8, tuesday);
						System.out.println("�п�J�P���T Y/N ���U��: ");
						String wednesday = scanner.nextLine();
						pstmt.setString(9, wednesday);
						System.out.println("�п�J�P���| Y/N ���U��: ");
						String thursday = scanner.nextLine();
						pstmt.setString(10, thursday);
						System.out.println("�п�J�P���� Y/N ���U��: ");
						String friday = scanner.nextLine();
						pstmt.setString(11, friday);
						System.out.println("�п�J�P���� Y/N ���U��: ");
						String saturday = scanner.nextLine();
						pstmt.setString(12, saturday);
						break;
					}
					
					pstmt.executeUpdate();
					System.out.println("create���\");
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
