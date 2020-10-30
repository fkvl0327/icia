
import java.util.HashMap;
import java.util.Scanner;

public class MyToDoList_HashMap_OHYOON {
	static Scanner sc = new Scanner(System.in);
	static HashMap<Integer, String> todo = new HashMap<Integer, String>();

	public static void main(String[] args) {
		menu();
	}

	private static void makeList() {
		System.out.println("요일을 입력하세요.");
		System.out.println("요일 입력은 숫자로 할 수 있습니다.");
		System.out.println("0)일 1)월 2)화 3)수 4)목 5)금 6)토");
		int day = sc.nextInt();
		System.out.println("할 일을 입력하세요.");
		String work = sc.next();
		todo.put(day, work);
	}

	private static void printList() {
		for (int day : todo.keySet()) {
			weekDayPrint(day);
			System.out.println(todo.get(day));
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
					printList();
				} else if (sel.equals("2")) {
					makeList();
				} else if (sel.equals("3")) {
					dayList();
				} else if (sel.equals("4")) {
					editList();
				} else if (sel.equals("5")) {
					resetList();
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

	private static void dayList() {
		System.out.println("어느 요일의 할일을 보시겠습니까?");
		System.out.println("0)일 1)월 2)화 3)수 4)목 5)금 6)토");
		int day = sc.nextInt();
		weekDayPrint(day);
		System.out.println(todo.get(day));
	}

	private static void resetList() {
		System.out.println("입력된 할일을 모두 지우시겠습니까? (Y/N)");
		String input = sc.next();
		if (input.equals("Y")) {
			todo.clear();
			System.out.println("초기화가 완료되었습니다.");
		} else {
			System.out.println("초기화를 실행하지 않았습니다.");
		}
		System.out.println("메뉴로 돌아갑니다.");
	}

	private static void editList() {
		System.out.println("어느 요일의 할일을 수정합니까?");
		System.out.println("0)일 1)월 2)화 3)수 4)목 5)금 6)토");
		int day = sc.nextInt();
		weekDayPrint(day);
		System.out.println("현재 입력된 할일은 다음과 같습니다.");
		System.out.println(todo.get(day));
		System.out.println("어떻게 변경하시겠습니까?");
		System.out.print(">");
		String work = sc.next();
		System.out.println("변경한 내용을 확인하세요.");
		weekDayPrint(day);
		System.out.println("할일:"+work);
		todo.put(day, work);
		
	}
	
	enum Week {
		SUNDAY,
		MONDAY,
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY
	};

}
