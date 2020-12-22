package auth.services.mall.jade;

import javax.servlet.http.HttpServletRequest;

public class Authentication {
	
	public Authentication() {
		
	}
	
	public void entrance(HttpServletRequest rq, int num) {
		// backcontroller 역할을 하는 메소드라서 backcontroller라고 써도 됩니다
		// private한 것들을 entrance를 통해서 전달
		// 다른 클래스에도 이 entrance와 같은 backcontroller들이 필요할 겁니다
		if(num == 1) {
			this.logIn(rq);
		}
		else if(num == 2) {
			this.logOut(rq);
		}
		else {
			this.join(rq);
		}
	}
	
	// 로그인
	private void logIn(HttpServletRequest rq) {
//		System.out.println(rq.getParameterValues("accessinfo")[0]);
//		System.out.println(rq.getParameterValues("accessinfo")[1]);
		rq.setAttribute("message", "로그인 성공");
	}
	// 로그아웃
	private void logOut(HttpServletRequest rq) {
		
	}
	// 회원가입
	private void join(HttpServletRequest rq) {
		
	}
}
