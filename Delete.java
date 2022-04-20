package garbagetruck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

//	private static final String JDBC_DRIVER = 
//			"com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
	
	private static final String DELETE_SQL =
			"DELETE GARBAGE_TRUCK  WHERE  CITY_CODE = ?  and VILLAGE = ? ";	
	
	
	public static void deletedata() {
		
		Scanner scanner = new Scanner(System.in);
		
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			){ 
				PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL);
				
				boolean isExecute = true;
				while(isExecute) {
					System.out.println("�O�_�n�R�����?  Y/N ");
					String answer = scanner.nextLine();
					if(answer.equals("Y")) {
						System.out.println("��J�n�R���������X");
						String city_code = scanner.nextLine();
						pstmt.setString(1, city_code);
						System.out.println("��J�R�����F��");
						String village = scanner.nextLine();
						pstmt.setString(2, village);
						int count = pstmt.executeUpdate();
						System.out.println("�R�����\");
					}else if(answer.equals("N")){
						isExecute = false; 	
					}
				}
			
			
			pstmt.close();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		
		
	}
	
	
	
	

