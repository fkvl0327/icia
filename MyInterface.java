package interfaceLesson;

public interface MyInterface {
	public void method1();//abstract라고 안 적어놨지만 abstract 메소드
	
	//인터페이스 생성-추상메소드 method1 생성-구현클래스에서 method1 생성 후에
	//method2를 추가하여 인터페이스를 수정할 수 있다
	//이렇게 수정하더라도 구현클래스에서 컴파일 에러가 발생하지 않는다
	
	public default void method2() {//body가 있는 것은 default나 static 없이 public void만 쓸 수는 없다
		//정적 메소드를 만들고자 하면 static
		//후에 재정의하고자 하면 default라고 한다
		System.out.println("MyInterface-method2 실행");
	}
	
	public static void method3() {
		System.out.println("MyInterface-method3 실행");
	}

}
