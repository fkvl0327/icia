package stringLesson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//p.497-498
public class StringEx {

	public static void main(String[] args) throws IOException {
		// byteToString();
		// keyboardToString();
		// stringMethodTest();
		regexText();
		// stringSplitTest();
		// stringTokenizerTest();
		// stringBuilder();
		// patternTest();

	}

	private static void patternTest() {  
		// 역슬래시 두 개 쓰인 건 \를 문자로 인식하게 하기 위해 \를 한 번 더 쓴 것
		String regex = "(02|010|031|032)-\\d{3,4}-\\d{4}";
		String data = "010-1234-1235";
		boolean isData = Pattern.matches(regex, data);

		if (isData) {
			System.out.println(data + "는 regex가... 맞습니다!");
			System.out.println("정규표현식에 맞게 입력된 전화번호입니다.");
		} else {
			System.out.println(data + "는 regex가 아니고 String이야 ㅜㅜ");
			System.out.println("정규표현식에 맞지 않게 입력된 전화번호입니다.");
		}
		regex = "\\w+@\\w+\\.\\w+(\\.\\w)";
		data = "angel@navercom";
		isData = Pattern.matches(regex, data);
		System.out.print("email 주소: ");
		if (isData) {
			System.out.println(data + "는 regex가.... 맞습니다!");
			System.out.println("정규표현식에 맞게 입력된 이메일입니다.");
		} else {
			System.out.println(data + "는 regex가.... 아니고 String이야!");
			System.out.println("정규표현식에 맞지 않게 입력된 이메일입니다.");
		}
	}

	// 516p
	private static void stringBuilder() {
		// buffer를 내부적으로 사용
		// String str1 = "abc"; -> heap 영역 차지
		// 프로그램의 성능이 떨어진다
		// 버퍼를 사용함

		// StringBuffer: 여러 개의 thread 즉 multi-thread에서 동작
		// StringBuilder: single thread에서만 사용
		StringBuilder sb = new StringBuilder();

		// [Java Program Study]
		sb.append("Java ");
		sb.append("Program Study");
		System.out.println(sb.toString());

		sb.insert(4, "2");
		System.out.println(sb.toString());

		sb.setCharAt(4, '6');
		System.out.println(sb.toString());

		sb.replace(6, 13, "Book");
		System.out.println(sb.toString());

		int length = sb.length();
		System.out.println("총문자수: " + length);

		String result = sb.toString();
		System.out.println(result);

		int start = 6;
		int end = 13;
		String str = "Book";
		sb.replace(start, end, str);
		System.out.println(sb.toString());

		sb.delete(start, end);
		System.out.println(sb.toString());

		length = sb.length();
		System.out.println("총문자수: " + length);
	}

