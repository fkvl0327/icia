package interfaceLesson;

public class Driver {
	private Vehicle v;
	
	void drive() {
		v.run();
	}

	void drive(Vehicle v) {
		this.v = v;
		v.run();
	}
	
}
