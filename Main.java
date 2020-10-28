package wBaekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 입출력을 위해 BufferedReader와 BufferedWriter를 생성
		// BufferedReader는 InputStreamReader를 메소드로 가지고
		// BufferedWriter는 OutputStreamWriter를 메소드로 가진다
		
		// 입력방법: br.readLine()
		// 입력은 두 번 받는다(예제 입력에 따라)
		
		// 첫 번째 입력을 StringTokenizer의 인스턴스 st라고 한다
		// StringTokenizer는 특별한 제한이 없을 경우 띄어쓰기를 기준으로 문자열을 나누고
		// .nextToken()은 존재하는 토큰을 return하므로 띄어쓰기 전의 값이 N,
		// 띄어쓰기 뒤의 값이 X가 되며, int값으로 변환을 위해 Integer.parseInt를 사용했다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		// 두 번째 입력은 String line이라고 한다
		// 빈칸 하나를 기준으로 입력받은 값을 나누고, 그 값들을 strs라는 배열로 만든다
		// \\s는 정규표현식regex를 사용한 것
		String line = br.readLine();
		String [] strs = line.split("\\s");
		
		// 첫 번째 입력에서 만든 N을 수열의 개수로 정한다
		for (int i = 0; i < N; i++) {
			int[] A = new int[N];
			// A의 원소값은 두 번째 입력에서 만든 배열 strs를 int로 변환한 것이다
			A[i]=Integer.parseInt(strs[i]);
			// A의 원소값 중 첫 번째 입력에서 만든 X보다 작은 값만 출력할 값으로 정한다
			if (A[i] < X) {
				bw.write(A[i] + " ");
			}
		}
		//출력할 값으로 정한 것을 출력한다
		bw.flush();
	}
}
