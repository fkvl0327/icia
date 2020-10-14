package classLesson;//손자

public class SonataCar extends HCar {
	String driver = "J";

	int maxSpeed = 200;

	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void honk() {
		System.out.println("SonataCar honk!");
	}
	
	public void honk(int type) {
		if(type==1) {
		System.out.println("SonataCar honk!");
		}else if(type==2){
			System.out.println("1이 아닙니다");
		}
	}

	public static void main(String[] args) {
		SonataCar mine = new SonataCar();
		mine.honk(); // Vehicle로부터 상속
		System.out.println(mine.brand + " " + mine.modelName + "'s owner: " + mine.driver);
		// V에서 brand, H에서 modelName을 상속, 본 클래스에서 driver 사용

	}

}
