package search.services.mall.icia;

import java.util.ArrayList;

import beans.GoodsBean;

public class DataAccessObject extends beans.DataAccessObject {
	
	DataAccessObject() {

	}
	
	// 전체 상품 조회
	ArrayList<GoodsBean> searchGoods(){
		ArrayList<GoodsBean> gList = null;
		
		return gList;
	}
	
	// 단어 검색 상품 조회 - word를 넘겨 받아야 함
	// *복습: 파라미터의 개수나 타입이 다르면 같은 이름의 메소드 사용 가능 = 오버로딩
	ArrayList<GoodsBean> searchGoods(GoodsBean gb){
		ArrayList<GoodsBean> gList = new ArrayList<GoodsBean>();
		String query = "SELECT * FROM GOODSINFO";
		
		try {
			this.statement = this.connection.createStatement();
			this.rs = this.statement.executeQuery(query);
			while(rs.next()) {
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return gList;
	}

}
