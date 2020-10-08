
//1) sql import 선언
import java.sql.*;
import java.util.Scanner;

public class api_sample {
//10월7일. JDBC 연결 1. select
//10월8일. JDBC 연결 2. insert
//참조: https://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm
	static final String driverClass = "org.mariadb.jdbc.Driver";
	static final String dbURL = "jdbc:mariadb://localhost:3306/univ2";
	static final String id = "dev";
	static final String pw = "devpass";

	public static void main(String[] args) {
		//mariadbConnectionTest();

		// pstmtTest();
		// increTest();

		// manyTest(); // sql 여러 개를 실행할 수 있습니다

		dbM(args);

	}

	private static void dbM(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		String s1 = null;
		System.out.print("DML은 1번, DDL은 2번을 선택해주세요>");
		System.out.println();
		System.out.println();
		
		do {System.out.println("MyClass6 DML\r\n" + "#====================================\r\n" + "database: DML\r\n"
					+ "menu: 1. table 전체조회 2. table 내용삭제\r\n" + "      3. table 항목입력\r\n"
					+ "#=====================================\r\n" + "\r\n" + "> MyClass6 DDL	\r\n"
					+ "#====================================\r\n" + "database: DDL\r\n"
					+ "menu: 1. database 생성 2. database 삭제\r\n" + "      3. table 생성    4. table 삭제\r\n"
					+ "#=====================================");
		int n1 = sc.nextInt();
		if (n1==1) {
			showTables();
		}if (n1==2) {
			deleteTest();
		}if(n1==3) {
			increTest();
		}
		System.out.println("종료하려면 q를 입력하세요");
		System.out.println("계속하려면 아무 숫자나 입력하세요");
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("> ");
		s1 = sc2.next();
	}while(!s1.equals("q"));
		System.out.println("프로그램을 종료합니다.");
	}
	private static void showTables() {
		// 2) jdbc 드라이버 로딩
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e4) {
			e4.printStackTrace();
		}
		// 3) Connection 생성
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, id, pw);
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		// 4)Statement 생성
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		// 5)sql 문장 작성
		String sql = "show tables from univ2;";
		// 6)ResultSet 생성
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 7)데이터처리 완료 - 로컬변수에 값을 복사해오고 출력
		try {
			while (rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 8)연결종료
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void dropTest() {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, id, pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement moonjang = null;
		try {
			moonjang = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "DROP TABLE baksa;";
		ResultSet rs = null;
		try {
			moonjang.executeUpdate(sql);
			System.out.println("박사가 사라졌습니다☆");
		} catch (SQLException e) {
			System.out.println("sql failed");
			e.printStackTrace();
		}

	}

	private static void manyTest() {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, id, pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement moonjang = null;
		try {
			moonjang = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql1 = "INSERT INTO staff VALUES(null, 'iu', 1993, 'pr', 'pusan');";
		String sql2 = "INSERT INTO staff VALUES(null, 'mbti', 1993, 'pr', 'pusan');";
		ResultSet rs = null;
		try {
			moonjang.executeUpdate(sql1);
			System.out.println("아이유♬");
		} catch (SQLException e) {
			System.out.println("sql1 failed");
			e.printStackTrace();
		}
		try {
			moonjang.executeUpdate(sql2);
			System.out.println("MBTI 노잼");
		} catch (SQLException e) {
			System.out.println("sql2 failed");
			e.printStackTrace();
		}

	}

	private static void deleteTest() {
		// 2) jdbc 드라이버 로딩
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e4) {
			e4.printStackTrace();
		}
		// 3) Connection 생성
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, id, pw);
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		// 4)Statement 생성
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 5)sql 문장 작성
		String sql = "DELETE FROM student;";
		// 6)ResultSet 생성
		ResultSet rs = null;
		// 7)데이터처리 완료 - 로컬변수에 값을 복사해오고 출력
		try {
			stmt.executeUpdate(sql);
			System.out.println("테이블 삭제 성공!");
		} catch (SQLException e) {
			System.out.println("실패 ㅠㅠ");
			e.printStackTrace();
		}
		// 8)연결종료
		// 아래 세 코드는 안 적은 것과 같습니다 //
		// 실제로 아래 close는 동작하지 않는 dead code입니다 //
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			}

	}

	private static void createTest() {
		// 2) jdbc 드라이버 로딩
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e4) {
			e4.printStackTrace();
		}
		// 3) Connection 생성
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, id, pw);
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		// 4)Statement 생성
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 5)sql 문장 작성
		String sql = "create TABLE staff (\r\n" + "sawonbunho int not NULL AUTO_INCREMENT, \r\n"
				+ "name VARCHAR(20), \r\n" + "year int, \r\n" + "dept varchar(10),\r\n" + "addr varchar(50),\r\n"
				+ "primary key(sawonbunho) \r\n" + "); ";
		// 6)ResultSet 생성
		ResultSet rs = null;
		// 7)데이터처리 완료 - 로컬변수에 값을 복사해오고 출력
		try {
			stmt.executeUpdate(sql);
			System.out.println("테이블 추가 성공!");
		} catch (SQLException e) {
			System.out.println("실패 ㅠㅠ");
			e.printStackTrace();
		}
		// 8)연결종료
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			}

	}

	private static void increTest() {
		// 2) jdbc 드라이버 로딩
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e4) {
			e4.printStackTrace();
		}
		// 3) Connection 생성
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, id, pw);
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		// 4)Statement 생성
		PreparedStatement pstmt = null;
		// 5)sql 문장 작성
		String sql = "insert into student(name, year, dept, addr) values(?, ?, ?, ?)";
		String name = "jinju";
		int year = 1980;
		String dept = "ruby";
		String addr = "guro";

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("table 항목을 입력하세요.");
		System.out.print("이름: ");
		name = sc.next();
		System.out.print("출생년도: ");
		year = sc2.nextInt();
		System.out.print("학과: ");
		dept = sc.next();
		System.out.print("주소지: ");
		addr = sc.next();
		System.out.print("입력이 완료되었습니다.");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, year);
			pstmt.setString(3, dept);
			pstmt.setString(4, addr);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 6)ResultSet 생성
		ResultSet rs = null;
		// 7)데이터처리 완료 - 로컬변수에 값을 복사해오고 출력
		try {
			// pstmt는 완성하지 않은 문장을 사용하므로 빈칸 사용
			pstmt.executeUpdate();
			System.out.println("행 추가 성공!");
		} catch (SQLException e1) {
			System.out.println("실패ㅠㅠ");
			e1.printStackTrace();
		}
		// 8)연결종료
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			} // dead code(사용 안 되고 있다고 나오는 거)
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			}

	}

	private static void pstmtTest() {
		// 2) jdbc 드라이버 로딩
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e4) {
			e4.printStackTrace();
		}
		// 3) Connection 생성
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, id, pw);
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		// 4)Statement 생성
		PreparedStatement pstmt = null;
		// 5)sql 문장 작성
		String sql = "insert into student values(?, ?, ?, ?, ?)";
		// String sql = "insert into student(?,?,?,?) values(?,?,?,?)";
		// 값을 몇 개만 넣을 수는 없을까?
		int hakbun = 7676;// primary key가 중복되면 안 되니까 재실행할 때는 없애주세요
		String name = "gorgo";
		int year = 1980;
		String dept = "ruby";
		String addr = "iksan";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hakbun);
			pstmt.setString(2, name);
			pstmt.setInt(3, year);
			pstmt.setString(4, dept);
			pstmt.setString(5, addr);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 6)ResultSet 생성
		ResultSet rs = null;
		// 7)데이터처리 완료 - 로컬변수에 값을 복사해오고 출력
		try {
			// pstmt는 완성하지 않은 문장을 사용하므로 빈칸 사용
			pstmt.executeUpdate();
			System.out.println("행 추가 성공!");
		} catch (SQLException e1) {
			System.out.println("실패ㅠㅠ");
			e1.printStackTrace();
		}
		// 8)연결종료
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			} // dead code(사용 안 되고 있다고 나오는 거)
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			}

	}

	private static void insertTest() {
		// 2) jdbc 드라이버 로딩
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e4) {
			e4.printStackTrace();
		}
		// 3) Connection 생성
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, id, pw);
		} catch (SQLException e3) {
			e3.printStackTrace();
		} // 외부에서 클래스를 가져오기 때문에 오류가 없는지 확인하기 위해 try-catch를 사용합니다

		// 4)Statement 생성
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		// 5)sql 문장 작성
		String sql = "insert into student values(3333, \"name1\", 1993, \"java\", \"incheon1\")";

		// 6)ResultSet 생성
		ResultSet rs = null;
		try {
			stmt.executeUpdate(sql);
			System.out.println("행 추가 성공!");
		} catch (SQLException e1) {
			System.out.println("실패ㅠㅠ");
			e1.printStackTrace();
		}
		// 7)데이터처리 완료 - 로컬변수에 값을 복사해오고 출력

		// 8)연결종료
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			} // dead code(사용 안 되고 있다고 나오는 거)
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			}
		// select와 다르게 insert는 return값이 없기 때문에
		// rs에 int 타입으로 바꾸라고 계속 나옴
		// rs타입에 대해 null값 여부를 체크하는 코드를 넣어둠으로써 정상 실행 가능
		// 단, 위 세 줄(if~) 없어도 insert는 정상 실행함
	}

	private static void selectTest() {
		// 2) jdbc 드라이버 로딩
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e4) {
			e4.printStackTrace();
		}
		// 3) Connection 생성
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, id, pw);
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		// 4)Statement 생성
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		// 5)sql 문장 작성
		String sql = "SELECT * from student";
		// 6)ResultSet 생성
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 7)데이터처리 완료 - 로컬변수에 값을 복사해오고 출력
		try {
			while (rs.next()) {
				int hakbun = rs.getInt("hakbun");
				System.out.println("hakbun: " + hakbun);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 8)연결종료
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void mariadbConnectionTest() {
		try {
			Class.forName(driverClass);// 2) jdbc 드라이버 로딩
			// Class.for까지만 써도 정해진 forName 함수를 보여준다
			System.out.println("mariadb driverClass Loading Succeeded!");
		} catch (ClassNotFoundException e) {
			System.out.println("mariadb driverClass Loading Fail!");
			e.printStackTrace();
		}

		Connection conn = null;// 3) Connection 생성

		try {
			conn = DriverManager.getConnection(dbURL, id, pw);
			// DriverManager.get까지만 써도 쓸 내용을 보여준다(순서대로 입력해야 함)
			System.out.println("mariadb 서버 connection 성공!");
		} catch (SQLException e) {
			System.out.println("mariadb 서버 connection 실패!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("mariadb 서버 connection 성공!");
				} catch (SQLException e) {
					System.out.println("mariadb 서버 connection 성공!");
					e.printStackTrace();
				}
			}
		} System.out.println("mariadb 서버 connection 프로그램을 종료합니다.");
	}

}
