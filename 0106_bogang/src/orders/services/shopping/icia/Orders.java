package orders.services.shopping.icia;

import javax.servlet.http.HttpServletRequest;

import beans.shopping.icia.Action;
import services.shopping.icia.Service;

public class Orders extends Service {
	Action action;
	
	public Orders(HttpServletRequest req) {
		super(req);
	}

	@Override
	public Action entrance(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return action;
	}
	
	

}
