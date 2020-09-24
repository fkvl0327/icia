import java.util.Scanner;

public class _japanki_again {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("[ 자  판  기 ]");
		System.out.println("* 선 택 메 뉴 *");
		System.out.println("0) 입금");
		System.out.println("9) 거스름(종료)");
		System.out.println("===========================");
		System.out.println("자판기의 메뉴는 다음과 같습니다");
		int drink1 = 1000, drink2 = 500, drink3 = 400;
		System.out.println("- 포카리스웨트 " + drink1 + "원");
		System.out.println("- 환타 " + drink2 + "원");
		System.out.println("- 레쓰비 " + drink3 + "원");
		
		int zeroNine;
		zeroNine = sc.nextInt();
		
		if(zeroNine==0) {
			int n;
			
			System.out.println("입력할 수 있는 금액은 100원 또는 500원 또는 1000원입니다.");
				
			n = input();
				
			if(n==100) {
				System.out.println("입력된 금액: 100원");
				} else if(n==500) {
						System.out.println("입력된 금액: 500원");
				} else if(n==1000) {
						System.out.println("입력된 금액: 1000원");
						System.out.println("주문할 음료수를 선택하세요.");
						
						String s;
						s = sc.next();
						
						if(s.equals("포카리스웨트")) {
							System.out.println("포카리스웨트 1캔을 주문하셨습니다.");
							System.out.println("잔액은 " + (n - drink1) + "원입니다.");
							System.out.println("자판기 운영이 종료되었습니다. 감사합니다.");
						} else if(s.equals("환타")) {
							System.out.println("환타 1캔을 주문하셨습니다.");
							System.out.println("잔액은 " + (n - drink2) + "원입니다.");
							System.out.println("자판기 운영이 종료되었습니다. 감사합니다.");
							
						} else if(s.equals("레쓰비")) {
							System.out.println("레쓰비 1캔을 주문하셨습니다.");
							System.out.println("잔액은 " + (n - drink3) + "원입니다.");
							System.out.println("자판기 운영이 종료되었습니다. 감사합니다.");
						}
				} else {
						System.out.println("[주의]입력할 수 있는 금액은 100원 또는 500원 또는 1000원입니다.");
						System.out.println("프로그램을 종료하려면 9를 입력하세요.");
				}
		
		} else if(zeroNine==9) {
			System.out.println("자판기 운영이 종료되었습니다. 감사합니다.");
			
		} else {
			System.out.println("0번 또는 9번을 선택하세요.");
			System.out.println("자판기를 다시 실행해주세요. 감사합니다.");
		}
			
		}
		
		private static int input() {
			int n;
			Scanner sc = new Scanner(System.in);
			System.out.println("금액을 입력하세요.");
			System.out.println("> ");
			n = sc.nextInt();
			return n;
	}

		
		
		
		
	}


