package bank.schema;

public class HighCreditAccount extends Account { 
	
	public HighCreditAccount(String accNum, String name, int balance) {
		super(accNum, name, balance);
		// TODO Auto-generated constructor stub
	}
//신용신뢰계좌
	private String accNum;  
	private String name;
	private int balance;
	private double rate; // 이자율
	private char creditGrade; //신용등급 
	
	

}
