package bank.schema;

import java.util.Scanner;

public class AccountManager { // 기능
	
	static Scanner sc=new Scanner(System.in);
	
	public void	makeAccount() { //
	System.out.println("계좌 개설");
	System.out.println("*** 신규 계좌 개설 ***");
	System.out.println("----- 계좌 선택 ------");
	
	System.out.println("1. 보통계좌");
	System.out.println("2. 신용신뢰계좌");
	int choice = sc.nextInt();//계좌선택
	System.out.println("선택 : "+choice);
	
	if(choice==1) {//보통계좌 선택시 
		System.out.print("계좌번호 : ");
		String accNum=sc.nextLine();
		
		System.out.print("예금주명 : ");
		String name = sc.nextLine();
		
		System.out.print("잔액 : ");
		int balance = sc.nextInt();
		
		System.out.print("기본이자%(정수형태로 입력) : ");
		int rate = sc.nextInt(); 
		
	}
	else if(choice==2) {//신용신뢰계좌 선택시 
		System.out.print("계좌번호 : ");
		String accNum=sc.nextLine();
		
		System.out.print("예금주명 : ");
		String name = sc.nextLine();
		
		System.out.print("잔액 : ");
		int balance = sc.nextInt();
		
		System.out.print("기본이자%(정수형태로 입력) : ");
		int rate = sc.nextInt(); 
		
		System.out.print("신용등급(A,B,C 등급) : ");
		String input= sc.next();
		char grade = input.charAt(0);
	}
	System.out.println("계좌 개설이 완료 되었습니다.");

	}
	
	public void depositMoney(){
		

	}
	
	public void withdrawMoney(){
		
	}
	
	public void showAccInfo(){
		
	}
	
	
	
	
	
	
}