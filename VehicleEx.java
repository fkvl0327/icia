package interfaceLesson;

public class VehicleEx {

	public static void main(String[] args) {
		Vehicle v = new Bus();// 업캐스팅
		v.run();

		if (v instanceof Bus) {
			System.out.println("Bus 객체가 맞습니다.");
			Bus bus = (Bus) v;// 강제 타입 변환으로 다운캐스팅
			bus.run();
			bus.checkFare();
		}
	}

}
