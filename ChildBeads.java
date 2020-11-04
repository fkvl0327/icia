package test;

public class ChildBeads {
	private int beads;

	public ChildBeads(int beads) {
		this.beads = beads;
	}

	public void obtainBead(ChildBeads child, int beads) {
		if (child.beads < beads) {
			this.beads += child.beads;
			child.beads = 0;
		} else {
			this.beads += beads;
			child.beads -= beads;
		}

	}

	public void showBeadsNum() {
		System.out.println("beads=" + beads);

	}

}
