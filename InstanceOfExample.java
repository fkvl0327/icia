package classLesson;

public class InstanceOfExample {
	//field 변수
	
	//field 메소드
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("parent는 Child의 instance입니다.");
		}else {
			System.out.println("parent는 Child의 instance가 아닙니다.");
		}
	}
	
	public static void method2(Parent parent) {
		try {
		Child child = (Child) parent;
		//parent class의 instance는 child class로 캐스팅 후 child의 instance로 대입가능
		System.out.println("child = (Child) parent");
		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
			System.out.println("child = (Child) parent 오류가 발생했습니다.");
		}finally {//case의 default와 유사하다
			//try{}가 성공하거나 try{} 도중 문제발생하여 catch{} 실행되거나
			//마지막으로 언제나 finally{}를 실행한다
			System.out.println("instance를 확인해서 입력하세요.");
		}
	}
	
	public static void method3(Child child) {
		if(child instanceof Parent) {
			Parent parent = child;
			//child class의 instance는 바로 parent의 instance로 대입 가능
			System.out.println("child는 Parent의 instance입니다.");
		}else {
			System.out.println("child는 Parent의 instance가 아닙니다.");
		}
	}

	public static void main(String[] args) {
		Parent p = new Parent();
		method1(p);
		
		Parent m = new Child();
		method1(m);
		
		Child a = new Child();
		method1(a);
		method2(a);
		method3(a);
	
		method2(p);//p는 Parent의 instance이므로 Child로 캐스팅해서 넣을 수 없기 때문에 문제 발생
		method2(m);//m은 Child의 instance이므로 정상실행
		
		System.out.println("=================");
		
		Parent parent = new Child();//(Parent)캐스팅이 없더라도 parent를 만들 수 있다
		//Child는 Parent 클래스를 상속받았기 때문에
		
		parent.s1_parent = "parent 1234";
		parent.method1();//child의 멤버(child 클래스에서 오버라이딩한 내용으로 출력)
		parent.method2();//parent의 멤버
		
		Child child = (Child) parent;
		child.s1_child = "child 1234";
		System.out.println(child.s1_parent);
		System.out.println(child.s1_parent);
		child.s1_parent = "child 1234 with s1.parent";
		System.out.println(child.s1_parent);
		System.out.println(child.s1_parent);
		
		//child instance는 child의 메소드와 parent의 메소드 모두 볼 수 있다
		child.method1();//child method(부모에게도 같은 이름의 메소드가 있을 때는 본인 클래스의 메소드 사용)
		child.method2();//parent method
		child.method3();//child method

	}

}

class Parent {
	String s1_parent;
	
	void method1() {
		System.out.println("parent m1");
	}
	
	void method2() {
		System.out.println("parent m2");
	}
	
	
}

class Child extends Parent {
	String s1_child;
	
	@Override // 오버라이드 어느테이션이 없어도, child 클래스에 parent 클래스의 것과
	// 같은 이름의 메소드가 있으면, 자동으로 오버라이딩한다
	void method1() {
		System.out.println("child m1");
	}
	
	void method3() {
		System.out.println("child m3");
	}
	
}

//class와 method 구분
//class 뒤에는 ()를 사용하지 않아요