package classLesson;

public class AnimalAbs {
	public static void main(String[] args) {
		PigChild myPig = new PigChild();
	    myPig.animalSound();
	    myPig.sleepSound();
	    myPig.eatMuch();
	}
}

abstract class Animal {
	abstract void animalSound();
	void sleepSound() {
		System.out.println("zZ~~!");
	}
}

abstract class PigParent extends Animal {
	abstract void eatMuch();
}

class PigChild extends PigParent {
	//PigChild가 직접 상속받은 PigParent뿐만 아니라
	//PigParent가 상속받은 Animal에서도 abstract 메소드가 있었던 경우에
	//Override할 메소드는 두 개가 된다
	
	//새로 만든 child class(이 예제에서는 PigChild) 위에 커서를 올리면
	//아래와 같이 이클립스가 Override할 메소드가 두 개 있다고 알려준다
	
	@Override
	void animalSound() {
		System.out.println("Pig is crying");
	}
	
	@Override
	void eatMuch() {
		System.out.println("Pig is happy");
	}
}