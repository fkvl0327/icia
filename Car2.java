package interfaceLesson;

public class Car2 {
	
//	Tire frontLeftTire = new HankookTire();
//	Tire frontRightTire = new HankookTire();
//	Tire backLeftTire = new KumhoTire();
//	Tire backRightTire = new KumhoTire();
	
	/*
	 * 자바독으로 정리한 경우
	 * tires[0] = 앞왼쪽
	 * tires[1] = 앞오른쪽
	 * tires[2] = 뒤왼쪽
	 * tires[3] = 뒤오른쪽
	 */
	Tire[] tires = {//프로그래머는 각각이 뭘 의미하는지 약속을 해놓는다
		new HankookTire(),//앞왼쪽
		new HankookTire(),//앞오른쪽
		new KumhoTire(),//뒤왼쪽
		new KumhoTire()//뒤오른쪽
	};
	
//	void run() {
//		frontLeftTire.roll();
//		frontRightTire.roll();
//		backLeftTire.roll();
//		backRightTire.roll();
//	}
	
	void run() {
		for(Tire t: tires) {
			t.roll();
		}
	}
}
