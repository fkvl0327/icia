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

@WebServlet({"/Basket","/Order"})
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Action action;
	
    public OrderController() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		action=null;
		Orders ord;
		
		System.out.println("오더 컨트롤러 진입");
		String reqV = req.getRequestURI().substring(req.getContextPath().length()+1);
		
		
		
		if(reqV.equals("Basket") || reqV.equals("Order")) {
			//세션 만료
			if(req.getSession().getAttribute("accessInfo")!=null) {
				action = new Action();
				ord = new Orders();
				action = ord.entrance(req, reqV);
			}else {
				action = new Action();
				action.setActionType(true);
				action.setPage("login.jsp?" + this.setParam("gInfo", req));
			}
		
			
		}
		
		//Client 응답
		if(action.isActionType()) {
			res.sendRedirect(action.getPage());
		}else {
		RequestDispatcher dis = req.getRequestDispatcher(action.getPage());
		dis.forward(req, res);
		}
	}

	// gInfo = '' &gInfo='' &gInfo='' &gInfo=''
	private String setParam(String paramName, HttpServletRequest req) throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<req.getParameterValues(paramName).length;i++) {
			sb.append(paramName+"=");
			sb.append(URLEncoder.encode(req.getParameterValues(paramName)[i],"UTF-8"));
			sb.append(i==req.getParameterValues(paramName).length-1?"":"&");
		}
		return sb.toString();
	}
	
}
