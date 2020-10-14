package classLesson;

public class Car {
	// 필드 입력
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;
	int gas;

	// 우클릭>source>Generate Constructor using Fields
	// 개수가 많지 않으면 자동생성된 대로 써도 상관은 없지만
	// 중복되는 줄이 많다면 줄이는 방법이 있다 (책 213p)
	// 아래에 적어둔 model, 은색, 250은 변수 타입을 제시한 내용
	public Car(String model) {
		this(model, "은색", 250);
		// Car(Str, Str, int) 함수를 가리킴
		// ctrl+클릭 시 this가 가리키는 함수로 이동

//		super();
//		this.model = model;
	}

	public Car(String model, String color) {
		this(model, color, 250);
//		super();
//		this.model = model;
//		this.color = color;
	}

	public Car(String model, String color, int maxSpeed) {
		super();
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	// 생성자 함수가 없으면 default constructor가 동작
	// default constructor: 기본 생성자 (비어 있는 생성자)
	public Car() {

	}

	void setGas(int gas) {
		this.gas = gas;
	}

	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	}

	void run() {
		while (true) {
			if (gas > 0) {
				System.out.println("달립니다. (gas잔량:" + gas + ")");
				gas -= 1; // gas--; 라고 적어도 똑같음
			} else {
				System.out.println("멈춥니다. (gas잔량:" + gas + ")");
				return;
			}
		}
	}

	public void fullThrottle() {
		System.out.println("The car is going as fast as it can!");
	}

	public void speed(int maxSpeed) {
		// this.maxSpeed = maxSpeed; <- 이렇게 쓰면 이 파일의 maxSpeed 값을 받음
		System.out.println("Max speed is: " + maxSpeed);
	}

	int modelYear;
	String modelName;

	public Car(int year, String name) {
		modelYear = year;
		modelName = name;
	}

}
