package classLesson;

import java.util.Scanner;

public class CalEX {
//너무 복잡하게 돼서 만들다 만 건데 나중에 부활시켜서 혼자 만들어 보든가 합시다
	public static void main(String[] args) {
		String s1 = null;

		do {
			menu();

			Scanner sc = new Scanner(System.in);
			s1 = sc.next();
			if (s1.equals("q")) {
				int n1 = Integer.parseInt(s1);
				s1 = sc.next();
				String math = sc.next();
				int n2 = Integer.parseInt(s1);
				s1 = sc.next();
				
				System.out.println(n1+math+n2);
				break;
			}
			
		} while (true);

		Calculator myCalc = new Calculator();
		myCalc.powerOn();

		int result1 = myCalc.plus(5, 6);
		System.out.println("result1: " + result1);

		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("result2: " + result2);

		myCalc.powerOff();
	}

	private static void menu() {
		System.out.println("-----------------");
		System.out.println("DID YOU MISS ME 계산기");
		System.out.println("두 수를 입력하고 계산할 부호를 입력하든가-.-");
		System.out.println("종료할 때는 q를 입력하든가-.-");
		System.out.println("-----------------");
		System.out.print("입력해라 인마-.-☞");
	}
}
