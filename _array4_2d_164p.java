
public class _array4_2d_164p {

	public static void main(String[] args) {
		int[][] mathScores = new int[2][3];
		mathScores[0][0] = 30;// 이런 식으로 값이 주어지면 아래 출력 시 (0,0) 좌표 값에 30이 출력됨
		for(int i=0; i<mathScores.length; i++) {
			for(int k=0; k<mathScores[i].length; k++) {
				System.out.println("mathScores[" + i + "][" + k +"]="
						+ mathScores[i][k]);
			}
		}
		System.out.println();
		
		int[][] englishScores = new int[2][];
		englishScores[0] = new int[2];
		englishScores[1] = new int[3];
		for(int i=0; i<englishScores.length; i++) {
			for(int k=0; k<englishScores[i].length; k++) {
				System.out.println("englishScores[" + i + "][" + k + "]="
						+ englishScores[i][k]);
			}
		}
		System.out.println();
		//수학점수와 영어점수는 배열만 주어지고 배열 안의 값이 없기 때문에 초기값인 0으로만 나온다
		
		int[][] javaScores = {{95,80},{92,96,80}};
		for(int i=0; i<javaScores.length; i++) {
			for(int k=0; k<javaScores[i].length; k++) {
				System.out.println("javaScores[" + i + "][" + k + "]="
						+ javaScores[i][k]);
		}
	}

}
}