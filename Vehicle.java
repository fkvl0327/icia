package classLesson;//부모

public class Vehicle {
	int maxSpeed = 150; // private가 표시되어 있지 않아도 private가 기본값
	
	String brand = "현대자동차";        // Vehicle attribute
	  public void honk() {                    // Vehicle method
	    System.out.println("Tuut, tuut!");
	  }
	  
	  public void honk(int type) {
			if(type==1) {
			System.out.println("Vehicle honk!");
			}else if(type==2){
				System.out.println("1이 아닙니다");
			}
		}
	  
	public int getMaxSpeed() {
		return maxSpeed;
	}//setter 없이 getter만 만들면 값을 바꿀 수 없고 정해진 값을 출력만 한다
	
}

