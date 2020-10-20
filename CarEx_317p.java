package classLesson;

// 펑크났을 때 다른 타이어 수명도 다 나오게 하고 싶어

// 어떻게 하면 될까?

public class CarEx_317p {

	public static void main(String[] args) {

		carRunTest1();
		//carRunTest2();
//		errTire = i30.run();
//		errTire = i30.run();

//		i30.tires[0] = new HankookTire("앞왼쪽", 10);
//		i30.tires[1] = new HankookTire("앞오른쪽", 10);
//		errTire = i30.run();
//		errTire = i30.run();

	}

	private static void carRunTest2() {
		Carrr i30 = new Carrr();
		int errTire = 0;

		for (int i = 1; i <= 20; i++) {//주행 20회
			errTire = i30.run2();
			
			//array 활용해서 어느 위치의 타이어가 고장나든 한국타이어로 교체
			//교체하는 한국타이어의 수명은 10
			if (errTire != 0) {
				//고장난 타이어의 번호는 errTire-1
				System.out.println(i30.tires[errTire - 1].location + " HankookTire로 교체");
				i30.tires[errTire - 1] = new HankookTire(i30.tires[errTire - 1].location, 10);
			}
			System.out.println("---------------");
		}

	}

	private static void carRunTest1() {
		Carrr i30 = new Carrr();
		int errTire = 0;// 주행할 수 없는 타이어번호
		
		//고장난 타이어번호에 따라 케이스를 나누고, 고장날 때마다 케이스에 따라 타이어 교체
		//array로 타이어를 호출하기는 했지만, 간결성은 활용하지 못함
		for (int i = 1; i <= 20; i++) {//주행 20회
			errTire = i30.run();

			switch (errTire) {
			case 1:
				System.out.println("앞왼쪽 HankookTire로 교체");
				i30.tires[0] = new HankookTire("앞왼쪽", 15);
				break;
			case 2:
				System.out.println("앞오른쪽 KumhoTire로 교체");
				i30.tires[1] = new KumhoTire("앞오른쪽", 13);
				break;
			case 3:
				System.out.println("뒤왼쪽 HankookTire로 교체");
				i30.tires[2] = new HankookTire("뒤왼쪽", 14);
				break;
			case 4:
				System.out.println("뒤오른쪽 KumhoTire로 교체");
				i30.tires[3] = new KumhoTire("뒤오른쪽", 17);
				break;
			}
			System.out.println("----------------------");

		}
	}
}
