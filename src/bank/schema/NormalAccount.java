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
	// money만큼 입금하고, 이자까지 더해서 최종 결과를 반환하는 메서드
	return super.plus(money)+(int)(super.getBalance()*rate);
	// 부모 클래스의 plus() 메서드를 호출해서 money만큼 입금하고,
	// 그 후 잔액에 기본 이자(rate)를 계산해서 정수로 바꾼 뒤 더해서 반환
	}
}


