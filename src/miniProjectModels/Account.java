package miniProjectModels;

public class Account {
	private int a_id;
	private int account_no;
	private String first_name;
	private String last_name;
	private double balance;


	// constructor to create new account
	public Account(int account_no,String first_name, String last_name) {
		super();
		this.account_no = account_no;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	// constructor called when only account number available
	public Account(int account_no) {
		super();
		this.account_no = account_no;
	}
	
	//Display method
	
	
	//----------------Getter and Setters --------------------
	
	public int getA_id() {
		return a_id;
	}

	@Override
	public String toString() {
		return "Account [account_no=" + account_no + ", first_name=" + first_name + ", last_name="
				+ last_name + ", balance=" + balance + "]";
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public long getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//-----------------------------------------------------------

}
