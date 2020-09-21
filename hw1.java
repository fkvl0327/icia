public class hw1 {
  public static void main(String[] args) {
	  p1();
	  p2();
	  
  }
  private static void p1() {
	  int n1 = 1024, n2 = 500;
	  System.out.println("Q1) n1 = 1024, n2 = 500");
	  add(n1, n2);
	  sub(n1, n2);
	  mul(n1, n2);
	  div(n1, n2);	
}
  private static void p2() {
	  int n1 = 100, n2 = 250;
	  System.out.println("Q2) n1 = 100, n2 = 250");
	  add(n1, n2);
	  sub(n1, n2);
	  mul(n1, n2);
	  div(n1, n2);

	
}
private static void div(int n1, int n2) {
	if (n1>=n2) {
		System.out.println("div : " + n1/n2);
		} else {
			System.out.println("div : " + n2/n1);
		}
}

private static void mul(int n1, int n2) {
	System.out.println("mul : " + n1*n2);
	
}

private static void sub(int n1, int n2) {
	if (n1>=n2) {
	System.out.println("sub : " + (n1-n2));
	} else {
		System.out.println("sub : " + (n2-n1));
	}
}

private static void add(int n1, int n2) {
	System.out.println("add : " + (n1+n2));
	
}
}