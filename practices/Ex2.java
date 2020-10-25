package practices;

//문제1. arr의 원소값을 +7이 되게 하시오.
//문제2. arr의 원소값을 모두 더하시오.
public class Ex2 {

	public static void main(String[] args) {
		
		int[] arr=createArray();

		addAllArray(arr, 7);

		for (int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");//8 9 10 11 12
		System.out.println();
		System.out.println("sum=" + sumArray(arr));//50
	}
	
	private static int[] createArray() {
		int[] arr;
		arr=new int[] {1,2,3,4,5};//heap(메소드가 공유할 객체)
		return arr;
	}
	
	// 모범답안
	private static int sumArray(int[] arr) {
		int tot=0;
		for(int e:arr) {
			tot+=e;
		}
		return tot;
	}

	// 모범답안(스태틱 종료돼도 그대로)
	private static void addAllArray(int[] arr, int n) {
		for(int i=0;i<arr.length;i++) {
			arr[i]+= n;
		}

	}

	// 원소값을 바꾸고, 더하는 것도 같이 하는 법(스태틱 안에서 끝남)
//	private static void addAllArray(int[] arr, int add) {
//		int num=arr[0];
//		int sum=0;
//		
//		for (int i=0;i<arr.length;i++) {
//			num = arr[i];
//			num = num + add;
//			sum+= num;
//		}
//		System.out.println("addAllArray: " + sum);
//	}

}
