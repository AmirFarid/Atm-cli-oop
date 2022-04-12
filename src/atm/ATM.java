package atm;

import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ATM {

	static Manager manager;
	static Employe[] employe;
	static Customer[] customer;

	public ATM() {

		bootStarp();

		while (logIn())

			shotDown();
	}

	// Load all states from file
	private void bootStarp() {
		// Load manager state
		FileReader managerReader = new FileReader(FileName.MANAGER);
		List<String> managerContent = managerReader.chooseFile();
		loadManager(managerContent);
		managerReader = null;
		managerContent = null;

		// Load employee state
		FileReader employeReader = new FileReader(FileName.EMPLOYE);
		List<String> employeContent = employeReader.chooseFile();
		loadEmploye(employeContent);
		employeReader = null;
		employeContent = null;

		// Load customer state

		FileReader customerReader = new FileReader(FileName.CUSTOMER);
		List<String> customerContent = customerReader.chooseFile();
		loadCustomer(customerContent);
		customerReader = null;
		customerContent = null;

	}

	private void loadManager(List<String> managers) {
		StringTokenizer tokenizer = new StringTokenizer(managers.get(0), ",");
		String firstName = tokenizer.nextToken();
		String lastName = tokenizer.nextToken();
		String passWord = tokenizer.nextToken();
		String id = tokenizer.nextToken();
		String userName = tokenizer.nextToken();
		System.out.println(userName);
		manager = Manager.createOneManager(firstName, lastName, passWord, Long.parseLong(id), userName);
	}

	private void loadEmploye(List<String> employes) {
		this.employe = new Employe[employes.size()];

		for (int i = 0; i < employes.size(); i++) {
			StringTokenizer tokenizer = new StringTokenizer(employes.get(i), ",");
			String firstName = tokenizer.nextToken();
			String lastName = tokenizer.nextToken();
			String passWord = tokenizer.nextToken();
			String id = tokenizer.nextToken();
			String userName = tokenizer.nextToken();
			System.out.println(userName);
			this.employe[i] = new Employe(firstName, lastName, passWord, Long.parseLong(id), userName);
		}
	}

	private void loadCustomer(List<String> customers) {

		this.customer = new Customer[customers.size()];

		for (int i = 0; i < customers.size(); i++) {
			StringTokenizer tokenizer = new StringTokenizer(customers.get(i), ",");
			String firstName = tokenizer.nextToken();
			String lastName = tokenizer.nextToken();
			String passWord = tokenizer.nextToken();
			String id = tokenizer.nextToken();
			String userName = tokenizer.nextToken();
			String balance = tokenizer.nextToken();
			int j = 0;
			String[] lastFiveAccountStatement = new String[5];
			while (tokenizer.hasMoreElements()) {
				lastFiveAccountStatement[j] = tokenizer.nextToken();
				if (i == 4)
					break;
				j++;
			}
			this.customer[i] = new Customer(firstName, lastName, passWord, Long.parseLong(id), userName,
					Double.parseDouble(balance), lastFiveAccountStatement);
		}
	}

	private boolean logIn() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("### Welcome To the ATM App ###");
		System.out.println("Press 1 or press anykey for continue menu");
		System.out.println("Press 2 for exit entier app");
		System.out.print("Enter Input : ");
		String condition = scanner.nextLine();

		switch (condition) {
		case "1":
			break;
		case "2":
			return false;
		default:
			break;
		}
		System.out.println();
		System.out.println();
		System.out.print("\nEnter your username or ID : ");
		String identifier = scanner.nextLine();
		System.out.print("\nEnter your password : ");
		String password = scanner.nextLine();
		System.out.println();
		System.out.println();
		authorization(identifier, password);
		return true;
	}

	private void authorization(String identifier, String password) {

		int length = identifier.length();
		if ((length == 5 && identifier.equals(manager.getId().toString()))
				|| manager.getUserName().equals(identifier)) {
			if (password.equals(manager.getPassWord()))
				managerMenu();
			return;
		} else if (length > 0) {
			for (Employe e : employe) {
				if ((identifier.equals(e.getId().toString()) || e.getUserName().equals(identifier))
						&& password.equals(e.getPassWord())) {
					employeMenu(e);
					return;
				}
			}

			for (Customer c : customer) {
				if ((identifier.equals(c.getUserName()) || identifier.equals(c.getId().toString()))
						&& password.equals(c.getPassWord())) {
					customerMenu(c);
					return;
				}
			}
		}
	}

	private void managerMenu() {
		boolean showable = true;
		Scanner scanner = new Scanner(System.in);
		while (showable) {
			System.out.println("Welcome" + " " + manager.getFirstName() + " " + manager.getLastName());
			System.out.println("Press 1 to create employe");
			System.out.println("press 2 to update employe");
			System.out.println("press 3 to delete employe");
			System.out.println("press 4 to go to the employe menu");
			System.out.println("press 5 to exit");
			System.out.print("Enter Input : ");
			String input = scanner.nextLine();
			switch (input) {
			case "1":
				manager.createEmploye();
				break;
			case "2":
				manager.updateEmploye();
				break;
			case "3":
				manager.deleteEmploye();
				break;
			case "4":
				Employe e = new Employe();
				e.setFirstName("manager");
				employeMenu(e);
				break;
			case "5":
				showable = false;
				break;

			default:
				break;
			}
			System.out.println("\n\n\n");

		}
		scanner = null;
	}

	private void employeMenu(Employe e) {
		boolean showable = true;
		Scanner scanner = new Scanner(System.in);
		while (showable) {
			System.out.println("Welcome" + " " + e.getFirstName() + " " + e.getLastName());
			System.out.println("Press 1 to create customer");
			System.out.println("press 2 to update customer");
			System.out.println("press 3 to delete customer");
			System.out.println("press 4 to exit");
			System.out.print("Enter Input : ");
			String input = scanner.nextLine();
			switch (input) {
			case "1":
				e.createCustomer();
				break;
			case "2":
				e.updateCustomer();
				break;
			case "3":
				e.deleteCustomer();
				break;
			case "4":
				showable = false;
				break;

			default:
				break;
			}
			System.out.println("\n\n\n");

		}
		scanner = null;
	}

	private void customerMenu(Customer c) {
		boolean showable = true;
		Scanner scanner = new Scanner(System.in);
		while (showable) {
			System.out.println("Welcome" + " " + c.getFirstName() + " " + c.getLastName());
			System.out.println("Press 1 to deposit money");
			System.out.println("press 2 to withdraw money");
			System.out.println("press 3 to show balance");
			System.out.println("press 4 to show last five statement");
			System.out.println("press 5 to exit");
			System.out.print("Enter Input : ");
			String input = scanner.nextLine();
			switch (input) {
			case "1":
				c.depositMoney();
				break;
			case "2":
				c.withdrawMoney();
				break;
			case "3":
				c.showBalance();
				break;
			case "4":
				c.showTheLastFiveAccountStatement();
				break;
			case "5":
				showable = false;
				break;

			default:
				break;
			}
			System.out.println("\n\n\n");

		}
		scanner = null;
	}

	// Save all states in file
	private void shotDown() {

		FileWriter writer = new FileWriter();
		
		writer.saveStates();
	}

	public static void increaseEmploye() {
		
		int length = employe.length;
		Employe[] tmp = new Employe[length];
		
		
		for(int i = 0 ; i < length; i++) {
			tmp[i] = employe[i];
		}
		
		employe = new Employe[length +1];
		
		for(int i = 0 ; i < length; i++) {
			employe[i] = tmp[i] ;
		}
		
	}
	
public static void increaseCustomer() {
		
		int length = customer.length;
		Customer[] tmp = new Customer[length];
		
		
		for(int i = 0 ; i < length; i++) {
			tmp[i] = customer[i];
		}
		
		customer = new Customer[length +1];
		
		for(int i = 0 ; i < length; i++) {
			customer[i] = tmp[i] ;
		}
		
	}

}
