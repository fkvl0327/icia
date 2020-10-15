package classLesson;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {

	public static void main(String[] args) {
		//arrayListStringTest();
		arrayListIntegerTest();

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
