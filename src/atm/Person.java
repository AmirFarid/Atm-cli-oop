package atm;

public abstract class Person {

	private String firstName;
	private String lastName;
	private Long id;
	private String passWord;
	private String userName;
	private boolean isDeleted;
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName,Long id , String passWord ,String userName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.passWord = passWord;
		this.userName = userName;
		this.isDeleted = false;
		
	}
	
	
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
