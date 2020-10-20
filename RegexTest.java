package stringLesson;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	
	public static void main(String[] args) {
		//simpleEmailRegex();
		recommendEmailRegex();
	}

	private static void recommendEmailRegex() {
		List<String> emails = new ArrayList<String>();
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user.name@domain.com");
		emails.add("user_name@domain.com");
		emails.add("username@yahoo.corporate.in");
		 
		//Invalid emails
		emails.add(".username@yahoo.com");
		emails.add("username@yahoo.com.");
		emails.add("username@yahoo..com");
		emails.add("username@yahoo.c");
		emails.add("username@yahoo.corporate");
		 
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		 
		Pattern pattern = Pattern.compile(regex);
		 
		for(String email : emails){
		    Matcher matcher = pattern.matcher(email);
		    System.out.println(email +" : "+ matcher.matches());
		}
		
	}

	private static void simpleEmailRegex() {
		
		//List와 ArrayList는 기본 타입이 <E>라고 되어 있다
		//String을 add하고자 할 때, String 타입을 입력한다는
		//generic 표시를 해주지 않으면 아래 add에서 type safety 워닝이 발생하기도 하고
		//for문에서는 emails가 object이기 때문에 String email을 반복할 수 없다(컴파일 에러)
		List<String>emails = new ArrayList<String>();
		
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user1@domain.com");
		emails.add("user.name@domain.com");
		emails.add("user#@domain.co.in");
		emails.add("user@domaincom");
		 
		//Invalid emails
		emails.add("user#domain.com");
		emails.add("@yahoo.com");
		 
		String regex = "^(.+)@(.+)$";
		 
		Pattern pattern = Pattern.compile(regex);
		
		for(String email : emails){
		    Matcher matcher = pattern.matcher(email);
		    System.out.println(email +" : "+ matcher.matches());
		}
	}

}
