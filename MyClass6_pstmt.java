import java.sql.*;//1) sql import 선언

public class MyClass6_pstmt {
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
		Class.forName(driverClass);//2) jdbc 드라이버 로딩
	} catch (ClassNotFoundException e4) {
		// TODO Auto-generated catch block
		e4.printStackTrace();
	}
	Connection conn = null;//3) Connection 생성
	try {
		conn = DriverManager.getConnection(dbURL, id, pw);
	} catch (SQLException e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}
	PreparedStatement pstmt = null;//4)Statement 생성
	
	String sql = "SELECT * from student;";//5)sql 문장 작성
	try {
		pstmt = conn.prepareStatement(sql);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}//pstmt는 sql 다음에 작성
	ResultSet rs = null;//6)ResultSet 생성
		try {
			rs = pstmt.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	try {
		while(rs.next()) {//7)데이터처리 완료 - 로컬변수에 값을 복사해오고 출력
			String addr = rs.getString(1);
			System.out.println(addr);
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
}
