
public class test2017_1_sample_eungyong {//비트연산자 문제 : 비트연산자는 배워서 어디에 쓰는가? 

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
			.replace("0", "_").replace("1", "#");
//					while (arr[i].length() < n) {
//						arr[i] = "0" + arr[i];
//					}//문제의 예제가 앞자리 빈칸을 표시하지 않게 하고 있으므로 불필요
		}
		
		return arr;
	}
	
	public static void printArr(String[] arr) {
		StringBuilder sb = new StringBuilder();
		for(String i: arr) {
//			sb.append("["+i+"]\n");//예제가 "", "" 형식으로 보여주기를 요구하므로 다르게 써야
		}
		System.out.println(sb.toString());
	}
	

}
