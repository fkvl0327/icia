import java.util.HashMap;
import java.util.Scanner;

public class MyPhoneBook_OHYOON {
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, String> map = new HashMap<String, String>();

	public MyPhoneBook_OHYOON() {
		map.put("name", "number");
	}

	public static void menu() {
		System.out.println("--------------");
		System.out.println("[전화번호부 메뉴]");
		System.out.println("1. 전체조회     2. 전화번호 검색");
		System.out.println("3. 전화번호 추가 4. 전화번호 삭제");
		System.out.println("5. 전화번호 편집 6. 리셋");
		System.out.println("*종료하려면 q를 누르세요");
		System.out.println("--------------");
	}

	public static void main(String[] args) {
		String input;
		int sel = 0;

		do {
			menu();
			input = sc.next();

			if (!input.equals("q")) {
				sel = Integer.parseInt(input);
				if (sel == 1) {
					System.out.println("1. 전체조회");
					select();
				} else if (sel == 2) {
					System.out.println("2. 전화번호 검색");
					search();
				} else if (sel == 3) {
					System.out.println("3. 전화번호 추가");
					insert();
				} else if (sel == 4) {
					System.out.println("4. 전화번호 삭제");
					delete();
				} else if (sel == 5) {
					System.out.println("5. 전화번호 편집");
					edit();
				} else if (sel == 6) {
					System.out.println("6. 리셋");
					reset();
				} else {
					System.out.println("해당메뉴가 없습니다 메뉴를 다시 확인하세요");
				}
			}
		} while (!input.equals("q"));
		System.out.println("메뉴를 종료합니다.");
	}

	private static void edit() {
		System.out.print("정보를 변경할 이름을 입력하세요>");
		String name = sc.next();
		System.out.println(map.get(name));
		System.out.println("어떻게 변경하시겠습니까?");
		System.out.print("번호>");
		String number = sc.next();
		System.out.println("변경한 내용을 확인하세요.");
		System.out.println("이름: " + name + " 번호: " + number);
		map.put(name, number);
	}

	private static void select() {
		for (String name : map.keySet()) {
			System.out.println(name + " " + map.get(name));
		}

	}

	private static void insert() {
		System.out.print("이름을 입력하세요>");
		String name = sc.next();
		System.out.print("번호를 입력하세요>");
		String number = sc.next();
		System.out.println("입력된 내용을 확인하세요.");
		System.out.println("이름: " + name + " 번호: " + number);
		map.put(name, number);
	}

	private static void reset() {
		System.out.println("리셋은 전체 번호 삭제입니다. 실행합니까? (Y/N)");
		String yesOrNo = sc.next();
		if (yesOrNo.equals("Y")) {
			map.clear();
			System.out.println("전체 번호가 삭제 완료되었습니다.");
		} else if (yesOrNo.equals("N")) {
			System.out.println("삭제하지 않았습니다.");
		} else {
			System.out.println("입력값이 올바르지 않습니다. Y 또는 N 입력이 필요합니다.");
			System.out.println("초기 메뉴로 돌아갑니다.");
		}
	}

	private static void delete() {
		System.out.print("번호를 삭제할 이름을 입력하세요>");
		String name = sc.next();
		map.remove(name);
		System.out.println(name + "의 번호가 삭제 완료되었습니다.");
	}

	private static void search() {
		System.out.print("번호를 조회할 이름을 입력하세요>");
		String name = sc.next();
		System.out.println(map.get(name));

	}
}
