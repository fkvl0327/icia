import java.util.Scanner;
//이거 이대로 실행 안됨. 선생님 코드 참고용.
public class todoSample {

	public static void main(String[] args) {
		String s1 = args[0];
		String s2 = args[1];
		int n1 = args.length;//2  or 1
		
		if(s1.equals("0")) {
			todo1(args);
		}
		if(s1.equals("1")) {
			todo2(args);
		}

	}

	private static void todo2(String[] args) {
		if (args.length != 2) {
			System.out.println("프로그램 파라미터 갯수에 맞도록 입력해주세요");
			System.out.println("사용법 : My0928 param1 param2");
			System.out.println("param1 : 0이면 요일별 할일을 등록");
			System.out.println("param1 : 1이면 요일별 할일을 출력");
			System.out.println("param2 : 출력할 요일");
			System.out.println("ex) java My0928 1 SUNDAY");
		}else {
			String s1 = args[0];
			String s2 = args[1];
			int n1 = args.length;//2  or 1
			
			String [][] todo = new String [7][3];
			todo = setTodo();
			//printTodo(todo);
			int n2 = getIndexWeek(s2); // 입력요일을 인덱스로 반환....
			
			System.out.println(n2+"번째 요일할일:");
			for(int j=0;j<3;j++) {
				System.out.println(j+":" + todo[n2][j]);
			}
		
			System.out.println();
			
		}
		System.out.println("프로그램을 종료합니다. ");
		
	}

	private static int getIndexWeek(String s2) {
		int index=0;
		
		if(s2.equals("일요일")) {
			index = 0;
		}else if(s2.equals("월요일")) {
			index = 1;
		}else if(s2.equals("화요일")) {
			index = 2;
		}else if(s2.equals("수요일")) {
			index = 3;
		}else if(s2.equals("목요일")) {
			index = 4;
		}else if(s2.equals("금요일")) {
			index = 5;
		}else if(s2.equals("토요일")) {
			index = 6;
		}else {
			index = 0;
		}
		
		return index;
	}

	private static void printTodo(String[][] todo) {
		for(int i=0;i<7;i++) {
			System.out.println(i+"번째 요일할일:");
			for(int j=0;j<3;j++) {
				System.out.println(j+":" + todo[i][j]);
			}
		}
	}

	private static String[][] setTodo() {
		String[][] todo2 = new String[7][3];
		todo2[0][0]="java열심히 공부하기0";
		todo2[0][1]="집에서 놀기";
		todo2[0][2]="성묘가기";
		
		todo2[1][0]="java열심히 공부하기1";
		todo2[1][1]="집에서 놀기";
		todo2[1][2]="성묘가기";
		
		todo2[2][0]="java열심히 공부하기2";
		todo2[2][1]="집에서 놀기";
		todo2[2][2]="성묘가기";
		
		todo2[3][0]="java열심히 공부하기3";
		todo2[3][1]="집에서 놀기";
		todo2[3][2]="성묘가기";
		
		todo2[4][0]="java열심히 공부하기4";
		todo2[4][1]="집에서 놀기";
		todo2[4][2]="성묘가기";
		
		todo2[5][0]="java열심히 공부하기5";
		todo2[5][1]="집에서 놀기";
		todo2[5][2]="성묘가기";
		
		todo2[6][0]="java열심히 공부하기6";
		todo2[6][1]="집에서 놀기";
		todo2[6][2]="성묘가기";
		
		return todo2;
	}

	private static void todo1(String[] args) {
		if (args.length != 1) {
			System.out.println("프로그램 파라미터 갯수에 맞도록 입력해주세요");
			System.out.println("사용법: JavaLesson13 param1");
			System.out.println("param1 :  0이면 요일별 할일 등록");
			System.out.println("param1 :  1이면 요일별 할일 출력");
			System.out.println("ex) java JavaLesson13 0");
		} else {
			String[][] todo = new String[7][3];
			Scanner sc = new Scanner(System.in);
			

			System.out.println("요일별 할일을 입력하세요");

			for (int i = 0; i < 7; i++) {
				//System.out.println("요일:" + Week.SUNDAY);
				//무슨 요일인지 알려주기......
				weekDayPrint(i);				

				// 요일별 3가지 할일 입력하기
				for (int j = 0; j < 3; j++) { 
					System.out.print(j + ">");
					todo[i][j] = sc.nextLine();
				}
			}

			// 출력할때....
			for (int i = 0; i < 7; i++) {
				System.out.println(i + ">");
				for (int j = 0; j < 3; j++) {
					System.out.println(j + ":" + todo[i][j]);
				}
				System.out.println();
			}
		}

	}

	private static void weekDayPrint(int m) {
		switch(m) {
		case 0:
			System.out.println("일요일:");
			break;
		case 1:
			System.out.println("월요일:");
			break;
		case 2:
			System.out.println("화요일:");
			break;
		case 3:
			System.out.println("수요일:");
			break;
		case 4:
			System.out.println("목요일:");
			break;
		case 5:
			System.out.println("금요일:");
			break;
		case 6:
			System.out.println("토요일:");
			break;
		
		default:
			System.out.println("오류가 났어요....");
			break;
		}
		
		
	}

	private static void argTest(String[] args) {

		if (args.length == 1) {

			String strDay = args[0];
			Week myWeek = Week.valueOf(strDay);

			if ((myWeek == Week.SATURDAY) || (myWeek == Week.SUNDAY)) {
				System.out.println("Weekend ~ 주말입니다.");
			} else {
				System.out.println("열심히 일하고 공부하는 평일입니다. ");
			}
		} else {
			System.out.println("프로그램 파라미터 갯수에 맞도록 입력해주세요");
			System.out.println("사용법: JavaLesson13 param1");
			System.out.println("param1 :  MONDAY, TUESDAY, ...., SATURDAY, SUNDAY");
			System.out.println("ex) java JavaLesson13 SUNDAY");
		}
	}

}
