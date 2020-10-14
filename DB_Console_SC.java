import java.sql.*;
import java.util.Scanner;

//이클립스 실행, Scanner를 사용하는 버전
public class DB_Console_SC {

	static final String driverClass = "org.mariadb.jdbc.Driver";
	static final String dbURL = "jdbc:mariadb://localhost:3306/univ2";
	static final String id = "dev";
	static final String pw = "devpass";

	public static void main(String[] args) {

		System.out.println("DML(조작어)? DDL(정의어)?");

		Scanner sc = new Scanner(System.in);
		System.out.print("선택>");
		String option = sc.next();
		if (option.equals("DML")) {
			do {
				System.out.println("DML을 실행합니다.");
				dml();
				Scanner sc2 = new Scanner(System.in);
				int sel = sc2.nextInt();
				if (sel == 1) {
					System.out.println("1. table 전체조회");
					selectTable();
				} else if (sel == 2) {
					System.out.println("2. table 내용삭제");
					deleteTable();
				} else if (sel == 3) {
					System.out.println("3. table 항목입력");
					insertTable();
				} else if (sel == 9) {
					System.out.println("메뉴를 종료합니다.");
					break;// break 없으면 다시 '실행합니다' 문구로 돌아감
				} else {
					System.out.println("해당메뉴가 없습니다 메뉴를 다시 확인하세요");
				}
			} while (true);
		} else if (option.equals("DDL")) {
			do {
				System.out.println("DDL을 실행합니다.");
				ddl();
				Scanner sc2 = new Scanner(System.in);
				int sel = sc2.nextInt();
				if (sel == 1) {
					System.out.println("1. database 생성");
					createDB();
				} else if (sel == 2) {
					System.out.println("2. database 삭제");
					deleteDB();
				} else if (sel == 3) {
					System.out.println("3. table 생성");
					createTable();
				} else if (sel == 4) {
					System.out.println("4. table 삭제");
					dropTable();
				} else if (sel == 9) {
					System.out.println("메뉴를 종료합니다.");
					break;
				} else {
					System.out.println("해당메뉴가 없습니다 메뉴를 다시 확인하세요");
				}
			} while (true);
		} else {
			System.out.println("입력을 확인하시고 다시 실행해주세요.");
		}

	}

	private static void ddl() {
		System.out.println("1. database 생성 | 2. database 삭제");
		System.out.println("3. table 생성    | 4. table 삭제   | 9. 종료");

	}

	private static void dml() {
		System.out.println("1. table 전체조회 | 2. table 내용삭제 | 3. table 항목입력 | 9. 종료");

	}

	private static void dropTable() {
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
		String sql = "drop table student";

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

	}

	private static void createTable() {
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

	}

	private static void deleteDB() {
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
		String sql = "delete database school";

		// 6)ResultSet 생성
		ResultSet rs = null;
		// 7)데이터처리 완료 - 로컬변수에 값을 복사해오고 출력
		try {
			stmt.executeUpdate(sql);
			System.out.println("DB 삭제 성공!");
		} catch (SQLException e) {
			System.out.println("실패 ㅠㅠ");
			e.printStackTrace();
		}

	}

	private static void createDB() {
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
		String sql = "create database school";

		// 6)ResultSet 생성
		ResultSet rs = null;
		// 7)데이터처리 완료 - 로컬변수에 값을 복사해오고 출력
		try {
			stmt.executeUpdate(sql);
			System.out.println("DB 추가 성공!");
		} catch (SQLException e) {
			System.out.println("실패 ㅠㅠ");
			e.printStackTrace();
		}

	}

	private static void insertTable() {
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
		String sql = "insert into student(?,?,?,?) values(?,?,?,?)";
		String name = "gorgo";
		int year = 1980;
		String dept = "ruby";
		String addr = "iksan";
		
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

	}

	private static void deleteTable() {
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

	}

	private static void selectTable() {
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
				String name = rs.getString("name");
				int year = rs.getInt("year");
				String dept = rs.getString("dept");
				String addr = rs.getString("addr");
				System.out.println("hakbun: " + hakbun);
				System.out.println("name " + name);
				System.out.println("year: " + year);
				System.out.println("dept: " + dept);
				System.out.println("addr: " + addr);
				System.out.println("--------------");
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

}
