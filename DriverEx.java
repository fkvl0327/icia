package interfaceLesson;

public class DriverEx {

	public static void main(String[] args) {
		Driver driver1 = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver1.drive(bus);
		driver1.drive(taxi);

	}

}
