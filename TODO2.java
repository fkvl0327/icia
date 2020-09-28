
public class TODO2 {
	private static String[][] todo2;
//객체지향에서는 전부 field에 만듭니다(변수가 함수 앞에 만들어짐)
	public static void main(String[] args) {
		int n1 = args.length;
		if(n1!=2) {
			System.out.println("param1: 0이면 할일을 등록");
			System.out.println("parma1: 1이면 할일을 출력");
			System.out.println("param2: 요일 입력");
		System.out.println("ex) java TODO2 1 SUNDAY");
		}else {
			String s1 = args[0];
			String s2 = args[1];
			
			String [][] todo = new String[7][3];
			todo = setTodo(todo);
			int n2 = getIndexWeek(s2);//요일을 인덱스로 반환
			
				System.out.println(n2+"번째 요일 할일:");
				for(int j=0;j<3;j++) {
					System.out.println(j +":" + todo[n2][j]);
				}
				System.out.println();
			}
		System.out.println("프로그램을 종료합니다.");
		}



	private static int getIndexWeek(String s2) {
	int index=0;
	if(s2.equals("일요일")) {
		index=0;
	}else if(s2.equals("월요일")) {
		index=1;
	}else if(s2.equals("화요일")) {
		index=2;
	}else if(s2.equals("수요일")) {
		index=3;
	}else if(s2.equals("목요일")) {
		index=4;
	}else if(s2.equals("금요일")) {
		index=5;
	}else if(s2.equals("토요일")) {
		index=6;
	}else {
		index=0;
	}
	return index;
	
}

	private static String[][] setTodo(String[][] todo) {
		String[][] todo2 = new String[7][3];
		todo2[0][0] = "java 열심히 공부하기";
		todo2[0][1] = "집에서 놀기";
		todo2[0][2] = "성묘가기";
		
		todo2[1][0] = "java 열심히 공부하기";
		todo2[1][1] = "집에서 놀기";
		todo2[1][2] = "성묘가기";
		
		todo2[2][0] = "java 열심히 공부하기";
		todo2[2][1] = "집에서 놀기";
		todo2[2][2] = "성묘가기";
		
		todo2[3][0] = "java 열심히 공부하기";
		todo2[3][1] = "집에서 놀기";
		todo2[3][2] = "성묘가기";
		
		todo2[4][0] = "java 열심히 공부하기";
		todo2[4][1] = "집에서 놀기";
		todo2[4][2] = "성묘가기";
		
		todo2[5][0] = "java 열심히 공부하기";
		todo2[5][1] = "집에서 놀기";
		todo2[5][2] = "성묘가기";
		
		todo2[6][0] = "java 열심히 공부하기";
		todo2[6][1] = "집에서 놀기";
		todo2[6][2] = "성묘가기";
		
		return todo2;
	}

}
