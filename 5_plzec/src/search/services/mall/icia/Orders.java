package search.services.mall.icia;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.Action;
import beans.GoodsBean;

public class Orders {
	private DataAccessObject dao;

	public Orders() {

	}

	public Action entrance(HttpServletRequest req) {
		Action action = null;
		String reqValue = req.getRequestURI().substring(req.getContextPath().length() + 1);
		switch (reqValue) {
		case "Order":
			action = this.orderCtl(req);
			break;
		}
		return action;
	}

	private Action orderCtl(HttpServletRequest req) {
		Action action = new Action();
		boolean actionType = false;
		String page = "orderPage.jsp";
		String list;
		GoodsBean gb = new GoodsBean();

		if (req.getParameter("fromBasket")!=null) { // 장바구니를 확인하는 orderdoc.jsp에 id가 fromBasket인 hidden input을 추가해놓음
			// 장바구니 페이지에서 주문 클릭 시
			String[] gInfo = req.getParameter("gInfo").split(":");
			for (int i = 0; i < gInfo.length; i++) {
				String[] goods = gInfo[i].split(",");
				gb.setmId(goods[0]);
				gb.setGoCode(goods[1]);
				gb.setSeCode(goods[2]);
				gb.setQty(Integer.parseInt(goods[3]));
			}
		} else{
			// 상세 상품 페이지에서 주문 클릭 시
			gb.setmId(req.getParameterValues("gInfo")[0]);
			gb.setGoCode(req.getParameterValues("gInfo")[1]);
			gb.setSeCode(req.getParameterValues("gInfo")[2]);
			gb.setQty(Integer.parseInt(req.getParameterValues("gInfo")[3]));
		}

		dao = new DataAccessObject();
		dao.getConnection();

		list = this.makeHtml(this.orderGoodsInfo(gb));

		dao.closeConnection();

		req.setAttribute("orders", list);

		action.setActionType(actionType);
		action.setPage(page);
		return action;
	}

	private ArrayList<GoodsBean> orderGoodsInfo(GoodsBean gb) {
		return dao.orderGoodsInfo(gb);
	}

	// 단건 출력
	private String makeHtml(ArrayList<GoodsBean> gList) {
		StringBuffer sb = new StringBuffer();
		int totAmount = 0;
		int amount;
		int index = 0;

		String gInfo = new String();

		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td colspan=\"2\">상품정보</td>");
		sb.append("<td>가격</td>");
		sb.append("<td>수량</td>");
		sb.append("<td>금액</td>");
		sb.append("<td>판매자</td>");
		sb.append("</tr>");

		for (GoodsBean g : gList) {
			index++;
			amount = g.getGoPrice() * g.getQty();
			totAmount += amount;
			sb.append("<tr>");
			sb.append("<td><img src=\"image/" + g.getGoImage() + "\"/></td>");
			sb.append("<td>" + g.getGoName() + "</td>");
			sb.append("<td>" + g.getGoPrice() + "</td>");
			sb.append("<td>" + g.getQty() + "</td>");
			sb.append("<td>" + amount + "</td>");
			sb.append("<td>" + g.getSeName() + "</td>");
			sb.append("</tr>");
			// 전체주문
			gInfo += (g.getmId() + "," + g.getGoCode() + "," + g.getSeCode() + "," + g.getQty()
					+ (index == gList.size() ? "" : ":")); // 마지막 주문은 끝에 : 없게 할 것
		}

		sb.append("<tr>");
		sb.append("<td colspan=\"6\">" + totAmount + "</td>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("<input type=\"button\" value=\"결제하기\" onClick=\"order(\'" + gInfo + "\')\"/>");

		return sb.toString();
	}

}
