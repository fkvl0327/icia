
public class StringEqualsExample_java91page {

	public static void main(String[] args) {
		String strVar1 = "신민철";
		String strVar2 = "신민철";
		String strVar3 = new String("신민철");
		
		System.out.println( strVar1 == strVar2 );
		System.out.println( strVar1 == strVar3 );// == 연산자가 주소값을 비교하기 때문에 false
		System.out.println();
		System.out.println( strVar1.equals(strVar2));
		System.out.println( strVar1.equals(strVar3));// .equals()메소드는 리터럴 값을 비교하기 때문에 true
	}

}
