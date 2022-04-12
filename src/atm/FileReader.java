package atm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

	private Object fileName;

	public FileReader(FileName fileName) {
		this.fileName = fileName;
	}

	public FileReader(String fileName) {
		this.fileName = fileName;
	}

	public List<String> chooseFile() {

		if (fileName instanceof FileName) {
			FileName findName = (FileName) fileName;
			switch (findName) {
			case MANAGER:
				return readFile(FileName.MANAGER);
			case CUSTOMER:
				return readFile(FileName.CUSTOMER);
			case EMPLOYE:
				return readFile(FileName.EMPLOYE);
			}
		} else {
			String findName = (String) fileName;

			switch (findName.toLowerCase()) {
			case "manager":
			case "manager.txt":
				return readFile(FileName.MANAGER);
			case "employe":
			case "employe.txt":
				return readFile(FileName.EMPLOYE);
			case "customer":
			case "customer.txt":
				return readFile(FileName.CUSTOMER);

			}
		}
		return null;

	}
	
	
	private List<String> readFile(FileName fileName) {
		
		List<String> fileContent = new ArrayList<String>();
		
		try {
			File file = new File(fileName.toString());
			//my class name is FileReader 
			java.io.FileReader fileReader = new java.io.FileReader(file);
			BufferedReader bufferedReader  = new BufferedReader(fileReader);
			String line = null;
			while((line = bufferedReader.readLine())!=null) {
				fileContent.add(line);
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		return fileContent;
		
	}

}
