package wBaekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader
				(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter
				(new OutputStreamWriter(System.out));
		StringTokenizer st;
		//BufferedReader로 연산을 몇 번 할 것인지 입력받는다
		//문자열을 입력받았기 때문에 숫자로 인식하기 위해 Integer.parseInt가 필요
		int T= Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			//한 줄에 숫자를 두 개 띄어쓰기해서 입력받는다
			//입력된 숫자는 띄어쓰기를 제외하고 인식하기로 한다
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			//입력된 두 개의 숫자를 더한 값을
			int sum = A+B;
			//BufferedWriter로 출력한다
			bw.write(sum + "\n");
		}
		bw.flush();
	}
}