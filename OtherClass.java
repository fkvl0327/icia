package classLesson;

import lesson.Day;

public class OtherClass {

	public static void main(String[] args) {
		myFunction1("abc", "abc", "abc", "abc");
		// containerForOthers();

	}

	private static void containerForOthers() {
		System.out.println(Day.Friday);

		MyClass my1 = new MyClass();
		System.out.println("my1.x = " + my1.x);// 10
		System.out.println("my1.y = " + my1.y);// 20

		my1.x = my1.x + 100;
		my1.y = my1.y + 100;
		System.out.println("my1.x = " + my1.x);// 110
		System.out.println("my1.y = " + my1.y);// 120

		MyClass my2 = new MyClass();
		System.out.println("my2.x = " + my2.x);// 10
		// my2.x와 my1.x가 서로 다른 공간이기 때문에 my1.x 값이 바뀐 것에 영향받지 않는다

		System.out.println("my2.y = " + my2.y);// 120
		// y는 static이기 때문에 마지막으로 업데이트된 값을 반영한다
		// static 변수는 선언된 순간부터 global 변수로 동작

		// local vs static vs global 구분해서 설명하기
		// 메모리주소 개념으로 설명하면, static은 고정된 주소를 할당해놓고 쓴다고 한다

		my1.y = my1.y + 1000;

		System.out.println("MyClass.y = " + MyClass.y);// 클래스변수를 직접 소환

		my1.myMethod1();
		my1.myMethod();

		my2.myMethod1();
		my2.myMethod();

		MyClass.myMethod();

		// non-static method
		// my.getX()=10 (this.x가 10이기 때문)
		my1.myMethod_x();
		my2.myMethod_x();

		// static method
		// MyClass라는 클래스에서 new로 instance를 만든 my.x의 값을 가져오므로
		// my1이든 my2이든, int x로 입력했던 초기값(10)을 받는다
		my1.otherMethod();
		my2.otherMethod();

		my1.another(my1.x);// my1.x=110, y=1120, my.y=1120 >> 1230

		System.out.println("-----------------");
		// myClassTest();

		// abstractTest();

		inheritTest();

	}

	private static void myFunction1(String... strings) {
		for (String s : strings) {
			System.out.println(s);
		}
		for (int i = 0; i < strings.length; i++) {
			System.out.println(i + ", " + strings[i]);
		}

	}

	private static void inheritTest() {
		// 상속
		SonataCar myCar = new SonataCar();
		myCar.honk();
		System.out.println(myCar.brand + " " + myCar.modelName + "'s owner: " + myCar.driver);

		HCar myCar2 = new HCar();
		myCar2.honk();
		System.out.println(myCar2.brand + " " + myCar2.modelName);

		Vehicle myCar3 = new Vehicle();
		myCar3.honk();
		System.out.println(myCar3.brand);

		// 다형성: 다형성은 상속을 전제로 한 개념이다
		Vehicle vc = null;

		vc = new Vehicle();
		vc.honk();
		vc.honk(1);
		System.out.println("Vehicle: " + vc.getMaxSpeed());
		System.out.println();

		vc = new HCar();
		vc.honk();
		vc.honk(1);
		System.out.println("HCar: " + vc.getMaxSpeed());
		System.out.println();

		vc = new SonataCar();
		vc.honk();
		vc.honk(1);
		vc.honk(2);
		System.out.println("SonataCar: " + vc.getMaxSpeed());
		System.out.println();

	}

	private static void abstractTest() {
		Student j = new Student("1926", "Jay");
		// instance 생성을 Student로 해도, Person으로 해도 동일한 내용 생성됨
		System.out.println(j.name + " " + j.ssn + "년생");
		System.out.println(j.fname);
	}

	private static void myClassTest() {
		Car myCar = new Car(); // Create a myCar object
		myCar.fullThrottle(); // Call the fullThrottle() method
		myCar.speed(200); // Call the speed() method

		// 멤버변수 속성을 이용하는 방법
		myCar.maxSpeed = 200;
		myCar.speed(myCar.maxSpeed);

		Car myCar1 = new Car(1969, "Mustang");
		System.out.println(myCar1.modelYear + " " + myCar1.modelName);

		Car newCar = new Car(2020, "mini");
		System.out.println(newCar.modelYear + "년식 " + newCar.modelName);

	}

}
