package classLesson;

public class TVE {

	public static void main(String[] args) {
		System.out.println(TV.info);
	}
}
class TV {
	static String company = "Samsung";
	static String model = "LCD";
	static String info;

	static {// 정적 초기화 블록
		info = company + "-" + model;
	}

}

class StaticBlockTest {
	int field1;
	void method1() {
		System.out.println("method1");
	}
	static int field2;
	static void method2() {
		System.out.println("static method2");
	}
	static {
		//static 멤버에서 non-static 멤버 호출(참조) 불가
		//field1 = 10;
		//method1();
		
		//static에서 static 호출o
		field2 = 10;
		method2();
	}
}
