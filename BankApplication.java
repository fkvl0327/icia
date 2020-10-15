package selfstudy;

import java.util.Scanner;

//6장 20번
//참고: https://wooaoe.tistory.com/11
public class BankApplication {

	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// while 반복을 위해 boolean 값을 정하고 이름을 run이라고 한다
		// run은 프로그램 실행 시 true이고 종료할 때에만 false가 되게 한다
		boolean run = true;
		// while(true){}: sel 값에 따라 if문을 진행하고 계속 다시 메뉴로 돌아온다
		while (run) {
			System.out.println("--------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("--------------------------------------------------");
			System.out.print("선택> ");

			// 입력받는 정수 값을 sel이라고 하겠다
			int sel = sc.nextInt();

			if (sel == 1) {
				createAccount();
			} else if (sel == 2) {
				accountList();
			} else if (sel == 3) {
				deposit();
			} else if (sel == 4) {
				withdraw();
			} else if (sel == 5) {
				// boolean run 값을 false라고 하면 while 반복이 종료되어 프로그램이 종료된다
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

	// 계좌생성
	private static void createAccount() {
		System.out.println("---------");
		System.out.println("계좌생성");
		System.out.println("---------");
		Account a = new Account(null, null, 0);
		System.out.print("계좌번호: ");
		a.setAno(sc.next());
		System.out.print("계좌주: ");
		a.setOwner(sc.next());
		System.out.print("초기입금액: ");
		a.setBalance(sc.nextInt());

		// accountArray.length 길이만큼 계좌가 생성된다
		// if문: accountArray[0]이 null이라면(값을 입력한 적이 없으므로 실행시점에 null이다)
		// 배열의 [0]번째 원소로 a를 입력하고 계좌 생성 문구를 출력한다
		// 출력 후 break;이므로 배열에 1회 입력, 문구 1회 출력 후 메뉴로 돌아간다
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = a;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		}
	}

	// 계좌목록보기
	private static void accountList() {
		System.out.println("---------");
		System.out.println("계좌목록");
		System.out.println("---------");

		// accountArray.length 길이만큼 i를 반복한다
		// accountArray의 i번째 원소가 null이 아니면(앞서 생성했다면 [0]의 값이 null이 아니다)
		// instance i의 ano, owner, balance값을 출력한다
		// accountArray[0] 외에는 null이므로 1회만 출력 후 메뉴로 돌아간다
		// 실행 후 계좌생성을 하지 않았다면 모든 값이 null이므로 바로 메뉴로 돌아간다
		for (int i = 0; i < accountArray.length; i++) {
			Account a = accountArray[i];
			if (accountArray[i] != null) {
				System.out.printf("%-6s %-6s %-6s \n", a.getAno(), a.getOwner(), a.getBalance());
			}
		}

	}

	// 예금하기
	private static void deposit() {
		System.out.println("---------");
		System.out.println("예금");
		System.out.println("---------");
		// 입력받는 계좌번호를 where라고 하고, 입력받는 입금액을 howMuch라고 한다
		System.out.print("계좌번호: ");
		String where = sc.next();
		System.out.print("출금액: ");
		int howMuch = sc.nextInt();

		// 어떤 결과가 나오더라도 결과: 를 찍고 보여준다
		System.out.print("결과: ");

		// 문자열 where를 findAccount의 매개값으로 사용하는 Account를 a라고 하겠다
		Account a = findAccount(where);

		if (a == null) {
			System.out.println("계좌가 존재하지 않습니다.");
			// if문에서 return은 if문이 속한 메소드 자체를 종료시킨다(초기 메뉴로 돌아간다)
			return;
		}
		if (!a.getAno().equals(where)) {
			System.out.println("계좌를 잘못 입력하셨습니다.");
			return;
		}

		a.setBalance(a.getBalance() + howMuch);
		System.out.println("예금이 성공되었습니다.");
		System.out.println("잔액: " + a.getBalance());// 문제 요구사항에는 없지만 있으면 좋을 것 같다

	}

	// 출금하기
	private static void withdraw() {
		System.out.println("---------");
		System.out.println("출금");
		System.out.println("---------");
		// 입력받는 계좌번호를 where라고 하고, 입력받는 출금액을 howMuch라고 한다
		// 위와 같은 이름의 변수를 사용하더라도 다른 메소드 안에 있어서 서로 인식하지 않음
		System.out.print("계좌번호: ");
		String where = sc.next();
		System.out.print("출금액: ");
		int howMuch = sc.nextInt();

		// 어떤 결과가 나오더라도 결과: 를 찍고 보여준다
		System.out.print("결과: ");

		// 문자열 where를 findAccount의 매개값으로 사용하는 Account를 a라고 하겠다
		Account a = findAccount(where);

		if (a == null) {
			System.out.println("계좌가 존재하지 않습니다.");
			// if문에서 return은 if문이 속한 메소드 자체를 종료시킨다(초기 메뉴로 돌아간다)
			return;
		}
		if (!a.getAno().equals(where)) {
			System.out.println("계좌를 잘못 입력하셨습니다.");
			return;
		}
		if (a.getBalance() == 0 || a.getBalance() < howMuch || a.getBalance() - howMuch < 0) {
			System.out.println("잔액이 부족합니다.");
			return;
		}

		a.setBalance(a.getBalance() - howMuch);
		System.out.println("출금이 성공되었습니다.");
		System.out.println("잔액: " + a.getBalance());// 문제 요구사항에는 없지만 있으면 좋을 것 같다
	}

	// Account 배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano) {
		// findAccount 이해 불확실, 추후 재확인 필요

		// a의 초기값은 null이다
		Account a = null;

		// accountArray의 length만큼 i를 반복
		for (int i = 0; i < accountArray.length; i++) {
			// accountArray[0]이 null이 아닐 때
			if (accountArray[i] != null) {
				// accountArray[0]의 ano를 get한 것을 ano라고 부른다
				ano = accountArray[i].getAno();
				// ano가 ano와 같으면(사실 둘은 같은 거니까 항상 true)
				// 즉, accountArray[0]이 아닐 때의 body가 실행되기만 하면
				// accountArray[0]을 a에 대입하겠다는 뜻이다
				// accountArray[0]에는 sel==1에서 입력한 계좌번호가 저장되어 있다
				if (ano.equals(ano)) {
					a = accountArray[i];
					break;
				}
			}
		}
		// 함수 실행 후에는 a를 리턴으로 얻게 되므로, 계좌를 찾는 역할을 수행하게 된다
		return a;
	}
}

class Account {
	private String ano;
	private String owner;
	private int balance;

	// Source -> generate constructor using fields로 만들자
	public Account(String ano, String owner, int balance) {
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	// Source -> generate getters and setters로 만들자
	public String getAno() {
		return ano;
	}

	public String getOwner() {
		return owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