	private static void stringTokenizerTest() {
		String text = "아이유&지연, 유인나, 유희열-정재형";
		String seperator = "&|,|-";
		// -를 기준으로 나눔(나눈 것을 토큰이라고 함)

		// StringTokenizer 파라미터 안에는 String, String이 들어와야 하므로
		// 구분자를 String 변수로 담아두면 편하다
		StringTokenizer st = new StringTokenizer(text, seperator);

		// 토큰 개수를 int로 받아옴
		int countTokens = st.countTokens();

		// 토큰 개수만큼, 한 줄에 한 토큰씩 프린트
		for (int i = 0; i < countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token.trim());
		}

	}

	private static void stringSplitTest() {
		String text = "김동균&이수연, 피성우, 변준혁-박현옥";

		// &이나 ,이나 -를 구분자로 부분 문자열을 추출한 것을 regex라고 한다
		String seperator = "&|,|-";

		// regex를 names라는 이름의 String 배열로 표현
		// StringTokenizer 파라미터 안에는 String, String이 들어와야 하므로
		// 구분자를 String 변수로 담아두면 편하다
		String[] names = text.split(seperator);

		// 배열의 원소만큼 프린트
		for (String name : names) {
			// 위에서 , 앞에 띄어쓰기를 했다면 .trim()을 덧붙이지 않아도 빈칸 없이 나온다
			System.out.println(name.trim());
		}
	}

	private static void regexText() {
		Scanner sc = new Scanner(System.in);
		String phoneNumber = null;
		System.out.print("전화번호를 입력해주세요: ");
		phoneNumber = sc.next();
		String[] phoneArray = phoneNumberSplit(phoneNumber);
		System.out.println(phoneArray[0]);
		System.out.println(phoneArray[1]);
		System.out.println(phoneArray[2]);

	}

	// 참고: https://lnsideout.tistory.com/entry/JAVA-정규식으로-휴대폰번호-자르기
	private static String[] phoneNumberSplit(String phoneNumber) {
		String str1, str2, str3 = null;

		// ^: 시작한다 // replace 같이 위치를 찾아야 할 때 넣으면 좋음
		// ^뒤에 오는 건 시작하는 번호, ?뒤에 오는 건 시작하는 번호가 아닌 번호

		// 01+숫자(0~9)하나 또는 0505, 0502, 0506, 0+숫자 하나나 둘(02,031 등 지역번호)로 시작
		// 가운데 번호는 세자리나 네자리
		// 마지막 번호는 네자리
		String regex_pattern = "^(01\\d{1}|0505|0502|0506|0\\d{1,2})[.-]?(\\d{3,4})[.-]?(\\d{4})";
		// String regex_pattern = "(02|010|031|032)-(\\d{3,4})-(\\d{4})";

		Pattern p = Pattern.compile(regex_pattern);

		// Matcher 객체는 Pattern 객체의 메소드로 받아온다
		Matcher m = p.matcher(phoneNumber);

		//phoneNumber에서 m이 찾은 group의 수
		System.out.println(m.groupCount());

		if (m.matches()) {
			// 정규식에 적합하면 matcher.group으로 리턴
			System.out.println("matcher: 전화번호가 정상입력되었습니다.");
			return new String[] { m.group(1), m.group(2), m.group(3) };
		} else {
			// 정규식에 적합하지 않으면 substring으로 휴대폰 번호 나누기
			System.out.println("substring: 전화번호가 아닙니다.");
			str1 = phoneNumber.substring(0, 3);
			str2 = phoneNumber.substring(3, 7);
			str3 = phoneNumber.substring(7, 11);
			return new String[] { str1, str2, str3 };
		}
	}

	private static void stringMethodTest() {
		String str1 = "abc/123/code/fghhi-AS/fdaajhajfhk/13/한글2020   ";
		System.out.println("str1: [" + str1 + "]");

		str1.charAt(5);
		System.out.println("charAt(5): [" + str1.charAt(5) + "]");

		int n1 = str1.indexOf("abc");
		System.out.println("indexOf(\"abc\"): " + n1);

		String str2 = "abcd1234  ";
		System.out.println("str2 = [" + str2 + "]");
		n1 = str2.length();
		System.out.println("str2.length: " + n1);
		n1 = str2.trim().length();
		System.out.println("str2.trim().length: " + n1);
		str2 = str2.trim();
		System.out.println("str2.trim(): [" + str2 + "]");

		n1 = str1.length(); // str1의 문자열 길이를 리턴
		System.out.println("str1.length: " + n1);
		str1.replace("abc", "123");

		str1.substring(10);
		System.out.println("substring(10): [" + str1.substring(10) + "]");
		str1.substring(10, 20);
		System.out.println("substring(10, 20): [" + str1.substring(10, 20) + "]");

		n1 = str1.indexOf("abc");
		int len = "abc".length();
		str2 = str1.substring(n1, n1 + len);// 길면 직접 세는 게 어렵습니다 이렇게 바꿔서 쓰면 편해용
		boolean isEqual = str2.equals("abc");
		System.out.println("str2.equals(\"abc\"): " + isEqual);
		String str3 = null;
		if (isEqual) {
			str3 = str2.replace("abc", "123");

		}
		System.out.println("replace(\"abc\", \"123\"): " + str3);

		str2 = str1.toLowerCase();
		System.out.println("str1.toLowerCase(): [" + str2 + "]");
		str2 = str1.toUpperCase();
		System.out.println("str1.toUpperCase(): [" + str2 + "]");

		str2 = String.valueOf(123.23);
		System.out.println("String.valueOf(123.23): [" + str2 + "]");

		try {
			// 네트워크상에서 수신한 바이트 데이터를 utf-8 인코딩으로 읽어옵니다
			byte[] bytes = str1.getBytes("utf-8");
			byteToString(bytes);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void byteToString(byte[] bytes) {
		int readByteNo;
		try {
			readByteNo = System.in.read(bytes);
			String str = new String(bytes, 0, readByteNo - 2);
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void keyboardToString() throws IOException {
		byte[] bytes = new byte[100]; // 이렇게 만들어 놓는 걸 버퍼라고 부르기도 해요

		System.out.print("입력: ");
		int readByteNo = System.in.read(bytes);

		System.out.println("bytes: " + bytes);
		System.out.println("int: " + readByteNo);

		String str = new String(bytes, 0, readByteNo - 2);
		// 0번부터 byte의 길이 -2번째까지 String str으로 담아줘
		// -2인 이유는 윈도우 OS에서 캐리지리턴(\r)+라인피드(\n) 부분은 문자열로 만들 필요가 없기 때문
		// 리눅스 OS의 경우에는 -2 말고 조건을 조금 다르게 적을 거예요
		// 위에서 int가 7로 나오는 이유도 입력된 다섯 글자 외에 두 자리를 차지하는 \r, \n을 count했기 때문
		System.out.println(str);

	}

	private static void byteToString() {
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };

		String str1 = new String(bytes);

		System.out.println(str1);

		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
	}

}
