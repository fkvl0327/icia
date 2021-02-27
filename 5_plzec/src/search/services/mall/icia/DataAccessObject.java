package search.services.mall.icia;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.GoodsBean;

public class DataAccessObject extends beans.DataAccessObject {

	DataAccessObject() {

	}

	// 장바구니 담기
	int insBasket(GoodsBean gb) {
		int count = 0;
		String dml = "INSERT INTO BA(BA_MMID, BA_SAGOCODE, BA_SASECODE, BA_QUANTITY) VALUES(?, ?, ?, ?)";
		try {
			this.pstatement = this.connection.prepareStatement(dml);
			this.pstatement.setNString(1, gb.getmId());
			this.pstatement.setNString(2, gb.getGoCode());
			this.pstatement.setNString(3, gb.getSeCode());
			this.pstatement.setInt(4, gb.getQty());
			count = this.pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// 전체 상품 조회
	ArrayList<GoodsBean> searchGoods() {
		ArrayList<GoodsBean> gList = new ArrayList<GoodsBean>();
		String query = "SELECT GOCODE, GONAME, SECODE, PRICE, STOCK, LIMAGE FROM DBA5.GOODSINFO";

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
				goods.setGoImage(rs.getNString("LIMAGE"));

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
				goods.setGoImage(rs.getNString("LIMAGE"));

				gList.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return gList;
	}

	// 상세 상품 조회
	ArrayList<GoodsBean> getDetail(GoodsBean gb) {
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
				goods.setGoImage(rs.getNString("LIMAGE"));
				goods.setbImage(rs.getNString("BIMAGE"));

				gList.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return gList;
	}

	int updBasket(GoodsBean gb) {
		int count = 0; 
		String dml = "UPDATE BA SET BA_QUANTITY = BA_QUANTITY + ? WHERE BA_MMID = ? AND BA_SAGOCODE = ? AND BA_SASECODE = ?";
		
		try {
			this.pstatement = this.connection.prepareStatement(dml);
			this.pstatement.setInt(1, gb.getQty());
			this.pstatement.setNString(2, gb.getmId());
			this.pstatement.setNString(3, gb.getGoCode());
			this.pstatement.setNString(4, gb.getSeCode());
			count = this.pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return count;
	}
	
	// 이전에 장바구니에 담겼는지 확인
	int alreadyIs(GoodsBean gb) {
		int count = 0;
		String query = "SELECT COUNT(*) AS CNT FROM BA WHERE BA_MMID = ? AND BA_SAGOCODE = ? AND BA_SASECODE = ?";
		
		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, gb.getmId());
			this.pstatement.setNString(2, gb.getGoCode());
			this.pstatement.setNString(3, gb.getSeCode());
			this.rs = this.pstatement.executeQuery();
			while(rs.next()) {
				count = rs.getInt("CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		return count;
	}

	int insOrders(GoodsBean gb) {
		int count = 0;
		String dml = "INSERT INTO \"OR\"(OR_MMID, OR_DATE, OR_STATE) VALUES(?, DEFAULT, \'I\')";
		try {
			this.pstatement = this.connection.prepareStatement(dml);
			this.pstatement.setNString(1, gb.getmId());
			count = this.pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return count;
	}

	int insOrderDetail(GoodsBean gb) {
		int count = 0;
		String dml = "INSERT INTO OD(OD_ORMMID, OD_ORDATE, OD_SAGOCODE, OD_QUANTITY, OD_STATE, OD_SASECODE) "
				+ "VALUES(?, TO_DATE(?, \'YYYYMMDDHH24MISS\'), ?, ?, \'I\', ?)";
		try {
			this.pstatement = this.connection.prepareStatement(dml);
			this.pstatement.setNString(1, gb.getmId());
			this.pstatement.setNString(2, gb.getOrderDate());
			this.pstatement.setNString(3, gb.getGoCode());
			this.pstatement.setInt(4, gb.getQty());
			this.pstatement.setNString(5, gb.getSeCode());
			count = this.pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return count;
	}
	
	String searchOrderDate(GoodsBean gb) {
		String orderTime = null;
		String query = "SELECT TO_CHAR(MAX(OR_DATE), \'YYYYMMDDHH24MISS\') AS ORDATE FROM \"OR\" WHERE OR_MMID=?";
		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, gb.getmId());
			this.rs = this.pstatement.executeQuery();
			
			while(rs.next()) {
				orderTime = rs.getNString("ORDATE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderTime;
	}

	ArrayList<GoodsBean> getBasketList(GoodsBean gb) {
		ArrayList<GoodsBean> bList = new ArrayList<GoodsBean>();
		String query = "SELECT * FROM BL WHERE MID = ?";

		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, gb.getmId());
			this.rs = this.pstatement.executeQuery();
			while (rs.next()) {
				GoodsBean basket = new GoodsBean();
				basket.setmId(rs.getNString("MID"));
				basket.setmName(rs.getNString("MNAME"));
				basket.setGoCode(rs.getNString("GOCODE"));
				basket.setGoName(rs.getNString("GONAME"));
				basket.setGoPrice(rs.getInt("GOPRICE"));
				basket.setSeCode(rs.getNString("SECODE"));
				basket.setSeName(rs.getNString("SENAME"));
				basket.setQty(rs.getInt("QTY"));
				basket.setGoImage(rs.getNString("GOIMAGE"));
				
				bList.add(basket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return bList;
	}

	public int updOrder(GoodsBean gb) {
		int count = 0;
		String dml = "UPDATE \"OR\" SET OR_STATE = 'C' WHERE OR_MMID = ? AND OR_DATE = TO_DATE(?, \'YYYYMMDDHH24MISS\')";
		try {
			this.pstatement = this.connection.prepareStatement(dml);
			this.pstatement.setNString(1, gb.getmId());
			this.pstatement.setNString(2, gb.getOrderDate());
			count = this.pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return count;
	}

	public int updOrderDetail(GoodsBean gb) {
		int count = 0;
		String dml = "UPDATE OD SET OD_STATE = 'C' WHERE OD_ORMMID = ? AND OD_ORDATE = TO_DATE(?, \'YYYYMMDDHH24MISS\')";
		try {
			this.pstatement = this.connection.prepareStatement(dml);
			this.pstatement.setNString(1, gb.getmId());
			this.pstatement.setNString(2, gb.getOrderDate());
			count = this.pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return count;
	}

	public ArrayList<GoodsBean> orderGoodsInfo(GoodsBean gb) {
		ArrayList<GoodsBean> gList = new ArrayList<GoodsBean>();
		String query = "SELECT GOCODE, GONAME, SECODE, SENAME, PRICE, LIMAGE FROM GOODSINFO WHERE GOCODE = ? AND SECODE = ?";

		try {
			this.pstatement = this.connection.prepareStatement(query);
			this.pstatement.setNString(1, gb.getGoCode());
			this.pstatement.setNString(2, gb.getSeCode());
			this.rs = this.pstatement.executeQuery();
			while (rs.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setGoCode(rs.getNString("GOCODE"));
				goods.setGoName(rs.getNString("GONAME"));
				goods.setSeCode(rs.getString("SECODE"));
				goods.setSeName(rs.getString("SENAME"));
				goods.setGoPrice(rs.getInt("PRICE"));
				goods.setGoImage(rs.getNString("LIMAGE"));
				goods.setQty(gb.getQty());
				goods.setmId(gb.getmId());

				gList.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return gList;
	}

}
