
public class BitReverseOperator_toBinaryString {

	public static void main(String[] args) {
		int v1 = 10;
		int v2 = ~v1;
		int v3 = ~v1 + 1;
		
		System.out.println(toBinaryString(v1) + "(십진수: " + v1 + ")");
		System.out.println(toBinaryString(v2) + "(십진수: " + v2 + ")");
		System.out.println(toBinaryString(v3) + "(십진수: " + v3 + ")");
		System.out.println();

		int v4 = -10;
		int v5 = ~v4;
		int v6 = ~v4 + 1;
		System.out.println(toBinaryString(v4) + "(십진수: " + v4 + ")");
		System.out.println(toBinaryString(v5) + "(십진수: " + v5 + ")");
		System.out.println(toBinaryString(v6) + "(십진수: " + v6 + ")");
	}

	private static String toBinaryString(int anyName) {//총 32자리 글자가 되도록 표시
		String str = Integer.toBinaryString(anyName);//자바가 이진수를 리턴하는 메소드
		//아래 while구문을 지우면 앞자리가 0으로 된 부분이 생략되어 표시된다
		while (str.length() < 32) {//32자리 글자가 될 때까지 반복
			str = "0" + str;//생략된 자리의 0을 표시
		}//여기까지 while구문
		return str;//이 부분은 int를 이진수로 표시하는 문자열로 보여달라는 내용
	}

}
