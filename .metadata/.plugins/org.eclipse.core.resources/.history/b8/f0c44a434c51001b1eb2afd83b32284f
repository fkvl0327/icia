package search.services.mall.icia;

import javax.servlet.http.HttpServletRequest;

import beans.Action;

public class Orders {
	private DataAccessObject dao;

	public Orders() {

	}

	public Action entrance(HttpServletRequest req) {
		Action action = null;
		String reqValue = req.getRequestURI().substring(req.getContextPath().length() + 1);
		switch (reqValue) {
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
		boolean isCommit = false;
		boolean actionType = true;
		String page = "index.jsp";

		dao = new DataAccessObject();
		dao.getConnection();
		dao.setAutoCommit(false);

		dao.setTransaction(isCommit);
		dao.setAutoCommit(true);
		dao.closeConnection();

		action.setActionType(actionType);
		action.setPage(page);
		return action;
	}

	private Action orderCtl(HttpServletRequest req) {
		Action action = new Action();
		boolean isCommit = false;
		boolean actionType = true;
		String page = "index.jsp";

		dao = new DataAccessObject();
		dao.getConnection();
		dao.setAutoCommit(false);

		dao.setTransaction(isCommit);
		dao.setAutoCommit(true);
		dao.closeConnection();

		action.setActionType(actionType);
		action.setPage(page);
		return action;
	}
}
