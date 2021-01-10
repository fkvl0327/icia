package auth.services.mall.icia;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		case "LogIn":
			action = this.logInCtl(req);
			break;
		case "Join":
			action = this.joinCtl(req);
			break;
		case "LogOut":
			action = this.logOutCtl(req);
			break;
		}
		return action;
	}
	
	private Action logOutCtl(HttpServletRequest req){
		Action action = new Action();
		boolean tran = false;
		boolean actionType = true;
		String page = "index.jsp";
		String message = null;
		
		AuthBean auth = new AuthBean();
		auth.setmId(req.getParameter("member"));
		auth.setAccessType(-1);
		
		dao = new DataAccessObject();
		
		dao.getConnection();
		dao.setAutoCommit(false);
		
		HttpSession session = req.getSession();
		if(session.getAttribute("accessInfo") != null) {
			if(session.getAttribute("accessInfo").equals(auth.getmId())) {

				if(this.insLog(auth)) {
					session.removeAttribute("accessInfo");

					tran = true;
					message = "정상적으로 로그아웃되었습니다.";
				}

			}else {message = "넌 누구니?";}
		}else {	message = "이미 로그아웃되었거나 로그인하지 않았습니다.";}
		
		dao.setTransaction(tran);
		dao.setAutoCommit(true);
		dao.closeConnection();
		
		action.setActionType(actionType);
		action.setPage(page);
		action.setMessage(message);
		
		return action;
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
	
	private Action logInCtl(HttpServletRequest req) {
		Action action = new Action();
		ArrayList<AuthBean> memberInfo = null;
		boolean tran = false;
		boolean actionType = true;
		String page = "login.jsp";
		String message = "아이디나 패스워드가 올바르지 않습니다.";
		
		System.out.println(req.getParameter("action"));
		System.out.println(req.getParameterValues("gInfo")[0]);
		System.out.println(req.getParameterValues("gInfo")[1]);
		System.out.println(req.getParameterValues("gInfo")[2]);
		System.out.println(req.getParameterValues("gInfo")[3]);
		
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
					if(this.insLog(auth)) {								
						memberInfo = this.searchMemberInfo(auth);
						
						// HttpSession저장
						HttpSession session = req.getSession();
						session.setAttribute("accessInfo", memberInfo.get(0).getmId());
						
						tran = true;
						actionType = false;
						page = "goods.jsp";
						message = "";
					} else { message = "네트워크가 불안정합니다. 다시 접속해주세요~";}
				}
			}else { message = "휴면 계정입니다. 활성화를 해주세요~";}
		}
		
		dao.setTransaction(tran);
		dao.setAutoCommit(true);
		dao.closeConnection();
		
		//훈짱(hoonzzang)님은 2020-12-31 14:00:00 로그인 하셨습니다.
		// request.setAttribute
		String mInfo = memberInfo.get(0).getmName() + "(" + 
				memberInfo.get(0).getmId() +")님은 " + memberInfo.get(0).getAccessTime() +
				" 로그인 하셨습니다.";
		req.setAttribute("memberInfo", mInfo);
		
		action.setActionType(actionType);
		action.setPage(page);
		
		return action;
	}
	
	private boolean isMember(AuthBean auth) {
		return this.convertToBoolean(dao.isMember(auth));
	}
	
	private boolean insMember(AuthBean auth) {
		return this.convertToBoolean(dao.joinMember(auth));
	}
	
	private boolean isActive(AuthBean auth) {
		return this.convertToBoolean(dao.isActive(auth));
	}
	
	private boolean isAccess(AuthBean auth) {
		return this.convertToBoolean(dao.isAccess(auth));
	}
	
	private boolean insLog(AuthBean auth) {
		return this.convertToBoolean(dao.insAccessLog(auth));
	}
	
	private ArrayList<AuthBean> searchMemberInfo(AuthBean auth){
		return dao.searchMemberInfo(auth);
	}
	
	private boolean isLogIn(AuthBean auth) {
		return this.convertToBoolean(dao.isLogIn(auth));
	} 
	
	private boolean convertToBoolean(int value) {
		return (value==1)? true : false;
	}
}
