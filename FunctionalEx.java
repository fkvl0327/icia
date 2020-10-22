package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionalEx {

	static List<Student> list = Arrays.asList(new Student("노윤정", 90, 96), new Student("민상혁", 95, 93));

	public static void main(String[] args) {

		System.out.println("Function: 학생이름을 출력합니다.");
		printString(t -> t.getName());

		System.out.println("Function: 영어성적을 출력합니다.");
		printInt(t -> t.getEnglishScore());

		System.out.println("ToIntFunction: 수학성적을 출력합니다.");
		printInt2(t -> t.getMathScore());
		
		System.out.println("영어 성적 평균을 출력합니다.");
		double englishAvg = getAvg(q->q.getEnglishScore());
		System.out.println(englishAvg);
		
		System.out.println("영어 성적 총점을 출력합니다.");
		int englishSum = getSum(q->q.getEnglishScore());
		System.out.println(englishSum);
		
		System.out.println("수학 성적 평균을 출력합니다.");
		double mathAvg = getAvg(q->q.getMathScore());
		System.out.println(mathAvg);
		
		System.out.println("수학 성적 총점을 출력합니다.");
		int mathSum = getSum(q->q.getMathScore());
		System.out.println(mathSum);
	}

	private static int getSum(Function<Student, Integer> function) {
		int sum = 0;
		int english;
		for(Student student : list) {
			english = function.apply(student);
			sum = sum + english;
		}
		return sum;
	}

	private static double getAvg(Function<Student, Integer> function) {
		double avg;
		int sum = 0;
		int english;
		int count;
		for(Student student : list) {
			english = function.apply(student);
			sum = sum + english;
		}
		count = list.size();
		avg = (double)sum / count;
		
		return avg;
	}

	private static void printInt2(Function<Student, Integer> function) {
		for (Student student : list) {
			System.out.println(function.apply(student));
		}
		System.out.println();
	}

	private static void printInt(ToIntFunction<Student> function) {
		for (Student student : list) {
			System.out.println(function.applyAsInt(student));
		}
		System.out.println();
	}

	private static void printString(Function<Student, String> function) {
		for (Student student : list) {
			System.out.println(function.apply(student));
		}
		System.out.println();
	}
}
