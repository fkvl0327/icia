
public class floatNdouble {

	public static void main(String[] args) {
		double var1 = 3.14;
		float var3 = 3.14f;
		
		double var4 = 0.1234567890123456789;
		float var5 = 0.1234567890123456789f;
		//float값보다 double이 정밀한 값을 출력
		//double 타입의 가수 bit 수가 float 타입의 가수 bit 수보다 약 두 배 정도 크기 때문
		
		System.out.println(var1);
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
		
		int var6 = 3000000;
		double var7 = 3e6;
		float var8 = 3e6f;
		double var9 = 2e-3;
		
		System.out.println(var6);
		System.out.println(var7);
		System.out.println(var8);
		System.out.println(var9);

	}

}
