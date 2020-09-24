import java.util.Scanner;

public class hw5_re {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);		
		int n;
		menu();
		
	while(true) {	
		n  = userInput();	
		switch(n) {
			case 1:
				printTable1();
				menu();
				break;
			case 2:
				printTable2();
				menu();
				break;
			case 3:
				printTable3();
				menu();
				break;
			case 4:
				printTable4();
				menu();
				break;
			case 5:
				printTable5();
				menu();
				break;
			}
		if(n==9) {
			System.out.println("프로그램을 종료합니다. 감사합니다.");
		} 
	}	
	}

	private static int userInput() {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴를 입력하세요.");
		System.out.println("> ");
		n = sc.nextInt();
		return n;
	}

	private static void printTable5() {
		printTable1();
		printTable2();
		printTable3();
		printTable4();
	}

	private static void printTable4() {
		System.out.println("← = 37");
		System.out.println("↑ = 38");
		System.out.println("→ = 39");
		System.out.println("↓ = 40");
	}

	private static void printTable3() {
		System.out.println("Backspace = 8");
		System.out.println("Tab = 9");
		System.out.println("Enter = [CR=13, LF=10]");
		System.out.println("Shift = 16");
		System.out.println("Ctrl = 17");
		System.out.println("Alt = 18");
		System.out.println("ESC = 27");
		System.out.println("Space = ");
	}

	private static void printTable2() {
		for (int alpha = 65; alpha < 123; alpha++) {
			char al = (char) alpha;
			if (alpha > 90 && alpha < 97)
				continue;
			System.out.println(al + " = " + alpha);
		}
	}

	private static void printTable1() {
		for (int number = 48; number < 58; number++) {
			char num = (char) number;
			System.out.println(num + " = " + number);
		}
	}

	private static void menu() {
		System.out.println("아스키코드 출력 프로그램입니다.");
		System.out.println("--------------------");
		System.out.println("메뉴");
		System.out.println("1. 0~9 출력");
		System.out.println("2. A~Z 출력");
		System.out.println("3. 기능키 출력");
		System.out.println("4. 방향키 출력");
		System.out.println("5. 모든 문자 출력");
		System.out.println("9. 종료");
		System.out.println("--------------------");
	}

}
