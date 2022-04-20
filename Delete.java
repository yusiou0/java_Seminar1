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
					System.out.println("是否要刪除資料?  Y/N ");
					String answer = scanner.nextLine();
					if(answer.equals("Y")) {
						System.out.println("輸入要刪除的城市碼");
						String city_code = scanner.nextLine();
						pstmt.setString(1, city_code);
						System.out.println("輸入刪除的鄰里");
						String village = scanner.nextLine();
						pstmt.setString(2, village);
						int count = pstmt.executeUpdate();
						System.out.println("刪除成功");
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
	
	
	
	

