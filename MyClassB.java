package interfaceLesson;

public class MyClassB implements MyInterface {
	
	//추상메소드이기 때문에 아래 내용이 없으면 컴파일 에러 발생
	//재정의를 하지 않는다면 body내용은 MyClassA에서 구현해준 내용을 가져오면 된다
	@Override
	public void method1() {
		System.out.println("MyClassB-method1() 실행");
		
	}
	
	//디폴트 메소드 재정의
	@Override
	public void method2() {
		System.out.println("MyClassB-method2() 실행");
	}

}
