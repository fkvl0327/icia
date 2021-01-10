package auth.services.mall.icia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.AuthBean;

/* Database 연동
 * 1. Oracle Driver loading >> Class.forName("oracle.jdbc.driver.OracleDriver");
 * 2. Connection >> DriverManager.getConnection(Oracle Url, Oracle User, password);
 *    - Oracle Url >> "jdbc:oracle:thin:@106.243.194.230:7007:xe"
 * 3. Statement --> 많은 레코드를 추출(where 절이 없는 경우 유용) 
 * 	  PreparedStatement --> Where절이 있는 경우 유용
 * 4. execute --> query -->  ResultSet  --> Record단위로 Bean에 저장  --> ArrayList
 * 	  executeUpdate --> DML  --> 적용된 레코드 수를 int로 리턴
 * 5. Transcation
 * 6. Connection.close()
 * */
public class DataAccessObject extends beans.DataAccessObject{

	 DataAccessObject() {

	}

	

	// 아이디 유무 확인 + 아이디 중복 체크
	 int isMember(AuthBean auth) {
		this.pstatement = null;
		this.rs = null;
		int count = 0;

		String query = "SELECT COUNT(*) AS CNT FROM MM WHERE MM_ID = ?";
		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, auth.getmId());

			this.rs = this.pstatement.executeQuery();
			while (rs.next()) {
				count = rs.getInt("CNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	// 현재 id 활성화 여부 확인
	 int isActive(AuthBean auth) {
		this.pstatement = null;
		this.rs = null;
		int count = 0;
		String query = "SELECT COUNT(*) AS CNT FROM MM WHERE MM_ID = ? AND MM_STATE = ?";

		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, auth.getmId());
			this.pstatement.setNString(2, "A");

			this.rs = this.pstatement.executeQuery();
			while (rs.next()) {
				count = rs.getInt("CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	// userId + userPassword 일치여부
	 int isAccess(AuthBean auth) {
		this.pstatement = null;
		this.rs = null;
		int count = 0;
		String query = "SELECT COUNT(*) AS CNT FROM MM WHERE MM_ID = ? AND MM_PASSWORD = ?";

		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, auth.getmId());
			this.pstatement.setNString(2, auth.getmPassword());

			this.rs = this.pstatement.executeQuery();
			while (rs.next()) {
				count = rs.getInt("CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	// ACCESSLOG INS (1)
	 int insAccessLog(AuthBean auth) {
		this.pstatement = null;
		int count = 0;

		String dml = "INSERT INTO AL(AL_ID, AL_TIME, AL_TYPE) VALUES(?, DEFAULT, 1)";

		try {
			this.pstatement = this.connection.prepareStatement(dml);
			this.pstatement.setNString(1, auth.getmId());
			// this.pstatement.setInt(2, auth.getAccessType());

			count = this.pstatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	// ACCESSLOG INS (-1)
	 int insAccessLogOut(AuthBean auth) {
		this.pstatement = null;
		int count = 0;

		String dml = "INSERT INTO AL(AL_ID, AL_TIME, AL_TYPE) VALUES(?, DEFAULT, -1)";

		try {
			this.pstatement = this.connection.prepareStatement(dml);
			this.pstatement.setNString(1, auth.getmId());
			// this.pstatement.setInt(2, auth.getAccessType());

			count = this.pstatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	// 회원정보 추출 :: 회원아이디, 회원이름, 로그인시간
	 ArrayList<AuthBean> searchMemberInfo(AuthBean auth) {
		ArrayList<AuthBean> memberList = new ArrayList<AuthBean>();

		this.pstatement = null;
		this.rs = null;
		String query = "SELECT * FROM MINFO WHERE MID = ? AND ALTYPE = 1";

		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, auth.getmId());
			// this.pstatement.setInt(2, auth.getAccessType());

			this.rs = this.pstatement.executeQuery();
			while (rs.next()) {
				AuthBean ab = new AuthBean();
				ab.setmId(rs.getNString("MID"));
				ab.setmName(rs.getNString("MNAME"));
				ab.setAccessTime(rs.getNString("ALTIME"));

				memberList.add(ab);
			}
		} catch (SQLException e) {
		}

		return memberList;
	}

	 int joinMember(AuthBean auth) {
		this.pstatement = null;
		int count = 0;

		String dml = "INSERT INTO MM(MM_ID, MM_PASSWORD, MM_NAME, MM_PHONE, MM_STATE) VALUES(?, ?, ?, ? , 'A')";

		try {
			this.pstatement = this.connection.prepareStatement(dml);
			this.pstatement.setNString(1, auth.getmId());
			this.pstatement.setNString(2, auth.getmPassword());
			this.pstatement.setNString(3, auth.getmName());
			this.pstatement.setNString(4, auth.getPhone());

			count = this.pstatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	 int AccessCheck(AuthBean auth) {
		this.pstatement = null;
		this.rs = null;
		int count = 0;
		int bnum = 0;

		String query = "select sum(al_type) AS SUM from al where al_id =? ";

		try {
			this.pstatement = this.connection.prepareStatement(query);

			this.pstatement.setNString(1, auth.getmId());

			this.rs = this.pstatement.executeQuery();

			while (rs.next()) {
				count = rs.getInt("SUM");
			}

			System.out.println(count);

			if (count != 0) {
				bnum = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bnum;

	}

	 void modAccessLogOut(AuthBean auth) {
		this.pstatement = null;
		this.rs = null;

		String query = "select sum(al_type) AS SUM from al where al_id =? ";

		try {
			this.pstatement = this.connection.prepareStatement(query);

			this.pstatement.setNString(1, auth.getmId());

			this.rs = this.pstatement.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
