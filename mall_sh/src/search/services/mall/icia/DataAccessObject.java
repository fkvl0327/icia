package search.services.mall.icia;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.GoodsBean;

class DataAccessObject extends beans.DataAccessObject{
	
	
	DataAccessObject(){
		
	}
	
	//전체 상품 조회 메서드
	ArrayList<GoodsBean> searchGoods(){
		ArrayList<GoodsBean> gList = new ArrayList();
		
		String query = "select GOCODE, GONAME, LIMAGE, SECODE, PRICE, STOCK from GOODSINFO";
		
		try {
			this.statement=this.connection.createStatement();
			this.rs = this.statement.executeQuery(query);
			while(rs.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setGoCode(rs.getNString("GOCODE"));
				goods.setGoName(rs.getNString("GONAME"));
				goods.setGoPrice(rs.getInt("price"));
				goods.setGoStock(rs.getInt("STOCK"));
				goods.setGoImage(rs.getNString("LIMAGE"));
				goods.setSeCode(rs.getNString("SECODE"));
				
			
				gList.add(goods);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return gList;
	}
	
	
	ArrayList<GoodsBean> goDetails(GoodsBean gb){
		System.out.println("DAO goDetails진입");
		ArrayList<GoodsBean> gList = new ArrayList();
		
		String query = "select GOCODE, GONAME, SECODE, PRICE, STOCK, "
				+ "LIMAGE, BIMAGE, SENAME "
				+ "from GOODSINFO where GOCODE=? and SECODE=?";
		
		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, gb.getGoCode());
			this.pstatement.setNString(2, gb.getSeCode());
			
			this.rs=this.pstatement.executeQuery();
			
			while(rs.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setGoCode(rs.getNString("GOCODE"));
				goods.setGoName(rs.getNString("GONAME"));
				goods.setGoPrice(rs.getInt("price"));
				goods.setGoStock(rs.getInt("STOCK"));
				goods.setSeCode(rs.getNString("SECODE"));
				goods.setSeName(rs.getNString("SENAME"));
				goods.setGoImage(rs.getNString("LIMAGE"));
				goods.setGoBimage(rs.getNString("BIMAGE"));
				gList.add(goods);
			}
			
			System.out.println(gList.size());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return gList;
	}
	
	void searchImage(GoodsBean gb) {
		String query = "SELECT SI_IMAGE AS IMAGE FROM SI";
	
		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, gb.getGoCode());
			this.pstatement.setNString(2, gb.getSeCode());
			
			this.rs=this.pstatement.executeQuery();
			
			while(rs.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setGoImage(rs.getNString("IMAGE"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	void searchImage(ArrayList<GoodsBean> gList) {
		String query = "SELECT SI_SAGOCODE AS GOCODE, SI_SASECODE AS SECODE, SI_SAIMAGE AS IMAGE FROM SI";
		
		try {
			this.pstatement = this.connection.prepareStatement(query);
		
			this.rs=this.pstatement.executeQuery();
			
			while(rs.next()) {
				for(int i =0;i<gList.size();i++) {
					if(gList.get(i).getGoCode().equals(rs.getNString("GOCODE"))) {
						if(gList.get(i).getGoCode().equals(rs.getNString("SECODE"))) {
							gList.get(i).setGoImage(rs.getNString("IMAGE"));
						}
					}
				}
			}
			
			System.out.println(gList.size());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//단어검색 상품 조회 메서드
	ArrayList<GoodsBean> searchGoods(GoodsBean gb){
		System.out.println("searchGoods진입");
		ArrayList<GoodsBean> gList = new ArrayList();
			
		String query = "SELECT * FROM GOODSINFO WHERE SEARCH LIKE ? ";
		
		
		try {
			this.pstatement = this.connection.prepareStatement(query);
			System.out.println(gb.getWord());
			this.pstatement.setNString(1, "%"+gb.getWord()+"%");
			
			this.rs=this.pstatement.executeQuery();
			
			while(rs.next()) {
				GoodsBean goods = new GoodsBean();
				
				goods.setGoCode(rs.getNString("GOCODE"));
				goods.setGoName(rs.getNString("GONAME"));
				goods.setGoPrice(rs.getInt("price"));
				goods.setGoStock(rs.getInt("STOCK"));
				goods.setGoImage(rs.getNString("LIMAGE"));
				goods.setSeCode(rs.getNString("SECODE"));
				goods.setSeName(rs.getNString("SENAME"));
				goods.setGoBimage(rs.getNString("BIMAGE"));
				gList.add(goods);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return gList;
	}
}
