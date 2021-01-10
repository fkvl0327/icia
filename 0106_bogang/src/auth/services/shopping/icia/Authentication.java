package auth.services.shopping.icia;

import javax.servlet.http.HttpServletRequest;

import beans.shopping.icia.Action;
import services.shopping.icia.Service;

public class Authentication extends Service {
	DataAccessObject dao;
	
	public Authentication(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public Action entrance(HttpServletRequest req) {
		Action action = null;
		switch(this.reqValue) {
			case "LogIn":
				this.loginCtl();
				break;
			case "Join":
				this.joinCtl();
				break;
			case "LogOut":
				this.logOutCtl();
				break;
		}
		
		return action;
	}

	private Action logOutCtl() {
		Action action = new Action();
		String page = null;
		boolean actionType = false;
		dao = new DataAccessObject();
		
		dao.getConnection();
		
		dao.closeConnection();
		
		action.setPage(page);
		action.setAction(actionType);
		
		return action;
	}

	private Action joinCtl() {
		Action action = new Action();
		String page = null;
		boolean actionType = false;
		dao = new DataAccessObject();
		
		dao.getConnection();
		
		dao.closeConnection();
		
		action.setPage(page);
		action.setAction(actionType);
		
		return action;
	}

	private Action loginCtl() {
		Action action = new Action();
		String page = null;
		boolean actionType = false;
		dao = new DataAccessObject();
		
		dao.getConnection();
		
		dao.closeConnection();
		
		action.setPage(page);
		action.setAction(actionType);
		
		return action;
	}

}
