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
		String reqValue = req.getRequestURI().substring(req.getContextPath().length() + 1);
		switch (reqValue) {
		case "Search":
			action = this.searchCtl(req);
			break;
		}
		return action;
	}

	private Action searchCtl(HttpServletRequest req) {
		Action action = new Action();
		String page = null;
		boolean actionType = true;
		ArrayList<GoodsBean> gList = null;
		GoodsBean gb = new GoodsBean();
		
		// req --> GoodsBean
		gb.setWord(req.getParameter("word"));
		
		// Connection 생성
		dao = new DataAccessObject();
		dao.getConnection();
		dao.setAutoCommit(false);
		
		// 상품 조회
		gList = (gb.getWord()==null)?this.searchGoods(): this.searchGoods(gb);
		
		dao.setAutoCommit(true);
		dao.closeConnection();
		
		// Action 설정
		
		return action;
	}
	
	private ArrayList<GoodsBean> searchGoods(GoodsBean gb){
		return dao.searchGoods(gb);
	}
	
	private ArrayList<GoodsBean> searchGoods(){
		return dao.searchGoods();
	}
}
