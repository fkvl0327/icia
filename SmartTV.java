package interfaceLesson;

public class SmartTV implements RemoteControl, Searchable {
	private int vol;
	
	@Override
	public void turnOn() {
		System.out.println("스마트TV를 켭니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("스마트TV를 끕니다.");
		
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
		System.out.println("현재 스마트TV 볼륨: " + vol);
		
	}

	@Override
	public void search(String url) {
		System.out.println(url + "을 검색합니다.");
		
	}

}
