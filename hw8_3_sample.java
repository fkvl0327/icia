import java.util.Arrays;
import java.util.Scanner;
//선생님 코딩
public class hw8_3_sample {
	private static final int max = 10;//array는 공간이 주어져야 함
	//값이 입력되지 않았을 때 빈 공간을 아낄 수 있는 방법을 고민하게 됨
	//값이 입력되지 않은 빈 공간은 null값으로 출력됨
	private static int no; // tuple 번호
	private static int[][] data = new int[max][3];//private이 이 클래스의 속성, field 생성 시 기본값 private로 생성됨
	private static String[][] data_name = new String[max][1];
	private static float[][] data_agg = new float[max][2];
	//static은 메모리 공간에서의 위치
	//클래스 안에서는 메모리 공간에서 지우지 말고 계속 사용한다는 의미
	
// 로컬 변수로 쓰면 다른 메소드에서는 인식을 못하므로 field로 아래 내용을 위처럼 작성

//	String[][] data_name; // 이름
//	int[][] data; // 점수(국어, 수학, 영어)
//	float[][] data_agg; // 합계, 평균

	public static void main(String[] args) {
		arraysungjuk();
		//charAtTest();
		//substringTest();
		
	}

	private static void substringTest() {
		Scanner sc = new Scanner(System.in);
		String s1 = null;
		
		System.out.println("15자 이상 문자열을 입력하세요.");
		System.out.print("> ");
		s1 = sc.next();
		String s2 = s1.substring(10, 15);//이런 식으로 데이터를 부분부분 처리해주는 걸 파싱이라고 한다~
		System.out.println("substring(10, 15)> ["+s2+"]");
		
		s2 = (String) s1.subSequence(0, 5);
		System.out.println("(String) s1.subSequence(0, 5)> ["+s2+"]");
		//결과는 똑같이 나오는데(sequence는 String 캐스팅도 필요합니다) substring 씁시다
		System.out.println("프로그램을 종료합니다.");
		
	}

	private static void charAtTest() {
		Scanner sc = new Scanner(System.in);
		String s1 = null;
		
		System.out.println("메뉴를 선택하세요.");
		System.out.println("> ");
		s1 = sc.next();
		char c1 = s1.charAt(0);
		for(int i=0;i<s1.length();i++) {
			c1 =s1.charAt(i);
			System.out.println(i+"번째 문자> ["+c1+"]");
		}
		System.out.println("프로그램을 종료합니다.");
	}

	private static void arraysungjuk() {
		String s1 = null;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("===========================");
			System.out.println("성적 입출력 프로그램 v0.9");
			System.out.println("선택메뉴: 1. 조회 2. 입력 q. 종료");
			System.out.println("===========================");
			System.out.print("> ");
			s1 = sc.next();
			char c1 = s1.charAt(0);
			System.out.println("선택메뉴: " + c1);
			if(c1=='1') {
				printsungjuk();
			} else if(c1=='2') {
				inputsungjuk();
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
			System.out.println("종료하려면 q를 입력하세요. 계속하려면 아무 숫자나 입력하세요.");
			System.out.print("> ");
			s1 = sc.next();
			
		} while(!s1.equals("q"));
		System.out.println("프로그램을 종료합니다.");
	}


	private static void inputsungjuk() {
		System.out.println("성적을 입력합니다.");
		System.out.println("===========================");
		//int [][] sungjuk;
		Scanner sc = new Scanner(System.in);
		System.out.print("이름> ");
		String name = sc.next();
		Scanner sc2 = new Scanner(System.in);
		System.out.print("국어점수> ");
		int n1 = sc2.nextInt();
		System.out.print("수학점수> ");
		int n2 = sc2.nextInt();
		System.out.print("영어점수> ");
		int n3 = sc2.nextInt();
		float sum = n1 + n2 + n3;
		float avg = (float)(n1 + n2 + n3)/3;
//		
//		if(no>=max) {
//			System.out.println("저장할 수 있는 공간이 없습니다.");
//			return;
//		}
		
		data_name[no][0] = name;
		data[no][0] = n1;
		data[no][1] = n2;
		data[no][2] = n3;
		data_agg[no][0] = sum;
		data_agg[no][1] = avg;
		
		no++;
}
	private static void printsungjuk() {
		System.out.println("성적을 조회합니다.");
		System.out.println("===========================");
		
		for (int i=0; i<data_name.length;i++) {
			System.out.printf("%2d", no);
			for (int j=0; j<data_name[i].length;j++) {
			System.out.printf("%4s", data_name[i][j]);
		}
		System.out.println();
	}
		
		for (int i=0; i<data.length;i++) {
			for (int j=0; j<data[i].length;j++) {
			System.out.printf("%4d", data[i][j]);
		}
		System.out.println();
	}
		for (int i=0; i<data_agg.length;i++) {
			for (int j=0; j<data_agg[i].length;j++) {
			System.out.printf("%4.1f", data_agg[i][j]);
		}
		System.out.println();
	}
	}
}