import java.util.Scanner;

public class calculatorScanner2 {

	public static void main(String[] args) {
		methodOverloadingTest();
	}
	private static void methodOverloadingTest() {
		/*
		 * 함수 오버로딩을 사용해서 다음의 함수들을 만들고 실행해보세요.
		 */
		// Scanner 입력
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		double n1, n2, n3;
		String s1 = null;

		System.out.println("숫자를 하나 입력하세요. 절대값을 계산합니다.");
		System.out.print(">");
		n1 = sc.nextInt();
		myCalcMethod(n1);

		System.out.println();
		System.out.println("두 숫자를 입력하세요. 곱셈계산합니다.");
		System.out.print(">");
		n1 = sc.nextInt();
		System.out.print(">");
		n2 = sc.nextInt();
		myCalcMethod(n1, n2);

		System.out.println();
		System.out.println("세개의 숫자를 입력하세요. 복잡한 계산을 합니다.");
		System.out.print(">");
		n1 = sc.nextInt();
		System.out.print(">");
		n2 = sc.nextInt();
		System.out.print(">");
		n3 = sc.nextInt();
		
		double d2;
		d2 = myCalcMethod(n1, n2, n3); // 두 수를 뺀 값에 세번째 값을 곱합니다.
		System.out.printf("(%s-%s)*%s = %s \n"
				, String.valueOf(n1), String.valueOf(n2)
				, String.valueOf(n3), String.valueOf(d2));

		double d1;
		
		do {
			System.out.println();
			System.out.println("두 수와 연산기호를 입력하세요, 사칙계산을 수행합니다.");
			System.out.print("> ");
			n1 = sc.nextInt();
			System.out.print("> ");
			n2 = sc.nextInt();
			System.out.print("> ");
			s1 = sc2.nextLine();
			
			// d1 = myCalcMethod(10, 20, "+"); // 두 수를 더한 결과를 리턴합니다.
			d1 = myCalcMethod(n1, n2, s1);
			System.out.printf("계산기 %f %f %f = %f \n"
					, n1, n2, s1, d1);

			System.out.println("종료하려면 @를 연산기호로 입력하세요. 계속하려면 엔터! ");
			System.out.print("> ");
			s1 = sc2.nextLine();
			
		} while (!s1.equals("@"));

		System.out.println("프로그램을 종료합니다. ");
	}

	private static double myCalcMethod(double n1, double n2, double n3) {
		double d2 = 0;
		System.out.println(d2=(n1-n2)*n3);
		return d2;
		
	}
	private static void myCalcMethod(double n1, double n2) {
		System.out.println(n1+"*"+n2+"="+n1*n2);
		
	}
	private static void myCalcMethod(double n1) {
		System.out.println("절대값을 구할 숫자 하나를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		n1 = sc.nextInt();
		System.out.println(n1+"의 절대값:"+Math.abs(n1));
		
	}
	private static double myCalcMethod(double n1, double n2, String s1) {
		double d1 = 0;

		switch (s1) {
		case "+":
			d1 = n1 + n2;
			break;
		case "-":
			d1 = n1 - n2;
			break;
		case "*":
			d1 = n1 * n2;
			break;
		case "/":
			d1 = n1 / n2;
			break;
		default:
			d1 = 0;
			break;
		}

		return d1;
	}
	
}
