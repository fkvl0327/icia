import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		// 100미만의 점수를 입력시 10단위 숫자로 주기
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String n1 = null;
		int grade;
		try {
			do {
				System.out.println("100미만의 숫자 입력 or 종료시 키리면 q를 입력해주세요");
				System.out.print("입력 : ");
				n1 = sc.next();
				if (!n1.equals("q")) {
					grade = Integer.parseInt(n1);
					input(grade);
				} else if (n1.equals("q")) {
					System.out.println("시스템을 종료합니다");
				}
			} while (!n1.equals("q"));
		} catch (NumberFormatException e) {
			System.out.println("다시 입력해 주세요");
			main(null);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("에러데스");
		}
	}

	private static void input(int grade) {
		if (100 > grade && grade >= 90) {
			System.out.println("성적은 90 이상 입니다 : " + grade);
		} else if (90 > grade && grade >= 80) {
			System.out.println("성적은 80 이상 입니다 : " + grade);
		} else if (80 > grade && grade >= 70) {
			System.out.println("성적은 70 이상 입니다 : " + grade);
		} else if (70 > grade && grade >= 60) {
			System.out.println("성적은 60 이상 입니다 : " + grade);
		} else if (60 > grade && grade >= 50) {
			System.out.println("성적은 50 이상 입니다 : " + grade);
		} else if (50 > grade && grade >= 40) {
			System.out.println("성적은 40 이상 입니다 : " + grade);
		} else if (40 > grade && grade >= 30) {
			System.out.println("성적은 30 이상 입니다 : " + grade);
		} else if (30 > grade && grade >= 20) {
			System.out.println("성적은 20 이상 입니다 : " + grade);
		} else if (20 > grade && grade >= 10) {
			System.out.println("성적은 10 이상 입니다 : " + grade);
		} else if (10 > grade && grade >= 0) {
			System.out.println("공부 드럽게 못하네");
		}
	}

}
