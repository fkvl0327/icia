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

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Action action = null;
		
		String reqValue = req.getRequestURI().substring(req.getContextPath().length() + 1);
		if(reqValue.equals("Basket") || reqValue.equals("Order")) {
			// 세션 만료  MM1  
			if(req.getSession().getAttribute("accessInfo") != null) {
				Orders orders = new Orders();
				action = orders.entrance(req);
			}else {
				action = new Action();
				action.setActionType(true);
				action.setPage("login.jsp?"+ this.setParam(reqValue, "gInfo", req)) ;
			}
			
		}
		
		// Client 응답
		if(action.isActionType()) {
			res.sendRedirect(action.getPage());
		}else {
			RequestDispatcher dis = req.getRequestDispatcher(action.getPage());
			dis.forward(req, res);
		}
	}
	
	private String setParam(String fAction, String paramName, HttpServletRequest req) throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		// action=Basket&gInfo=null&gInfo=1001&gInfo=1234567890&gInfo=10
		sb.append("action="+ URLEncoder.encode(fAction, "UTF-8") + "&");
		for(int index=0; index<req.getParameterValues(paramName).length; index++) {
			sb.append(paramName + "=");
			sb.append(URLEncoder.encode(req.getParameterValues(paramName)[index], "UTF-8"));	
			sb.append(index==req.getParameterValues(paramName).length-1?"":"&");
		}
		return sb.toString();
	}

}
