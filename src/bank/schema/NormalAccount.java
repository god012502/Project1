package bank.schema;

public class NormalAccount extends Account { //보통계좌 개설

	private String accNum;  
	private String name;
	private int balance;
	private double rate;
	
	//생성자 - 이자율까지 초기화
	public NormalAccount(String accNum, String name, int balance, String accNum2, 
			String name2, int balance2,double rate) {
		super(accNum, name, balance);
		accNum = accNum2;
		name = name2;
		balance = balance2;
		this.rate = rate;
	}
	
	

}


