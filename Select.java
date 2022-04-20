package garbagetruck;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Select {
//	private static final String JDBC_DRIVER = 
//			"com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
	
	private static final String SELECT_SQL =
			"SELECT * FROM GARBAGE_TRUCK WHERE [ADD] like '%%' ";	
	
	static List<Data>  datalist = new ArrayList<>();   //�i�������ܼƨϥ�
	
	public static void selectdata() throws SQLException, IOException {
		Scanner scanner = new Scanner(System.in);
		Statement stmt = null;
		ResultSet rs = null;
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			){
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(SELECT_SQL);    

			while(rs.next()) {              
				//�`�����
				Data data = new Data();
				data.setCity(rs.getString(1));
				data.setCity_code(rs.getString(2));
				data.setAddress(rs.getString(3));
				data.setVilliage(rs.getString(4));
				data.setTime(rs.getString(5));
				data.setSunday(rs.getString(6));
				data.setMonday(rs.getString(7));
				data.setTuesday(rs.getString(8));
				data.setWednesday(rs.getString(9));
				data.setThursday(rs.getString(10));
				data.setFriday(rs.getString(11));
				data.setSaturday(rs.getString(12));
				datalist.add(data);
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
		}
		
		List<Data>  resultList = new ArrayList<>();  //new �@�ӦW��resultList���}�C�A�s��ŦX����r�����
		boolean isExecute = true;
		while(isExecute) {    
			System.out.println("�п�J�d��/���T���W�F ��J:stop �����d��");//scanner�b�A��J��A�~�|=true
			if(scanner.hasNext()) {
				String answer = scanner.nextLine();
				if(answer.equals("stop")) {
					isExecute = false;
				}else {
						for( Data  dataselect  : datalist) {  //�z�Lfor-each�j��f�tif�z��A��ŦX����r����Ʃ�iresultList��
						if(dataselect.getAddress().contains(answer)) {   //�j���d��.contains.�p���d��A���ŦX��J����N�|���X�j��
							System.out.println(dataselect.getCity()+ ", " + dataselect.getCity_code()+",	 " + dataselect.getAddress()+",			" + dataselect.getVilliage()+",		" + dataselect.getTime()+",	" + dataselect.getSunday()+"," + dataselect.getMonday()+"," + dataselect.getTuesday()+"," + dataselect.getWednesday()+"," + dataselect.getThursday()+"," + dataselect.getFriday()+"," + dataselect.getSaturday());
							resultList.add(dataselect);
							} 
						}	
					  }
			}
		}
		
		FileOutputStream fos = new FileOutputStream("D:\\JDBC\\output.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "MS950");
		BufferedWriter bw = new BufferedWriter(osw);	
		
		try {
		
		for(Data data : resultList) {
			bw.write(data.getCity() +"," + data.getCity_code() +"," + data.getAddress() +"," + data.getVilliage() +"," + data.getTime() +"," + data.getSunday() +"," + data.getMonday() +"," + data.getTuesday() +"," + data.getWednesday() +"," + data.getThursday() +"," + data.getFriday() +"," + data.getSaturday() );
			bw.newLine();  		
		}
		}catch(Exception e) {
		}finally {
			bw.close();
			osw.close();
			fos.close();
		}
		
	}
	
}
