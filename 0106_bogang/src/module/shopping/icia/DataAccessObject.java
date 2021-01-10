package module.shopping.icia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessObject {
	// field값은 final로 선언하지 않는다
	protected Connection connection;
	protected PreparedStatement pstatement;
	protected Statement statement;
	protected ResultSet rs;
	protected int count;
	
	public DataAccessObject() {

	}

	// 오라클 연결 :: Connection 개체 생성
	public final void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@106.243.194.230:7005:xe", "HONG", "1234");
		} catch (Exception e) {

		}
	}

	public final void setAutoCommit(boolean isAuto) {
		try {
			this.connection.setAutoCommit(isAuto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Transaction 처리 :: COMMIT || ROLLBACK
	public final void setTransaction(boolean isCommit) {
		try {
			if (isCommit) {
				this.connection.commit();
			} else {
				this.connection.rollback();
			}
		} catch (Exception e) {
		}
	}

	// 오라클 연결 해제 :: Connection.close()
	public final void closeConnection() {
		try {
			if (!this.connection.isClosed()) {
				this.connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

