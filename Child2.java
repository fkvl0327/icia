package interfaceLesson;

public interface Child2 extends Parent {
	@Override
	public default void method2() {
		System.out.println("Child2에서 재정의한 method2");
	}
	
	public void method3();// 여기서 ;을 지우고 {} 안에 this.을 찍어보면 여기서 override할 수 있는
	//메소드를 쉽게 판단할 수 있다(만일 남이 하던 작업을 이어서 한다면 이런 방법이 있다는 걸 알면 좋다)
}