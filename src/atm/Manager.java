package atm;

import java.util.Scanner;

public class Manager extends Person {

	private Manager(String firstName, String lastName, String passWord, Long id, String userName) {

		super(firstName, lastName, id, passWord, userName);
		// id include 5 digits
	}

	public static Manager createOneManager(String firstName, String lastName, String passWord, long id,
			String userName) {
		return new Manager(firstName, lastName, passWord, id, userName);
	}

	public void createEmploye() {

		Scanner inputScanner = new Scanner(System.in);
		ATM.increaseEmploye();
		int length = ATM.employe.length - 1;

		System.out.print("\nPlease Enter first name : ");
		String firstName = inputScanner.nextLine();
		System.out.print("\nPlease Enter last name : ");
		String lastName = inputScanner.nextLine();
		System.out.print("\nPlease Enter password : ");
		String passWord = inputScanner.nextLine();

		Long id = null;
		if (length == 0) {
			id = 100000L;
		} else {
			id = ATM.customer[length - 1].getId() + 1;
		}

		boolean exist = true;

		String userName = null;
		while (exist) {

			System.out.print("\nPlease Enter user name : ");
			userName = inputScanner.nextLine();

			exist = checkUserName(userName);

		}

		ATM.employe[length] = new Employe(firstName, lastName, passWord, id, userName);

		System.out.println("\n\n\n");

		ATM.employe[length].showInformation();

		inputScanner = null;

	}

	public boolean checkUserName(String userName) {

		for (Employe e : ATM.employe) {
			if (e.getUserName().equals(userName)) {
				System.out.println("this username " + userName+ " was existed choose another one");
				return true;
			}
		}

		for (Customer c : ATM.customer) {
			if (c.getUserName().equals(userName)) {
				System.out.println("this username " + userName+ " was existed choose another one");
				return true;
			}
		}
		
		return false;
	}

	public void deleteEmploye() {

		Scanner inputScanner = new Scanner(System.in);

		System.out.print("\nEnter id or press 1 to go back : ");
		long id = inputScanner.nextLong();
		if (id == 1)
			return;
		Employe e = findEmploye(id);

		if (e != null) {
			e.setDeleted(true);
		} else {
			System.out.println("\n this id " + id + " not found!!!!");
		}
		System.out.println("\n\n");
	}

	public void updateEmploye() {

		Scanner inputScanner = new Scanner(System.in);

		System.out.print("\nEnter id or press 1 to go back : ");
		String id = inputScanner.nextLine();
		if (id.equals("1"))
			return;
		Employe e = findEmploye(Long.parseLong(id));

		System.out.println("\n\n");

		if (e != null) {

			boolean showable = true;

			while (showable) {

				System.out.println("Enter 1 for change firstName");
				System.out.println("Enter 2 for change lastName");
				System.out.println("Enter 3 for change userName");
				System.out.println("Enter 4 for change password");
				System.out.println("Enter 5 for show information and exit");
				System.out.print("Enter yor input :");
				String choose = inputScanner.nextLine();

				switch (choose) {
				case "1":
					System.out.print("\ncurrent first name is :\'" + e.getFirstName() + "\' change to = ");
					e.setFirstName(inputScanner.nextLine());
					break;
				case "2":
					System.out.print("\ncurrent last name is :\'" + e.getLastName() + "\' change to = ");
					e.setLastName(inputScanner.nextLine());
					break;
				case "3":
					System.out.print("\ncurrent user name is :\'" + e.getUserName() + "\' change to = ");
					e.setUserName(inputScanner.nextLine());
					break;
				case "4":
					System.out.print("\ncurrent password is :\'" + e.getPassWord() + "\' change to = ");
					e.setPassWord(inputScanner.nextLine());
					break;
				case "5":
					e.showInformation();
					return;
				}

			}
		} else {
			System.out.println("\n this id " + id + " not found!!!!");
		}
		System.out.println("\n\n");

	}

	public Employe findEmploye(long id) {

		for (Employe e : ATM.employe) {
			if (e.getId() == id)
				return e;
		}

		return null;

	}

	@Override
	public void setFirstName(String firstName) {
		System.out.println("You cant Change FirstName to : " + firstName);
	}

	@Override
	public void setLastName(String lastName) {
		System.out.println("You cant Change LastName to : " + lastName);
	}

	@Override
	public void setPassWord(String passWord) {
		System.out.println("You cant Change PassWord to : " + passWord);
	}

	@Override
	public void setId(long id) {
		System.out.println("You cant Change ID to : " + id);
	}

	@Override
	public void setUserName(String userName) {
		System.out.println("You cant Change UserName to : " + userName);
	}
}
