package interfaceLesson;

public class ImpleC implements InterfaceChildC {

	@Override
	public void methodA() {
		System.out.println("imple.methodA()");
		
	}

	@Override
	public void methodB() {
		System.out.println("imple.methodB()");
		
	}

	@Override
	public void methodC() {
		System.out.println("imple.methodC()");
		
	}
//추상메소드 였던 것을 구현 클래스에서 구현해줌으로써
//interface A,B,C의 추상메소드가 구현되어 애플리케이션(main메소드가 있는 곳)에서 실행
}
