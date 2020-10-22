package lambda;

public class MyFunctionalEx {

	public static void main(String[] args) {
		MyFunctionalClass mfc = new MyFunctionalClass();
		mfc.method(2, "hello~class");

		// 람다식: 익명 구현 객체
		MyFunctionalInterface mfi;

		// 사용법1
		mfi = (x, s1) -> {
			System.out.println(s1);
			return x * 1000;
		};
		int result;
		result = mfi.method(2, "hello1");
		System.out.println("사용법1 result: " + result);
		System.out.println("-------------------------");

		// 사용법2
		mfi = (x, s1) -> {
			int calc = x * 1000;
			System.out.println(s1);
			return calc;
		};
		result = mfi.method(2, "hello2");
		System.out.println("사용법2 result: " + result);
		System.out.println("-------------------------");

		// 사용법3
		mfi = (x, s1) -> {
			System.out.println(s1);
			return x * 1000;
		};
		mfi = (x, s1) -> myCalc1000(x, s1);
		result = mfi.method(2, "hello3");

		System.out.println("사용법3 result: " + result);
		System.out.println("-------------------------");
	}

	private static int myCalc1000(int x, String s1) {
		int calc = x * 1000;
		System.out.println(s1);
		return calc;
	}
}
