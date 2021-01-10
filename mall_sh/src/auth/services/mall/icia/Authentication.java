package auth.services.mall.icia;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import beans.Action;
import beans.AuthBean;

public class Authentication {
	private Action action;
	private AuthBean auth;
	private DataAccessObject dao;

	public Authentication() {

//		dao = new DataAccessObject();
	}

	public Action entrance(HttpServletRequest req, String reqV) {

		if (reqV.equals("Join")) {
			joinCtl(req);
		} else if (reqV.equals("LogIn")) {
			loginCtl(req);
		} else if (reqV.equals("LogOut")) {
			logoutCtl(req);
		}

		return action;
	}

	private void logoutCtl(HttpServletRequest req) {
		String page = "index.jsp";
		boolean tran = false; // 일단 false = 자동 커밋 안해주겠다
		boolean actionT = true;
		dao = new DataAccessObject();
		action = new Action();
		auth = new AuthBean();

		auth.setmId(req.getParameter("member"));

		dao.getConnection();

		HttpSession session = req.getSession();

		if (session.getAttribute("accessInfo") != null) {
			System.out.println("session 유무 통과");

			if (session.getAttribute("accessInfo").equals(auth.getmId())) {
				System.out.println("session id 와 auth로 받은 id 가 같은지 확인 통과");

				if (this.ACL_CK(auth)) {
					System.out.println("ACL SUM 통과");

					if (this.InsACL_CK(auth)) {
						System.out.println("ACL INSERT (-1) 통과");

						tran = true;

						req.setAttribute("message", "LOGOUT성공");

						actionT = true;
						page = "index.jsp";

						session.invalidate();

					}
				}
			}else {
				tran = true;
			req.setAttribute("message", "FIND HACKING APPROACH");
			
			}
		} else {
			tran = true;
		req.setAttribute("message", "로그아웃 실패! 세션 만료");
			modifyACL(auth);
		}
		
		
		dao.setAutoCommit(true);
		dao.setTransaction(tran);

		action.setActionType(actionT);
		action.setPage(page);

		dao.closeConnection();
		System.out.println("로그아웃 성공");

	}

	private void modifyACL(AuthBean auth) {
		
		dao.modAccessLogOut(auth);
	}

	private boolean InsACL_CK(AuthBean auth) {

		return convert(dao.insAccessLogOut(auth));
	}

	private boolean ACL_CK(AuthBean auth) {

		return convert(dao.AccessCheck(auth));
	}

	private void loginCtl(HttpServletRequest req) {
		dao = new DataAccessObject();
		action = new Action();
		auth = new AuthBean();
		ArrayList<AuthBean> mem = new ArrayList<AuthBean>();

		boolean tran = false;
		boolean actionType = true;
		String page = "login.jsp";

		dao.getConnection(); // 데이터 베이스 연결(만)
		dao.setAutoCommit(false); // 일단 false = 자동 커밋 안해주겠다

		auth.setmId(req.getParameterValues("accessInfo")[0]);// 아이디
		auth.setmPassword(req.getParameterValues("accessInfo")[1]);// 비밀번호

		action.setActionType(true); // response dispathcer 선택 여기선 일단 response선택
		action.setPage("login.jsp"); // 이동할 페이지 지정

		// 아이디 확인
		if (isIdCk(auth)) {
			System.out.println("1번 통과");
			// 아이디 활성화 확인
			if (isIdSCk(auth)) {
				System.out.println("2번 통과");
				// 아이디+비밀번호 일치여부 확인
				if (isColCk(auth)) {
					System.out.println("3번 통과");
					// AccessLog insert 무결성 확인
					if (isAcslInsCk(auth)) {
						System.out.println("4번 통과");

						mem = SMember(auth);

						// httpSession 저장
						HttpSession session = req.getSession();
						session.setAttribute("accessInfo", mem.get(0).getmId());

						dao.setTransaction(true);// 자동 커밋 on = commit 해주겠다.
						tran = true;

						actionType = false;
						page = "goods.jsp";

						// 여기서 부터는 추가 항목
						String memberInfo = mem.get(0).getmName() + "(" + mem.get(0).getmId() + ")님이 "
								+ mem.get(0).getAccessTime() + "에 로그인 하셨습니다.";

						req.setAttribute("memberInfo", memberInfo);

					}
				}
			}
		}

		dao.setTransaction(tran);
		dao.setAutoCommit(true); // 일단 false = 자동 커밋 안해주겠다
		dao.closeConnection(); // 데이터 베이스 연결(만)
		action.setActionType(actionType); // dispathcer 선택
		action.setPage(page); // 페이지 선택

//		req.setAttribute("mName", mem.get(0).getmName());
//		req.setAttribute("mId", mem.get(0).getmId());
//		req.setAttribute("accessTime",mem.get(0).getAccessTime());
//		

	}

	private ArrayList<AuthBean> SMember(AuthBean auth) {
		return dao.searchMemberInfo(auth);
	}

	private boolean isAcslInsCk(AuthBean auth2) { // AccessLog insert 가 제대로 되었는지 확인

		return convert(dao.insAccessLog(auth));
	}

	private boolean isColCk(AuthBean auth2) {// 아이디+비밀번호 일치여부 확인

		return convert(dao.isAccess(auth));
	}

	private boolean isIdSCk(AuthBean auth2) {// 아이디 활성화 확인

		return convert(dao.isActive(auth));
	}

	private void joinCtl(HttpServletRequest req) {
		action = new Action();
		auth = new AuthBean();
		dao = new DataAccessObject();
		dao.getConnection();
		dao.setAutoCommit(false);

		action.setActionType(true);
		action.setPage("join.jsp");

		auth.setmId(req.getParameterValues("joinInfo")[0]);// 아이디
		auth.setmPassword(req.getParameterValues("joinInfo")[1]);// 비밀번호
		auth.setmName(req.getParameterValues("joinInfo")[2]);// 이름
		auth.setPhone(req.getParameterValues("joinInfo")[3]); // 폰번호

		System.out.println(auth.getmId());
		System.out.println(auth.getmPassword());
		System.out.println(auth.getmName());
		System.out.println(auth.getPhone());

		// 아이디 중복 체크
		if (!isIdCk(auth)) { // 아이디 중복 걸림

			if (isAcCk(auth)) { // 인설트 무결성여부 체크
				dao.setTransaction(true);

				action.setActionType(true);
				action.setPage("login.jsp");

				System.out.println(" 통과");
			} else {
				System.out.println("2번 걸림");
				req.setAttribute("message", "네트워크 불안정! 회원가입실패!");
			}
		} else {
			System.out.println("1번 걸림");
		}

		dao.setAutoCommit(true);
		dao.closeConnection();
	}

	private boolean isAcCk(AuthBean auth) {// members테이블 인설트 무결성여부 체크

		return convert(dao.joinMember(auth));
	}

	private boolean isIdCk(AuthBean auth) {// 아이디 유무 확인 + 아이디 중복 확인

		return convert(dao.isMember(auth));
	}

	private boolean convert(int count) {
		return (count == 1) ? true : false;
	}

}
