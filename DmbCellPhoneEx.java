package classLesson;

public class DmbCellPhoneEx {
//요지: child class의 object는 parent class의 field와 method를 사용할 수 있다
	public static void main(String[] args) {
		//DmbCellPhone 객체 생성
		DmbCellPhone d = new DmbCellPhone("아이폰", "제트블랙", 7);
		
		Cellphone cell = null;
		
		//cell이 DmbCellPhone의 instance인지 묻는 boolean
		boolean result = cell instanceof DmbCellPhone;//false
		System.out.println(result);
		
		//d가 DmbCellPhone의 instance인지 묻는 boolean
		result = d instanceof DmbCellPhone;//true
		System.out.println(result);
		
		//d가 Cellphone의 instance인지 묻는 boolean
		result = d instanceof Cellphone;//true//Cell~이 Dmb~의 parent이기 때문
		System.out.println(result);
		
		//다형성 복습
		cell = d;
		
		
		
		System.out.println("-------");
		
		//CellPhone으로부터 상속받은 필드
		System.out.println("모델: " + d.model);
		System.out.println("색상: " + d.color);
		
		//DmbCellPhone의 필드
		System.out.println("채널: " + d.channel);
		
		//CellPhone으로부터 상속받은 메소드 호출
		d.powerOn();
		d.bell();
		d.sendVoice("Hello?");
		d.receiveVoice("Hi! This is Jess!");
		d.sendVoice("Oh, Hi.");
		d.hangUp();
		
		//DmbCellPhone의 메소드 호출
		d.turnOnDmb();
		d.changeChannelDmb(12);
		d.turnOffDmb();
		
		System.out.println("-------");
		d.channelUp();

	}

}
