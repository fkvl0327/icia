package practices;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
	static HashMap<String, String> map = new HashMap<String, String>();

	public static void menu() {
		System.out.println("--------------");
		System.out.println("[전화번호부 메뉴]");
		System.out.println("1. 전체조회     2. 전화번호 검색");
		System.out.println("3. 전화번호 추가 4. 전화번호 삭제 5. 리셋");
		System.out.println("*종료하려면 q를 누르세요");
		System.out.println("--------------");
	}

	public static void main(String[] args) {
		contact();
		
	}

	private static void contact() {
		Scanner sc = new Scanner(System.in);
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
					System.out.println("5. 리셋");
					reset();
				} else {
					System.out.println("해당메뉴가 없습니다 메뉴를 다시 확인하세요");
				}
			}
		} while (!input.equals("q"));
		System.out.println("메뉴를 종료합니다.");
		
		
		
	}
	private static void select() {
		for (String name : map.keySet()) {
			System.out.printf("%s %s \n", name, map.get(name));
		}

	}

	private static void insert() {
		Scanner sc = new Scanner(System.in);
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
		Scanner sc = new Scanner(System.in);
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

	private static void delete() {//있는 이름인지 없는 이름인지에 따라 다르게 뜨게 만들면 좋겠다
		Scanner sc = new Scanner(System.in);
		System.out.print("번호를 삭제할 이름을 입력하세요>");
		String name = sc.next();
		if (map.containsKey(name)) {
			map.remove(name);
			System.out.println(name+"의 번호가 삭제 완료되었습니다.");
		} else {
			System.out.println("조회되지 않습니다. 이름을 다시 확인해주세요.");
			System.out.println("초기 메뉴로 돌아갑니다.");
		}
	}

	private static void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("번호를 조회할 이름을 입력하세요>");
		String name = sc.next();
		System.out.println(map.get(name));

	}
	
}
