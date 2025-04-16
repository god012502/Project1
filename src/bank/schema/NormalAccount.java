package bank.schema;

public class NormalAccount extends Account { //보통계좌 개설

	private double rate;
	
	//생성자 - 이자율까지 초기화
	public NormalAccount(String accNum, String name, 
			int balance, double rate) 
	{
		super(accNum, name, balance);
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	@Override
		public String toString() {
			return super.toString()+"이자율="+rate;
		}
	
	@Override
		public int plus(int money) {
			return super.plus(money)+(int)(super.getBalance()*rate);
		}

}


