
public class chapter2question {

	public static void main(String[] args) {
		//자판기 만들려고 했는데 챕터2 확인문제
		int _int = 0;
		int $a = 1;
		System.out.println(_int);
		System.out.println($a);
		
		//5.
		byte byteValue = 10;
		char charValue = 'A';
		
		int intValue = byteValue;
		int intValue2 = charValue;
		//short shortValue = charValue;// char>short
		double doubleValue = byteValue;
		
		//6.
		int intValue3 = 10;
		char charValue2 = 'A';
		double doubleValue2 = 5.7;
		String strValue = "A";
		
		double var = (double) intValue3;
		byte var2 = (byte) intValue3;
		int var3 = (int) doubleValue;
		//char var4 = (char) strValue; // String문자열>char문자
		
		//7.
		//char var10 = ''; // 문자 하나가 반드시 입력되어야 함(스페이스도 가능)
		
		//8.
		byte a = 10;
		float b = 2.5f;
		double c = 2.5;
		
		//byte result = a + a; // byte는 1바이트 값이기 때문에 두 값을 더한 2바이트를 byte로 표시 불가
		//= 뒤에 (byte)라고 강제 캐스팅을 하면 컴파일 에러는 나지 않는다.
		
		int result2 = 5 + a;
		float result3 = 5 + b;
		double result4 = 5 + c;
		

	}

}
