package garbagetruck;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) throws SQLException, IOException {
		
		Scanner scanner = new Scanner(System.in);

		boolean isExecute = true;
		while(isExecute) {	
			System.out.println("choose your option:   (I)inputData (C)create (S)select (U)update (D)delete  (E)exit");
			if(scanner.hasNext()) {
				String answer = scanner.nextLine();
				System.out.println();
				
					if(answer.equals("I")) {
						Input.inputdata();
						System.out.println("input成功");
					}else if(answer.equals("C")) {
						Create.insertdata();
					}else if(answer.equals("S")) {
						Select.selectdata();
					}else if(answer.equals("U")) {
						Update.updatedata();
					}else if(answer.equals("D")) {
						Delete.deletedata();
					}else if (answer.equals("E")){
						System.out.println("Thank you, goodbye!");
						scanner.close();
						isExecute = false;
					}else {
						System.out.println("請輸入正確字彙");
						
					}

				
			}
			
		}

	}
	

}	
