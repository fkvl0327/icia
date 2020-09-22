import java.util.Scanner;

public class MyClass14_copy_doWhileSample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메시지를 입력하세요. \n");
		String m;
		int n = 0;
		
		do {
			System.out.println("100 이하 숫자를 입력: \n");
			System.out.print("종료하려면 q를 입력하세요.");
			m = sc.nextLine();
			System.out.println("입력된 문자 = " +m);
			
			if(! m.equals("q")) {
			n = Integer.parseInt(m);//입력된 문자가 q가 아닐 경우 숫자로 인식
			System.out.println("입력된 문자 = " +m);
			tell(n);
			}
			
		} while (! m.equals("q"));
		
		System.out.println();
		System.out.println("프로그램 종료");	
	}

	private static void tell(int n) {
		if (n<=0) {
			System.out.println("0 이하 숫자입니다.");
		} if (n>0 && n<10) {
			System.out.println("한자리 수입니다.");
		}if (n>=10 && n<20) {
			System.out.println("10이상 20미만 숫자입니다.");
		} if (n>=20 && n<30) {
			System.out.println("20이상 30미만 숫자입니다.");
	} if (n>=30 && n<40) {
		System.out.println("30이상 40미만 숫자입니다.");
} if (n>=40 && n<50) {
	System.out.println("40이상 50미만 숫자입니다.");
} if (n>=50 && n<60) {
	System.out.println("50이상 60미만 숫자입니다.");
} if (n>=60 && n<70) {
	System.out.println("60이상 70미만 숫자입니다.");
} if (n>=70 && n<80) {
	System.out.println("70이상 80미만 숫자입니다.");
} if (n>=80 && n<90) {
	System.out.println("80이상 90미만 숫자입니다.");
} if (n>=90 && n<100) {
	System.out.println("90이상 100미만 숫자입니다.");
} if (n>=100) {
	System.out.println("100 이상의 숫자를 인식할 수 없습니다.");
}

}
}