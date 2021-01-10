package search.services.mall.icia;

import java.util.ArrayList;

import beans.GoodsBean;

public class DataAccessObject extends beans.DataAccessObject {

	DataAccessObject() {

	}

	// 전체 상품 조회
	ArrayList<GoodsBean> searchGoods() {
		ArrayList<GoodsBean> gList = new ArrayList<GoodsBean>();
		String query = "SELECT GOCODE, GONAME, SECODE, PRICE, STOCK, LIMAGE FROM GOODSINFO";

		try {
			this.statement = this.connection.createStatement();
			this.rs = this.statement.executeQuery(query);
			while (rs.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setGoCode(rs.getNString("GOCODE"));
				goods.setGoName(rs.getNString("GONAME"));
				goods.setGoPrice(rs.getInt("PRICE"));
				goods.setGoStock(rs.getInt("STOCK"));
				goods.setSeCode(rs.getString("SECODE"));
				goods.setImage(rs.getNString("LIMAGE"));

				gList.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return gList;
	}

	// 단어 검색 상품 조회 - word를 넘겨 받아야 함
	// *복습: 파라미터의 개수나 타입이 다르면 같은 이름의 메소드 사용 가능 = 오버로딩
	ArrayList<GoodsBean> searchGoods(GoodsBean gb) {
		ArrayList<GoodsBean> gList = new ArrayList<GoodsBean>();
		String query = "SELECT GOCODE, GONAME, SECODE, PRICE, STOCK, LIMAGE FROM GOODSINFO WHERE SEARCH LIKE '%' || ? || '%'";

		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, gb.getWord());
			this.rs = this.pstatement.executeQuery();
			while (rs.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setGoCode(rs.getNString("GOCODE"));
				goods.setGoName(rs.getNString("GONAME"));
				goods.setGoPrice(rs.getInt("PRICE"));
				goods.setGoStock(rs.getInt("STOCK"));
				goods.setSeCode(rs.getString("SECODE"));
				goods.setImage(rs.getNString("LIMAGE"));

				gList.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return gList;
	}

	// 상세 상품 조회
	ArrayList<GoodsBean> goodsDetail(GoodsBean gb) {
		ArrayList<GoodsBean> gList = new ArrayList<GoodsBean>();
		String query = "SELECT GOCODE, GONAME, SECODE, PRICE, STOCK, LIMAGE, BIMAGE, SENAME FROM GOODSINFO WHERE GOCODE=? AND SECODE=?";

		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, gb.getGoCode());
			this.pstatement.setNString(2, gb.getSeCode());
			this.rs = this.pstatement.executeQuery();
			while (rs.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setGoCode(rs.getNString("GOCODE"));
				goods.setGoName(rs.getNString("GONAME"));
				goods.setGoPrice(rs.getInt("PRICE"));
				goods.setGoStock(rs.getInt("STOCK"));
				goods.setSeCode(rs.getString("SECODE"));
				goods.setSeName(rs.getNString("SENAME"));
				goods.setImage(rs.getNString("LIMAGE"));
				goods.setbImage(rs.getNString("BIMAGE"));

				gList.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return gList;
	}

}
