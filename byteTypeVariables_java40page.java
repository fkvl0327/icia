
public class byteTypeVariables_java40page {

	public static void main(String[] args) {
		byte var1 = -128;
		byte var2 = -30;
		byte var3 = 0;
		byte var4 = 30;
		byte var5 = 127;
		//byte var6 = 128; // 컴파일 에러 // byte 값은 127까지만 저장가능하므로 128은 데이터타입 범위를 벗어남
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
		
		for(byte i=0;;i++) {
			System.out.println("byte i = " + i);
		}//실행하면 무한 반복됨 ㅠㅠ//무한반복해도 -128부터 127까지 표시함//

	}

}
