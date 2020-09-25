import java.util.Scanner;

public class _array_afternoon1 {

	public static void main(String[] args) {
//		int [] a = {10,20,30};
//		int [][] b = new int [2][];
//		//배열 출력 방법
//		System.out.println("a: ");
//		for(int i=0;i<3;i++) {
//			System.out.println("=" + a[i]);
//		}//1. a의 i번째 값들을 for문으로 print
//		System.out.println("a: ");
//		for(int j: a) {
//			System.out.println("=" + j);
//		}//2. for(int 임의의 문자: a)로 print
//		//2번 방법은 foreach문 이라고 함'';
//		
//		//java에서는 배열의 값을 보여주는 방법이
//		//처음부터 배열의 값을 고정해서 알려주거나
//		//각 좌표의 값을 알려주거나
//		//정확하게 입력하는 방법밖에 없음
//		
//		//cf. c언어에서는 값을 직접 입력하지 않아도 조건 입력에 따라 볼 수 있음 (??? 어떻게)
//		
//		b[0] = new int [3];
//		b[1] = new int [4];
		//앞서 이중배열이라는 정보가 주어진 배열 b에 대해서 b 안의 첫 번째 배열은 3자리, 두 번째 배열은 4자리라는 공간을 제시
		//사이즈에 대해서는 주어졌지만 배열 안의 값에 대해서는 여전히 주어지지 않은 정보이므로 값 입력이 필요하다
		
		//배열을 초기화하는 방법
		//Arrays.fill(a,1); // a의 모든 index값을 1로 초기화
		
		Scanner sc = new Scanner(System.in);
		System.out.println("배열 h의 원소를 입력해주세요.");
		int h [][] = new int[3][3];
		
		for(int i=0;i<h[0].length;i++) {
			for(int j=0;j<h[1].length;j++) {

				System.out.println("h[" + i + "]" + "[" + j + "] = ");
				
				h[i][j] = sc.nextInt();
//				System.out.println("---------------------");
				System.out.printf("h[%d][%d] = %d \n", i, j, h[i][j]);
		}	
			
		
		}		
}
}