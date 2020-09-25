public class gugudan2 {

	public static void main(String[] args) {
		int[][] gugudan = {{2,3,4,5,6,7,8,9}, {1,2,3,4,5,6,7,8,9}};
		System.out.println(gugudan[0].length);
		System.out.println(gugudan[1].length);
		for(int i=0; i<gugudan[0].length; i++) {
			System.out.println(gugudan[0][i]+"단");
			for(int j=0; j<gugudan[1].length; j++) {
				int a = gugudan[0][i], b = gugudan[1][j], c = a*b;
				System.out.println(a + "x" + b + "=" + c);
			}
		}
	}
}