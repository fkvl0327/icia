package binn;

public class Main {

	public static void main(String[] args) {
		Average avg = new Average();
		
		int[] TestArr1 = {3, 4, 5};
		System.out.print("TestArr1의 평균:");
		avg.average(TestArr1);
		
		int[] TestArr2 = {10, 20, 30};
		System.out.print("TestArr2의 평균:");
		avg.average(TestArr2);
		
		int[] TestArr3 = {30, 60};
		System.out.print("TestArr3의 평균:");
		avg.average(TestArr3);

	}
}

class Average {
	
	void average(int[] arr) {
		int sum =0;
		for (int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum/arr.length);
	}
	
}