package atm;

public enum FileName {
		MANAGER("..\\Manager.txt"), 
		EMPLOYE("..\\Employe.txt"), 
		CUSTOMER("..\\Customer.txt");

	private final String fileName;
	
	FileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		return fileName;
	}
}
