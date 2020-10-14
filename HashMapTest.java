package classLesson;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		//hashMap();
		//people();
	}

	private static void people() {
		HashMap<String, Integer> people = new HashMap<String, Integer>();
		//<>부분을 작성하지 않으면 superclass의 기본값은 obj, obj가 됩니다

	    // Add keys and values (Name, Age)
	    people.put("정대교", 24);
	    people.put("변준혁", 26);
	    people.put("박종식", 25);

	    for (String i : people.keySet()) {
	      System.out.println("이름: " + i + "(나이: " + people.get(i) + "세)");
	    }
		
	}

	private static void hashMap() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "정대교");
		map.put(2, "전솔지");
		map.put(3, "변준혁");
		map.put(4, "박종식");
		map.put(5, "피성우");
		map.put(6, "오남혁");
		map.put(7, "김동균");
		map.put(8, "곽영규");
		map.put(9, "김도영");
		map.put(10, "이승호");
		map.put(11, "홍익종");
		map.put(12, "김호연");
		map.put(13, "노윤정");
		map.put(14, "민상혁");
		System.out.println(map.toString());//{}
		System.out.println(map.size());
		System.out.println(map.get(10));
		System.out.println(map.isEmpty());//true of false
		System.out.println(map.entrySet());//[]
		System.out.println(map.keySet());//[]
		
		map.put(100, "아무나");
		System.out.println(map.get(100));//100의 값: 아무나
		
		map.remove(100);
		System.out.println(map.get(100));//100의 값: null(위에서 remove했기 때문)
		
//		System.out.println();
//		map.clear();
//		System.out.println(map.size());
//		System.out.println(map.isEmpty());
//		System.out.println();
		
		System.out.println("------------");
		for(String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("------------");
		
		System.out.println("------------");
		System.out.println("전체 인원: " + map.size());
		System.out.println("명단: ");
		for(Integer key : map.keySet()) {
			//System.out.println("key: " + key + " = value: " + map.get(key));
			System.out.printf("%d. %s \n", key, map.get(key));
		}
		System.out.println("------------");
		
		HashMap<String, String> cc = new HashMap<String, String>();
		cc.put("England", "London");
	    cc.put("Germany", "Berlin");
	    cc.put("Norway", "Oslo");
	    cc.put("USA", "Washington DC");
	    System.out.println(cc.get("Norway"));
	    System.out.println(cc.containsValue("Berlin"));
		System.out.println(cc.containsKey("Engliand"));
		System.out.println(cc.replace("USA", "Seoul"));//old value = Washington DC
		System.out.println(cc.get("USA"));//now value = Seoul
		System.out.println(cc.replace("USA", "LA"));//old value = Seoul
		System.out.println(cc.get("USA"));//now value = LA
		
		System.out.println("------------");
		for(String i : cc.values()) {
			System.out.println(i);
		}
		
		System.out.println("------------");
		System.out.println("<주요국가의 수도>");
		for(String i : cc.keySet()) {
			System.out.printf("%s의 수도는 %s이다 \n", i, cc.get(i));
		}
	}//. 찍으면 쓸 수 있는 속성이 나오고 그 값도 미리 알 수 있다
	//위에서 .contains~ 속성은 boolean값을 가진다고 입력하기 전에 미리 알 수 있었다

}
