package auth.services.mall.icia;

import java.util.ArrayList;

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
		switch(reqValue) {
		case "Join":
			action = this.joinCtl(req);
			break;
		case "LogIn":
			action = this.loginCtl(req);
		}
		return action;
	}
	
	private Action loginCtl(HttpServletRequest req) {
		Action action = new Action();
		
		AuthBean auth = new AuthBean();
		auth.setmId(req.getParameterValues("accessInfo")[0]);
		auth.setmPassword(req.getParameterValues("accessInfo")[1]);
		auth.setAccessType(1);
		
		dao = new DataAccessObject();
		dao.getConnection();
		dao.setAutoCommit(false);
		
		if(this.isMember(auth)) {
			if(this.isActive(auth)) {
				if(this.isAccess(auth)) {
					if(this.insAccessLog(auth)) {
						dao.setTransaction(true);
						
						System.out.println(req.getParameterValues("accessInfo")[0]);
						System.out.println(req.getParameterValues("accessInfo")[1]);
						
						ArrayList<AuthBean> list = this.selectInfo(auth);
						req.setAttribute("memberInfo", list.get(0).getAccessTime());
						
						action.setActionType(false);
						action.setPage("index.jsp");
					}else {
						dao.setTransaction(false);
						req.setAttribute("message", "네트워크 오류가 발생하였습니다. 잠시 후 다시 시도해주세요.");
						action.setActionType(false);
						action.setPage("login.jsp");
					}
				}else {
					dao.setTransaction(false);
					req.setAttribute("message", "아이디나 비밀번호가 일치하지 않습니다. 확인 후 다시 시도해주세요.");
					action.setActionType(false);
					action.setPage("login.jsp");
				}
			}else {
				dao.setTransaction(false);
				req.setAttribute("message", "휴면계정입니다. 관리자에게 휴면해제를 요청하세요.");
				action.setActionType(false);
				action.setPage("login.jsp");
			}
		}else {
			dao.setTransaction(false);
			req.setAttribute("message", "가입되지 않은 아이디입니다. 회원가입해주세요.");
			action.setActionType(false);
			action.setPage("login.jsp");
		}

		dao.setAutoCommit(true);
		dao.closeConnection();
		
		return action;
	}

	private ArrayList<AuthBean> selectInfo(AuthBean auth) {
		return dao.searchMemberInfo(auth);
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

	private Action joinCtl(HttpServletRequest req) {
		Action action = new Action();
		
		AuthBean auth = new AuthBean();
		auth.setmId(req.getParameterValues("joinInfo")[0]);
		auth.setmPassword(req.getParameterValues("joinInfo")[1]);
		auth.setmName(req.getParameterValues("joinInfo")[2]);
		auth.setPhone(req.getParameterValues("joinInfo")[3]);
		auth.setState("A");
		
		dao = new DataAccessObject();
		dao.getConnection();
		dao.setAutoCommit(false);
		
		if(!this.isMember(auth)) {
			if(this.insMember(auth)) {
				dao.setTransaction(true);
				
				action.setActionType(true);
				action.setPage("login.jsp");
			}
		}
		
		dao.setAutoCommit(true);
		dao.closeConnection();
		
		return action;
	}
	
	private boolean isMember(AuthBean auth) {
		return this.convertToBoolean(dao.isMember(auth));
	}
	
	private boolean insMember(AuthBean auth) {
		return this.convertToBoolean(dao.joinMember(auth));
	}
	
	private boolean convertToBoolean(int value) {
		return (value==1)? true : false;
	}
}
