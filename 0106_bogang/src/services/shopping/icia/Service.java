package services.shopping.icia;

import javax.servlet.http.HttpServletRequest;

import beans.shopping.icia.Action;

public abstract class Service {
	protected String reqValue;
	
	public Service(HttpServletRequest request) {
		reqValue = request.getRequestURI().substring(request.getContextPath().length()+1);
	}
	
	public abstract Action entrance(HttpServletRequest req);
	
	protected final boolean convertToBoolean(int value) {
		return (value==1)? true : false;
	}
}
