import java.util.Scanner;

public class hw3_vendingMachine {

	public static void main(String[] args) {
		
		L1:
			
		System.out.println("메 뉴 를 선 택 하 세 요.");
		System.out.println("선택메뉴");
		System.out.println("-------------------");
		System.out.println("0)입금");
		System.out.println("1)음료수1 1000원");
		System.out.println("2)음료수2 500원");
		System.out.println("3)음료수3 400원");
		System.out.println("9)거스름(종료)");
		System.out.println("현재투입금액: 0원");
		System.out.println("-------------------");
		System.out.println("1)음료수1 개수: 0개");
		System.out.println("2)음료수2 개수: 0개");
		System.out.println("3)음료수3 개수: 0개");
		System.out.println("=====================");
		System.out.println("자판기 공사중. 음료수1 1개만 주문 가능합니다.");
		
		Scanner sc = new Scanner(System.in);
		int n = 0;
		n = sc.nextInt();
		
		if(n == 9) {
			System.out.println("자판기 운영이 종료됩니다.");
	} if(n == 0) {
		System.out.println("얼마를 입금합니까?");
		int cash = 0;
		cash = sc.nextInt();
		if(cash > 5000) {
			System.out.println("금액이 너무 큽니다.");
		} if(cash < 400) {
			System.out.println("금액이 너무 작습니다.");
		} if(cash>=400 && cash<5000) {
			System.out.println("음료수를 골라주세요.");
			String drink = null;
			drink = sc.next();
			if(drink.equals("1")) {
				System.out.println("음료수1 1개가 맞으면 1번, 아니면 2번을 눌러주세요.");
				String yesOrNo = null;
				yesOrNo = sc.next();
				if(yesOrNo.equals("1")) {
					System.out.println("추가주문하시려면 1번, 아니면 2번을 눌러주세요.");
					String add = null;
					add = sc.next();
					if(add.equals("2")) {
						System.out.println("거스름돈: " + (cash - 1000));
						System.out.println("자판기 운영이 종료됩니다.");
					}
				}
			}
		}
	}
	
	}
}
	
