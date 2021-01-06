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
		GoodsBean gb = new GoodsBean();
		ArrayList<GoodsBean> detail;
		gb.setGoCode(req.getParameterValues("code")[0]);
		gb.setSeCode(req.getParameterValues("code")[1]);

		// Connection 생성
		dao = new DataAccessObject();
		dao.getConnection();

		// 상품 조회
		detail = goodsDetail(gb);
		if (detail.size()!=1) {
			page = "goods.jsp";
			actionType = false;
			req.setAttribute("gList",
					this.makeGoodsList((gb.getWord()==null)? this.searchGoods(): this.searchGoods(gb)));
			req.setAttribute("msg", "죄송합니다. 품절상태입니다.");
		} else {
			req.setAttribute("goodsImage", "image/" + detail.get(0).getImage());
			req.setAttribute("item", detail.get(0).getGoName());
			req.setAttribute("price", detail.get(0).getGoPrice());
			req.setAttribute("gInfo", req.getSession().getAttribute("accessInfo")+":"
			+detail.get(0).getGoCode()+":"+detail.get(0).getSeCode());
			req.setAttribute("seller", detail.get(0).getSeName());
		}
		dao.closeConnection();

		// Action 설정
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

		// 상품 조회
		req.setAttribute("gList",
				this.makeGoodsList((gb.getWord().equals("")) ? this.searchGoods() : this.searchGoods(gb)));

		dao.closeConnection();

		// Action 설정
		action.setActionType(actionType);
		action.setPage(page);

		return action;
	}

	private ArrayList<GoodsBean> searchGoods(GoodsBean gb) {
		return dao.searchGoods(gb);
	}

	private ArrayList<GoodsBean> searchGoods() {
		return dao.searchGoods();
	}

	private ArrayList<GoodsBean> goodsDetail(GoodsBean gb) {
		return dao.goodsDetail(gb);
	}

	private String makeGoodsList(ArrayList<GoodsBean> gList) {
		StringBuffer sb = new StringBuffer();
		int index = 0;

		for (GoodsBean g : gList) {
			index++;

			if (index % 3 == 1) {
				sb.append("<div class=\"line\">");
			}

			sb.append("<div class=\"item\" onClick=\"goDetail(\'" + g.getGoCode() + ":" + g.getSeCode() + "\')\">");

			sb.append("<div class=\"item__top\"><img src=\"image/" + g.getGoCode() + "_" + g.getSeCode()
					+ ".jpg\"/></div>");

			sb.append("<div class=\"item__bottom\"><div class=\"item-name\">" + g.getGoName()
					+ "</div><div class=\"item-price\">" + g.getGoPrice() + "원" + "</div><div class=\"item-stock\">"
					+ "재고 " + g.getGoStock() + "&nbsp;&nbsp;&nbsp;무료배송</div></div></div>");

			if (index % 3 == 0) { // 마지막 index에서 </div> --> | index==gList.size()라고도 해보자..
				sb.append("</div>");
			}

		}
		if (index % 3 != 0) {
			sb.append("</div>");
		}

		return sb.toString();
	}
}