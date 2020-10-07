import java.sql.*;//1) sql import 선언

public class MyClass6 {
//10월7일. JDBC 연결
//참조: https://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm
	static final String driverClass = "org.mariadb.jdbc.Driver";//2) jdbc 드라이버 로딩
	static final String dbURL = "jdbc:mariadb://localhost:3306/univ";
	static final String id = "dev";
	static final String pw = "devpass";
	
	public static void main(String[] args) {
		//mariadbConnectionTest();
		statementSelectTest();
	}


private static void statementSelectTest() {
	try {
		Class.forName(driverClass);
	} catch (ClassNotFoundException e4) {
		// TODO Auto-generated catch block
		e4.printStackTrace();
	}//2) jdbc 드라이버 로딩
	Connection conn = null;//3) Connection 생성
	try {
		conn = DriverManager.getConnection(dbURL, id, pw);
	} catch (SQLException e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}
	Statement stmt = null;//4)Statement 생성
	try {
		stmt = conn.createStatement();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	String sql = "SELECT NAME, dept, hakbun, addr, YEAR FROM student ORDER BY YEAR DESC";//5)sql 문장 작성
	ResultSet rs = null;//6)ResultSet 생성
	try {
		rs = stmt.executeQuery(sql);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
	try {
		while(rs.next()) {//7)데이터처리 완료 - 로컬변수에 값을 복사해오고 출력
			int hakbun = rs.getInt("hakbun");
			System.out.println("hakbun: " + hakbun);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//8)연결종료
	}


private static void mariadbConnectionTest() {
	try {
		Class.forName(driverClass);//2) jdbc 드라이버 로딩
		//Class.for까지만 써도 정해진 forName 함수를 보여준다
		System.out.println("mariadb driverClass Loading Succeeded!");
	} catch (ClassNotFoundException e) {
		System.out.println("mariadb driverClass Loading Fail!");
		e.printStackTrace();
	}
	
	Connection conn = null;//3) Connection 생성
	
	try {
		conn = DriverManager.getConnection(dbURL, id, pw);
		//DriverManager.get까지만 써도 쓸 내용을 보여준다(순서대로 입력해야 함)
		System.out.println("mariadb 서버 connection 성공!");
	} catch (SQLException e) {
		System.out.println("mariadb 서버 connection 실패!");
		e.printStackTrace();
	} finally {
		if(conn !=null) {
			try {
				conn.close();
				System.out.println("mariadb 서버 connection 성공!");
			} catch (SQLException e) {
				System.out.println("mariadb 서버 connection 성공!");
				e.printStackTrace();
			}
		}
	}
}

}
