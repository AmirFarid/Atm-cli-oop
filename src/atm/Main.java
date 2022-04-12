package atm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

//		try {
//			System.out.println("SALAM");
//		//	File file = new File(FileName.EMPLOYE.toString());
//			
//			java.io.FileWriter fileWriter = new java.io.FileWriter(FileName.EMPLOYE.toString());
//			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//			bufferedWriter.write("salam");
//		
//			
//			System.out.println("SALAM2");
//		} catch (FileNotFoundException e) {
//			System.out.println("not found");
//		} catch (IOException e) {
//			System.out.println("error with connection");
//		}
		

		ATM atm = new ATM();
		System.out.println("we were glad to see you");
		/*
		 * FileReader f = new FileReader(FileName.MANAGER); ArrayList<String>
		 * managerContent = (ArrayList<String>) f.chooseFile();
		 * //System.out.println(managerContent.get(0)); StringTokenizer st =new
		 * StringTokenizer(managerContent.get(0) , ","); String firstName =
		 * st.nextToken(); String lastName = st.nextToken(); String passWord =
		 * st.nextToken(); String id = st.nextToken(); String userName = st.nextToken();
		 * Manager m =Manager.createOneManager(firstName, lastName, passWord,
		 * Long.parseLong(id), userName); System.out.println(m.getFirstName() +" s"+
		 * m.getLastName());
		 */

	}

}
