
public class MyClass2 {

	public static void main(String[] args) {
		int x = 5;
		int y = 3;
		System.out.println(x + y);
		
		String s1="abc";
		String s2="DEF";
		System.out.println(s1 + s2);
		System.out.println(s1 + x);
		
		System.out.println(x - y);
		System.out.println(x * y);
		System.out.println(x / y);
		System.out.println(x % y);
		//한 줄에 넣을 때는 x++ = ++x = x+1로 같다
		System.out.println(x++);// print(x);x=x+1
		System.out.println(++x);// x=x+1;print(x);
		System.out.println(y--);// print(y);y=y-1
		System.out.println(--y);// y=y-1;print(y);
		//++나 --가 뒤에 있으면 다음줄에 영향
		
		int n1 = 10;
		opTest(n1);//10
		opTest1(n1);//10
		opTest2(n1);//10
		opTest3(n1++);//10->11
		opTest3(++n1);//11
		
		opModular(4, 5);
		opModular(1, 5);
		opModular(-1, 5);
		opModular(-4, 5);
			  }

	private static void opModular(int n1, int n2) {
		System.out.println("opModular: " + n1 % n2);
		
	}

	private static void opTest3(int n1) {
		System.out.println("opTest3: " + n1);//5. 10->(11)->6. 12
		
	}

	private static void opTest2(int n1) {
		System.out.println("opTest2: " + ++n1);//4. 11
		
	}

	private static void opTest1(int n1) {
		System.out.println("opTest1: " + n1++);//3. 10
		
	}

	private static void opTest(int n1) {
		System.out.println("opTest: " + n1);//1. 10
		n1 = n1 + 1;
		System.out.println("opTest: " + n1);//2. 11
		
	}
	
	
	}

