
import java.util.Scanner;

import JavaLesson.a_enum.Week;

public class _TODOLIST {
//	//{"",""} <- 아규먼트 2개
	public static void main(String[] args) {
//		String s1 = args[0];
//		if(s1.equals("0")) {
//			input(args);
//		}else if(s1.equals("1")) {
//			output(args);
//		}//이번에 args.length는 두 개임
//		//java 프로그램이름 0 요일
//		//요일=args[1]의 값
//		String s2=args[1];
//		//if(s2.equals("tuesday"){
//		//int i = 2;
//		//for(int j=0; j<3; j++){
//		//sysout(j+":"+todo[i][j]);
//		int n1 = args.length; // 2 or 1
//		//입력된 아규먼트 값이 2개가 아니면 프로그램 사용법 출력 
//		//입력된 아규먼트 값이 2개이면 실행

		if (args.length != 1) {
			System.out.println("파라미터 갯수에 맞도록 입력해주세요");
			System.out.println("프로그램명: _TODOLIST");
			System.out.println("'java _TODOLIST 0' 입력 시 프로그램 실행");
			// 시스템 출력은 이렇지만 아규먼트 입력 개수가 하나일 때 실행하므로 0 자리에 뭘 넣어도 실행함
			// 프로그램 이름 뒤에 입력하는 게 파라미터=아규먼트
			// 아규먼트 길이=프로그램 초기 실행할 때 입력하는 값 개수
		} else {
			String todo[][] = new String[7][3];
			Scanner sc = new Scanner(System.in);

			System.out.println("요일별 할일을 입력하세요.");

			for (int i = 0; i < 7; i++) {
				weekDayPrint(i);

				for (int j = 0; j < 3; j++) {
					System.out.print(j + ">");
					todo[i][j] = sc.next();

				}

			}
			for (int i = 0; i < 7; i++) {
				weekDayPrint(i);

				for (int j = 0; j < 3; j++) {
					System.out.print(j + ":" + todo[i][j]);
				}
				System.out.println();
			}
		}

	}

	private static void weekDayPrint(int i) {
		switch (i) {
		case 0:
			System.out.println(Week.MONDAY);
			break;
		case 1:
			System.out.println(Week.TUESDAY);
			break;
		case 2:
			System.out.println(Week.WEDNESDAY);
			break;
		case 3:
			System.out.println(Week.THURSDAY);
			break;
		case 4:
			System.out.println(Week.FRIDAY);
			break;
		case 5:
			System.out.println(Week.SATURDAY);
			break;
		case 6:
			System.out.println(Week.SUNDAY);
			break;
		default:
			System.out.println("-----:");
			break;
		}

	}
}
