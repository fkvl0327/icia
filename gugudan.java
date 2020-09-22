import java.util.Scanner;

public class gugudan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String m;
		int n2 = 0;
		
		do {
			System.out.print("몇 단을 계산할까요?\n");
			System.out.print("종료하려면 q를 입력하세요.");
		m = sc.nextLine();
		
		if(! m.equals("q")) {
			n2 = Integer.parseInt(m);//입력된 문자가 q가 아닐 경우 숫자로 인식
			
		for(int n1=1; n1<=9; n1++) {
			System.out.printf("%d x %d = %d \n", n1 , n2 , (n1*n2) );
		} 
		}
	} while(! m.equals("q"));
		System.out.print("프로그램을 종료합니다.");
	}
}
