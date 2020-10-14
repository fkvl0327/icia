package classLesson;

public abstract class Person {// 대한민국 국민
	final String nation = "Korea";// 국적
	String ssn = ""; // 주민번호
	String name;// 이름

	public String fname = "John";
	public int age = 24;
	public abstract void study();//abstract method

	public String getNation() {
		return nation;
	}

	public String getSsn() {
		return ssn;
	}

	public String getName() {
		return name;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [nation=" + nation + ", ssn=" + ssn + ", name=" + name + "]";
	}

}
