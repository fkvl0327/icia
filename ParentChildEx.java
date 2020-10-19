package interfaceLesson;

public class ParentChildEx {

	public static void main(String[] args) {
		Child2 ci2 = new Child2() {
			//인스턴스로 직접 객체를 생성한 것처럼 보이지만
			//anonymous calss를 사용한 것이다
			
			//method1과 method2의 실체 메소드를 가지고 있어야 한다
			//아래에서 구현하지 않으면 아직 추상메소드이다
			//{}; 형식으로 body가 들어갈 자리를 만들었다면 add unimplemented.. 라고 뜬다
			
			@Override
			public void method1() {
				System.out.println("Child2에서 구현한 method1");
				
			}

			@Override
			public void method3() {
				System.out.println("Child2에서 구현한 method3");
				
			}
			
		};
		
		
		
		ci2.method1();
		ci2.method2();//Child2 인터페이스에서 재정의한 method2를 호출
		ci2.method3();

	}

}
