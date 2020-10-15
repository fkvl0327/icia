package classLesson;
//이너클래스는 자주 쓰나요?
//기능을 알고 있다고 무분별하게 쓰면 읽기 힘든 스파게티 코드가 되니 주의하세요 ㅠㅠ
public class InnerClassTest {
	
	public static void main(String[] args) {
	    OuterClass out = new OuterClass();
	    
	    //InnerClass를 OuterClass의 변수나 메소드처럼 .뒤에 불러올 수 있다
	    OuterClass.InnerClass in = out.new InnerClass();
	    
	    //InnerClass를 OuterClass처럼 InnerClass만 입력해서 instance를 생성할 수는 없다
	    //InnerClass in = new InnerClass();
	    
	    //InnerClass는 상속을 받은 것은 아니므로, InnerClass의 instance에 .을 찍으면
	    //InnerClass의 변수/메소드만 불러올 수 있다
	    //마찬가지로, 상속을 받은 것이 아니므로 같은 이름의 메소드를 사용한다고 자동으로
	    //오버라이딩하는 것이 아니다.
	    
	    //InnerClass라고 하더라도, InnerClass앞에 private modifier로 접근을 제한한다면
	    //OuterClass가 InnerClass에 접근할 수 없다
	    
	    //instance를 생성했다면 OuterClass의 instance를 사용하듯이 InnerClass도 instance만 쓰면
	    //InnerClass의 instance in. 뒤에 InnerClass 필드 변수 x를 사용할 수 있다
	    System.out.println(in.x + out.x);
	    
	    //InnerClass가 static이라면 OuterClass의 instance를 생성하지 않고도
	    //InnerClass의 instance를 생성할 수 있다
	    OuterClass.Inner2 in2 = new OuterClass.Inner2();
	    System.out.println(in2.x);
	  }

}


//field 변수 이름을 똑같이 써도 오류가 나지 않습니다 (당연한?? 서로 다른 클래스이니까)
class OuterClass {
	  int x = 10;

	  class InnerClass {
	    int x = 5;
	  }
	  
	  static class Inner2 {
		  int x = 20;
	  }
	}