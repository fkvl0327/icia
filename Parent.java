package interfaceLesson;

public interface Parent {
	public void method1();
	public default void method2() {
		System.out.println("method2");
	}
}
