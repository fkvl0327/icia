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
import search.services.mall.icia.Search;

@WebServlet({ "/LogIn", "/LogOut", "/Search", "/GoodsDetail" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.adaptiveRouting(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		this.adaptiveRouting(req, res);
	}

	private void adaptiveRouting(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Action action = null;
		Authentication auth;
		Search goods;

		String reqValue = req.getRequestURI().substring(req.getContextPath().length() + 1);
		// 클라이언트 요청
		// Get Type
		if (req.getMethod().equals("GET")) {
			if (reqValue.equals("GoodsDetail")) {
				goods = new Search();
				action = goods.entrance(req);
			} else {
				action = new Action();
				action.setActionType(true);
				action.setPage("index.jsp");
				action.setMsg("잘못된 접근입니다. 메인페이지로 이동합니다.");
			}
		} else {
			// Post Type
			if (reqValue.equals("LogIn")) {
				auth = new Authentication();
				action = auth.entrance(req);
			} else if (reqValue.equals("LogOut")) {
				auth = new Authentication();
				action = auth.entrance(req);
			} else if (reqValue.equals("Search")) {
				goods = new Search();
				action = goods.entrance(req);
			}
		}

		// 서버 응답
		if(action.isActionType()) {
			  if(action.getMsg() != null) {
			     res.sendRedirect(action.getPage() + "?msg=" + URLEncoder.encode(action.getMsg(), "UTF-8")); 
			  }else {
			     res.sendRedirect(action.getPage());
			  }
			 }else {
			  RequestDispatcher dispatcher = req.getRequestDispatcher(action.getPage());
			  dispatcher.forward(req, res);
			 }
		}
	}


