package bank.schema;

public class HighCreditAccount extends Account { 
	
	
//신용신뢰계좌
	private double rate; // 이자율
	private char creditGrade; //신용등급 
	
//	생성자
	public HighCreditAccount(String accNum, String name, int balance, 
			double rate, char creditGrade) {
		super(accNum, name, balance);
		this.rate = rate;
		this.creditGrade = creditGrade;
	}
	
//	getter, setter 생성
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public char getCreditGrade() {
		return creditGrade;
	}

	public void setCreditGrade(char creditGrade) {
		this.creditGrade = creditGrade;
	}

	@Override
		public String toString() {
			return super.toString()+"이자율 = "+rate+", 신용등급 = "+creditGrade;
		}
	
	@Override
	public int plus(int money) {
		if("A".equals(creditGrade)) {
			return super.plus(money)+(int)((super.getBalance()*rate)+(super.getBalance()*0.07));
			// 부모 클래스의 plus() 메서드로 돈을 입금하고,
			// 기본 이자(rate)와 추가 이자(7%)를 계산해서 더한 뒤, 그 값을 반환해요
		}
		else if("B".equals(creditGrade)) {
		return super.plus(money)+(int)((super.getBalance()*rate)+(super.getBalance()*0.04));
		// 입금하고, 기본 이자 + 4% 보너스 이자를 더해서 반환
		}
		else if("C".equals(creditGrade)) {
		return super.plus(money)+(int)((super.getBalance()*rate)+(super.getBalance()*0.02));
		// 입금하고, 기본 이자 + 2% 보너스 이자를 더해서 반환
		}
		else {
		System.out.println("잘못된 등급입니다.");
		return 0;
		}
	}
}
