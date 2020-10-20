package classLesson;

//교재 314p, 318p
public class TireLesson {

}

class HankookTire extends Tire {

	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}

	@Override
	public boolean roll() {
		boolean isRunnable = false;
		nowRotation++;
		if (nowRotation >= maxRotation) {
			isRunnable = false;
			flatTire();
		} else {
			isRunnable = true;
			okTire();
		}

		return isRunnable;
	}

	private void okTire() {
		System.out.println(location + "Tire 수명: " + (maxRotation - nowRotation) + "회");
	}

	private void flatTire() {
		System.out.println(location + "Tire 수명: " + (maxRotation - nowRotation) + "회");
		System.out.println(location + "타이어가 펑크났어요ㅠㅠ 타이어를 교체해주세요");
	}

}

class KumhoTire extends Tire {

	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}

	@Override
	public boolean roll() {
		boolean isRunnable = false;
		nowRotation++;
		if (nowRotation >= maxRotation) {
			isRunnable = false;
			flatTire();
		} else {
			isRunnable = true;
			okTire();
		}

		return isRunnable;
	}

	private void okTire() {
		System.out.println(location + "Tire 수명: " + (maxRotation - nowRotation) + "회");
	}

	private void flatTire() {
		System.out.println(location + "Tire 수명: " + (maxRotation - nowRotation) + "회");
		System.out.println(location + "타이어가 펑크났어요ㅠㅠ 타이어를 교체해주세요");
	}

}

class Tire {
	public int maxRotation;
	public int nowRotation;
	public String location;

	public Tire(String location, int maxRotation) {
		super();
		this.maxRotation = maxRotation;
		this.location = location;
	}

	public boolean roll() {
		boolean isRunnable = false;
		nowRotation++;// 1씩 늘어남 (cf. *=0.8 <1회 사용 시 0.8만큼 닳는다)
		if (nowRotation >= maxRotation) {
			isRunnable = false;
			flatTire();
		} else {
			isRunnable = true;
			okTire();
		}

		return isRunnable;
	}

	private void okTire() {
		System.out.println(location + "Tire 수명: " + (maxRotation - nowRotation) + "회");
	}

	private void flatTire() {
		System.out.println(location + "Tire 수명: " + (maxRotation - nowRotation) + "회");
		System.out.println(location + "타이어가 펑크났어요ㅠㅠ 타이어를 교체해주세요");
	}

}

class Carrr {
	// 얼마나 달렸는지 보여주는 int 자리를 하나 만들어주자
	int meter;

	// 바퀴 4개
	Tire[] tires = { new Tire("앞왼쪽 ", 6), new Tire("앞오른쪽 ", 2), new Tire("뒤왼쪽 ", 3), new Tire("뒤오른쪽 ", 4) };

	// run
	int run() {
		meter++;
		System.out.println();
		System.out.println("붕붕붕 아주 작은 자동차♬  꼬마 자동차가 나간다♪ " + meter + "번째로 달리고 있어요!");
		// Tire instance를 array로 정리해서 순서(tires[i])로 호출할 수 있게 됐다
		
		// if문으로 할 때는 순서대로 진행해서 false가 발견되면 종료(반복문이 아니다)
		// Tire 클래스에서 boolean roll은 현재 회전 수가 최대 회전 수 이상이면 false가 되도록 작성해 놓았음

		if (tires[0].roll() == false) {
			stop();
			return 1;
		}
		if (tires[1].roll() == false) {
			stop();
			return 2;
		}
		if (tires[2].roll() == false) {
			stop();
			return 3;
		}
		if (tires[3].roll() == false) {
			stop();
			return 4;
		}
		// 하지만 이렇게 쓰면 배열이 주는 편리함을 쓸 수 없어
		// 이걸 정리해서 run2()처럼 정리해주자(처음 쓸 때는 위처럼 쓰는 게 편할 것,
		// 머릿속에서 위 내용을 정리하면 아래처럼 줄여서 쓸 수 있어요)
		return 0;
	}

	int run2() {
		meter++;
		int result = 0;
		System.out.println();
		System.out.println("붕붕붕 아주 작은 자동차♬  꼬마 자동차가 나간다♪ " + meter + "번째로 달리고 있어요!");
		
		// for문은 반복하므로 tires[i].roll이 false일 때 stop하고 나서도 tires의 개수만큼 실행하고,
		// 값을 return한다
		for (int i = 0; i < tires.length; i++) {
			if (tires[i].roll() == false) {
				stop();
				result = i + 1;
			}
			
		}
		return result;
	}

	// stop
	void stop() {
		System.out.println("[*** 고장! 자동차가 멈춥니다 ***]");
	}
}