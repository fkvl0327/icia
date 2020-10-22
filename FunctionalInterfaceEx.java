package lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfaceEx {
	// 참고: https://multifrontgarden.tistory.com/125
	// API: Application Programming Interface
	// Java8에서 제공하는 API는 최대한 외울수 있는데까지는 외우는 것이 좋다.
	// Stream은 선언형 프로그래밍으로 API만 계속 등장하는데 그때마다 찾아서 쓰려면
	// 오히려 생산성이 저하되는 일이 발생할 수도 있기 때문이다.
	
	// 각각의 인터페이스는 import를 해주자
	// import 해주면 java.util.function 패키지 안에 API들이 있다
	// ctrl+클릭으로 API 문서를 열면 Project Explorer의 java.util.function 패키지가 열린다
	// 어떤 걸 써야 할지 헷갈릴 때 검색도 좋지만 이클립스 안에서 패키지 꾸러미를 살펴보는 것도 도움이 될 것 같다
	public static void main(String[] args) {
		
		// 1. Runnable: abstract void run() // 인자를 받지 않고, 리턴타입이 없다
		Runnable r = () -> System.out.println("Hello, Runnable!");
		r.run();

		// 2. Supplier<T>: T get()
		// API 문서 참고: <T> the type of results supplied by this supplier
		// 인자를 받지 않고, 리턴타입만 있다
		Supplier<String> s = () -> "Hello, Supplier!";
		// s.get();에는 출력 기능이 없으므로 다음과 같이 s.get()을
		// 지정했던 타입 변수 하나에 담아준다.(이름은 아무렇게나 해도 되지만
		// 자바 API 문서에서 get() 메소드가 result를 얻는다고 되어 있으니 result라고 하자)
		String result = s.get();
		System.out.println(result);
		
		// 3. Consumer<T>: void accept(T t)
		// API 문서 참고: <T> the type of the input to the operation
		// 인자를 받고, 리턴값이 없다
		// = 뒤에는 인자를 받아야 하는데 이름을 마음대로 지으면 되는 것 같다
		Consumer<String> c = whatRU -> System.out.println(whatRU);
		// 인자 자리에 입력한 타입의 값을 직접 입력한다
		c.accept("Hello, Consumer!");
		
		// 4. Function<T, R>: R apply(T t) // 인자를 받고, 리턴을 하는 메소드
		// 타입은 제네릭으로 정해준다
		// String 클래스에서 인풋을 가져오고, Integer 타입으로 값을 입력
		Function<String, Integer> f = str -> Integer.parseInt(str);
		// 문자열을 가져와서 int형으로 바꾸는 람다식을 입력해놓았다
		// "1"을 int 1로 프린트
		int anything = f.apply("1");
		System.out.println("Hello, Function!: " + anything);
		
		//---------------------------------------
		
		// 10월 22일 오전 이어서 정리 (함수형 인터페이스
		
		
	}

}
