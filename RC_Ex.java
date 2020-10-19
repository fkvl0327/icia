package interfaceLesson;

public class RC_Ex {

	public static void main(String[] args) {
		// 익명 구현 객체(p.354~)
		RemoteControl rc = new RemoteControl() {

			@Override
			public void turnOn() {
				System.out.println("App1의 전원을 켭니다.");
			}

			@Override
			public void turnOff() {
				// TODO Auto-generated method stub

			}

			@Override
			public void setVolume(int vol) {
				// TODO Auto-generated method stub

			}

		};// RC 인스턴스 제시한 것부터 여기까지 하나의 문장으로 취급하기 때문에 세미콜론 필요
		rc.turnOn();
		
		// 인터페이스 사용(p.359)
		rc = null;
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		rc.setMute(true);
		rc.setVolume(5);
		RemoteControl.changeBattery();
		
		System.out.println();
		
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		rc.setMute(true);
		rc.setVolume(5);
		RemoteControl.changeBattery();
	}

}
