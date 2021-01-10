package auth.services.mall.icia;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Action;
import beans.AuthBean;

public class Authentication {
	private DataAccessObject dao;

	public Authentication() {
	}

	public Action entrance(HttpServletRequest req) {
		Action action = null;
		String reqValue = req.getRequestURI().substring(req.getContextPath().length() + 1);
		switch (reqValue) {
		case "Join":
			action = this.joinCtl(req);
			break;
		case "LogIn":
			action = this.loginCtl(req);
			break;
		case "LogOut":
			action = this.logoutCtl(req);
			break;
		}
		return action;
	}

	private Action logoutCtl(HttpServletRequest req) {
		Action action = new Action();
		boolean tran = false;
		boolean actionType = true;
		String page = "index.jsp";
		String msg = "이미 로그아웃되었거나 로그인하지 않았습니다.";
		
		System.out.println(req.getParameter("gInfo"));

		AuthBean auth = new AuthBean();
		auth.setmId(req.getParameter("member"));
		auth.setAccessType(-1);

		dao = new DataAccessObject();
		dao.getConnection();
		dao.setAutoCommit(false);

		HttpSession session = req.getSession();
		if (session.getAttribute("accessInfo") != null) {
			if (session.getAttribute("accessInfo").equals(auth.getmId())) {
				if (!isLogout(auth)) {
					if (insAccessLog(auth)) {
						tran = true;
						msg = "정상적으로 로그아웃되었습니다.";
						session.removeAttribute("accessInfo");
					} else {
						msg = "네트워크가 불안정합니다. 다시 시도해주세요.";
					}
				}
			}else {msg = "넌 누구니?";}
		}

		dao.setTransaction(tran);
		dao.setAutoCommit(true);
		dao.closeConnection();

		action.setActionType(actionType);
		action.setPage(page);
		action.setMsg(msg);

		return action;
	}

	private boolean isLogout(AuthBean auth) {
		return (dao.isLogout(auth) == 0) ? true : false;
	}

	private Action loginCtl(HttpServletRequest req) {		
		Action action = new Action();
		ArrayList<AuthBean> list = null;
		boolean tran = false;
		boolean actionType = false; // 로그인 성공이든 실패든 사용자에게 문구를 보여주고자 하므로
		// req에 값을 저장 후 dispatcher방식으로 페이지를 이동해야 한다
		String page = "login.jsp";
		String msg = "아이디나 패스워드가 올바르지 않습니다.";
		String mInfo = "";
		
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

		if (this.isMember(auth)) {
			if (this.isActive(auth)) {
				if (this.isAccess(auth)) {
					if (this.insAccessLog(auth)) {
						list = this.searchMemberInfo(auth);
						tran = true;
						page = "goods.jsp";
						msg = "로그인 성공";
						mInfo = list.get(0).getmId() + "(" + list.get(0).getmName() + ")님은 "
								+ list.get(0).getAccessTime() + "에 로그인하셨습니다.";

						HttpSession session = req.getSession();
						session.setAttribute("accessInfo", list.get(0).getmId());
						
					} else {
						msg = "네트워크가 불안정합니다. 다시 시도해주세요.";
					}
				}
			} else {
				msg = "휴면계정입니다. 관리자에게 휴면해제를 요청하세요.";
			}
		}
		dao.setTransaction(tran);
		dao.setAutoCommit(true);
		dao.closeConnection();

		req.setAttribute("memberInfo", mInfo);
		req.setAttribute("message", msg);

		action.setActionType(actionType);
		action.setPage(page);

		return action;
	}

	private ArrayList<AuthBean> searchMemberInfo(AuthBean auth) {
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

		if (!this.isMember(auth)) {
			if (this.insMember(auth)) {
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
		return (value == 1) ? true : false;
	}
}
