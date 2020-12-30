package auth.services.mall.icia;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.Action;
import beans.AuthBean;

public class Authentication {
	DataAccessObject dao;
	Action action;

	public Authentication(){
		dao = new DataAccessObject();
		action = new Action();
	}
	
	public Action entrance(HttpServletRequest req){
		String reqValue = req.getRequestURI().substring(req.getContextPath().length()+1);

		if(reqValue.equals("LogIn")) {
			loginCtl(req);
		}
	return action;
	
	}

	private void loginCtl(HttpServletRequest req) {
		String msg = "로그인 실패하였습니다. 다시 시도해주세요.";
		boolean actionType = false;
		String page = "login.jsp";
		boolean tran = false;
		dao.getConnection();
		dao.setAutoCommit(false);
		
		AuthBean auth = new AuthBean();
		auth.setmId(req.getParameterValues("accessInfo")[0]);
		auth.setmPassword(req.getParameterValues("accessInfo")[1]);
		
		if(isUserId(auth)) {
			if(isUserPassword(auth)) {
				if(isUserActive(auth)) {
					if(insAccessLog(auth)) {
						tran = true;
						dao.setTransaction(tran);
						if(showInfo(auth)) {
							// 접속한 유저의 정보 DB에서 받아오기
							ArrayList<AuthBean> list = dao.searchMemberInfo(auth);
							// 로그인 성공 시 출력할 값 list에서 받아오기
							req.setAttribute("mName", list.get(0).getmName());
							req.setAttribute("mId", list.get(0).getmId());
							req.setAttribute("accessTime", list.get(0).getAccessTime());							
							page = "access.jsp";
						}
					}
				}
			}
		}
		req.setAttribute("message", msg);

		action.setRedirect(actionType);
		action.setPage(page);
		
		dao.closeConnection();
		dao.setAutoCommit(true);
		
	}
	
	private boolean showInfo(AuthBean auth) {
		return utility(dao.searchMemberInfo(auth).size());
	}

	private boolean insAccessLog(AuthBean auth) {
		return utility(dao.insAccessLog(auth));
	}

	private boolean isUserActive(AuthBean auth) {
		return utility(dao.isActive(auth));
	}

	// id+pw 일치여부
	private boolean isUserPassword(AuthBean auth) {
		return utility(dao.isAccess(auth));
	}
	
	// 아이디 유무
	public boolean isUserId(AuthBean auth){
		return utility(dao.isMember(auth));
	}
	
	public boolean utility(int num) {
		return num==1? true: false;
	}
}
