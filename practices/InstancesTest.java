package practices;

public class InstancesTest {

	public static void main(String[] args) {
		Data d = createInstance();
		System.out.println("main(): x=" + d.getX());
		System.out.println("main(): x=" + d.getY());
	}

	private static Data createInstance() {
		Data d = new Data();
		d.setX(100);
		d.setY(200);
		System.out.println("createInts(): x=" + d.getX());
		System.out.println("createInts(): x=" + d.getY());
		return d;
	}

}

class Data {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
