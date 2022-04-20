
package garbagetruck;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
//import java.util.Scanner;


public class Input{

//		private static final String JDBC_DRIVER = 
//				"com.microsoft.sqlserver.jdbc.SQLServerDriver";
		private static final String DB_URL = 
				"jdbc:sqlserver://localhost:1433;databaseName=jdbc";
		private static final String USER = "sa";
		private static final String PASSWORD = "passw0rd";
		
		private static final String CSV_TO_SQL =
				"INSERT INTO GARBAGE_TRUCK VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";	
		
		
	public static void inputdata(){	
		
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			PreparedStatement pstmt= conn.prepareStatement(CSV_TO_SQL);
			File file = new File("D:\\JDBC\\garbage_truck.csv");
			FileInputStream fis = new FileInputStream(file);       
			InputStreamReader isr = new InputStreamReader(fis,"UTF8");
			BufferedReader br = new BufferedReader(isr);
			
            String line = null;
            br.readLine(); //先把表頭讀掉，下面資料轉型才不會出錯
            while((line=br.readLine())!=null){
			String[] columns=line.split(",");
			
					pstmt.setString(1, columns[0]);
					pstmt.setInt(2, Integer.parseInt(columns[1]));
					pstmt.setString(3, columns[2]);
					pstmt.setString(4, columns[3]);
					pstmt.setTime(5, Time.valueOf(columns[4]));
					pstmt.setString(6, columns[5]);
					pstmt.setString(7, columns[6]);
					pstmt.setString(8, columns[7]);
					pstmt.setString(9, columns[8]);
					pstmt.setString(10, columns[9]);
					pstmt.setString(11,columns[10]);
					pstmt.setString(12, columns[11]);  			
					pstmt.execute();
					System.out.println(line);
            };
            
                    
			pstmt.close();
			br.close();
		
			
		} catch (SQLException e) {
			e.printStackTrace();	
		}catch (NumberFormatException e) {
			e.printStackTrace();	
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
		
				
  }



}
	
	
	