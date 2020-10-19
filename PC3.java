package classLesson;
//7장 7번 문제 답: 스노우 타이어가 굴러갑니다
public class PC3 {

	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		RegTire tire = snowTire;
		
		snowTire.run();//child 메소드 출력
		tire.run();//parent 메소드이지만
		//child에서 오버라이드되어서 바뀐 값 출력

	}

}

class RegTire {
	public void run() {
		System.out.println("일반 타이어가 굴러갑니다.");
	}
}

class SnowTire extends RegTire {
	@Override
	public void run() {
		System.out.println("스노우 타이어가 굴러갑니다.");
	}
}