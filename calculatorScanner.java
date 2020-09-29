import java.util.Scanner;

public class calculatorScanner {
//9월29일화요일작성

	
	public static void main(String[] args) {
		
		int n1=0, n2=0;
		String s=null;
		
		myCalcMethod(n1, n2, s);
	}		
private static void myCalcMethod(int n1, int n2, String s) {
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	System.out.println("사칙연산을 해봅시다.");
	System.out.println("계산할 숫자 2가지를 입력하세요.");
	System.out.println(">");
	n1 = sc.nextInt();
	System.out.println(">");
	n2 = sc.nextInt();

	System.out.println("두 수를 더하려면 +, 곱하려면 *를 입력하세요.");
	System.out.println("큰 수에서 작은 수를 빼려면 -, 나누려면 /를 입력하세요.");
	System.out.println(">");
	s = sc2.next();
	
	System.out.println("구하는 값은 다음과 같습니다.");
	
	int n = 0;
	switch(s) {
	case "+":
		n = n1+n2;
		System.out.println(n1+"+"+n2+"="+n);
		break;
	case "-":
		n = n2-n1;
		System.out.println(n1+"-"+n2+"="+n);
		break;
	case "*":
		n = n1*n2;
		System.out.println(n1+"*"+n2+"="+n);
		break;
	case "/":
		n = n2/n1;
		System.out.println(n2+"/"+n1+"="+n);
		break;
	}
	

	System.out.println("다른 수를 계산하려면 프로그램을 다시 실행해주세요.");
	
	
}
//	private static int myCalcMethod(int a, int b, String s) {
//		int n = 0;
//		if(s.equals("+")) {
//			n = a+b;
//			System.out.println(n);
//		} else if(s.equals("-")) {
//			n = b-a;
//			System.out.println(n);
//		} else if(s.equals("x")) {
//			n = a*b;
//			System.out.println(n);
//		} else if(s.equals("/")) {
//			n = b/a;
//			System.out.println(n);
//		}
//		return n;
//	} // if문으로 작성할 경우

	
}
