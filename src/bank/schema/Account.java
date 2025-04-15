package bank.schema;

public class Account {//Nomal, high 클래스의 부모

//	계좌번호(String형), 이름(String형), 잔액(int형) 
	private String accNum; 
	private String name;
	private int balance;
	//생성자
	public Account(String accNum, String name, int balance) {
		super();
		this.accNum = accNum; //계좌번호
		this.name = name; //예금주
		this.balance = balance; //잔액
	}
	
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	//toString 
		@Override
		public String toString() {
			return "Account [계좌번호=" + accNum + ", 이름 =" + name + ", 잔고=" + balance + "]";
		}
}
