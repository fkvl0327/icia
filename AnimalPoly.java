package classLesson;

class AnimalPoly {//animal로 다형성을 이해해보자 와아~
	public static void main(String[] args) {
		AnimalPoly myAnimal = new AnimalPoly();
		AnimalPoly myPig = new Pig();
		AnimalPoly myDog = new Dog();

		myAnimal.animalSound();
		myPig.animalSound();
		myDog.animalSound();
		
		System.out.println("---------------");
		
		myAnimal = myPig;
		myAnimal.animalSound();
		myAnimal = myDog;
		myAnimal.animalSound();
		
		System.out.println("---------------");
		

		myDog = myPig;
		myDog.animalSound();
		
		myPig = myDog;//Pig와 Dog는 parent-child 관계가 아니다. 한 번 바뀐 값으로 고정된다.
		myPig.animalSound();
		
		myAnimal = myPig;//Animal은 parent이기 때문에 여러 번 바꿀 수 있다.
		myAnimal.animalSound();
		
		System.out.println("---------------");
		
		myAnimal = new Dog();//Dog의 새 instance로 myAnimal를 만들면
		myAnimal.animalSound();
		myDog = myAnimal;//새로 만든 myAnimal(처음의 myDog와 같은 것, AnimalPoly의 myAnimal과 다름)
		myDog.animalSound();//값을 받아서 Dog의 animalSound() 실행
		
		
		System.out.println("---------------");
	}

	public void animalSound() {
		System.out.println("The animal makes a sound");
	}
}

class Pig extends AnimalPoly {
	public void animalSound() {
		System.out.println("The pig says: wee wee");
	}
}

class Dog extends AnimalPoly {
	public void animalSound() {
		System.out.println("The dog says: bow wow");
	}

}