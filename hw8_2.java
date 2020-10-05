import java.util.Arrays;
import java.util.Scanner;
//값이 입력된 배열에 대해 이름에 따라 성적 불러오기
public class hw8_2 {

	public static void main(String[] args) {
		System.out.println("성적처리 프로그램입니다.");
		String[][]arr1 = {
				{"홍길동", "100", "70", "100", "270", "90"},
				{"김이름", "99", "88", "77", "264", "88"},
				{"강민수", "50", "20", "15", "85", "28.3"},
				{"배재민", "90", "80", "85", "255", "85"},
				{"박수민", "100", "100", "100", "300", "100"},
				{"최태민", "32", "18", "29", "79", "26.3"},
				{"최상현", "52", "27", "90", "169", "56.3"},
				{"한종현", "70", "75", "60", "205", "68.3"},
				{"이루", "87", "52", "88", "227", "75.6"},
				{"오한결", "95", "76", "98", "269", "89.6"}
		};
		Scanner sc = new Scanner(System.in);
		System.out.println("성적을 알고 싶은 학생의 이름을 입력해주세요.");
		String s = sc.next();
		
		System.out.println("===============================");
		System.out.println("[이름, 국어, 수학, 영어, 합계, 평균]");
		if(arr1[0][0].equals(s)) {
			System.out.print(Arrays.deepToString(arr1[0]));
		} else if(arr1[1][0].equals(s)) {
			System.out.print(Arrays.deepToString(arr1[1]));
		} else if(arr1[2][0].equals(s)) {
			System.out.print(Arrays.deepToString(arr1[2]));
		} else if(arr1[3][0].equals(s)) {
			System.out.print(Arrays.deepToString(arr1[3]));
		} else if(arr1[4][0].equals(s)) {
			System.out.print(Arrays.deepToString(arr1[4]));
		} else if(arr1[5][0].equals(s)) {
			System.out.print(Arrays.deepToString(arr1[5]));
		} else if(arr1[6][0].equals(s)) {
			System.out.print(Arrays.deepToString(arr1[6]));
		} else if(arr1[7][0].equals(s)) {
			System.out.print(Arrays.deepToString(arr1[7]));
		} else if(arr1[8][0].equals(s)) {
			System.out.print(Arrays.deepToString(arr1[8]));
		} else if(arr1[9][0].equals(s)) {
			System.out.print(Arrays.deepToString(arr1[9]));
		}	
	}

}
