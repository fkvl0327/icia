package classLesson;

public class StudentClass {
	//소멸자의 사용형태
	//~Student() {
	//
	//} <- 클래스 {}안에 ~클래스명(){}
	
	//필드 멤버
	private int no;
	//13~24는 자동생성
	//멤버 위에 마우스 우클릭>Source > Generate getters and setters
	public int getNo() {
		return no;
	}
	public static int getSum() {
		return sum;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public static void setSum(int sum) {
		StudentClass.sum = sum;
	}
	//
	private static int sum; // static으로 설정하면서 메모리를 할당함 -> 코드 실행
	
	//해당 클래스에서만 사용하려면 private(OOP는 private이 디폴트)
	//다른 클래스에 상속하려면 public(C언어 등은 public이 디폴트)
	
	//생성자: class 이름과 같게 만들어 줍니다
	public StudentClass() {
		System.out.println("Student 생성자가 호출되었습니다.");
	}
	//생성자 오버로딩
	public StudentClass(int n1) {
		System.out.println("Student 생성자가 호출되었습니다. param1(" + n1 + ")");
		this.no = n1;
	}
	
	public StudentClass(int n1, int n2) {
		System.out.println("Student 생성자가 호출되었습니다. param1(" + n1 + ", " + n2 + ")");
	}
	
	public StudentClass(int n1, int n2, String s1) {
		System.out.println("Student 생성자가 호출되었습니다. param1(" + n1 + ", " + n2 + ", " + s1 + ")");
	}
	
	@Override // 어노테이션: 인터페이스를 기반으로 한 문법
	//클래스에 특별한 의미를 부여하거나 기능을 주입할 수 있다
	//Override는 메소드 앞에만 붙일 수 있으며,
	//현재 메소드가 수퍼클래스의 메소드를 오버라이드한 메소드임을
	//컴파일러에게 명시한다
	
	//어노테이션
	//1)JDK built-in
	//2)Meta(어노테이션에 대한 정보를 나타냄)
	//3)Custom(개발자가 직접 만듦)
	//참고: https://k39335.tistory.com/40
	//참고2: https://asfirstalways.tistory.com/309
	protected void finalize() throws Throwable {//finalize()를 오버라이딩
		System.out.println(no + "번 객체의 finalize()가 실행됨");
	}
	
	public static void main(String[] args) {
		// 호출은 하나만 해도 됨
		StudentClass s1 = new StudentClass();
		// 파라미터 빈칸인 생성자 호출
		// new는 새로운 메모리공간을 부여
		// class Student의 객체 타입을 Student(클래스 이름과 같게)라고 지정
		// s1은 그 인스턴스
		System.out.println("s1 변수가 Student 객체를 참조합니다.");
		
		StudentClass s4 = new StudentClass(1);
		System.out.println("s4 변수가 Student 객체를 참조합니다.");
		System.out.println("s4.no = " + s4.no);
		
		s4.no = s4.no + 1000;
		System.out.println("s4.no = " + s4.no);
		s4.no = s4.no + 5000;
		System.out.println("s4.no = " + s4.no);
		
		StudentClass s2 = new StudentClass(3, 27);
		System.out.println("s2 변수가 Student 객체를 참조합니다.");
		
		StudentClass s3 = new StudentClass(30, 50, "생성자");
		System.out.println("s3 변수가 Student 객체를 참조합니다.");
		//인스턴스 메소드는 클래스 변수에 접근할 수 있다
		System.out.println("#----------------------");
		s4.sum = s4.no + s4.no;
		System.out.println("s4.sum = " + s4.sum);
		System.out.println("sum = " + sum); // static sum = s4.sum
		//static은 member를 사용할 수 있다
		
		int n1 = s4.mySum(s4.sum, s4.sum); // static x
		System.out.println("s4.mySum returns: " + n1);
		n1 = mySum2(s4.sum, s4.sum); // static
		System.out.println("static mySum2 returns: " + n1);
		
		n1 = s4.mySumMember(1000);
		System.out.println("s4.mySumMember returns: " + n1);
		
		System.out.println(s4.getNo());
		System.out.println(s4.getSum());
		
		finalizeTest();
	}
	private int mySumMember(int n1) {//s4의 이름으로 new 할당받은 객체공간
		int result = this.no + n1;
		return result;
	}
	private static int mySum2(int sum2, int sum3) {
		return sum2 + sum3;
	}
	private int mySum(int sum2, int sum3) {
		return sum2 + sum3;
	}
	//메소드 멤버
	private static void finalizeTest() {
		System.out.println("#----------------------");
		StudentClass student=null; // Student클래스의 형태를 갖는 변수 student를 만듦
		for(int i=0; i<=10; i++) {
			student = new StudentClass(i);//new를 사용해서 객체를 만들면 생성자가 호출됨
			//클래스 Student의 객체를 변수 student에 입력
			System.out.println("finalize: " + student.no);
			student = null; // student 객체를 쓰레기로 만듦
			//System.gc(); // Garbage Collector 실행
		}
	}
	//논리로직대로 동작하지 않고 생성자-소멸자의 순서가 임의대로 처리됨
	//gc 때문! // 논리동작대로 하면 하나씩 호출(gc를 주석처리했을 때)
}
