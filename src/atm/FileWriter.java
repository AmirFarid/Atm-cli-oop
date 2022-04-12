package atm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileWriter {

	public FileWriter() {

	}

	public void saveStates() {

		// save employee states
		StringBuilder[] row = new StringBuilder[ATM.employe.length];
		int i = 0;

		for (Employe e : ATM.employe) {
			
			if(e.isDeleted()) {
				continue;
			}
			
			row[i] = new StringBuilder();
			row[i].append(e.getFirstName() + ",");
			row[i].append(e.getLastName() + ",");
			row[i].append(e.getPassWord() + ",");
			row[i].append(e.getId().toString() + ",");
			row[i].append(e.getUserName() + ",");
			i++;
		}
		save(row, FileName.EMPLOYE);
		
		row = new StringBuilder[ATM.customer.length];
		i = 0;
		for (Customer c : ATM.customer) {
			
			if(c.isDeleted()) {
				continue;
			}
			
			row[i] = new StringBuilder();
			row[i].append(c.getFirstName() + ",");
			row[i].append(c.getLastName() + ",");
			row[i].append(c.getPassWord() + ",");
			row[i].append(c.getId().toString() + ",");
			row[i].append(c.getUserName() + ",");
			row[i].append(c.getBalance() + ",");
			for (String statemnt : c.getLastFiveAccountStatement()) {
				row[i].append(statemnt + ",");
			}
			i++;
		}
		save(row, FileName.CUSTOMER);

	}

	private void save(StringBuilder[] rows , FileName f) {
		
		try {
			
			File file = new File(f.toString());
			java.io.FileWriter fileWriter = new java.io.FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for (int i = 0 ; i<rows.length ; i++) {
				if(rows[i] == null)
					continue;
				bufferedWriter.write(rows[i].toString());
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("file" + f.toString() + "not found");
		}catch(IOException e) {
			System.out.println("error with connection");
		}
	}

}
