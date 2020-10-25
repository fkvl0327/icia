package practices;

public class Self {

	public static void main(String[] args) {
		int[] arr = createArray();
		changeArray(arr, 7);
		
		for (int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");//8 9 10 11 12
		System.out.println();
		System.out.println("sum=" + sumArray(arr));//50
	}
		


	private static int sumArray(int[] arr) {
		int tot=0;
		for(int i:arr) {
			tot+=i;
		}
		return tot;
	}

	private static void changeArray(int[] arr, int n) {
		for(int i=0;i<arr.length;i++) {
			arr[i]+= n;
		}
		
	}

	private static int[] createArray() {
		int[] arr = {1,2,3,4,5};
		return arr;
	}

}
