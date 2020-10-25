package practices;
//이 개념은 잘 알고 있어
public class Ex3 {
	//main도 클래스 메소드이다 // 인스턴스를 만들지 않고 사용하는 간편함
	public static void main(String[] args) {
		//대부분 객체중심이기 때문에 클래스 메소드/변수를 사용할 일이 많지는 않지만
		//인스턴스를 쓰지 않을 일에 인스턴스를 만들지 않고도 호출이 가능하다는 장점
		welcome();
		
		Card.width=5;
		Card.height=8;
		Card.showCardSize();
		
		Card c1 = new Card(3, "다이아몬드");
		Card c2 = new Card(4, "하트");
		c1.showCardInfo(); // num=3, shape=다이아몬드, width=5, height=8
		c2.showCardInfo();
	}

	private static void welcome() {
		System.out.println("어서오세요");
	}

}
