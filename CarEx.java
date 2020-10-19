package interfaceLesson;

public class CarEx {

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		
		System.out.println();
		
		myCar.frontLeftTire = new KumhoTire();
		myCar.frontRightTire = new KumhoTire();
		myCar.run();
		
		System.out.println("<Array>");
		Car2 myACar = new Car2();
		myACar.run();
		//이렇게 하나씩 바꿀 수도 있고
		myACar.tires[0] = new KumhoTire();
		myACar.tires[1] = new KumhoTire();
		myACar.run();
		//for문을 써서 활용 -> 데이터가 많을수록 유용하다
		for(int i=0;i<myACar.tires.length;i++) {
			myACar.tires[i] = new KumhoTire();
		}
		myACar.run();
	}

}
