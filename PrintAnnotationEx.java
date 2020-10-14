package classLesson;
//어노테이션은 JSP, SPRING에서 중요합니다(감 잡는 용도)



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintAnnotationEx {

	public static void main(String[] args) {
		// Service클래스에서 메소드 가져오기
		//// Service클래스에서 가져온 Method의 배열을 declaredMethods라는 이름으로 부른다
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		
		//크게 가져올 수 있는 건 annotation, constructor, field, method, class
		Field[] declaredFields = Service.class.getDeclaredFields();
		
		for(Field f : declaredFields) {
			System.out.println(f.getName());
		}
		
		Constructor[] cons = Singleton.class.getDeclaredConstructors();
		
		for(int i=0;i<cons.length;i++) {
			System.out.printf("%s \n", cons[i]);
		}
		
		int cnt=0;

		// Method 객체를 하나씩 처리 for() 사용
		//// declaredMethods 원소의 개수만큼 Method를 하나씩 다 가져오고, 그걸 m이라고 하자
		for (Method m : declaredMethods) {
			
			// PrintAnnotation 적용 여부 확인 - if()
			//// PrintAnnotation이라는 클래스에 PrintAnnotation이라는 어노테이션이 있으면
			if (m.isAnnotationPresent(PrintAnnotation.class)) {
				
				//// PrintAnnotation클래스에서 어노테이션을 받아온 것을 ann이라고 하자
				PrintAnnotation ann = m.getAnnotation(PrintAnnotation.class);
				
				// annotation을 사용하는 method 출력
				System.out.println("[" + m.getName() + "]");

				// annotation의 기능을 사용해서 출력
				////PrintAnnotation이 쓰인 만큼(3회) value를 출력하도록 한다
				for (int i = 0; i < ann.number(); i++) {
					System.out.print(ann.value());
				}
				////invoke() 메서드는 리플렉션을 사용하여 동적으로 모든 java 메서드를 호출하는데 사용된다.
				////m.invoke(new Service()); 작성 후 try-catch
				try {
					m.invoke(new Service());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
