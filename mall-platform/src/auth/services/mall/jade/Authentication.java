package auth.services.mall.jade;

import javax.servlet.http.HttpServletRequest;

import beans.Action;
import beans.AuthBean;

public class Authentication {
	Action action; // 어느 메소드에서나 접근할 수 있도록 // 단, 선언과 할당을 분리하는 것을 원칙으로 하자
	DataAccessObject dao;
	
	public Authentication() {
		this.action = new Action(); // 어느 메소드에서나 접근할 수 있도록 생성자에 할당
		// (반드시 이렇게 해야 한다는 것은 아님. 일반적인 방법.)
	}
	
	public Action entrance(HttpServletRequest rq, int num) {
		// backcontroller 역할을 하는 메소드라서 backcontroller라고 써도 됩니다
		// private한 것들을 entrance를 통해서 전달
		// 다른 클래스에도 이 entrance와 같은 backcontroller들이 필요할 겁니다
		if(num == 1) {
			this.logInCtl(rq);
		}
		else if(num == 2) {
			this.logOutCtl(rq);
		}
		else {
			this.joinCtl(rq);
		}
		return action;
		// job에서 얻은 리턴값을 Controller로 넘겨주기 위해 action을 리턴합니다
	}
	
	// 로그인
	private void logInCtl(HttpServletRequest rq) {
		this.dao = new DataAccessObject();
		
//		System.out.println(rq.getParameterValues("accessinfo")[0]);
//		System.out.println(rq.getParameterValues("accessinfo")[1]);
//		rq.setAttribute("message", "로그인 성공");
		
		// Client Job Controller
		// 클라이언트가 전달할 값을 bean에 담자
		AuthBean authBean = new AuthBean();
		authBean.setmId(rq.getParameterValues("accessinfo")[0]);
		authBean.setmPassword(rq.getParameterValues("accessinfo")[1]);
		
		// 아이디 유무 확인
		if(this.isUserId(authBean)) {
			// 아이디 활성화 확인
			if(this.isIdState(authBean)) {
				// ID+PW 일치 확인
				if(this.isAccess(authBean)) {
					// ACCESSLOG INSERT
					if(this.insAccessLog(authBean)) {
						// COMMIT;
						// 회원이름, 로그인 시간 추출
						this.searchMemberInfo(authBean);
						rq.setAttribute("mId", authBean.getmId());
						rq.setAttribute("mName", authBean.getmName());
						rq.setAttribute("accessTime", authBean.getAccessTime());
						
						// Action 설정
						this.action.setRedirect(false);
						this.action.setPage("response.jsp");
					}
				}
			}
		}
	}
	private void searchMemberInfo(AuthBean auth) {
		auth.setmName("김");
		auth.setAccessTime("20201223104400"); // 이 메소드의 문제점: 리턴 AuthBean이 무의미하다
		// return을 하지 않아도 auth에 데이터가 저장되어있다
	}

	private boolean insAccessLog(AuthBean auth) {
		// TODO Auto-generated method stub
		return convertToBoolean(dao.isAccessLog(auth));
	}

	private boolean isAccess(AuthBean auth) {
		// TODO Auto-generated method stub
		return convertToBoolean(dao.isAccess(auth));
	}

	private boolean isIdState(AuthBean auth) {
		// TODO Auto-generated method stub
		return convertToBoolean(dao.isActive(auth));
	}

	private boolean isUserId(AuthBean auth) {
		// TODO Auto-generated method stub
		return convertToBoolean(dao.isMember(auth));
	}
	
	private boolean convertToBoolean(int data) {
		return data == 1? true: false;
	}

	// 로그아웃
	private void logOutCtl(HttpServletRequest rq) {
		action.setRedirect(true);
		action.setPage("index.html");
	}
	// 회원가입
	private void joinCtl(HttpServletRequest rq) {
		action.setRedirect(true);
		action.setPage("index.html");
	}
}
