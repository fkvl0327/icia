import java.util.Scanner;

public class calculatorScanner1 {
	
	public static void main(String[] args) {
		System.out.println("계산기입니다.");
		System.out.println("1)숫자 한 개 입력: 절대값 구하기");
		System.out.println("2)숫자 두 개 입력: 사칙연산");
		System.out.println("3)숫자 세 개 입력: 복잡한 계산하기");
		System.out.println("0)프로그램 종료");
		
		Scanner sc = new Scanner(System.in);
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			int a=0;
			myCalcMethod(a);
			break;
		case 2:
			int n1=0, n2=0;
			String s=null;
			myCalcMethod(n1, n2, s);
			break;
		case 3:
			int x=0, y=0, z=0;
			myCalcMethod(x,y,z);
			break;
		case 0:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("프로그램을 다시 시작해주세요.");
		}
		
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
	private static void myCalcMethod(int a) {
		System.out.println("절대값을 구할 숫자 하나를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		System.out.println(a+"의 절대값:"+Math.abs(a));
		System.out.println("다른 수를 계산하려면 프로그램을 다시 실행해주세요.");
	}
	
	private static void myCalcMethod(int x, int y, int z) {
		System.out.println("복잡한 계산을 할 숫자 3가지를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		System.out.println(">");
		x = sc.nextInt();
		System.out.println(">");
		y = sc.nextInt();
		System.out.println(">");
		z = sc.nextInt();
		System.out.println(y+"에서"+x+"를 뺀 값에"+z+"를 곱하면:"+(y-x)*z);
		
	
	}
	
}
