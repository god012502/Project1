package bank.schema;

import java.util.InputMismatchException;
import java.util.Scanner;
public class AccountManager { // 기능
	
	//개설된 계좌정보 카운트용 변수
	static Account[] accounts = new Account[50];//계좌정보 저장을 위한 인스턴스 배열
	static int accCnt=0;
	 //새로운 객체를 배열에 추가하고 accCnt를 1증가
	
	static Scanner sc=new Scanner(System.in);
	
	public static void	makeAccount() { //계좌개설
		System.out.println("*** 신규 계좌 개설 ***");
		System.out.println("----- 계좌 선택 ------");
		
		System.out.println("1. 보통계좌");
		System.out.println("2. 신용신뢰계좌");
		System.out.print("선택 : ");
		int choice = sc.nextInt();//계좌선택		
		sc.nextLine();
		
		if(choice==1) {//보통계좌 선택시 
			System.out.print("계좌번호 : \n");
			String accNum=sc.nextLine();
			
			System.out.println("예금주명 : ");
			String name = sc.nextLine();
			
			System.out.print("잔액 : ");
			int balance = sc.nextInt();
			sc.nextLine();
			System.out.print("기본이자%(정수형태로 입력) : ");
			
			int rate = sc.nextInt(); 
			sc.nextLine();
			
			NormalAccount ac = new NormalAccount(accNum,name,balance,rate);
			// NormalAccount 타입의 객체를 생성합니다.
			// 생성자 매개변수로는 계좌번호(accNum), 예금주 이름(name), 초기 잔액(balance), 이자율(rate)을 전달합니다.
			// 이 생성자는 아마도 부모 클래스(Account)를 상속받은 자식 클래스(NormalAccount)의 생성자일 것입니다.
			
			accounts[accCnt++] = ac;
			// 생성한 계좌 객체(ac)를 accounts 배열에 저장합니다.
			// accounts는 여러 개의 계좌를 저장하는 배열이며, accCnt는 현재까지 생성된 계좌 수를 나타내는 변수입니다.
			// 계좌를 배열에 저장한 뒤, accCnt 값을 1 증가시켜 다음 계좌가 들어갈 위치를 준비합니다.
		}
		else if(choice==2) {//신용신뢰계좌 선택시 
			System.out.print("계좌번호 : ");
			String accNum=sc.nextLine();
			
			System.out.print("예금주명 : ");
			String name = sc.nextLine();
			
			System.out.print("잔액 : ");
			int balance = sc.nextInt();
			sc.nextLine();
			System.out.print("기본이자%(정수형태로 입력) : ");
			int rate = sc.nextInt(); 
			sc.nextLine();
			System.out.print("신용등급(A,B,C 등급) : ");
			String input= sc.next();
			char grade = input.charAt(0);
			sc.nextLine();
			HighCreditAccount ac = new HighCreditAccount(accNum,name,balance,rate, grade);
			// 이 클래스는 아마도 NormalAccount를 상속받아 신용등급별 추가 이자를 적용하는 기능이 들어 있을 것입니다.
			accounts[accCnt++] = ac;
		}
		System.out.println("계좌 개설이 완료 되었습니다.");
	}
	
