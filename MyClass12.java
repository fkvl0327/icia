import java.util.Scanner;

public class MyClass12 {

	public static void main(String[] args) {
		int n1 = 0;
		System.out.println("100 이하 숫자를 입력: ");
		Scanner sc = new Scanner(System.in);
		n1 = sc.nextInt();//아래 함수 다 똑같은 내용. 다양하게 쓰는 방식.
		ifelseTest50(n1);
		ifTest50(n1);
		ifDiv50(n1);
	}

	private static void ifDiv50(int n1) {
		System.out.println("\nDiv");
		int m = n1/50;
		if (m >= 1) {
			System.out.println("50 이상의 숫자입니다. 입력숫자 = " + n1);
		} if (m<1) {
			System.out.println("50 미만의 숫자입니다. 입력숫자 = " + n1);
		}
		System.out.println("프로그램을 종료합니다.");
		
		
	}

	private static void ifTest50(int n1) {
		System.out.println("\nif50");
		if (n1 >= 50) {
			System.out.println("50 이상의 숫자입니다. 입력숫자 = " + n1);
		} if (n1<50) {
			System.out.println("50 미만의 숫자입니다. 입력숫자 = " + n1);
		}
		System.out.println("프로그램을 종료합니다.");
		
	}

	private static void ifelseTest50(int n1) {
		System.out.println("\nifelse"
				+ "");
		if (n1 >= 50) {
			System.out.println("50 이상의 숫자입니다. 입력숫자 = " + n1);
		} else {
			System.out.println("50 미만의 숫자입니다. 입력숫자 = " + n1);
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
