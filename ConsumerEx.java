package lambda;

import java.util.function.Consumer;

public class ConsumerEx {

	public static void main(String[] args) {
		Consumer<String> consumer = t-> {
			System.out.println(t+"8");
		};
		consumer.accept("java");
	}

}
