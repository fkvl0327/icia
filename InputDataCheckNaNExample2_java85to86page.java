
public class InputDataCheckNaNExample2_java85to86page {

	public static void main(String[] args) {
		String userInput = "NaN";//2)원래는 숫자를 문자열로 입력했어야 하는데, NaN이라는 문자가 들어온 경우
		double val = Double.valueOf(userInput);//1)은행 전산시스템에서는 문자열을 숫자로 바꿔서 계산하는 경우가 많다
		
		//문자를 숫자로 인식하게 하는 방법 많이 쓰니까 기억해둡시다
		//파싱 parsing: 문자열 보냈을 때 몇번째부터 몇번째까지 구분되는 정보라는 것을 구분해내는 것
		//파서 parser
		//Integer.valueOf("userInput")
		//Integer자리에 숫자 나타내는 어떤 타입을 입력해도 됨(보통 Double)
		
		//숫자를 문자열로 변환하는 것도 간단합니다
		//"" + 숫자 -> "숫자"
		//String.valueOf(숫자) -> "숫자"
		
		double currentBalance = 10000.0;
		
		if(Double.isNaN(val)) {
			System.out.println("NaN이 입력되어 처리할 수 없음");//3)숫자가 아닌 NaN이 들어와서 계산불가
			val = 0.0;//4)계산불가한 NaN이 들어온 경우에는 0으로 처리하자고 약속
			//이 조건문이 없으면 NaN을 인식하게 되어 현재잔액까지 NaN이 됨
		}
		
		currentBalance += val;//현재잔액에 val을 더했다
		System.out.println(currentBalance);//10000.0+0=10000.0

	}

}
