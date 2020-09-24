import java.util.Scanner;

public class array {
	
	public static void main(String[] args) {
		
		//textbook();
		//teacher();
		if(args.length != 1) {
			System.out.println("프로그램을 사용하려면 'java array 숫자'를 입력");
			System.exit(0);
		}
		//입력된 n1 값이 없으면 사용법을 안내할 수 있도록 입력
		System.out.println("args[0] = " + args[0]);
		String s1 = args[0];
		int n1 = Integer.parseInt(s1);
		//위 내용이 하나의 변수에 n1 값을 받아서 이용하겠다는 내용
		//참조. 이것이자바다 160쪽 - 변수를 여러 개 받을 수도 있음
		
		practice(n1);

	}

	private static void practice(int n1) {
		Scanner sc = new Scanner(System.in);
		int[] height = new int[n1];//사이즈를 확보해놓는 것(5개의 int 타입이 들어가는 array를 만든다)
		
		System.out.println("평균을 구할 " + n1 + "명의 키(cm)를 입력하세요");
		
		for(int i=0; i<n1; i++) {
			System.out.println((i+1) + "번째 > ");
			height[i]=sc.nextInt();
		}//5개의 데이터 입력
		
		System.out.println("각각의 키: ");
		for(int i=0; i<n1; i++) {
			System.out.println("\t" + height[i] + "cm");
		}//입력된 5개의 데이터 출력
		
		int sum = 0;
		for(int i=0; i<n1; i++) {
			sum += height[i];// sum = sum + height[i]; 라고 해도 동일하다
		}
		System.out.println("5명의 총합: " + sum + "cm");
		//총합 출력
		float avg = (float) sum / n1; 
		System.out.println("5명의 평균: " + avg + "cm");
		//평균 출력
		
	}

	private static void teacher() {
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[3];
		
		System.out.println("점수를 3개 입력하세요");
		
		for(int i=0; i<3; i++) {
			System.out.println((i+1) + "번째 > ");
			scores[i]=sc.nextInt();
		}
		
		System.out.println("scores[] = ");
		for(int i=0; i<3; i++) {
			System.out.println("\t" + scores[i]);
		}
		
	}

	private static void textbook() {
		int[] scores = { 83, 90, 87 };
		
		System.out.println("scores[0] : " + scores[0]);
		System.out.println("scores[1] : " + scores[1]);
		System.out.println("scores[2] : " + scores[2]);
		
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += scores[i];
		}
		System.out.println("총합 : " + sum);
		double avg = (double) sum / 3;
		System.out.println("평균 : " + avg);
		
	}

}
