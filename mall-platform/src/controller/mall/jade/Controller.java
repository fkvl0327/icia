package controller.mall.jade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.services.mall.jade.Authentication;
import beans.Action;

@WebServlet({ "/LogIn", "/LogOut", "/Join" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.adaptiveRouting(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.adaptiveRouting(request, response);
	}
	
	private void adaptiveRouting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Authentication auth; 
		Action action = null;
		
		// request mapping value 추출
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String result = uri.substring(path.length() + 1);

//		System.out.println(result);

		if (result.equals("LogIn")) {
			auth = new Authentication();
			action = auth.entrance(request, 1);
		} else if (result.equals("LogOut")) {
			auth = new Authentication();
			action = auth.entrance(request, 2);
		} else if (result.equals("Join")) {
			auth = new Authentication();
			action = auth.entrance(request, 3);
		}
		
		// rq.setAttribute("message", "로그인 성공");
		// Response Type Routing
		// response.sendRedirect()와 RequestDispatcher 사용 시 차이점 확인해 보기
		if(action.isRedirect()) {
			response.sendRedirect(action.getPage()); // 로그인성공 안 뜸 // 페이지만 전달 // 이동한 페이지 URL에 파일이름 표시
			// 모든 서버 언어에 response가 있다
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(action.getPage());
			dispatcher.forward(request, response); // 로그인성공 뜸 // 내용물도 전달(request에 저장된 값을 전달)
			// 이동한 페이지 URL에 파일이름 표시 안 됨 (/LogIn)이 표시됨 -- 제어권은 index.html에 있다
			// Dispatcher는 자바에만 있다(다른 언어에서도 같은 기능이 있지만 Dispatcher라는 이름이 아님)
		}
	}

}
