package practices;

public class Card {
	// 클래스 변수(공유변수): 인스턴스 변수에 비해 사용빈도 낮다
	// 스태틱은 보통 public으로 씁니다(private으로도 쓸 수는 있어요)
	public static int width;
	public static int height;

	// 인스턴스 변수(인스턴스마다 생성): 사용빈도 가장 높다
	private int number;
	private String shape;

	public Card(int number, String shape) {
		//생성자는 인스턴스 변수만 초기화하는 거예요(당연하지..)
		//this: 현재 작업중인 참조변수를 가리키는 키워드
		this.number = number;
		this.shape = shape;
	}

	public void play() {
		System.out.println("카드 플레이");
	}

	public void call() {
		System.out.println("카드 call");
	}

	public int getNumber() {
		return number;
	}

	public String getShape() {
		return shape;
	}
	
	
	//인스턴스 메소드
	public void showCardInfo() {
		System.out.println("num="+number+", "
				+ "shape="+shape+", width="+width+", height="+height);
	}
	
	//클래스 메소드
	public static void showCardSize() {
		System.out.println("width="+width+", height="+height);
	}

}
