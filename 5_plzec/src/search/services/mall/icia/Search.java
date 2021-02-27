package search.services.mall.icia;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import beans.Action;
import beans.GoodsBean;

public class Search {
	private DataAccessObject dao;

	public Search() {

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
		case "Basket":
			action = this.basketCtl(req);
			break;
		case "SendOrder":
			action = this.sendOrderCtl(req);
			break;
		case "BasketCheck":
			action = this.basketListCtl(req);
			break;
		}
		return action;
	}

	private Action sendOrderCtl(HttpServletRequest req) {
		Action action = new Action();
		boolean isCommit = true;
		boolean actionType = false;
		String page = "goods.jsp";
		ArrayList<GoodsBean> gList = new ArrayList<GoodsBean>();
		String msg = "주문완료!";
		String orderDate = null;
		
		String[] gInfo = req.getParameter("gInfo").split(":");
		for(int i=0; i<gInfo.length; i++) {
			GoodsBean gb = new GoodsBean();
			String[] goods = gInfo[i].split(",");
			gb.setmId(goods[0]);
			gb.setGoCode(goods[1]);
			gb.setSeCode(goods[2]);
			gb.setQty(Integer.parseInt(goods[3]));
			gList.add(gb);
		}
		
		dao = new DataAccessObject();
		dao.getConnection();
		dao.setAutoCommit(false);
	
		if (this.insOrders(gList.get(0))) {
			orderDate = this.searchOrderDate(gList.get(0));
			for(GoodsBean gb:gList) {
				gb.setOrderDate(orderDate);
				if(this.insOrderDetail(gb)) {
					if(this.isOK()) {
						if(this.updOrderDetail(gb)) {
							if(!this.updOrder(gb)) {
								msg = "잠시 후 다시 주문해주세요.";
								isCommit = false;
								page = "orderPage.jsp?gInfo="+req.getParameter("gInfo");
								break;
							}
						}
					}else {
						msg = "결제에 실패하였습니다. 다시 시도해주세요.";
						isCommit = false;
						page = "orderPage.jsp?gInfo="+req.getParameter("gInfo");
					}
				}
			}
		}
		dao.setTransaction(isCommit);
		dao.setAutoCommit(true);
		dao.closeConnection();
		
		req.setAttribute("msg", msg);
		action.setActionType(actionType);
		action.setPage(page);
		
		return action;
	}
	
	private boolean updOrder(GoodsBean gb) {
		return convertToBoolean(dao.updOrder(gb));
	}

	private boolean updOrderDetail(GoodsBean gb) {
		return convertToBoolean(dao.updOrderDetail(gb));
	}

	// 결제 시스템을 가정, 실습에서는 무조건 true만 반환하는 메소드로 생성
	private boolean isOK() {
		return true;
	}

	private Action goodsDetailCtl(HttpServletRequest req) {
		Action action = new Action();
		String page = "goodsDetail.jsp";
		boolean actionType = false;
		GoodsBean gb = new GoodsBean();
		ArrayList<GoodsBean> goodsInfo;
		gb.setGoCode(req.getParameterValues("code")[0]);
		gb.setSeCode(req.getParameterValues("code")[1]);

		// Connection 생성
		dao = new DataAccessObject();
		dao.getConnection();

		// 상품 조회
		goodsInfo = this.getDetail(gb);
		if (goodsInfo.size()!=1) {
			page = "goods.jsp";
			actionType = false;
			req.setAttribute("gList",
					this.makeGoodsList((gb.getWord()==null)? this.searchGoods(): this.searchGoods(gb)));
			req.setAttribute("message", "죄송합니다. 품절상태입니다.");
		} else {
			req.setAttribute("goodsImage", "image/" + goodsInfo.get(0).getGoImage());
			req.setAttribute("item", goodsInfo.get(0).getGoName());
			req.setAttribute("price", goodsInfo.get(0).getGoPrice());
			req.setAttribute("gInfo", req.getSession().getAttribute("accessInfo")+":"
			+goodsInfo.get(0).getGoCode()+":"+goodsInfo.get(0).getSeCode());
			req.setAttribute("seller", goodsInfo.get(0).getSeName());
			req.setAttribute("detailImage", "image/" + goodsInfo.get(0).getbImage());
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

	private ArrayList<GoodsBean> getDetail(GoodsBean gb) {
		return dao.getDetail(gb);
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

			sb.append("<div class=\"item__top\"><img src=\"image/" + g.getGoImage() + "\"/></div>");

			sb.append("<div class=\"item__bottom\"><div class=\"item-name\">" + g.getGoName()
					+ "</div><div class=\"item-price\">" + g.getGoPrice() + "원" + "</div><div class=\"item-stock\">"
					+ "재고 " + g.getGoStock() + "&nbsp;&nbsp;&nbsp;무료배송</div></div></div>");

			if (index % 3 == 0) {
				sb.append("</div>");
			}

		}
		if (index % 3 != 0) {
			sb.append("</div>");
		}

		return sb.toString();
	}
	
	private Action basketCtl(HttpServletRequest req) {
		Action action = new Action();
		boolean isCommit = false;
		boolean actionType = false;
		String page = "GoodsDetail";
		String msg = null;
		boolean msgType = false;
		GoodsBean gb = new GoodsBean();
		gb.setmId(req.getParameterValues("gInfo")[0]);
		gb.setGoCode(req.getParameterValues("gInfo")[1]);
		gb.setSeCode(req.getParameterValues("gInfo")[2]);
		gb.setQty(Integer.parseInt(req.getParameterValues("gInfo")[3]));

		dao = new DataAccessObject();
		dao.getConnection();
		dao.setAutoCommit(false);

		// 이전에 장바구니에 담겼는지 SELECT로 확인
		// 담긴 값이 없었으면 INSERT
		if (!this.alreadyIs(gb)) {
			if (!this.insBasket(gb)) {
				msg= "장바구니 담기 실패, 다시 시도해주세요.";
			} else {
				isCommit = true;
				page += "?code=" + gb.getGoCode() + "&code=" + gb.getSeCode();
				msgType = true;
				msg = "장바구니 담기 성공! 장바구니로 이동하시겠습니까?";
			}
		} 
		// 담긴 값이 있었으면 UPDATE
		else {
			if (!this.updBasket(gb)) {
				msg= "장바구니 추가 실패, 다시 시도해주세요.";
			} else {
				isCommit = true;
				page += "?code=" + gb.getGoCode() + "&code=" + gb.getSeCode();
				msgType = true;
				msg = "장바구니 담기 성공! 장바구니로 이동하시겠습니까?";
			}
		}

		dao.setTransaction(isCommit);
		dao.setAutoCommit(true);
		dao.closeConnection();
		
		req.setAttribute("mType", msgType);
		req.setAttribute("msg", msg);
		
		action.setActionType(actionType);
		action.setPage(page);
		return action;
	}
	
	private boolean updBasket(GoodsBean gb) {
		return convertToBoolean(dao.updBasket(gb));
	}

	private boolean alreadyIs(GoodsBean gb) {
		return convertToBoolean(dao.alreadyIs(gb));
	}

	private boolean insBasket(GoodsBean gb) {
		return convertToBoolean(dao.insBasket(gb));
	}

	private boolean convertToBoolean(int value) {
		return (value == 1) ? true : false;
	}
	
	private Action basketListCtl(HttpServletRequest req) {
		Action action = new Action();
		boolean actionType = false;
		String page = "orderdoc.jsp";
		String list;
		GoodsBean gb = new GoodsBean();
		gb.setmId(req.getParameter("gInfo"));
		
		dao = new DataAccessObject();
		dao.getConnection();
		
		list = this.makeHtml(this.getBasketList(gb));
		
		dao.closeConnection();
		
		req.setAttribute("basket", list);
		
		action.setActionType(actionType);
		action.setPage(page);
		
		return action;
	}
	
	private ArrayList<GoodsBean> getBasketList(GoodsBean gb){
		return dao.getBasketList(gb);
	}
	
	private String makeHtml(ArrayList<GoodsBean> basket) {
		StringBuffer sb = new StringBuffer();
		int totAmount=0;
		int amount;
		int index=0;

		String gInfo = new String();
		
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td colspan=\"2\"><input type=\"checkbox\" id=\"all\" onChange=\"checkAll()\" />상품정보</td>");
		sb.append("<td>가격</td>");
		sb.append("<td>수량</td>");
		sb.append("<td>금액</td>");
		sb.append("<td>판매자</td>");
		sb.append("</tr>");
		
		for (GoodsBean g : basket) {
			index++;
			amount = g.getGoPrice()*g.getQty();
			totAmount += amount;
			sb.append("<tr>");
			sb.append("<td><input type=\"checkbox\" name=\"check\" onChange=\"checkState(this)\" /> <img src=\"image/" + g.getGoImage() + "\"/></td>");
			sb.append("<td>"+ g.getGoName() +"</td>");
			sb.append("<td>"+ g.getGoPrice() +"</td>");
			sb.append("<td>"+ g.getQty() +"</td>");
			sb.append("<td>"+ amount +"</td>");
			sb.append("<td>"+ g.getSeName() +"</td>");
			sb.append("</tr>");
			// 전체주문
			gInfo += (g.getmId()+","+g.getGoCode()+","+g.getSeCode()+","+g.getQty()
					+(index==basket.size()? "":":")); // 마지막 주문은 끝에 : 없게 할 것
		}
		
		sb.append("<tr>");
		sb.append("<td colspan=\"6\">"+ totAmount +"</td>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("<input type=\"button\" value=\"주문하기\" onClick=\"order(\'"+ gInfo +"\')\"/>");
		
		return sb.toString();
	}
	
	private boolean insOrderDetail(GoodsBean gb) {
		return convertToBoolean(dao.insOrderDetail(gb));
	}

	private boolean insOrders(GoodsBean gb) {
		return convertToBoolean(dao.insOrders(gb));
	}
	
	private String searchOrderDate(GoodsBean gb) {
		return dao.searchOrderDate(gb);
	}

}
