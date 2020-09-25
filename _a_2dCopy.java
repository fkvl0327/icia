
public class _a_2dCopy {

	public static void main(String[] args) {
		//2d copy			[0]			[1]			[2]
		int [][] origin = {{10,11,12}, {3,4,5,6}, {7,8}};//원소가 2개=.length=2
		int [][] copy = new int[10][10];//층수가 10층, 호실이 층마다 10호씩 있는 공간(데이터가 들어갈 수 있는 공간 100개)
//		for(int i=0; i<origin.length; i++) {
//				System.out.println("origin[i].length : " + origin[i].length);
//				//[0].length=3개(첫번째 원소 안의 원소가 3개)
//				//[1].length=4개(두번째 원소 안의 원소가 4개)
//			for(int j=0; j<origin[i].length; j++) {
//				copy[i][j] = origin[i][j];
//				System.out.println(copy[i][j]);//origin의 데이터를 복사
//			}
//		}
		
		System.arraycopy(origin, 0, copy, 0, origin.length);
		
		for(int i=0; i<copy.length; i++) {//copy의 행 수만큼 표시
			for(int j=0; j<copy[i].length; j++) {//copy의 열 수만큼 표시
				System.out.printf("%d ", copy[i][j]);//copy 행x렬 데이터
			} System.out.println();
		}
	}

}//2중 for문: 개수가 많을 때 특히 유용
//2중 for문을 사용하지 않고 각각의 원소 안에 있던 원소들을 복사해 올 수도 있다
