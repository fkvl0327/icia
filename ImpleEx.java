package interfaceLesson;

public class ImpleEx {

	public static void main(String[] args) {
		ImpleC impl = new ImpleC();
		InterfaceParentA ia = impl;//A method만 호출가능
		ia.methodA();
		System.out.println();
		
		InterfaceParentB ib = impl;//B method만 호출가능
		ib.methodB();
		System.out.println();
		
		InterfaceChildC ic = impl;//A, B, C method 모두 호출 가능
		ic.methodA();
		ic.methodB();
		ic.methodA();
		
	}

}
