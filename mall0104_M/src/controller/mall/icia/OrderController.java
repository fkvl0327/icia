package controller.mall.icia;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Action;
import search.services.mall.icia.Orders;

@WebServlet({"/Basket", "/Order"})
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Action action = null;
		String reqValue = req.getRequestURI().substring(req.getContextPath().length() + 1);
		
		if (reqValue.equals("Basket") || reqValue.equals("Order")) {
			if(req.getSession().getAttribute("accessInfo")!=null) {
			//if(req.getSession().getAttribute("accessInfo").equals(req.getParameterValues("gInfo")[0])) {
				Orders orders = new Orders();
				action = orders.entrance(req);
			}else {
				action = new Action();
				action.setActionType(true);
				action.setPage("login.jsp?" + this.setParam(reqValue, "gInfo", req));
			}
		}

		// Client 응답
		if (action.isActionType()) {
			res.sendRedirect(action.getPage());
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher(action.getPage());
			dispatcher.forward(req, res);
		}

	}
	private String setParam(String pAction, String pName, HttpServletRequest req) throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		sb.append("action="+ URLEncoder.encode(pAction, "UTF-8") + "&");
		for(int i=0; i<req.getParameterValues(pName).length;i++) {
			sb.append(pName + "=");
			sb.append(URLEncoder.encode(req.getParameterValues(pName)[i], "UTF-8"));
			sb.append(i==req.getParameterValues(pName).length-1?"":"&");
		}
		return sb.toString();
	}
}
