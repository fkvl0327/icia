package classLesson;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target( METHOD )

//element
public @interface PrintAnnotation {
	//아래 쓰인 내용이 element(parameter 값을 설정해주기 위한 내용)
	String value() default "-";
	int number() default 5;
}
