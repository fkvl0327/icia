package controller.shopping.icia;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.services.shopping.icia.Authentication;
import beans.shopping.icia.Action;
import goods.services.shopping.icia.GoodsManagement;

@WebServlet({"/LogInForm", "/JoinForm", "/Search", "/GoodsDetail", "/LogIn", "/Join", "/LogOut"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = null;
		String reqValue = request.getRequestURI().substring(request.getContextPath().length()+1);
		if(reqValue.equals("LogInForm")) {
			action = new Action();
			action.setAction(false);
			action.setPage("login.jsp");
		}else if(reqValue.equals("JoinForm")) {
			action = new Action();
			action.setAction(false);
			action.setPage("join.jsp");
		}else if(reqValue.equals("Search")) {
			GoodsManagement gm = new GoodsManagement(request);
			action = gm.entrance(request);
		}else if(reqValue.equals("GoodsDetail")) {
			GoodsManagement gm = new GoodsManagement(request);
			action = gm.entrance(request);
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

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Authentication auth;
		Action action = null;
		String reqValue = req.getRequestURI().substring(req.getContextPath().length()+1);
		if(reqValue.equals("LogIn") || reqValue.equals("Join") || reqValue.equals("LogOut")) {
			auth = new Authentication(req);
			action = auth.entrance(req);
		}
		
		if(action.isAction()) {
			RequestDispatcher dis = req.getRequestDispatcher(action.getPage());
			dis.forward(req, res);
		}else {
			res.sendRedirect(action.getPage());
		}
	
	}
	

}
