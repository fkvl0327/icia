package classLesson;

public class DmbCellPhone extends Cellphone {
	int channel;
	final int maxChannel = 100;
	
	DmbCellPhone(String model, String color, int channel) {
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	void turnOnDmb() {
		System.out.println("채널 " + channel + "번 DMB 방송 수신을 시작합니다.");
	}
	
	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널 " + channel + "번으로 바꿉니다.");
	}
	
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
	
	void channelUp() {
		if(this.channel>=this.maxChannel) {
			this.channel = 0;
		}
		this.channel++;
	}
	
	void channelDown() {
		if(this.channel <=1) {
			this.channel = this.maxChannel;
		}
		this.channel--;
	}

}
