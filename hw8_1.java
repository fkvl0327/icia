import java.util.Arrays;

public class hw8_1 {

	public static void main(String[] args) {
	
	arrange();
	//star();
	//star2();
	//star3();
	//star4();
	}
	

	private static void star4() {
		System.out.println("5번문제");
		for(int i=0; i<6; i++) {
			for(int j=6; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}


	private static void star3() {
		System.out.println("4번문제");
		for(int i=0; i<6; i+=2) {
			for(int j=6; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=2; i<8; i+=2) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}


	private static void star2() {
		System.out.println("3번문제");
		for(int i=0; i<6; i++) {
			for(int j=6; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=2; i<7; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}


	private static void star() {
		System.out.println("2번문제");
		for(int i=0; i<6; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0; i<6; i++) {
			for(int j=6; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}


	private static void arrange() {
		System.out.println("1번문제");
		int[][]arr1= {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
	};
	
	System.out.println("arr1: " + Arrays.deepToString(arr1));
	int[][]arr2 = new int[5][5];
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				arr2[i][j] = arr1[j][i];
				}
		}
	System.out.println("arr2: " + Arrays.deepToString(arr2));	
	}
		
}

//1. 항목을 재배치해서 배열을 출력하는 함수를 프로그래밍
//2. 별표 그림 : for 구문 사용