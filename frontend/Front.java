package frontend;

import java.util.Scanner;

import backend.services.Arithmetic;

public class Front {
	
	public Front() {
		this.controller();
	}
	
	// 기능을 수행하는 것이 아니라 프로그램의 데이터 플로우를 제어
	public void controller() {
		Scanner scanner = new Scanner(System.in);
		String[] subTitle = {"첫 번째 숫자 입력 : ", "1. 더하기  2. 빼기   3. 곱하기  4. 나누기 : ", "두 번째 숫자 입력 : "};
		String[] userData = new String[3];
		String temp = null;

		boolean loop;
		
		for(int index=0; index < subTitle.length; index++) {
			loop = true;
			// index 0, 1, 2 --> 숫자변환가능
			while(loop) {
				this.display(subTitle[index]);
				temp = this.userInput(scanner);
				loop = !this.isNumber(temp); // loop = false
				if(index == 1) {
					if(!this.isRange(1, 4, temp)) {
						loop = true;
					}
				}
			}
			userData[index] = temp;
		}
		
		// 연산
		Arithmetic operation = new Arithmetic();
		if(userData[1].equals("1")) {
			this.display(operation.plus(Integer.parseInt(userData[0]), Integer.parseInt(userData[2]))+"");
		}else if(userData[1].equals("2")){
			this.display(operation.minus(Integer.parseInt(userData[0]), Integer.parseInt(userData[2]))+"");	
		}else if(userData[1].equals("3")){
			this.display(operation.product(Integer.parseInt(userData[0]), Integer.parseInt(userData[2]))+"");	
		}else {
			this.display(operation.division(Integer.parseInt(userData[0]), Integer.parseInt(userData[2]))+"");
		}
		
		scanner.close();
	}
	
	// 숫자의 지정 범위 여부 판단 메서드
	public boolean isRange(int r1, int r2, String value) {
		boolean range = false;
		int v = Integer.parseInt(value);
		if(v >= r1 && v <= r2) {range = true;}
		return range;
	}
	
	// 숫자변환가능여부 판단 메서드
	public boolean isNumber(String value) {
		boolean result = false;
		try {
			Integer.parseInt(value);
			result = true;
		}catch(Exception e) {	}
		return result;
	}
	// 입력기능
	public String userInput(Scanner sc) {
		return sc.next();
	}
	
	// 출력기능
	public void display(String text) {
		System.out.print(text);
	}
	
}
