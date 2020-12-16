package load;

import frontend.Front;

public class Loader {

	public static void main(String[] args) {
		new Front(); // 메인이 프론트를 제어하지 못하게 하기 위해 참조변수를 만들지 않음
	}

}
