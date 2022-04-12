package atm;

import java.util.Scanner;

public class Employe extends Person {

	public Employe() {

	}

	public Employe(String firstName, String lastName, String passWord, Long id, String userName) {

		super(firstName, lastName, id, passWord, userName);
		// id include 6 digits
	}

	public void createCustomer() {

		Scanner inputScanner = new Scanner(System.in);
		ATM.increaseCustomer();
		;
		int length = ATM.customer.length - 1;

		System.out.print("\nPlease Enter first name : ");
		String firstName = inputScanner.nextLine();
		System.out.print("\nPlease Enter last name : ");
		String lastName = inputScanner.nextLine();
		System.out.print("\nPlease Enter password : ");
		String passWord = inputScanner.nextLine();

		Long id = null;

		if (length == 0) {
			id = 10000000L;
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

		System.out.print("\nPlease Enter balance : ");
		String balance = inputScanner.nextLine();

		ATM.customer[length] = new Customer(firstName, lastName, passWord, id, userName, Double.parseDouble(balance),
				new String[5]);

		System.out.println("\n\n\n");

		ATM.customer[length].showInformation();

		inputScanner = null;

	}

	public boolean checkUserName(String userName) {

		for (Employe e : ATM.employe) {
			if (e.getUserName().equals(userName)) {
				System.out.println("this username " + userName + " was existed choose another one");
				return true;
			}
		}

		for (Customer c : ATM.customer) {
			if (c.getUserName().equals(userName)) {
				System.out.println("this username " + userName + " was existed choose another one");
				return true;
			}
		}

		return false;
	}

	public void deleteCustomer() {

		Scanner inputScanner = new Scanner(System.in);

		System.out.print("\nEnter id or press 1 to go back : ");
		long id = inputScanner.nextLong();
		if (id == 1)
			return;
		Customer c = findCustomer(id);

		if (c != null) {
			c.setDeleted(true);
		} else {
			System.out.println("\n this id " + id + " not found!!!!");
		}
		System.out.println("\n\n");

	}

	public void updateCustomer() {

		Scanner inputScanner = new Scanner(System.in);

		System.out.print("\nEnter id or press 1 to go back : ");
		String id = inputScanner.nextLine();
		if (id.equals("1"))
			return;
		Customer c = findCustomer(Long.parseLong(id));

		System.out.println("\n\n");

		if (c != null) {

			boolean showable = true;

			while (showable) {

				System.out.println("Enter 1 for change firstName");
				System.out.println("Enter 2 for change lastName");
				System.out.println("Enter 3 for change userName");
				System.out.println("Enter 4 for change password");
				System.out.println("Enter 5 for change password");
				System.out.println("Enter 6 for show information and exit");
				System.out.print("Enter yor input :");
				String choose = inputScanner.nextLine();

				switch (choose) {
				case "1":
					System.out.print("\ncurrent first name is :\'" + c.getFirstName() + "\' change to = ");
					c.setFirstName(inputScanner.nextLine());
					break;
				case "2":
					System.out.print("\ncurrent last name is :\'" + c.getLastName() + "\' change to = ");
					c.setLastName(inputScanner.nextLine());
					break;
				case "3":
					System.out.print("\ncurrent user name is :\'" + c.getUserName() + "\' change to = ");
					c.setUserName(inputScanner.nextLine());
					break;
				case "4":
					System.out.print("\ncurrent password is :\'" + c.getPassWord() + "\' change to = ");
					c.setPassWord(inputScanner.nextLine());
					break;
				case "5":
					System.out.print("\ncurrent balance is :\'" + c.getBalance() + "\' change to = ");
					c.setBalance(Double.parseDouble(inputScanner.nextLine()));
					break;
				case "6":
					c.showInformation();
					return;
				}

			}
		} else {
			System.out.println("\n this id " + id + " not found!!!!");
		}
		System.out.println("\n\n");

	}

	public Customer findCustomer(long id) {

		for (Customer c : ATM.customer) {
			if (c.getId() == id)
				return c;
		}

		return null;

	}

	public void showInformation() {

		System.out.println("First Name : " + this.getFirstName());
		System.out.println("Last Name : " + this.getLastName());
		System.out.println("User Name : " + this.getUserName());
		System.out.println("ID : " + this.getId());
		System.out.println("PassWord : " + this.getPassWord());

		System.out.println("====================================");

	}
}
