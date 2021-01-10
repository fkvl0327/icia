package controller.mall.icia;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.services.mall.icia.Authentication;
import beans.Action;

@WebServlet({"/Main", "/LogInForm", "/LogIn", "/JoinForm", "/Join"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adaptiveRouting(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.adaptiveRouting(request, response);
	}
	
	private void adaptiveRouting(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		Authentication auth;
		Action action = null;
						
		String reqValue = 
				req.getRequestURI().substring(req.getContextPath().length() + 1);
		// 클라이언트 요청
		// Get Type
		if(req.getMethod().equals("GET")) {
			String msg = URLEncoder.encode("잘못된 접근입니다. 메인페이지로 이동합니다.","UTF-8");
			action = new Action();
			action.setActionType(true);
			action.setPage("index.jsp?msg="+msg); // 잘 입력됐는지 확인: 아래 post type의 액션값을 주소창에 입력하여 이동하고자 할 때 msg alert
		} else {
			// Post Type
			if(reqValue.equals("LogInForm")) {
				action = new Action();
				action.setActionType(false);
				action.setPage("login.jsp");
			}else if(reqValue.equals("JoinForm")){
				action = new Action();
				action.setActionType(false);
				action.setPage("join.jsp");
			}else if(reqValue.equals("Main")){
				action = new Action();
				action.setActionType(false);
				action.setPage("index.jsp");
			}else if(reqValue.equals("LogIn")) {
				auth = new Authentication();
				action = auth.entrance(req);
			}else if(reqValue.equals("Join")) {
				auth = new Authentication();
				action = auth.entrance(req);
			}
			req.setAttribute("prev", req.getParameter("page"));
		}
		
		// 서버 응답
		if(action.isActionType()) {
			res.sendRedirect(action.getPage());
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher(action.getPage());
			dispatcher.forward(req, res);
		}
	}
	
}
