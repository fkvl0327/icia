package selfstudy;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = b/100;
		int y = (b-(x*100))/10;
		int z = (b-(x*100)-(y*10));
		
		int c = a*z;
		int d = a*y;
		int e = a*x;
		int f = c + d*10 + e*100;
		
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		
		sc.close();
		
	}

}
