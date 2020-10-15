package classLesson;

public class SmartPhone extends Cell {
	boolean service5G;
	String wifi;
	String gps;
	CameraType camera; // enum타입을 만든 후 .으로 선택
	String record;	
	
//이클립스 기능//
//parent 클래스가 abstract이고 상속받은 child 클래스에 abstract 메소드가 완성되지 않았을 때
//child 클래스 위에 마우스 커서를 대고 있으면 abstract 메소드를 @Override 어노테이션과 함께 작성

//추상 클래스//
//abstract는 항상 동일한 기능에는 불필요하고, 쓸 때마다 다르게 작동할 때 좋다
//하나의 parent에 여러 child가 있을 때, child마다 abstract를 다르게 완성할 수 있다
//parent는 여러 child를 가질 수 있다
//다중상속이 불가하다 = child는 여러 parent를 가질 수 없다

	@Override
	void bell() {
		// TODO Auto-generated method stub
	}

	public void SmartPhone(String model, String color, CameraType camera) {
		this.model = model;
		this.color = color;
		this.camera = camera;
	}
	
	//getter, setter는 속성값을 변경하기 위해서 사용하는 함수예요(메소드와는 다르다)
	public CameraType getCamera() {
		return camera;
	}

	public void setCamera(CameraType camera) {
		this.camera = camera;
	}
	
	//원하는 기능대로 메소드를 만들어보세요~
	void camStart() {
		System.out.println("카메라 앱을 시작합니다.");
	};
	void cmaStop() {
		System.out.println("카메라 앱을 종료합니다.");
	};
	void camPic() {
		System.out.println("사진을 찍습니다.");
	};
	void camMovie() {
		System.out.println("녹화합니다.");
	};
	void camSetting() {
		System.out.println("밝기를 조절합니다.");
	};


	
}
