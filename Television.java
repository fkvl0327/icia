package interfaceLesson;

public class Television implements RemoteControl{
	//RemoteControl은 class가 아니기 때문에 super로 정할 수 없고,
	//extends(상속)이 아닌 implements로 인터페이스 사용
	
	private int vol;

	@Override//add unimplemented methods
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}

	@Override
	public void setVolume(int vol) {
		if(vol>RemoteControl.MAX_VOL) {
			this.vol = RemoteControl.MAX_VOL;
		} else if(vol<RemoteControl.MIN_VOL) {
			this.vol = RemoteControl.MIN_VOL;
		} else {
			this.vol = vol;
		}
		System.out.println("현재 TV 볼륨: " + this.vol);
	}

}
