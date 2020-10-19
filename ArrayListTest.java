package classLesson;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {

	public static void main(String[] args) {
		//arrayListStringTest();
		//arrayListIntegerTest();
		bubbleSortTest();

	}

	private static void bubbleSortTest() {
		
		//(46기준) 숫자가 물수제비처럼 이동하기 때문에 bubble sort라고 부름
		
		//코딩 아닌 설명 부분 array 구분 편하게 하려고 주석처리 안 한 것 때문에 오류 발생
		//일부러 그냥 놔뒀음
		int[] numbs = new int[] {46, 6, 0, 8, 5, 3};//작성한 배열, i=0, j=0일 때
		//numbs[0]이 numbs[1]보다 크기 때문에 자리를 바꾼다
		int[] numbs = new int[] {6, 46, 0, 8, 5, 3};//자리를 바꾼 모습, i=0, j=1일 때
		//numbs[1]이 numbs[2]보다 크기 때문에 자리를 바꾼다
		int[] numbs = new int[] {6, 0, 46, 8, 5, 3};//자리를 바꾼 모습, i=0, j=2일 때
		//numbs[2]가 numbs[3]보다 크기 때문에 자리를 바꾼다
		int[] numbs = new int[] {6, 0, 8, 46, 5, 3};//자리를 바꾼 모습, i=0, j=3일 때
		//numbs[3]이 numbs[4]보다 크기 때문에 자리를 바꾼다
		int[] numbs = new int[] {6, 0, 8, 5, 46, 3};//자리를 바꾼 모습, i=0, j=4일 때
		//numbs[4]가 numbs[5]보다 크기 때문에 자리를 바꾼다
		int[] numbs = new int[] {6, 0, 8, 5, 3, 46};//자리를 바꾼 모습, i=1, j=0일 때
		//i=0일 때, j는 4가 마지막 값이므로 다음으로 i=1인 경우 진행
		//numbs[0]가 numbs[1]보다 크기 때문에 자리를 바꾼다
		int[] numbs = new int[] {0, 6, 8, 5, 3, 46};//자리를 바꾼 모습, i=1, j=1일 때
		//numbs[1]이 numbs[2]보다 작기 때문에 자리를 바꾸지 않는다
		//i=1, j=2일 때도 같은 모습
		//numbs[2]가 numbs[3]보다 크기 때문에 자리를 바꾼다
		int[] numbs = new int[] {0, 6, 5, 8, 3, 46};//자리를 바꾼 모습, i=1, j=3일 때
		//numbs[3]이 numbs[4]보다 크기 때문에 자리를 바꾼다
		//i=1일 때, j는 3이 마지막 값이므로 다음으로 i=2인 경우 진행
		int[] numbs = new int[] {0, 6, 5, 3, 8, 46};//자리를 바꾼 모습, i=2, j=0일 때
		//numbs[0]이 numbs[1]보다 작기 때문에 자리를 바꾸지 않는다
		//i=2, j=1일 때도 같은 모습
		//numbs[1]이 numbs[2]보다 크기 때문에 자리를 바꾼다
		int[] numbs = new int[] {0, 5, 6, 3, 8, 46};//자리를 바꾼 모습, i=2, j=2일 때
		//numbs[2]가 numbs[3]보다 크기 때문에 자리를 바꾼다
		//i=2일 때, j는 2가 마지막 값이므로 다음으로 i=3인 경우 진행
		int[] numbs = new int[] {0, 5, 3, 6, 8, 46};//자리를 바꾼 모습, i=3, j=0일 때
		//numbs[0]이 numbs[1]보다 작기 때문에 자리를 바꾸지 않는다
		//i=3, j=1일 때도 같은 모습
		//numbs[1]이 numbs[2]보다 크기 때문에 자리를 바꾼다
		//i=3일 때, j는 1이 마지막 값이므로 다음으로 i=4인 경우 진행
		int[] numbs = new int[] {0, 3, 5, 6, 8, 46};//자리를 바꾼 모습, i=4, j=0일 때
		//numbs[0]이 numbs[1]보다 작기 때문에 자리를 바꾸지 않는다.
		//따라서 array를 출력하면 작은 값부터 큰 값 순으로 나온다.
		
		int temp;
		for(int i=0;i<numbs.length;i++) {//i는 numbs 원소 개수만큼 반복(6번)
			for(int j=0;j<numbs.length-i-1;j++) {//j는 numbs 원소 개수에서 i를 뺀 값-1까지 반복
				//i가 0일 때는 6-0-1 =5
				//즉, i가 0일 때 j는 0, 1, 2, 3, 4 총 5회 진행
				//i=1이면 j=6-1-1=4로, 0, 1, 2, 3 총 4회 진행
				//i=2이면 j=6-2-1=3으로, 0, 1, 2 총 3회 진행
				//i=3이면 j=6-3-1=2로, 0, 1 총 2회 진행
				//i=4이면 j=6-4-1=1, 0만 1회 진행
				//앞의 숫자가 뒤의 숫자보다 크면
				if(numbs[j]>numbs[j+1]) {
					//앞과 뒤의 자리를 바꾼다
					temp = numbs[j];
					numbs[j] = numbs[j+1];
					numbs[j+1] = temp;
				}
			}
		}
		
	}

	private static void arrayListIntegerTest() {
		ArrayList<Integer> myNumbers = new ArrayList<Integer>();
	    myNumbers.add(33);
	    myNumbers.add(15);
	    myNumbers.add(20);
	    myNumbers.add(34);
	    myNumbers.add(8);
	    myNumbers.add(12);

		Collections.sort(myNumbers);//정순
		for(Integer i : myNumbers) {
			System.out.println(i);
		}
		
		System.out.println();
		
		Collections.reverse(myNumbers);//역순
		for(Integer i : myNumbers) {
			System.out.println(i);
		}
		
		int[] numbs = new int[myNumbers.size()];
		for(int i=0;i<myNumbers.size();i++) {
			numbs[i] = myNumbers.get(i);
		}
		
		//algorithm: 버블소팅 bubble sorting...
		//버블소팅, 퀵소팅
		int temp;
		for(int i=0;i<numbs.length;i++) {
			for(int j=0;j<numbs.length-i-1;j++) {
				if(numbs[j]>numbs[j+1]) {
					temp = numbs[j];
					numbs[j] = numbs[j+1];
					numbs[j+1] = temp;
				}
			}
		}
		
		
		System.out.println();
		for(int i=0;i<numbs.length;i++) {
			System.out.printf("numbs[%d] = %d \n", i, numbs[i]);
		}
		
		//역순
		for(int i=0;i<numbs.length;i++) {
			for(int j=0;j<numbs.length-i-1;j++) {
				if(numbs[j]<numbs[j+1]) {
					temp = numbs[j];
					numbs[j] = numbs[j+1];
					numbs[j+1] = temp;
				}
			}
		}
		
		System.out.println();
		for(int i=0;i<numbs.length;i++) {
			System.out.printf("numbs[%d] = %d \n", i, numbs[i]);
		}
	}

	private static void arrayListStringTest() {
		ArrayList<String> cars = new ArrayList<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    
	    Collections.sort(cars);
	    
	    for(String car: cars) {
	    	System.out.println(car);
	    }
		System.out.println();
		
		Collections.reverse(cars);
		
		String[] carArr1 = new String[cars.size()];
		
		for(int i=0;i<cars.size();i++) {
			System.out.printf("cars[%d] = %s \n",i,cars.get(i));
			carArr1[i] = cars.get(i);
		}
		
		for(int i=0;i<carArr1.length;i++) {
			System.out.printf("cars[%d] = %s \n",i,carArr1[i]);
		}
		
		//sorting(만들다 보니까 개념 이해용으로는 너무 복잡해서 보류
//		for(int i=0;i<carArr1.length;i++) {
//			for(int j=0;j<(carArr1.length-i)-1;j++) {
//				if(carArr1[j] > carArr1[j+1]) {
//					
//				}
//			}
//		}
	}

}
