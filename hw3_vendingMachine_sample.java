import java.util.Scanner;

public class hw3_vendingMachine_sample {

	public static void main(String[] args) {
		int price, priceAdd = 0;
		String select = null;
		int product1 = 1000;
		int product2 = 500;
		int product3 = 400;
		Scanner sc = new Scanner(System.in);

		System.out.print("얼마를 입금하시겠습니까?: ");
		price = sc.nextInt();

		if (price > 5000) {
			while (true) {
				if (price > 5000) {
					System.out.println("금액이 너무 많습니다.");
					price = sc.nextInt();
				} else {
					break;
				}
			}
		}
		System.out.println("- q를 누를 시 종료합니다. 금액을 충전하고 싶으시면 [충전] 이라고 입력해 주세요.");
		System.out.println("* 메 뉴 를 선 택 해 주 세 요 *");
		System.out.println("------------------------");
		System.out.println("1. 포카리스웨트 1000원");
		System.out.println("2. 레쓰비 500원");
		System.out.println("3. 이프로 400원");
		System.out.println("------------------------");

		while (true) {
			System.out.println("* 잔액 : " + price);
			System.out.println("> ");
			select = sc.next();

			if (select.equals("1")) {
				if (price < product1) {
					System.out.println("잔액이 부족합니다.");
				} else {
					price -= product1;
					System.out.println("포카리스웨트를 고르셨습니다.");
				}
			} else if (select.equals("2")) {
				if (price < product2) {
					System.out.println("잔액이 부족합니다.");
				} else {
					price -= product2;
					System.out.println("레쓰비를 고르셨습니다.");
				}
			} else if (select.equals("3")) {
				if (price < product3) {
					System.out.println("잔액이 부족합니다.");
				} else {
					price -= product3;
					System.out.println("이프로를 고르셨습니다.");
				}
			} else if (select.equals("q")) {
				System.out.println("*잔액 [" + price + "원]을 반환합니다.");
				System.out.println("자판기 운영을 종료합니다.");
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}

	}
}
