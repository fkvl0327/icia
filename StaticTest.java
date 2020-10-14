package classLesson;

public class StaticTest {
	//static double e = 2.712;
	
	//상수 선언과 사용(책 247p)
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;
	static final double EARTH_KOREA_AREA = 100; // <- 이런 식으로 막 넣을 수가 있다
	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}// Math.PI는 자바에서 제공하는 상수 // EARTH_RADIUS & EARTH_SURFACE_AREA는 만들어냈음

	public static void main(String[] args) {
		//staticCal();
		staticEarth();
	}

	private static void staticEarth() {
		System.out.println("지구의 반지름: " + StaticTest.EARTH_RADIUS + "km");
		System.out.println("지구의 표면적: " + StaticTest.EARTH_SURFACE_AREA + "km^2");
	}

	private static void staticCal() {
		
		// 둘다 정상 실행은 되지만
		// 정적 요소는 클래스 이름으로 접근하는 것이 좋다
		// 객체 참조 변수(인스턴스 이름)로 접근하면 경고 표시가 나타난다 = 문법적으로 권장되지 않는다
		Cal myC = new Cal();
		double result1 = 10 * 10 * myC.pi;
		int result2 = myC.plus(10, 5);
		int result3 = myC.minus(10, 5);

		double result4 = 10 * 10 * Cal.pi;
		int result5 = Cal.plus(10, 5);
		int result6 = Cal.minus(10, 5);

		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);
		System.out.println("result3: " + result3);
		System.out.println("--------구분선--------");
		System.out.println("result4: " + result4);
		System.out.println("result5: " + result5);
		System.out.println("result6: " + result6);

	}

}

class Cal {
	static double pi = 3.14156;

	static int plus(int x, int y) {
		return x + y;
	}

	static int minus(int x, int y) {
		return x - y;
	}

}