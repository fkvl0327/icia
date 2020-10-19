package interfaceLesson;

public interface RemoteControl {
	
	//상수 필드
	public int MAX_VOL = 10;
	public int MIN_VOL = 0;
	
	
	//추상(abstract) 메소드
	public void turnOn();
	public void turnOff();
	public void setVolume(int vol);
	
	//디폴트(default) 메소드
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
		}else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	//정적(static) 메소드
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}

}
