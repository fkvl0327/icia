package lambda;
//표준 API의 함수적 인터페이스(p.688)
//interface Runnable: 스레드의 작업을 정의 
public class RunnableEx {

	public static void main(String[] args) {
		Runnable runnable = () -> {//매개변수와 return값이 없음(void)이므로 이렇게 사용가능
			for(int i=0; i<10; i++) {
				System.out.println(i);
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}

}
