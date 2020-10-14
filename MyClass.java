package classLesson;

public class MyClass {
	int x = 10;
	static int y = 20;
	
	//x에 대해서만 getter, setter를 만들어 볼게요
	//원래는 더 간편하려고 쓰는 거라고 하는데.. 예시가 혼동된다
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		MyClass.y = y;
	}
	
	void myMethod1() {
		System.out.println("myMethod");
	}
	
	

	static void myMethod() {
		System.out.println("myMethod");
	}
	
	void myMethod_x() {
		System.out.println("myMethod_x : x = " + x);
	}//static이 아닌 함수에서 static 변수를 불러올 수 없다
	
	static void otherMethod() {
		MyClass my = new MyClass();
		System.out.println("otherMethod1 : my.x+y = " + (my.x+y));
		System.out.println("otherMethod2 : my.x+my.y = " + (my.x+my.y));
		//static 함수에서 static 변수를 불러올 수 있다
		//static 함수에서 non-static 변수를 불러올 수 없다
		
		//System.out.println("otherMethod : x+y = " + x+y);
		//non-static 변수를 사용하기 위해서 static 함수 안에서 instance를 생성한다
		System.out.println("otherMethod3 : my.getX()+my.y = " + (my.getX()+my.getY()));
	}
	
	static void another(int x2) {
		MyClass my = new MyClass();
		System.out.println("another1 : x2+y = " + (x2+y));
		System.out.println("another2 : x2+my.y = " + (x2+my.y));
		
		System.out.println("another3 : my.getX()+my.y = " + (x2+my.getY()));
	}

	
	
}
