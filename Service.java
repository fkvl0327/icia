package classLesson;
//여기에 어노테이션을 입력하면 위치가 맞지 않는다 @PrintAnnotation
public class Service {
	
	int n1;//field
	String s1;//field
	
	@PrintAnnotation
	public void method1() {
		System.out.println("실행 내용1");
	}
	
	@PrintAnnotation("♥")
	public void method2() {
		System.out.println("실행 내용2");
	}
	
	@PrintAnnotation(value="#", number=10)
	//value만 쓸 때는 다른 부분 다 생략하고 "#"만 기재하면 디폴트값 5개 #가 print됨
	public void method3() {
		System.out.println("실행 내용3");
	}
}
