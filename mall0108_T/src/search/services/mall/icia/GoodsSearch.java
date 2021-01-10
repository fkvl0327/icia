package search.services.mall.icia;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.Action;
import beans.GoodsBean;

public class GoodsSearch {
	private DataAccessObject dao;
	
	public GoodsSearch() {
		
	}
	
	public Action entrance(HttpServletRequest req) {
		Action action = null;
		String reqValue = 
				req.getRequestURI().substring(req.getContextPath().length() + 1);
		
		switch(reqValue) {
		case "Search":
			action = this.searchCtl(req);
			break;
		case "GoodsDetail":
			action = this.goodsDetailCtl(req);
			break;
		}
		return action;
	}
	
	private Action goodsDetailCtl(HttpServletRequest req) {
		Action action = new Action();
		String page = "goodsDetail.jsp";
		boolean actionType = false;
		ArrayList<GoodsBean> goodsInfo;
		// req --> gb
		GoodsBean gb = new GoodsBean();
		gb.setGoCode(req.getParameterValues("code")[0]);
		gb.setSeCode(req.getParameterValues("code")[1]);
		
		// dao
		dao = new DataAccessObject();
		dao.getConnection();
		
		goodsInfo = this.getDetail(gb);
		if(goodsInfo.size() != 1) {
			page = "goods.jsp";
			actionType = false;
			req.setAttribute("gList", this.makeGoodsList((gb.getWord() == null)? this.searchGoods(): this.searchGoods(gb)));
			req.setAttribute("message", "죄송합니다. 품절상태입니다.");
		} else {
			req.setAttribute("goodsImage", "image/" + goodsInfo.get(0).getGoImage());
			req.setAttribute("item", goodsInfo.get(0).getGoName());
			req.setAttribute("price", goodsInfo.get(0).getGoPrice());
			req.setAttribute("gInfo", req.getSession().getAttribute("accessInfo")+":"+
										goodsInfo.get(0).getGoCode() + ":" + 
										goodsInfo.get(0).getSeCode());
			req.setAttribute("detailImage", "image/" + goodsInfo.get(0).getGoBimage());
			req.setAttribute("seller", goodsInfo.get(0).getSeName());
		}
		dao.closeConnection();
		
		action.setActionType(actionType);
		action.setPage(page);
		
		return action;
	}
	
	private Action searchCtl(HttpServletRequest req) {
		Action action = new Action();
		String page = "goods.jsp";
		boolean actionType = false;
		
		GoodsBean gb = new GoodsBean();
		// req --> GoodsBean
		gb.setWord(req.getParameter("word"));
		
		// Connection 생성
		dao = new DataAccessObject();
		dao.getConnection();	
		dao.setAutoCommit(false);
		
		// 상품 조회
		req.setAttribute("gList", this.makeGoodsList((gb.getWord().equals(""))? this.searchGoods(): this.searchGoods(gb)));
		
		dao.setAutoCommit(true);
		dao.closeConnection();
		
		// Action 설정
		action.setActionType(actionType);
		action.setPage(page);
		
		return action;
	}
	
	private String makeGoodsList(ArrayList<GoodsBean> gList) {
		StringBuffer sb = new StringBuffer();
		int index = 0;
		for(GoodsBean goods : gList) {
			index++;
			if(index%3 == 1) { sb.append("<div class=\"line\">");}
			
			sb.append("<div class=\"item\" onClick=\"goDetail(\'"+goods.getGoCode()+":"+goods.getSeCode()+"\')\">");
            sb.append("<div class=\"item__top\"><img src=\"image/"+ goods.getGoImage() + "\" /></div>");
            sb.append("<div class=\"item__bottom\"><div class=\"item-name\">"+ goods.getGoName() + "</div>"
            		+ "<div class=\"item-price\">" + goods.getGoPrice() +"원</div>"
            		+ "<div class=\"item-stock\">재고 "+ goods.getGoStock() + "&nbsp;&nbsp;&nbsp;무료배송</div></div>");
            sb.append("</div>");
			
            if(index%3 == 0) { sb.append("</div>");}
		}
		if(index%3 != 0) {sb.append("</div>");}
		
		return sb.toString();
	}
	
	private ArrayList<GoodsBean> getDetail(GoodsBean gb){
		return dao.getDetail(gb);
	}
	private ArrayList<GoodsBean> searchGoods(){
		return dao.searchGoods();
	}
	private ArrayList<GoodsBean> searchGoods(GoodsBean gb){
		
		return dao.searchGoods(gb);
	}
}
