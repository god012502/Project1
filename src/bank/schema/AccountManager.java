package bank.schema;

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
			NormalAccount ac = new NormalAccount(accNum,name,balance,rate);//계좌정보
			accounts[accCnt++] = ac;
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
			HighCreditAccount ac = new HighCreditAccount(accNum,name,balance,
													rate, grade);//계좌정보
			accounts[accCnt++] = ac;
			
		}
		System.out.println("계좌 개설이 완료 되었습니다.");

	}
	
	public static void depositMoney(){ // 입금 계좌선택시 
		System.out.print("계좌번호 : ");
		String accNum=sc.nextLine();

		System.out.println("입금을 해주세요!!");
		int balance=sc.nextInt();
		
		sc.nextLine();
		
		for(int i=0; i<accCnt; i++) {
			if(accNum.compareTo(accounts[i].getAccNum())==0) {
				/*
			  	// accNum과 accounts[i]에 저장된 계좌번호가 같은지 비교한다
				// compareTo()는 두 문자열이 같으면 0을 반환한다
				// 즉, 두 계좌번호가 같을 때 조건문 안의 코드가 실행된다
			 */	
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
	public static void withdrawMoney(){ // 출금계좌선택시
		System.out.print("계좌번호 : ");
		String accNum=sc.nextLine();
		
		System.out.println("출금을 해주세요!!");
		int amount=sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<accCnt; i++) {
			if(accNum.compareTo(accounts[i].getAccNum())==0) {
				/*
			  	// accNum과 accounts[i]에 저장된 계좌번호가 같은지 비교한다
				// compareTo()는 두 문자열이 같으면 0을 반환한다
				// 즉, 두 계좌번호가 같을 때 조건문 안의 코드가 실행된다
			 */	
				int money = accounts[i].getBalance()-amount;
				accounts[i].setBalance(money);
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