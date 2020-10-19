package interfaceLesson;

public class MyClass {
	//필드
	RemoteControl rc = new Television();
	int n1;
	
	
	//생성자
	public MyClass(RemoteControl rc) {
		this.rc = rc;
	}
	
	public MyClass(RemoteControl rc, int n1) {
		this.rc = rc;
		this.n1 = n1;
	}
	
	//메소드
	void methodA() {
		RemoteControl rc = new Audio();
		methodB(rc);
	}
	
	void methodB(RemoteControl rc) {
		rc.setMute(true);
	}
}
