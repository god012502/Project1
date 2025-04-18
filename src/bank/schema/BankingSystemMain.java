package bank.schema;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {
	//키보드 입력을 위한 인스턴스 
	static Scanner sc=new Scanner(System.in);
	public static void menushow() { //메뉴선택
		System.out.println("==================Menu===================================");
		System.out.print("1. 계좌개설 ");
		System.out.print("2. 입금 ");
		System.out.print("3. 출금 ");
		System.out.print("4. 전체계좌정보출력 ");
		System.out.println("5. 프로그램종료");
		System.out.println("=========================================================");
	}
	   
	public static void main(String[] args) {
		while(true) {
		//메뉴 출력
		try {
		menushow();
		System.out.print("메뉴 선택 : ");
		int key = sc.nextInt();
		sc.nextLine(); //버퍼에 남은 엔터키 제거
			switch(key) { //1~5번까지 case 생성. 값에 따른 switch 조건문
				case ICustomDefine.MAKE://인터페이스 호출
					//계좌개설
					System.out.println("계좌개설");
					AccountManager.makeAccount();
					break;
				case ICustomDefine.DEPOSIT:
					//입금
					System.out.println("입 금");
					AccountManager.depositMoney();
					break;
				case ICustomDefine.WITHDRAW:
					//출금
					System.out.println("출 금");
					AccountManager.withdrawMoney();
					break;
				case ICustomDefine.INQUIRE:
					//계좌정보 출력
					System.out.println("계좌정보 출력");
					AccountManager.showAccInfo();
					break;
				case ICustomDefine.EXIT:
					//프로그램 종료
					System.out.println("프로그램 종료");
					System.exit(0);//정상적으로 종료 (0)은 정상종료를 의미
				default:
					MenuSelectException.exception1();
			}// switch 끝
		}//try문 끝 
		catch(InputMismatchException e){
		//문자나 특수문자를 입력한 경우
			System.out.println("숫자만 입력 가능합니다.");
			sc.nextLine();
		}	
	}
}//Main 끝
}//클래스 끝
