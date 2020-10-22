package lambda;

//1개의 추상메소드를 가지고 있는 인터페이스를 함수형 인터페이스라고 한다
//Single Abstract Method(SAM)이라고도 한다
//람다식이 함수형 인터페이스로만 접근되기 때문에 사용

@FunctionalInterface

public interface MyFunctionalInterface {
	
	public int method(int n1, String string);
}
