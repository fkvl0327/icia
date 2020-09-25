import java.util.Scanner;

public class array_input {

	public static void main(String[] args) {
		int arr[][] = new int[2][3];
		int a, i, j;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("2차원 배열 안의 값을 순차적으로 입력하세요");
		for(i=0; i<arr.length; i++) {
			for(j=0; j<arr[i].length; j++) {
				System.out.print("arr[" + i + "][" + j + "] : ");
				a = sc.nextInt();
				arr[i][j] = a;
			}
		}
		for(i=0; i<2; i++) {
			for(j=0; j<3; j++) {
				System.out.println("arr[" + i + "][" + j + "]: " + arr[i][j]);
			}
		}
	}

}
