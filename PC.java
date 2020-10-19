package classLesson;
//7장 5번 문제
public class PC {
	public String name;
	
	public PC(String name) {
		this.name = name;
	}
}

class ChildOfPC extends PC {
	private int studentNo;
	
	public ChildOfPC(String name, int studentNo) {
		super(name);
		//super(매개값포함)를 가져와야 함=super클래스 생성자 호출문 필요
		//순서대로 작성하면 클래스를 만들고 난 후 이클립스 워닝 뜨고 
		//워닝 따라 만들면 super클래스 자동 생성됨
		this.name = name;
		this.studentNo = studentNo;
	}
	
//	@Override
	//Child가 Parent 메소드를 Override할 때,
	//Parent 메소드보다 좁은 접근 제한자를 붙일 수 없다
//	private void PC(String name) {
//		this.name = name;
//	}
	
//	@Override
//	//Child가 Parent 메소드를 Override할 때,
//	//Parent 메소드보다 좁은 접근 제한자를 붙일 수 없다
//	private ChildOfPC(String name, int studentNo) {
//		super(name);
//		this.name = name;
//		this.studentNo = studentNo;
//	}
}