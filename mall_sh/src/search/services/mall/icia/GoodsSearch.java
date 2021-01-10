package search.services.mall.icia;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Action;
import beans.GoodsBean;

public class GoodsSearch {
	private DataAccessObject dao;
	public GoodsSearch() {
		
	}
	
	public Action entrance(HttpServletRequest req, String reqValue) {
		Action action = null;
		
		switch(reqValue) {
		case "Search":
			action = this.searchCtl(req);
			break;
		case "GoodsDetail" :
			action = this.goodsDetailCtl(req);
			break;
		}

		return action;

	}
	
	private Action goodsDetailCtl(HttpServletRequest req) {
		System.out.println("goodsDetail 진입");
		Action action = new Action();
		GoodsBean gb = new GoodsBean();
		dao = new DataAccessObject();
		
		ArrayList<GoodsBean> goodsInfo;
		String page ="goodsDetail.jsp";
		boolean actionT = false;
		
		gb.setGoCode(req.getParameterValues("code")[0]);
		gb.setSeCode(req.getParameterValues("code")[1]);
		
		System.out.println(gb.getGoCode());
		System.out.println(gb.getSeCode());
		
		dao.getConnection();
		
		goodsInfo=this.goDetails(gb);
		if(goodsInfo.size() != 1) {
			page = "goods.jsp";
			actionT = false;
			req.setAttribute("gList", this.makeGoodslist((gb.getWord()==null)? this.searchGoods() : this.searchGoods(gb)));
			req.setAttribute("message", "죄송합니다. 품절 상태입니다.");
		}else {
			
			
			req.setAttribute("goodsImage", "image/"+goodsInfo.get(0).getGoImage());
			req.setAttribute("item", goodsInfo.get(0).getGoName());
			req.setAttribute("price", goodsInfo.get(0).getGoPrice());
			req.setAttribute("gInfo", req.getSession().getAttribute("accessInfo")+":"+
										goodsInfo.get(0).getGoCode()+":"+
										goodsInfo.get(0).getSeCode());
			req.setAttribute("seller", goodsInfo.get(0).getSeName());
			req.setAttribute("detailImage", "image/"+goodsInfo.get(0).getGoBimage());
		}
		
		dao.closeConnection();
		
		action.setActionType(actionT);
		action.setPage(page);
		
		return action;
	}

	private Action searchCtl(HttpServletRequest req) {
		System.out.println("search 진입");
		Action action = new Action();
		GoodsBean gb = new GoodsBean();
		dao = new DataAccessObject();
		
		ArrayList<GoodsBean> gList;
		String page ="goods.jsp";
		boolean actionT = false;
		
		dao.getConnection();
		dao.setAutoCommit(false);
		
		//req --> GoodsBean
		gb.setWord(req.getParameter("word"));
		
		
		System.out.println(gb.getWord());
		
		//상품조회
		gList =(gb.getWord().equals(""))? this.searchGoods() : this.searchGoods(gb);
		String result =this.makeGoodslist(gList);
		
		
		//connection 생성

		
		dao.setAutoCommit(true);
		dao.closeConnection();
		
		System.out.println("glist 설정");
		req.setAttribute("gList", result);
		System.out.println(gList.get(0).getGoName());
		
		
		//action 설정
		action.setActionType(actionT);
		action.setPage(page);
		
		System.out.println("액션값 주고 리턴");
		return action;
	}
	
	private String makeGoodslist(ArrayList<GoodsBean> gList) {
		StringBuffer sb = new StringBuffer();
		String code =null;
		
		int i=0;
		for(GoodsBean g:gList) {
			code =g.getGoCode()+":"+g.getSeCode();
			
			i++;
			if(i%3 ==1) {
				sb.append("<div class=\"line\">");
				
			}
			sb.append("<div class=\"item\" onClick=\"goDetail("+"\'"+code+"\'"+")\">");
			sb.append("<div class=\"item__top\"><img src=\"image/"+ g.getGoImage() + "\" /></div>");
            sb.append("<div class=\"item__bottom\"><div class=\"item-name\">"+ g.getGoName() + "</div>"
            		+ "<div class=\"item-price\">" + g.getGoPrice() +"원</div>"
            		+ "<div class=\"item-stock\">재고 "+ g.getGoStock() + "&nbsp;&nbsp;&nbsp;무료배송</div></div>");
            sb.append("</div>");
            
			
			if(i%3 ==0) {sb.append("</div>");
						 }
		}
		
		if(i%3 !=0) {sb.append("</div>");
						}

		
		
		return sb.toString();
		
	}
	
	private ArrayList<GoodsBean> goDetails(GoodsBean gb) {
		System.out.println("상품 상세 조회 진입");
		return dao.goDetails(gb);
	}
	private ArrayList<GoodsBean> searchGoods(){
		System.out.println("전체상품 조회 진입");
		ArrayList<GoodsBean> gList = dao.searchGoods();
		return dao.searchGoods();
	}
	private ArrayList<GoodsBean> searchGoods(GoodsBean gb) {
		System.out.println("개별 상품 조회 진입");
		
		return dao.searchGoods(gb);
	}

}
