package wBaekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i < N + 1; i++) {
			for (int k = 0; k < N-i; k++) {
				bw.write(" ");
			}
			for (int j = 0; j < i; j++)	{
				bw.write("*");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
