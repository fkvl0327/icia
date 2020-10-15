package classLesson;
//책 321-322p
public class DriverEx {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		
		Taxi taxi = new Taxi();
		
		bus.run();
		taxi.run();
		
		//Vehicle의 instance 자리에 bus와 taxi가 들어올 수 있다
		//bus와 taxi가 Vehicle의 child class이기 때문
		//v가 이클립스 자동제안되지만, 아직 Vehicle의 instance를 생성하지 않았으므로 사용할 수 없다
		driver.drive(bus);
		driver.drive(taxi);
		
		//v라는 이름으로 Vehicle의 instance를 만들면
		Vehicle2 v = new Vehicle2();
		//drive의 매개값으로 instance v를 사용할 수 있다
		driver.drive(v);

	}

}

class Vehicle2 {
	public void run() {
		System.out.println("차량이 달립니다.");
	}
}

class Driver{
	public void drive(Vehicle2 v) {
		v.run();
	}
}

class Bus extends Vehicle2 {
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}
}

class Taxi extends Vehicle2 {
	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}
	
}