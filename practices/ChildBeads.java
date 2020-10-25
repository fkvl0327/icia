package practices;

public class ChildBeads {
	int beads;

	public ChildBeads(int beads) {
		this.beads = beads;
	}

	public void showBeads() {
		System.out.println(beads + "개 ");
	}

	public void obtainBead(ChildBeads child, int num) {
		System.out.println("----------");
		
		int restAmount = child.loseBead(num);
		if(restAmount<0) {
			beads+= num+restAmount;
			child.beads = 0;
		}else {
			beads= beads+num;
		}
		
	}

	private int loseBead(int num) {
		beads-= num;
		return beads;
	}
}