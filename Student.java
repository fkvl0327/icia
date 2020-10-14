package classLesson;

public class Student extends Person {
	String school = "";
	int sn = 0;

	public int graduationYear = 2018;
	
	@Override // 안 적어도 구현은 됨
	public void study() { // the body of the abstract method is provided here
		System.out.println("Studying all day long");
	}
	//abstract method를 적은 person에서는 함수 내용을 적을 수 없고, 상속받은 클래스에서 만들 수 있음
	
	//person을 만드는 개발자와 student를 만드는 개발자가 같은 사람이 아니라면
	//abstract method를 person을 만드는 개발자가 기재해두면
	
	//student를 만드는 개발자가 abstract method를 구현해야 한다는 것을 알 수 있다

	public String getSchool() {
		return school;
	}

	public int getSn() {
		return sn;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public Student(String ssn, String name) {
		super(ssn, name);
	}

	public Student(String ssn, String name, String school, int sn) {
		super(ssn, name);
		this.school = school;
		this.sn = sn;
	}


	@Override
	public String toString() {
		return "Student [school=" + school + ", sn=" + sn + ", nation=" + nation + ", ssn=" + ssn + ", name=" + name
				+ "]";
	}

}
