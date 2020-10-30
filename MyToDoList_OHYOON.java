
import java.util.Scanner;

import javaLesson.Week;

public class MyToDoList_OHYOON {
	static Scanner sc = new Scanner(System.in);
	static String[][] todo = new String[7][3];

	public static void main(String[] args) {
		System.out.println("프로그램 파라미터 갯수에 맞도록 입력해주세요");
		System.out.println("사용법: MyToDoList_작성자이름영문 param1");
		System.out.println("param1 : 0이면 요일별 할일 등록");
		System.out.println("ex) java MyToDoList_OHYOON 0");
		System.out.println("-----------------------------");
		String s1 = args[0];

		if (s1.equals("0")) {
			makeList(todo);
			menu();
		}
	}

	private static String[][] makeList(String[][] todo) {
		System.out.println("[요일별 할일을 하나씩 입력합니다.]");
		for (int i = 0; i < todo.length; i++) {
			weekDayPrint(i);
			for (int j = 0; j < todo[i].length; j++) {
				System.out.print(">");
				todo[i][j] = sc.next();
			}
		}
		return todo;
	}

	private static void printList(String[][] todo) {
		System.out.println("[요일별 할일을 출력합니다.]");
		if (todo == null) {
			System.out.println("입력된 할일이 없습니다.");
		} else {
			for (int i = 0; i < todo.length; i++) {
				weekDayPrint(i);
				for (int j = 0; j < todo[i].length; j++) {
					System.out.print(">" + todo[i][j] + "\r\n");
				}
			}
		}
	}

	private static void weekDayPrint(int day) {
		switch (day) {
		case 0:
			System.out.println(Week.SUNDAY);
			break;
		case 1:
			System.out.println(Week.MONDAY);
			break;
		case 2:
			System.out.println(Week.TUESDAY);
			break;
		case 3:
			System.out.println(Week.WEDNESDAY);
			break;
		case 4:
			System.out.println(Week.THURSDAY);
			break;
		case 5:
			System.out.println(Week.FRIDAY);
			break;
		case 6:
			System.out.println(Week.SATURDAY);
			break;

		default:
			System.out.println("오류가 났어요....");
			break;
		}

	}

	private static void menu() {
		String sel = null;

		do {
			showMenu();
			sel = sc.next();
			if (!sel.equals("q")) {

				if (sel.equals("1")) {
					printList(todo);
				} else if (sel.equals("2")) {
					makeList(todo);
				} else if (sel.equals("3")) {
					dayList(todo);
				} else if (sel.equals("4")) {
					editList(todo);
				} else if (sel.equals("5")) {
					resetList(todo);
				} else {
					System.out.println("잘못된 입력입니다. 프로그램을 다시 시작하세요.");
				}
			}
		} while (!sel.equals("q"));
		System.out.println("프로그램을 종료합니다.");
	}

	private static void showMenu() {
		System.out.println("---------------------------");
		System.out.println("ToDo List v1.0");
		System.out.println("---------------------------");
		System.out.println("메뉴:");
		System.out.println("1.전체조회 2.Todo등록 3.Todo출력");
		System.out.println("4.Todo편집 5.리셋");
		System.out.println("(* 종료하려면 q를 누르세요)");
		System.out.println("---------------------------");

	}

	private static void dayList(String[][] todo) {
		System.out.println("어느 요일의 할일을 보시겠습니까?");
		System.out.println("0)일 1)월 2)화 3)수 4)목 5)금 6)토");
		int choice = sc.nextInt();
		weekDayPrint(choice);
		listPrint(choice);
	}

	private static void listPrint(int day) {
		for (int i = 0; i < todo[i].length; i++) {
			System.out.println(todo[day][i]);
		}
	}

	private static String[][] resetList(String[][] todo) {
		System.out.println("입력된 할일을 모두 지우시겠습니까? (Y/N)");
		String input = sc.next();
		if (input.equals("Y")) {
			for (int i = 0; i < todo.length; i++) {
				for (int j = 0; j < todo[i].length; j++) {
					todo[i][j] = null;
				}
			}
			System.out.println("초기화가 완료되었습니다.");
			System.out.println("메뉴로 돌아갑니다.");
			return todo;
		} else {
			System.out.println("초기화를 실행하지 않았습니다.");
			System.out.println("메뉴로 돌아갑니다.");
			return todo;
		}
	}

	private static String[][] editList(String[][] todo) {
		System.out.println("어느 요일의 할일을 수정합니까?");
		System.out.println("0)일 1)월 2)화 3)수 4)목 5)금 6)토");
		int choice = sc.nextInt();
		weekDayPrint(choice);
		System.out.println("현재 입력된 할일은 다음과 같습니다.");
		listPrint(choice);
		String[][] editToDo = listEdit(choice);
		return editToDo;
	}
	
	private static String[][] listEdit(int day) {
		System.out.println("어떻게 수정합니까?");
		for (int i = 0; i < todo[i].length; i++) {
			System.out.print(">");
			todo[day][i] = sc.next();
		}
		return todo;
	}

}
