package controller.mall.icia;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Action;

@WebServlet({ "/Main", "/LogInForm", "/LogIn", "/JoinForm", "/Join" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
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

	private void adaptiveRouting(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Action action = new Action();
		String reqValue = req.getRequestURI().substring(req.getContextPath().length() + 1);

		// 클라이언트 요청
		// Get Type
		if (req.getMethod().equals("GET")) {

		} else {
			// Post Type
			if (reqValue.equals("LogIn")) {

			} else if (reqValue.equals("LogInForm")) {
				action.setActionType(false);
				action.setPage("login.jsp");
			} else if (reqValue.equals("JoinForm")) {
				action.setActionType(false);
				action.setPage("join.jsp");
			} else if (reqValue.equals("Join")) {

			} else if (reqValue.equals("Main")) {
				action.setActionType(true);
				action.setPage("index.jsp");
			}
			req.setAttribute("prev", req.getParameter("page"));
		}

		// 서버 응답
		if (action.isActionType()) {
			res.sendRedirect(action.getPage());
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher(action.getPage());
			dispatcher.forward(req, res);
		}
	}

}
