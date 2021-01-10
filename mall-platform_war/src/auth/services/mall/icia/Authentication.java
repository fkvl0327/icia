package auth.services.mall.icia;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.Action;
import beans.AuthBean;

public class Authentication {
	private Action action;
	private DataAccessObject dao;

	public Authentication() {
		this.action = new Action();
	}

	public Action entrance(HttpServletRequest req, int serviceCode) {
		// 1:로그인 2: 로그아웃 3:회원가입
		if (serviceCode == 1) {
			this.logInCtl(req);
		} else if (serviceCode == 2) {
			this.logOutCtl(req);
		} else if (serviceCode == 3) {
			this.joinCtl(req);
		}

		return this.action;
	}

	// 로그인
	private void logInCtl(HttpServletRequest req) {
		this.dao = new DataAccessObject();
		this.dao.getConnection();
		this.dao.autoCommit(false);
		// Client Job Controller
		// 클라이언트가 전달한 데이터를 Bean에 저장
		// 클라이언트에 전달할 데이터를 request에 저장

		this.action.setRedirect(true);
		this.action.setPage("index.html");

		AuthBean authBean = new AuthBean();
		authBean.setmId(req.getParameterValues("accessInfo")[0]);
		authBean.setmPassword(req.getParameterValues("accessInfo")[1]);
		authBean.setAccessType(1);

		// 로그인 = db(AccessLog insert) + middle(Session)
		// userId check = 아이디 유무
		if (this.isUserId(authBean)) {
			// 현재 활성화 여부 확인
			if (this.isIdState(authBean)) {
				// userId + userPassword 일치여부
				if (this.isAccess(authBean)) {
					// ACCESSLOG INS
					if (this.insAccessLog(authBean)) {
						// COMMIT;
						dao.setTransaction(true);
						// 회원이름, 로그인 시간 추출
						req.setAttribute("mId", this.searchMemberInfo(authBean).get(0).getmId());
						req.setAttribute("mName", this.searchMemberInfo(authBean).get(0).getmName());
						req.setAttribute("accessTime", this.searchMemberInfo(authBean).get(0).getAccessTime());
						System.out.println(this.searchMemberInfo(authBean).size());
						// Action 설정
						action.setRedirect(false);
						action.setPage("response.jsp");
					} else {
						dao.setTransaction(false);
					}
				}
			}
		}
		this.dao.autoCommit(false);
		this.dao.closeConnection();
	}

	// 아이디 유무 확인 :: 사용자가 전달한 id필요
	private boolean isUserId(AuthBean auth) {
		return convertToBoolean(dao.isMember(auth));
	}

	// 현재 id 활성화 여부 확인 :: 사용자가 전달한 id필요
	private boolean isIdState(AuthBean auth) {
		return this.convertToBoolean(dao.isActive(auth));
	}

	// userId + userPassword 일치여부 :: 사용자가 전달한 id와 password 필요
	private boolean isAccess(AuthBean auth) {
		return convertToBoolean(dao.isAccess(auth));
	}

	// ACCESSLOG INS :: 사용자가 전달한 id필요
	private boolean insAccessLog(AuthBean auth) {
		return this.convertToBoolean(dao.insAccessLog(auth));
	}

	// Utility method
	private boolean convertToBoolean(int data) {
		return data == 1 ? true : false;
	}

	// 회원정보 추출 :: 회원아이디, 회원이름, 로그인시간
	private ArrayList<AuthBean> searchMemberInfo(AuthBean auth) {
		return dao.searchMemberInfo(auth);
	}

	// 로그아웃
	private void logOutCtl(HttpServletRequest req) {
		// Action 설정
		action.setRedirect(true);
		action.setPage("index.html");
	}

	// 회원가입
	private void joinCtl(HttpServletRequest req) {
		// Client Job Controller
		// 클라이언트가 전달한 데이터를 Bean에 저장
		// 클라이언트에 전달할 데이터를 request에 저장
		AuthBean authBean = new AuthBean();
		authBean.setmId(req.getParameterValues("joinInfo")[0]);
		authBean.setmPassword(req.getParameterValues("joinInfo")[1]);
		authBean.setmName(req.getParameterValues("joinInfo")[2]);
		authBean.setPhone(req.getParameterValues("joinInfo")[3]);
		authBean.setState("A");
		
		this.dao = new DataAccessObject();
		this.dao.getConnection();
		this.dao.autoCommit(false);

		if (this.isUserId(authBean)) { // 아이디 중복 확인, true이면 가입 불가, false이면 다음 단계로
			req.setAttribute("message", "이미 사용 중인 아이디입니다.");
			action.setRedirect(false);
			action.setPage("join.jsp");
		} else {
			if (this.joinMember(authBean)) { // 가입 완료 시 true
				dao.setTransaction(true);
				action.setRedirect(true);
				action.setPage("index.html");
			} else {
				dao.setTransaction(false);
				req.setAttribute("message", "네트워크가 불안정합니다. 다시 시도해주세요.");
				action.setRedirect(false);
				action.setPage("join.jsp");
			}
		}
		this.dao.autoCommit(true);
		this.dao.closeConnection();
	}

	private boolean joinMember(AuthBean auth) {
		return this.convertToBoolean(dao.joinMember(auth));
	}

}
