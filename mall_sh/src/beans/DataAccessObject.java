package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessObject {
	protected Connection connection;
	protected Statement statement;
	protected PreparedStatement pstatement;
	protected ResultSet rs;

	
	public DataAccessObject() {
		
	}
	
	// 오라클 연결 :: Connection 개체 생성
	public void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@106.243.194.230:7004:xe", "fox", "1234");
		} catch (Exception e) {

		}
	}

	//자동 커밋
	public void setAutoCommit(boolean isAuto) {
		try {
			this.connection.setAutoCommit(isAuto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Transaction 처리 :: COMMIT || ROLLBACK
	public void setTransaction(boolean isCommit) {
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
	public void closeConnection() {
		try {
			if (!this.connection.isClosed()) {
				this.connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
