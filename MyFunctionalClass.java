package lambda;

public class MyFunctionalClass implements MyFunctionalInterface{

//	@Override
//	public void method() {
//		System.out.println("MyFunctionalClass: implemented menthod ~ ");
//		
//	}

	@Override
	public int method(int n1, String string) {
		int calc = n1*1000;
		return calc;
	}

}
