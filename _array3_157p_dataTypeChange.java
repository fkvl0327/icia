
public class _array3_157p_dataTypeChange {

	public static void main(String[] args) {
		//1.
		int[] arr1 = new int[3];//데이터 공간을 3개 제시
		for(int i=0; i<3; i++) {
			System.out.println("arr1[" + i + "] : " + arr1[i]);// 모두 숫자 데이터 초기값 0으로 출력
		}
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		for(int i=0; i<3; i++) {
			System.out.println("arr1[" + i + "] : " + arr1[i]);// 바로 위에서 입력한 데이터 값으로 출력
		}
		//2.
		double[] arr2 = new double[3];
		for(int i=0; i<3; i++) {
			System.out.println("arr2[" + i + "] : " + arr2[i]);// 모두 숫자 데이터 초기값 0.0으로 출력
		}
		arr2[0] = 0.1;
		arr2[1] = 0.2;
		arr2[2] = 0.3;
		for(int i=0; i<3; i++) {
			System.out.println("arr2[" + i + "] : " + arr2[i]);// 바로 위에서 입력한 데이터 값으로 출력
		}
		//3.
		String[] arr3 = new String[3];
		for(int i=0; i<3; i++) {
			System.out.println("arr3[" + i + "] : " + arr3[i]);// 모두 문자 데이터 초기값 null로 출력
		}
		arr3[0] = "1월";
		arr3[1] = "2월";
		//arr3[2] = "3월";
		//arr3[3] = "4월";
		for(int i=0; i<arr3.length; i++) {
			System.out.println("arr3[" + i + "] : " + arr3[i]);// 바로 위에서 입력한 데이터 값으로 출력
		}
		//데이터 공간이 세 개인데 4개의 데이터를 입력하면 오류 발생
		//데이터 공간 세 개를 마련하고 2개의 데이터를 입력하면 오류는 발생하지 않고 잘 실행됨
	}

}
