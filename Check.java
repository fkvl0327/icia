package selfstudy;
//이것이 자바다 6장 확인문제 13번~18번

//같은 파일 안에 적으려고 예제의 public은 뺐음

public class Check {
	// 14번-2: 외부에서 값 입력(instance 생성)
	public static void main(String[] args) {
		Member user1 = new Member("홍길동", "hong");
		Member user2 = new Member("강자바", "java");
		
		// 14번-3: 잘 입력 받았는지 확인
		user1.print();
		user2.print();
		
		// 15번-1: 주어진 MemberServiceExample 클래스
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
		if (result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
		
		//16번: 주어진 PrinterExample 클래스
//		Printer printer = new Printer();
//		printer.println(10);
//		printer.println(true);
//		printer.println(5.7);
//		printer.println("홍길동");

		//17번: 주어진 PrinterExample 클래스
		Printer.println(10);
		Printer.println(true);
		Printer.println(5.7);
		Printer.println("홍길동");
		
		//18번: 주어진 ShopServiceExample 클래스
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		}else {
			System.out.println("다른 ShopService 객체입니다.");
		}
		
	}
}

//13번-1: Member 클래스 생성
class Member {
	// 13번-2: field 선언
	private String name;
	private String id;
	private String password;
	private int age;

	// 14번-1: 생성자 추가
	// 우클릭>Source>Generate Constructors Using Fields>name/id 선택
	public Member(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	// 14번-3: 잘 입력 받았는지 확인
	public void print() {
		System.out.println("이름: " + name + " ID: " + id);
	}

}

//15번-1: MemberService 클래스 생성
class MemberService {
	// 15번-2: login() 메소드는 id가 hong, password가 12345일 때만 true, 외외에는 false 리턴
	public boolean login(String id, String password) {
		if (id.equals("hong") && password.equals("12345")) {
			return true;
		} else {
			return false;
		}
	}

	// 15번-3: logout() 메소드는 "로그아웃 되었습니다."가 출력되도록
	public void logout(String id) {
		id = "hong";
		System.out.println("로그아웃 되었습니다.");
	}
}

//16번: Printer 클래스 생성
class Printer {
//	void println(int number) {
//		System.out.println(number);
//	}
//	void println(boolean b) {
//		System.out.println(b);
//	}
//	void println(double d) {
//		System.out.println(d);
//	}
//	void println(String s) {
//		System.out.println(s);
//	}
	//17번: Printer 객체를 생성하지 않고 호출하는 방법 = 정적 멤버 사용
	static void println(int number) {
		System.out.println(number);
	}
	static void println(boolean b) {
		System.out.println(b);
	}
	static void println(double d) {
		System.out.println(d);
	}
	static void println(String s) {
		System.out.println(s);
	}
}

//18번: 싱글톤
class ShopService{
	private static ShopService s = new ShopService();
	
	private ShopService() {}
	
	static ShopService getInstance() {
		return s;
	}
	
}