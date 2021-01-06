package controller.shopping.icia;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.shopping.icia.Action;

@WebServlet({"/LogInForm", "/JoinForm", "/Search", "/GoodsDetail", "/LogIn", "/Join", "/LogOut"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = null;
		String reqValue = request.getRequestURI().substring(request.getContentLength()+1);
		if(reqValue.equals("LogInForm")) {
			
		}else if(reqValue.equals("JoinForm")) {
			
		}else if(reqValue.equals("Search")) {
			
		}else if(reqValue.equals("GoodsDetail")) {
		
		}else {
			action = new Action();
			action.setAction(false);
			action.setMsg("잘못된 경로로 접근하셨습니다. 메인으로 이동합니다.");
			action.setPage("index.jsp?msg=" + URLEncoder.encode(action.getMsg(), "UTF-8"));
		}

		if(action.isAction()) {
			RequestDispatcher dis = request.getRequestDispatcher(action.getPage());
			dis.forward(request, response);
		}else {
			response.sendRedirect(action.getPage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = null;
		String reqValue = request.getRequestURI().substring(request.getContentLength()+1);
		if(reqValue.equals("LogIn")) {
			
		}else if(reqValue.equals("Join")) {
			
		}else if(reqValue.equals("LogOut")) {
			
		}	
	
	}
	

}
