
public class _array_167p {

	public static void main(String[] args) {
		String[] strArray = new String[3];
		strArray[0] = "Java";
		strArray[1] = "Java";
		strArray[2] = new String("Java");
		
		System.out.println(strArray[0] == strArray[1]);
		System.out.println(strArray[0] == strArray[2]);
		System.out.println(strArray[0].equals(strArray[2]));
		
		int[] oldIntArray = {1,2,3};
		int[] newIntArray = new int[5];
		
		for(int i=0; i<oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];//old에서 제시한 원소를 new에서 그대로 쓰겠다는 내용
		}//new[3]=old[4]=0
		
		for(int i=0; i<newIntArray.length; i++) {
			System.out.println(newIntArray[i]);//1~3번째 원소는 있던 대로, 4~5번은 입력되지 않아 0
		}
		
		int[][] a = {{10,20,30,40}, {111,222,333}};
		int[][] newA = new int[5][5];
		
		for(int i=0; i<a[0].length; i++) {
			for(int j=0; j<a[1].length; j++) {
			newA[i][j] = a[i][j];
			//newA[0][0] = a[0][0]
			//newA[0][1] = a[0][1]
			//newA[2][0] = a[2][0] 
			System.out.println(newA[i][j]);
		}
		}
//		for(int i=0; i<newA.length; i++) {
//			System.out.println(newA);
//		}
	}

}
