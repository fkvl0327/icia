package interfaceLesson;
//8장 확인문제 5번
public class ActionEx {

	public static void main(String[] args) {
		Action action = new Action() {

			@Override
			public void work() {
				System.out.println("복사를 합니다.");
				
			}
			
		};
		
		action.work();

	}

}

interface Action {
	void work();
}