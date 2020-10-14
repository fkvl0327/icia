package classLesson;//자식

public class HCar extends Vehicle {
	int maxSpeed = 300;
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void honk() {
		System.out.println("HCar honk!");
	}
	
	public void honk(int type) {
		if(type==1) {
		System.out.println("HCar honk!");
		}else if(type==2){
			System.out.println("1이 아닙니다");
		}
	}
	
	String modelName = "큐브";  // private이면 다른 클래스에서 참조 불가
	public static void main(String[] args) {
		    // Create a myCar object
		    HCar mine = new HCar();

		    // Call the honk() method (from the Vehicle class) on the myCar object
		    mine.honk();

		    // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
		    System.out.println(mine.brand + " " + mine.modelName);
		  }
	
	}


