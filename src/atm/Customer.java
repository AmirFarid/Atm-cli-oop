package atm;

import java.util.Scanner;

public class Customer extends Person {

	private double balance;
	private String[] lastFiveAccountStatement;

	public Customer(String firstName, String lastName, String passWord, Long id, String userName, double balance,
			String[] lastFiveAccountStatement) {

		super(firstName, lastName, id, passWord, userName);
		// id include 10 digits
		this.balance = balance;
		this.lastFiveAccountStatement = lastFiveAccountStatement;
	}

	// واريز وجه
	public void depositMoney() {

		Scanner scanner = new Scanner(System.in);

		System.out.print("\nplease Enter how much you want to deposit : ");
		String money = scanner.nextLine();
		balance += Double.parseDouble(money);
		addStatement(money, "+");
		System.out.println(" you deposit " + money + "$");
		showBalance();

	}

	// برداشت وجه
	public void withdrawMoney() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nplease Enter how much you want to deposit : ");
		String money = scanner.nextLine();
		double dmoney = Double.parseDouble(money);
		if (balance > dmoney) {
			balance -= dmoney;
			addStatement(money, "-");
			System.out.println("you withdrw " + money + "$");
			showBalance();
		} else {
			System.out.println("you have not enough money");
		}
	}

	// نمايش موجودي
	public void showBalance() {

		System.out.println("============Your Balance is============");
		System.out.println("              " + balance + "$  ");
		System.out.println("=======================================");
	}

	// پنج گردش اخر
	public void showTheLastFiveAccountStatement() {

		System.out.println("======Last Five Account Statement======");
		int i = 0;
		for (String s : lastFiveAccountStatement) {
			System.out.println("      " + i+1 + "-    " + s+"$");
			i++;
		}
		System.out.println("=======================================");
	}

	public void addStatement(String money, String sign) {

		for (int i = 0; i < lastFiveAccountStatement.length; i++) {
			if (lastFiveAccountStatement[i] == null) {
				lastFiveAccountStatement[i] = new String(sign + money);
				return;
			}
		}
		for (int i = lastFiveAccountStatement.length - 1; i >= 0; i--) {

			if (i == 0) {
				lastFiveAccountStatement[i] = new String(sign + money);
				return;
			}

			lastFiveAccountStatement[i] = lastFiveAccountStatement[i - 1];
		}
	}

	public void showInformation() {

		System.out.println("First Name : " + this.getFirstName());
		System.out.println("Last Name : " + this.getLastName());
		System.out.println("User Name : " + this.getUserName());
		System.out.println("ID : " + this.getId());
		System.out.println("PassWord : " + this.getPassWord());
		showBalance();
		showTheLastFiveAccountStatement();
		
		System.out.println("====================================");
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String[] getLastFiveAccountStatement() {
		String[] tmp = lastFiveAccountStatement;
		return tmp;
	}

}
