package classLesson;

public class Computer {
	int sum1(int[] values) {//개수를 모를 때 (new int[] {원소배열})
		int sum = 0;
		
		for(int i=0; i<values.length; i++) {
			sum += values[i];
		}
		
		return sum;
	}
	
	int sum2(int... values) {//... : 몇 개가 오더라도 받아준다 = (원소배열)
		// 유용하게 자주 쓰니까 기억해둡시다(파이썬에서도 써요)
		int sum = 0;
		
		for(int i=0; i<values.length; i++) {
			sum += values[i];
		}
		
		return sum;
	}
}
