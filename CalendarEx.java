package basicAPI;
//540P >> 544, 546도 이어서
import java.util.Calendar;
import java.util.TimeZone;

public class CalendarEx {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();//싱글턴 사용
		//static final로 선언한 멤버를 호출해서 사용하는 프로그래밍 방법
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		
		int week = now.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		switch(week) {
		case Calendar.MONDAY:
			strWeek = "월";
			break;
		case Calendar.TUESDAY:
			strWeek = "화";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "수";
			break;
		case Calendar.THURSDAY:
			strWeek = "목";
			break;
		case Calendar.FRIDAY:
			strWeek = "금";
			break;
		case Calendar.SATURDAY:
			strWeek = "토";
			break;
		case Calendar.SUNDAY:
			strWeek = "일";
			break;
		}
		
		int amPm = now.get(Calendar.AM_PM);
		String strAmPm = null;
		if(amPm == Calendar.AM) {
			strAmPm = "오전";
		}else {
			strAmPm = "오후";
		}
		
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		System.out.print(year + "년 ");
		System.out.print(month + "월 ");
		System.out.println(day + "일 ");
		System.out.print(strWeek + "요일 ");
		System.out.println(strAmPm + " ");
		System.out.print(hour + "시 ");
		System.out.print(minute + "분 ");
		System.out.println(second + "초 ");
		
		
		
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Rome");
		Calendar now2 = Calendar.getInstance(timeZone);
		
		String[] availableIDs = TimeZone.getAvailableIDs();
		for(String id : availableIDs) {
			System.out.println(id);
		}
		
		System.out.println("==============");
		
		int amPm2 = now2.get(Calendar.AM_PM);
		String strAmPm2 = null;
		if(amPm2 == Calendar.AM) {
			strAmPm2 = "오전";
		}else {
			strAmPm2 = "오후";
		}
		
		int hour2 = now2.get(Calendar.HOUR);
		int minute2 = now2.get(Calendar.MINUTE);
		int second2 = now2.get(Calendar.SECOND);
		
		System.out.print(year + "년 ");
		System.out.print(month + "월 ");
		System.out.println(day + "일 ");
		System.out.print(strWeek + "요일 ");
		System.out.println(strAmPm2 + " ");
		System.out.print(hour2 + "시 ");
		System.out.print(minute2 + "분 ");
		System.out.println(second2 + "초 ");
		
		
		
	}

}
