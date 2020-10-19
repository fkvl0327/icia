package classLesson;
//7장 6번 문제

public class PC2 {

	public static void main(String[] args) {
		Child2 kid = new Child2();
		//모든 메소드 출력됨
	}

}

class Parent2 {
	public String nation;
	
	public Parent2() {
		this("대한민국");
		System.out.println("Parent2() call");
	}
	
	public Parent2(String nation) {
		this.nation = nation;
		System.out.println("Parent2(String nation) call");
	}
}

class Child2 extends Parent2 {
	private String name;
	
	public Child2() {
		this("홍길동");
		System.out.println("Child2() call");
	}

	public Child2(String name) {
		this.name = name;
		System.out.println("Child2(String name) call");
	}
}
