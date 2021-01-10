package auth.services.mall.jade;

import java.sql.Connection;
import java.sql.DriverManager;

import beans.AuthBean;

public class DataAccessObject {
	Connection connection;
	
	public DataAccessObject() {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.getConnection("jdbc:oracle:thin:@106.243.194.230:7005:xe", "yun", "1234");
		} catch (Exception e) {
			
		}
	}
	
	public int isMember(AuthBean auth) {
		
		return 0;
	}
	
	public int isActive(AuthBean auth) {
		
		return 0;
	}
	
	public int isAccess(AuthBean auth) {
		
		return 0;
	}
	
	public int isAccessLog(AuthBean auth) {
		
		return 0;
	}
	
}
