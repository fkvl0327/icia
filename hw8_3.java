import java.util.Arrays;
import java.util.Scanner;
//array 미사용
public class hw8_3 {
	
	public static void main(String[] args) {
		System.out.println("성적처리 프로그램입니다.");
		
		
		if (args.length == 0) {
			System.out.println("파라미터 갯수에 맞도록 입력해주세요");
			System.out.println("프로그램명: array_grade_input");
			System.out.println("'java hw8 1 학생이름' 입력 시 학생 한 명 성적 처리 프로그램 실행");
			System.out.println("'java hw8 2' 입력 시 학생 여러 명 성적 처리 프로그램 실행");
		} else if(args.length==1) {//여러 명 처리 프로그램
			int n1=0, n2=0, n3=0;
			String s=null;
			grade(s, n1, n2, n3);
		}
		else if(args.length==2){//한 명 처리 프로그램
			int n1=0, n2=0, n3=0;
			grade(n1, n2, n3);
			} 
	}

	private static void grade(int n1, int n2, int n3) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력한 한 명의 성적만 처리합니다.");
		System.out.println("국어성적을 입력하세요.");
		System.out.print(">");
		n1 = sc.nextInt();
		System.out.println("수학성적을 입력하세요.");
		System.out.print(">");
		n2 = sc.nextInt();
		System.out.println("영어성적을 입력하세요.");
		System.out.print(">");
		n3 = sc.nextInt();
		
		arr1(n1, n2, n3);
		
	}

	private static void arr1(int n1, int n2, int n3) {
		System.out.println("===============================");
		System.out.println("[국어, 수학, 영어, 합계, 평균]");
		System.out.println(n1+", "+n2+", "+n3+", "+(n1+n2+n3)+", "+(n1+n2+n3)/3);
		System.out.println("프로그램을 종료합니다.");
	}

	private static void grade(String s, int n1, int n2, int n3) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		String[][]arr1 = new String [10][6];
	
		do {
		System.out.println("종료하고 입력한 모든 학생의 결과를 보려면 q를 입력하세요.");
		System.out.println("성적처리할 학생의 이름을 입력하세요.");
		System.out.print(">");
		s = sc2.next();
		
		if(!s.equals("q")) {
		System.out.println("국어성적을 입력하세요.");
		System.out.print(">");
		n1 = sc.nextInt();
		System.out.println("수학성적을 입력하세요.");
		System.out.print(">");
		n2 = sc.nextInt();
		System.out.println("영어성적을 입력하세요.");
		System.out.print(">");
		n3 = sc.nextInt();
		
		arr1(s, n1, n2, n3);
		}	
	} while(!s.equals("q"));
		//arr1 = {s, n1, n2, n3, (n1+n2+n3), (n1+n2+n3)/3};
		System.out.print(Arrays.deepToString(arr1));//여기서 arr1이 선언 되었으므로 null값만 나옴
		System.out.print("프로그램을 종료합니다.");
	}
	private static void arr1(String s, int n1, int n2, int n3) {
		System.out.println("===============================");
		System.out.println("[이름, 국어, 수학, 영어, 합계, 평균]");
		System.out.println(s+", "+n1+", "+n2+", "+n3+", "+(n1+n2+n3)+", "+(n1+n2+n3)/3);
	}
	
}