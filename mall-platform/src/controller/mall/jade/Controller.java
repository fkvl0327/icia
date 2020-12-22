package controller.mall.jade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.services.mall.jade.Authentication;

@WebServlet({ "/LogIn", "/LogOut", "/Join" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Authentication auth; 

		System.out.println(request.getRequestURI());
		System.out.println(request.getContextPath());

		// request mapping value 추출
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String result = uri.substring(path.length() + 1);

		System.out.println(result);

		if (result.equals("LogIn")) {
			auth = new Authentication();
			auth.entrance(request, 1);
		} else if (result.equals("LogOut")) {
			auth = new Authentication();
			auth.entrance(request, 2);
		} else if (result.equals("Join")) {
			auth = new Authentication();
			auth.entrance(request, 3);
		}
		
		// req.setAttribute("message", "로그인 성공");
		// Response Type Routing
		// response.sendRedirect()와 RequestDispatcher 사용 시 차이점 확인해 보기
		if(false) {
			response.sendRedirect("response.jsp"); // 로그인성공 안 뜸
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("response.jsp");
			dispatcher.forward(request, response); // 로그인성공 뜸
		}
		
		
	}

}
