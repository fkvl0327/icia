
public class JavaLesson {
	public static
	void main(String[] args) {
		dividerTest();
		dataTypeTest();
	}
		private static void dividerTest() {
			int n1=4, n2=10;
			float f1 = (float)n1/n2;
			System.out.println("n1/n2 ="+f1);
		};
		

		//variableTest();
		
		/*
		int n0 = 100, n1 = 1000;
		n0 = n1; // n0=1000으로 변경
		int retCode=0;
		char c0 = 'a';
		return retCode=0;
		*/
	
	private static void dataTypeTest() {
		
				byte myNumByte = 100;
				System.out.println(myNumByte);
				
				short myNumShort = 5000;
				System.out.println(myNumShort);
				
				int myNumInt = 100000;
				System.out.println(myNumInt);
				
				long myNumLong = 15000000000L;
				System.out.println(myNumLong);
				
				float myNumFloat = 5.75f;
				System.out.println(myNumFloat);
				
				double myNumDouble = 19.99d;
				System.out.println(myNumDouble);
				
				
				float f1 = 35e3f;//35x10^3
				double d1 = 12E4d;
				System.out.println(f1);
				System.out.println(d1);
				
				char a = 65, b = 66, c = 67;
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				
}
	
	private static void variableTest() {
		
		String name = "John";
		System.out.println(name);

		int myNum = 15;
		System.out.println(myNum);
		
		/*
		 * int myNum; myNum = 15; System.out.println(myNum);
		 * 
		 * final int myNum = 15; myNum = 20; // will generate an error: cannot assign a
		 * value to a final variable
		 * 
		 * 
		 * 
		 * int myNum = 5;
		
		float myFloatNum = 5.99f;
		char myLetter = 'D';
		boolean myBool = true;
		String myText = "Hello";

		System.out.printf("Hello %s\n", name);
		System.out.println("Hello" + name + "high");
		
		String firstName = "John ";
		String lastName = "Doe";
		String fullName = firstName + lastName;
		System.out.println(fullName);
		*/

		int minutesPerHour = 60;

		// OK, but not so easy to understand what m actually is
		int m = 60;
	}}
	
		
	


