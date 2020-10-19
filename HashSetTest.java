package classLesson;

import java.util.Collections;
import java.util.HashSet;

public class HashSetTest {
	
	public static void main(String[] args) {
		hashSetStr();
		//hashSetInt();
		
	
	}

	private static void hashSetInt() {
		// TODO Auto-generated method stub
		HashSet<Integer> numbs = new HashSet<Integer>();
		numbs.add(4);
		numbs.add(5);
		numbs.add(8);
		
		for(int i=0; i<10; i++) {
			if(numbs.contains(i)) {
				System.out.println(i + " 번호가 있어요!");
			}else {
				System.out.println(i + " 번호가 없어요");
			}
		}
	}

	private static void hashSetStr() {
		HashSet<String> cars = new HashSet<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("BMW");
		cars.add("Mazda");
		cars.add("morning");

		System.out.println("size: " + cars.size());
		
		//HashSet도 HashMap처럼 순서대로 출력하지 않는다
		//순서대로 출력을 원하면 Linked~사용 필요
		System.out.println("{cars}: " + cars);
		
		System.out.println("---------");
		
		if(cars.contains("morning")) {
			System.out.println("Is there morning?");
			System.out.println("cars - found: morning");
			System.out.println("remove...");
			cars.remove("morning");
		}
		
		System.out.println("--------");
		
		for(String i: cars) {
			System.out.println(i);
		}
		
		
		//sort, reverse는 set에서는 사용할 수 없고 list 사용가능
//		Collections.sort(cars);
//		Collections.reverse(cars);
		
	}
}
