package bank.schema;
import java.util.Scanner;

public class BankingSystemMain {
	//키보드 입력을 위한 인스턴스 
	static Scanner sc=new Scanner(System.in);
	//계좌정보 저장을 위한 인스턴스 배열
	static Account[] accounts = new Account[50];
	//개설된 계자정보 카운트용 변수
	static int accCnt=0;
	static int amount=0;
	
	public static void menushow() { //메뉴선택
		System.out.println("==================Menu==================");
		System.out.print("1. 계좌개설 ");
		System.out.print("2. 입금 ");
		System.out.print("3. 출금 ");
		System.out.print("4. 전체계좌정보출력 ");
		System.out.println("5. 프로그램종료");
		System.out.println("========================================");
	}
	   
	public static void makeAccount(){// 계좌개설을 위한 함수
		System.out.print("계좌번호 :");
		String a = sc.nextLine();
		
		System.out.print("이름 :");
		String n = sc.nextLine();
		
		System.out.print("잔고 :");
		int b = sc.nextInt();
		
		//신규계좌 생성 및 추가
		Account ac = new Account(a, n, b); //매개변수 a,n,b를 이용해 객체를 생성. ac변수에 저장
		accounts[accCnt++] = ac; //새로운 객체를 배열에 추가하고 accCnt를 1증가
		System.out.println("신규계좌 개설 완료되었습니다.");
	}

	public static void depositMoney(){// 입금
		System.out.println("입금을 해주세요!!");
		int balance=sc.nextInt();
		
		if(balance>0) {
			System.out.print("입금한 금액:"+balance);
			
			System.out.println("\n현재 잔액은 "+balance+"원 입니다.");
		}//if문종료
		else {
			System.out.println("0보다 큰 금액을 입금시켜 주세요!!!");
		}//else 종료	
		System.out.println("최종잔액은 "+balance+"입니다.");
		balance += amount;
	}//depositMoney 종료
		
	public static void withdrawMoney(){// 출금
		int amount=sc.nextInt();
		System.out.print("현재잔액은 "+amount+"원 입니다");
		
		int balance = sc.nextInt();
		System.out.println("출금할 금액은 "+balance+"원 입니다");
		
		if(balance>0 && balance<=amount) { // 출금금액이 0보다 큰지, 내 잔액보다 작거나 같은지
			amount -= balance; //잔액에서 출금액을 뺀
			System.out.println(balance+"원이 출금되었습니다.");
			
		}//if문종료
		else {
			System.out.println("출금 할 수 없습니다. 잔액이 부족하거나 금액이 잘못되었습니다.");
		}//else 종료
		System.out.println("최종잔액 :"+balance+"원이 있습니다.");
	}//withdrawMoney 종료
	
	public static void showAccInfo(){// 전체계좌정보출력
		for(int i=0; i<accCnt; i++) {
			//toString을 오버라이딩 했으므로 인스턴스를 그대로 출력
			System.out.println(accounts[i]);
		}//for문 종료
		System.out.println("*** 전체 계좌 정보가 출력됨  ***");
	} //showAccInfo 종료
	
	
	
	
	public static void main(String[] args) {
		while(true) {
		//메뉴 출력
		menushow();
		System.out.print("메뉴 선택 : ");
		int key = sc.nextInt();
		
		sc.nextLine(); //버퍼에 남은 엔터키 제거
		switch(key) { //1~5번까지 case 생성. 값에 따른 switch 조건문
		
		case ICustomDefine.MAKE://인터페이스 호출
			//계좌개설
			
			break;
		case ICustomDefine.DEPOSIT:
			//입금
			System.out.println("입 금");
			depositMoney();
			break;
		case ICustomDefine.WITHDRAW:
			//출금
			System.out.println("출 금");
			withdrawMoney();
			break;
		case ICustomDefine.INQUIRE:
			//계좌정보 출력
			System.out.println("계좌정보 출력");
			showAccInfo();
			break;
		case ICustomDefine.EXIT:
			//프로그램 종료
			System.out.println("프로그램 종료");
			System.exit(0);//정상적으로 종료 (0)은 정상종료를 의미
		} // switch 끝
		}//while문 끝
	}//Main 끝
}//클래스 끝
