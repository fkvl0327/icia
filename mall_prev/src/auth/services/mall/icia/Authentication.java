package auth.services.mall.icia;

import javax.servlet.http.HttpServletRequest;

import beans.Action;
import beans.AuthBean;

public class Authentication {
	private DataAccessObject dao;
	
	public Authentication() {}
	
	public Action entrance(HttpServletRequest req) {
		Action action = null;
		String reqValue = 
				req.getRequestURI().substring(req.getContextPath().length() + 1);
		if(reqValue.equals("LogIn")) {
			this.loginCtl(req);
		}else if(reqValue.equals("Join")) {
			this.joinCtl(req);
		}
		return action;
	}

	private Action joinCtl(HttpServletRequest req) {
		Action action = new Action();
		dao = new DataAccessObject();
		
		dao.getConnection();
		dao.setAutoCommit(false);
		
		AuthBean auth = new AuthBean();
		auth.setmId(req.getParameterValues("joinInfo")[0]);
		auth.setmPassword(req.getParameterValues("joinInfo")[1]);
		auth.setmName(req.getParameterValues("joinInfo")[2]);
		auth.setPhone(req.getParameterValues("joinInfo")[3]);
		auth.setState("A");
		
		String msg = "회원가입에 실패하였습니다. 다시 시도해주세요.";
		if(!this.isMember(auth)) {
			if(this.insMember(auth)) {
				dao.setTransaction(true);
				action.setActionType(true);
				action.setPage("login.jsp");
			}
		} req.setAttribute("message", msg);

		dao.setAutoCommit(true);
		dao.closeConnection();
		
		return action;
	}

	private boolean insMember(AuthBean auth) {
		return this.convertToBoolean(dao.joinMember(auth));
	}
	
	private boolean isMember(AuthBean auth) {
		return this.convertToBoolean(dao.isMember(auth));
	}

	private void loginCtl(HttpServletRequest req) {
		dao.getConnection();
		dao.setAutoCommit(false);
		
		AuthBean auth = new AuthBean();
		auth.setmId(req.getParameterValues("accessInfo")[0]);
		auth.setmPassword(req.getParameterValues("accessInfo")[1]);
		auth.setAccessType(1);
		
		String msg = "로그인에 실패하였습니다. 다시 시도해주세요.";
		boolean actionType = false;
		boolean tran = false;
		String page = "login.jsp";
		
		if(this.isMember(auth)) {
			if(this.isActive(auth)) {
				if(this.isAccess(auth)) {
					if(this.insAccessLog(auth)) {
						tran = true;
						dao.setTransaction(tran);
						req.setAttribute("memberInfo", dao.searchMemberInfo(auth).get(0).getAccessTime());
						System.out.println(dao.searchMemberInfo(auth).size());
						page = "index.jsp";
					}else {
						dao.setTransaction(tran);
					}
				}
			}
		} req.setAttribute("message", msg);
		
		action.setActionType(actionType);
		action.setPage(page);
		dao.setAutoCommit(true);
		dao.closeConnection();
		
	}

	private boolean insAccessLog(AuthBean auth) {
		return this.convertToBoolean(dao.insAccessLog(auth));
	}

	private boolean isAccess(AuthBean auth) {
		return this.convertToBoolean(dao.isAccess(auth));
	}

	private boolean isActive(AuthBean auth) {
		return this.convertToBoolean(dao.isActive(auth));
	}
	
	private boolean convertToBoolean(int num) {
		return num==1? true: false;
	}

}
