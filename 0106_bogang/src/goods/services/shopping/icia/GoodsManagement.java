package goods.services.shopping.icia;

import javax.servlet.http.HttpServletRequest;
import beans.shopping.icia.Action;
import services.shopping.icia.Service;

public class GoodsManagement extends Service {
	DataAccessObject dao;
	
	public GoodsManagement(HttpServletRequest req) {
		super(req);
	}

	@Override
	public Action entrance(HttpServletRequest req) {
		Action action = null;
		switch(this.reqValue) {
			case "Search":
				this.searchCtl();
				break;
			case "GoodsDetail":
				this.goodsDetailCtl();
				break;
		}
		return action;
	}

	private Action goodsDetailCtl() {
		Action action = new Action();
		String page = null;
		boolean actionType = false;
		dao = new DataAccessObject();
		
		dao.getConnection();
		
		dao.closeConnection();
		
		action.setPage(page);
		action.setAction(actionType);
		
		return action;
		
	}

	private Action searchCtl() {
		Action action = new Action();
		String page = null;
		boolean actionType = false;
		dao = new DataAccessObject();
		
		dao.getConnection();
		
		dao.closeConnection();
		
		action.setPage(page);
		action.setAction(actionType);
		
		return action;
		
	}

}
