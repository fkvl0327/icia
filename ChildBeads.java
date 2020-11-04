package test;

public class ChildBeads {
	private int beads;
	
	public ChildBeads(int beads) {
		this.beads = beads;
	}
	
	public void obtainBead(ChildBeads child, int num) {
		if(child.beads<num) {
			this.beads += child.beads;
		}else {
			this.beads += num;
		}
		child.loseBead(num);
		
	}

	private int loseBead(int num) {
		if(beads < num) {
			beads = 0;
		}else {
			beads -= num;
		}
		return beads;
	}

	public void showBeadsNum() {
		System.out.println("beads="+ beads);
		
		
	}
	
	
	

}
