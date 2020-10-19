package classLesson;

import java.util.LinkedList;

public class LinkedListTest {// LinkedList까지만 쓰면
	// java에서 제공하는 클래스와 혼동돼서 import 정상 실행 안되니 주의 필요

	public static void main(String[] args) {
		LinkedList<String> cars = new LinkedList<String>();
		cars.clear();

		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");
		cars.add("morning");
		cars.add("morning");

		System.out.println("last index: " + cars.indexOf("morning"));
		System.out.println("last index: " + cars.lastIndexOf("morning"));
		//indexOf는 그 값이 처음으로 입력된 순번을 출력
		//lastIndexOf는 그 값이 마지막으로 입력된 순번을 출력
		
//		if(cars.contains("morning")) {
//			System.out.println("remove..morning..");
//			int index = cars.indexOf("morning");
//			cars.remove(index);
//		}
	
	}

}
