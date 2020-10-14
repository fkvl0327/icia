package classLesson;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Abc(value="", param1="", param2="", param3=10)//아래에서 @interface로 만든 커스텀 어노테이션 Abc
public @interface Abc {
	String value() default "values";
	String param1();
	String param2();
	int param3() default 10;
}
