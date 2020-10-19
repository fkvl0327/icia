package interfaceLesson;

// 상속extends: 속성property을 받음
// implements: 규격을 받음
public class HankookTire implements Tire{

	@Override
	public void roll() {
		System.out.println("한국타이어 굴러갑니다.");
	}

}
