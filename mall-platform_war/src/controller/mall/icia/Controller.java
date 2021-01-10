package controller.mall.icia;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.services.mall.icia.Authentication;
import beans.Action;

@WebServlet({"/LogIn", "/LogOut", "/Join", "/SearchGoods"}) // 이름을 만들 때 일관된 규칙을 정할 것
// 본 실습 시에는 클래스이름과 동일하게 대문자로 시작하게끔 정했음
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adaptiveRouting(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.adaptiveRouting(request, response);
	}

	private void adaptiveRouting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Class Routing
		Authentication auth;
		Action action = null;
		// request mapping value 추출(uri - contextpath)
		String reqValue = 
				request.getRequestURI().substring(request.getContextPath().length()+1);

		if(reqValue.equals("LogIn")) {
			auth = new Authentication();		
			action = auth.entrance(request, 1);
		} else if(reqValue.equals("LogOut")) {
			auth = new Authentication();		
			action = auth.entrance(request, 2);
		} else if(reqValue.equals("Join")) {
			auth = new Authentication();		
			action = auth.entrance(request, 3);
		}
		
		// Response Type Routing
		if(action.isRedirect()) {
			response.sendRedirect(action.getPage());
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(action.getPage());
			dispatcher.forward(request, response);
		}


	}

}
