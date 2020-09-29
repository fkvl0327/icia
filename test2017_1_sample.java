
public class test2017_1_sample {//비트연산자 문제 : 비트연산자는 배워서 어디에 쓰는가? 

	public static void main(String[] args) {
		int[]arr1 = {9, 20, 28, 18, 11};
		int[]arr2 = {30, 1, 21, 17, 28};
		printArr(map(5, arr1, arr2));
		
		arr1 = new int[]{46,33,33,22,31,50};
		arr2 = new int[]{27,56,19,14,14,10};
		printArr(map(6, arr1, arr2));
		
		

	}

	public static String[] map(int n, int[] arr1, int[] arr2) {
		
		String[] arr = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.toBinaryString(arr1[i]|arr2[i])
                    .replace("0", " ")
                    .replace("1", "#");

		}
		return arr;
	}
	
	public static void printArr(String[] arr) {
		StringBuilder sb = new StringBuilder();
		for(String i: arr) {
			sb.append(", \""+i+"\"");
		}
		System.out.println(sb.toString().replaceFirst(", ", ""));
	}
// 샘플 = https://javaplant.tistory.com/3
// 이 코딩에서는 앞자리가 0인 것까지 분명히 표현되지는 않는다
	

}
