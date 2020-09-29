
public class Overloading {
//9월29일화요일작성

	
	public static void main(String[] args) {
		System.out.println("간단한 계산기");
		myCalcMethod(10);
		myCalcMethod(10, 20);
		myCalcMethod(10,20,30);
		System.out.println();
		System.out.println("사칙연산을 해봅시다.");
		myCalcMethod(10,20,"+");
		myCalcMethod(10,20,"-");
		myCalcMethod(10,20,"*");
		myCalcMethod(10,20,"/");

	}
private static void myCalcMethod(int a, int b, String s) {
	int n = 0;
	switch(s) {
	case "+":
		n = a+b;
		System.out.println(a+"+"+b+"="+n);
		break;
	case "-":
		n = b-a;
		System.out.println(b+"-"+a+"="+n);
		break;
	case "*":
		n = a*b;
		System.out.println(a+"*"+b+"="+n);
		break;
	case "/":
		n = b/a;
		System.out.println(b+"/"+a+"="+n);
		break;
	}
	
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
	
	

	private static void myCalcMethod(int a, int b, int c) {
		System.out.println(b+"에서"+a+"를 뺀 값에"+c+"를 더하면:"+(b-a)*c);
	
}

	private static void myCalcMethod(int a, int b) {
		System.out.println(a+"*"+b+"="+a*b);
	
}

	private static void myCalcMethod(int a) {
		System.out.println(a+"의 절대값:"+Math.abs(a));
		
	}
	
}
