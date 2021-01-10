package search.services.mall.icia;

import java.util.ArrayList;

import beans.GoodsBean;

class DataAccessObject extends beans.DataAccessObject{
	
	DataAccessObject(){

	}

	//전체상품조회
	ArrayList<GoodsBean> searchGoods(){
		ArrayList<GoodsBean> gList = new ArrayList<GoodsBean>();
		String query = "SELECT GOCODE, GONAME, SECODE, "
				+ "PRICE, STOCK, LIMAGE FROM GOODSINFO";
		
		try {
			this.statement = this.connection.createStatement();
			this.rs = this.statement.executeQuery(query);
			while(rs.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setGoCode(rs.getNString("GOCODE"));
				goods.setGoName(rs.getNString("GONAME"));
				goods.setGoPrice(rs.getInt("PRICE"));
				goods.setGoStock(rs.getInt("STOCK"));
				goods.setGoImage(rs.getNString("LIMAGE"));
				goods.setSeCode(rs.getNString("SECODE"));
				gList.add(goods);
			}
		}catch(Exception e) {e.printStackTrace();}
		
		return gList;
	}
	
	//단어 검색 상품 조회
	ArrayList<GoodsBean> searchGoods(GoodsBean gb){
		ArrayList<GoodsBean> gList = new ArrayList<GoodsBean>();
		String query = "SELECT GOCODE, GONAME, SECODE, " + 
				    "PRICE, STOCK, LIMAGE FROM GOODSINFO "
				    + "WHERE SEARCH LIKE '%'||?||'%'";

		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, gb.getWord());
						
			this.rs = this.pstatement.executeQuery();
			while(rs.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setGoCode(rs.getNString("GOCODE"));
				goods.setGoName(rs.getNString("GONAME"));
				goods.setGoPrice(rs.getInt("PRICE"));
				goods.setGoStock(rs.getInt("STOCK"));
				goods.setGoImage(rs.getNString("LIMAGE"));
				goods.setSeCode(rs.getNString("SECODE"));
				gList.add(goods);
			}
		}catch(Exception e) {e.printStackTrace();}
		
		return gList;
	}
		
	// 상세정보 검색
	ArrayList<GoodsBean> getDetail(GoodsBean gb){
		ArrayList<GoodsBean> gList = new ArrayList<GoodsBean>();
		String query = "SELECT GOCODE, GONAME, SECODE, PRICE, STOCK, "
				+ "LIMAGE, BIMAGE, SENAME "
				+ "FROM GOODSINFO "
				+ "WHERE GOCODE=? AND SECODE=?";
		
		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, gb.getGoCode());
			this.pstatement.setNString(2, gb.getSeCode());
			
			this.rs = this.pstatement.executeQuery();
			while(rs.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setGoCode(rs.getNString("GOCODE"));
				goods.setGoName(rs.getNString("GONAME"));
				goods.setGoPrice(rs.getInt("PRICE"));
				goods.setGoStock(rs.getInt("STOCK"));
				goods.setGoImage(rs.getNString("LIMAGE"));
				goods.setGoBimage(rs.getNString("BIMAGE"));
				goods.setSeCode(rs.getNString("SECODE"));
				goods.setSeName(rs.getNString("SENAME"));
				gList.add(goods);
			}
		}catch(Exception e) {e.printStackTrace();}
		
		return gList;
	}
}
