package search.services.mall.icia;

import javax.servlet.http.HttpServletRequest;

import beans.Action;

public class Orders {
	private DataAccessObject dao;
	
	public Orders() {
		
	}
	
	public Action entrance(HttpServletRequest req, String reqV ) {
		Action action = null;
		
		switch (reqV) {
		case "Basket":
			action = this.basketCtl(req);
			break;
		
		case "Order":
			action = this.orderCtl(req);
			break;
		}
		
		return action;
	}
	
	private Action basketCtl(HttpServletRequest req) {
		Action action = new Action();
		dao= new DataAccessObject();
		
		boolean actionT= true;
		String page = "index.jsp";
		boolean isCommit = false;
		
		dao.getConnection();
		dao.setAutoCommit(false);
		
		System.out.println(req.getParameterValues("gInfo")[0]);
		System.out.println(req.getParameterValues("gInfo")[1]);
		System.out.println(req.getParameterValues("gInfo")[2]);
		System.out.println(req.getParameterValues("opt")[0]);
		
		dao.setTransaction(isCommit);
		dao.setAutoCommit(true);
		dao.closeConnection();
		
		action.setActionType(actionT);
		action.setPage(page);
		
		return action;
	}
	
	private Action orderCtl(HttpServletRequest req) {
		Action action = new Action();
		dao= new DataAccessObject();
		
		boolean actionT= true;
		String page = "index.jsp";
		boolean isCommit = false;
		
		dao.getConnection();
		dao.setAutoCommit(false);
		
		System.out.println(req.getParameterValues("gInfo")[0]);
		System.out.println(req.getParameterValues("gInfo")[1]);
		System.out.println(req.getParameterValues("gInfo")[2]);
		System.out.println(req.getParameterValues("opt")[0]);
		
		dao.setTransaction(isCommit);
		dao.setAutoCommit(true);
		dao.closeConnection();
		
		action.setActionType(actionT);
		action.setPage(page);
		
		return action;
	}
}
