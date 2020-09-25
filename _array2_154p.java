
public class _array2_154p {

	public static void main(String[] args) {
		int[] scores;
		scores = new int[] {83, 90, 87};
		int sum1 = 0;
		for(int i=0; i<3; i++) {
			System.out.println(i + "번째 값 (초기값) = " + scores[i]);
			sum1 += scores[i];
		}
		System.out.println("총합1 : " + sum1);
		
		int sum2 = add(new int[] {83, 90, 87});
		System.out.println("총합2 : " + sum2);//154페이지 예시
		
		int sum3 = add(new int[] {100, 50, 20});
		System.out.println("총합3 : " + sum3);//배열에서 함수생성 사용하는 방법: ()안에 new int[] {집합} 입력//실습
		
		int sum4 = add(scores);
		System.out.println("총합4 : " + sum4);
		
		scores = new int[10];
		scores[0]=100;
		scores[1]=200;
		scores[2]=300;
		scores[3]=300;
		scores[4]=400;// 위에서 제시한 것과 다른 값을 새로 입력할 수 있다
		for(int i=0; i<3; i++) {
			System.out.println(i + "번째 값 (변경확인) = " + scores[i]);
			sum1 += scores[i];
		}
		int sum5 = add(scores);
		System.out.println("총합5 : " + sum5);

		//배열에서는 작은 공간에 큰 데이터를 넣을 때 문제 발생
		
		int[] number;
		number = new int[] {1,2,3};
		int check = 0;
		System.out.println("number.length = " + number.length);
		for(int i=0; i<number.length; i++) {
			System.out.println(i + "번째 값 = " + number[i]);
			check += number[i];
		}
		System.out.println(check);
		
		//공간을 주지 않고 데이터를 실제로 주면 주어진 데이터 개수와 동일하게 length를 구할 수 있다
	}
	
	public static int add(int[] scores) {
		int sum = 0;
		System.out.println("length = " + scores.length);
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		
		return sum;
		//scores.length는 new int[] 안의 숫자와 동일하다
		//위 내용에서는 실제 스코어 개수는 5개인데 10칸이 주어져서 불필요한 공간이 있기는 하지만
		//데이터보다 넓은 공간이 주어져서 오류는 나지 않고 계산이 실행된다.
	}
	
	
	

}