	public static void depositMoney(){ // 입금 계좌선택시 
		System.out.print("계좌번호 : ");
		String accNum=sc.nextLine();

		try {
		System.out.println("입금을 해주세요!!");
		int balance=sc.nextInt();
		sc.nextLine();
		//2.1 음수입력 예외처리(if문)
		if(balance<0) {//입금액이 0원보다 작다면
			System.out.println("음수는 입금할 수 없습니다.");
			return;
		}
		//2.3. 입금단위(500원) 예외처리
		if(balance % 500 != 0) {
			System.out.println("입금 금액은 500원 단위로만 가능합니다.");
			return;
		}
		
		for(int i=0; i<accCnt; i++) {
			if(accNum.compareTo(accounts[i].getAccNum())==0) {	
			  	// accNum과 accounts[i]에 저장된 계좌번호가 같은지 비교한다
				// compareTo()는 두 문자열이 같으면 0을 반환한다
				// 즉, 두 계좌번호가 같을 때 조건문 안의 코드가 실행된다
			 
				if(accounts[i] instanceof NormalAccount) {
					// accounts[i]가 NormalAccount 타입인지 확인한다
					// 즉, 현재 계좌가 일반 계좌(NormalAccount)인지 검사한다
					int money = ((NormalAccount)accounts[i]).plus(balance);
					((NormalAccount)accounts[i]).setBalance(money);
					// accounts[i]를 NormalAccount 타입으로 형변환(casting)한 후
				    // 그 계좌에 balance만큼 금액을 더한다 (입금 또는 적립)
				}
				else if(accounts[i] instanceof HighCreditAccount) {
					// HighCreditAccount 타입으로 바꿔서, 입금(balance)하고 
					// 이자나 보너스까지 계산된 '최종 금액'을 받아온다
					int money = ((HighCreditAccount)accounts[i]).plus(balance);
					// 방금 계산한 '최종 금액'을 계좌 잔액으로 저장한다 (잔액을 업데이트한다)
					((HighCreditAccount)accounts[i]).setBalance(money);
				}
			}
		}
		}
		
		//2.2 문자입력 예외처리
		catch(InputMismatchException e) {
		//문자나 특수문자를 입력한 경우
			System.out.println("숫자만 입력 가능합니다.");
			sc.nextLine();
		}
		}

	public static void withdrawMoney(){ // 출금계좌선택시
		System.out.print("계좌번호 : ");
		String accNum=sc.nextLine();
		
		System.out.println("출금을 해주세요!!");
	
		int amount=sc.nextInt();
		sc.nextLine();
		
		//3.1 음수입력 예외처리(if문)
		if(amount<0) {//출금액이 0원보다 작다면
			System.out.println("음수는 입금할 수 없습니다.");
			return;
		}
		//3.2. 입금단위(500원) 예외처리
		if(amount % 1000 != 0) {
			System.out.println("출금 금액은 1000원 단위로만 가능합니다.");
			return;
		}
		
		for(int i=0; i<accCnt; i++) {
			
			if(accNum.compareTo(accounts[i].getAccNum())==0) {
		  	// accNum과 accounts[i]에 저장된 계좌번호가 같은지 비교한다
			// compareTo()는 두 문자열이 같으면 0을 반환한다
			// 즉, 두 계좌번호가 같을 때 조건문 안의 코드가 실행된다
			}
			else if(accounts[i].getBalance() - amount >= accounts[i].getBalance()) {//정상출금
				int money = accounts[i].getBalance()-amount;
				// i번째 계좌의 현재 잔액에서 출금할 금액(amount)을 뺀 값을 money 변수에 저장
				accounts[i].setBalance(money);
				System.out.println("정상 출금 되었습니다.");
				System.out.println();
				}
				//전액 출금 처리
			else if(accounts[i].getBalance() - amount >= 0) {//전액출금
				int money = accounts[i].getBalance()-amount;
				// i번째 계좌의 현재 잔액에서 출금할 금액(amount)을 뺀 값을 money 변수에 저장
				accounts[i].setBalance(money);
				// 계산된 잔액(money)을 i번째 계좌의 잔액으로 다시 설정
				System.out.println("YES : 금액 전체 출금처리");
				System.out.println(accounts[i].getBalance()+"원을 출금합니다.");
			}	
			else if(accounts[i].getBalance() - amount < 0) {// 3.2. 출금 요청 취소
				System.out.println("NO : 출금 요청 취소");	 
			}
		}	
	}
		
	public static void showAccInfo(){//전체계좌정보
		for(int i=0; i<accCnt; i++) {
			//toString을 오버라이딩 했으므로 인스턴스를 그대로 출력
			System.out.println(accounts[i]);
		}//for문 종료
		System.out.println("*** 전체 계좌 정보가 출력됨  ***");
	}	
}