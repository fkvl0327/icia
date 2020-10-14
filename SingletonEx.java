package classLesson;

public class SingletonEx {

	public static void main(String[] args) {
		// 컴파일 에러: The constructor Singleton() is not visible
		// private이기 때문에 클래스 외부에서 보지 못한다!
		// Singleton a = new Singleton();

		// 정상실행: getInstance()
		Singleton b = Singleton.getInstance();
		Singleton c = Singleton.getInstance();

		if (b == c) {
			System.out.println("b=c");
		} else {
			System.out.println("b!=c");
		}
		
		Singleton d = new Singleton(100);

	}

}

class Singleton {
	// 정적 필드
	// 인스턴스를 static으로 생성
	private static Singleton s = new Singleton();
	
	private int n1;

	// 생성자: 외부에서 호출하지 못하도록 private modifier 사용
	// private이기 때문에 new를 사용해서 복사본을 만들 수 없다
	private Singleton() {}
	
	Singleton(int n1){
		this.n1 = n1;
		System.out.println("생성자: Singleton(int n1)");
	}

	// 정적 메소드
	// 클래스 외부에서는 인스턴스를 호출할 수 없지만 api함수인 getInstance()는 호출가능
	static Singleton getInstance() {
		return s;
	}
}