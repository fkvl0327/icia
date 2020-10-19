package interfaceLesson;

public interface InterfaceChildC extends InterfaceParentA, InterfaceParentB {
	//인터페이스도 인터페이스를 상속받는다
	//child 인터페이스는 parent 인터페이스를 다중상속 받을 수 있다
	public void methodC();
}
