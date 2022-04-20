package garbagetruck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

//	private static final String JDBC_DRIVER = 
//			"com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
	
	private static final String UPDATE_SQL_ADD =
			"UPDATE GARBAGE_TRUCK SET [ADD] = ? WHERE VILLAGE = ? ";	
	private static final String UPDATE_SQL_TIME =
			"UPDATE GARBAGE_TRUCK SET ARRIVAL_TIME = ? WHERE [ADD] like ? ";	

	public static void updatedata() {
		
		Scanner scanner = new Scanner(System.in);
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			){ 
			PreparedStatement pstmt1 = conn.prepareStatement(UPDATE_SQL_ADD);
			PreparedStatement pstmt2 = conn.prepareStatement(UPDATE_SQL_TIME);
			System.out.println("�п�ܧ�s�覡:(A)��s�a�}  (T)��s�ɶ� ");
			while(scanner.hasNext()) {
				String answer = scanner.nextLine();
				if(answer.equals("A")) {
					System.out.println("�п�J�n��s���a�}: ");
					String address = scanner.nextLine();
					System.out.println("�̾ڨ��W: ");
					String villiage = scanner.nextLine();
					pstmt1.setString(1, address);
					pstmt1.setString(2, villiage);
					pstmt1.addBatch();
					pstmt1.executeBatch();
					System.out.println("��s���\ ");
					pstmt1.close();
					break;
				}else if(answer.equals("T")) {
					System.out.println("�п�J�n��s���ɶ�: ");
					String time = scanner.nextLine();
					System.out.println("�̾ڦa�}: ");
					String addr = scanner.nextLine();
					pstmt2.setString(1, time);
					pstmt2.setString(2, addr);
					pstmt2.addBatch();
					pstmt2.executeBatch();
					System.out.println("��s���\ ");
					pstmt2.close();
					break;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}
}
