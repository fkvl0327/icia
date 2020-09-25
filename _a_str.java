
public class _a_str {

	public static void main(String[] args) {
		
		//arr1();
		//arr2();
		//arr3();
		again();
		
	}

	private static void again() {
		String[][] arr2 = {{"a", "b", "c"}, {"12a", "13a", "14a", "8", "0", "happy"}};
		String[][] arr3 = new String [4][5];
		
		System.arraycopy(arr2, 0, arr3, 0, arr2.length);
		//소스, 시작위치, 데스티네이션, 데스티네이션위치, 소스길이
		//2중 for문으로 가져오는 것과 형태는 조금 다르다 (null)이 있을 칸이 채워짐
		//데스티네이션 공간이 부족해도 소스 값을 그대로 가져온다
		
		for(int i=0; i<arr3.length;i++) {
			for(int j=0; j<arr3[i].length;j++) {
				System.out.printf("%s\t", arr3[i][j]);
			}	System.out.println();
		}
	}

	private static void arr3() {
		String[][] arr2 = {{"a", "b", "c"}, {"12a", "13a", "14a"}};
		String[][] arr3 = new String [4][5];
		
		for(int i=0; i<arr2.length;i++) {
			for(int j=0; j<arr2[i].length;j++) {
				arr3[i][j] = arr2[i][j];
				System.out.printf("%s\t", arr2[i][j]);
			}	System.out.println();
		}
		
		System.out.println("----------아래는 카피---------");
		
		for(int i=0; i<arr3.length;i++) {
			for(int j=0; j<arr3[i].length;j++) {
				System.out.printf("%s\t", arr3[i][j]);
			}	System.out.println();
		}
		
	}

	private static void arr2() {
		String[][] arr2 = {{"a", "b", "c"}, {"12a", "13a", "14a"}};
		
		for(int i=0; i<arr2.length;i++) {
			for(int j=0; j<arr2[i].length;j++) {
				System.out.printf("%s\t", arr2[i][j]);
			}	System.out.println();
		}
		
	}

	private static void arr1() {
		String[] arr1 = new String[3];
		arr1[0] = "Java1";
		arr1[1] = "Java2";
		arr1[2] = "Java3";
		
		for(int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		
	}

}
