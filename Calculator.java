package classLesson;

public class Calculator {
	int powerButton = 0;
	int resultButton = 0;
	double result;
	int n1;
	int n2;
	
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	int plus(int n1, int n2) {
		int result = n1 + n2;
		return result;
	}
	double divide(int n1, int n2) {
		double result = (double)n1 / (double)n2;
		return result;
	}
	
	int minus(int n1, int n2) {
		int result = n1 - n2;
		return result;
	}
	
	int mul(int n1, int n2) {
		int result = n1 * n2;
		return result;
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
}
