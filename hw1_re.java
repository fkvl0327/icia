
public class hw1_re {

	public static void main(String[] args) {
		System.out.println("<예제> n1과 n2의 사칙연산을 구하시오."
				+ "\n단, n1이 n2이상이면 n1-n2, n1/n2를 계산하고,"
				+ "\nn2가 n1보다 크면 n2-n1, n2/n1을 계산하시오.\n");
		p1();
		p2();

	}

	private static void p2() {
		System.out.println("\nQ2) n1=100, n2=250");
		int n1 = 100, n2 = 250;
		add(n1, n2);
		sub(n1, n2);
		mul(n1, n2);
		div(n1, n2);
		
	}

	private static void p1() {
		System.out.println("Q1) n1=1024, n2=500");
		int n1 = 1024, n2 = 500;
		add(n1, n2);
		sub(n1, n2);
		mul(n1, n2);
		div(n1, n2);
		
	}

	private static void div(int n1, int n2) {
		if(n1>=n2) {
		System.out.println("나눗셈: " + n1/n2);
	}else {
		System.out.println("나눗셈: " + n2/n1);
	}
	}
	private static void mul(int n1, int n2) {
		System.out.println("곱셈: " + n1*n2);
		
	}

	private static void sub(int n1, int n2) {
		if(n1>=n2) {
		System.out.println("뺄셈: " + (n1-n2));
	}else {
		System.out.println("뺄셈: " + (n2-n1));
	}
	}
	private static void add(int n1, int n2) {
		System.out.println("덧셈: " + (n1+n2));
		
	}

}
