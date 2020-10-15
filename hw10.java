package classLesson;

public class hw10 {

	public static void main(String[] args) {
		// 18번 문제(주어진 실행문)
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		//obj1이나 obj2나 인스턴스 값이 바뀐 적이 없으므로
		if (obj1 == obj2) {
			//같은 값이어서 아래 내용이 print된다
			System.out.println("같은 ShopService 객체입니다.");
		} else {
			System.out.println("다른 ShopService 객체입니다.");
		}

		// 19번 문제(주어진 실행문)
		Account account = new Account();

		account.setBalance(10000);
		System.out.println("현재 잔고: " + account.getBalance());

		account.setBalance(-100);
		System.out.println("현재 잔고: " + account.getBalance());

		account.setBalance(2000000);
		System.out.println("현재 잔고: " + account.getBalance());

		account.setBalance(300000);
		System.out.println("현재 잔고: " + account.getBalance());
	}
}

//18번 문제
class ShopService {
	//필드를 private하게 하고
	private static ShopService s = new ShopService();
	
	//생성자를 private하게 하고
	private ShopService() {
	}
	//instance의 값을 보여준다
	static ShopService getInstance() {
		return s;
	}
}

//19번 문제
class Account {
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;

	Account() {
	}

	private int balance = 0;

	public int getBalance() {
		return this.balance;
	}

	// setter 안의 내용을 1이나 2로 쓰면 된다.

	public void setBalance(int balance) {

		// 1.
		// Setter의 매개값(패러미터 안의 int)가 MIN_BALANCE 이상이면서 MAX_BALANCE 이하일 때
		// balance 값을 int로 바꾸고, 그렇지 않을 때에는 아무것도 실행하지 않는다.
		if (balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
			this.balance = balance;
		}

		// 2.
		// Setter의 매개값(패러미터 안의 int)가 MIN_BALANCE 미만 또는 MAX_BALANCE 초과일 때는
		// 아무것도 실행하지 않고, 그렇지 않을 때에만 balance를 매개값으로 반영한다.
//		if (balance < MIN_BALANCE || balance > MAX_BALANCE) {
//		} else {
//			this.balance = balance;
//		}
//
	}
}
