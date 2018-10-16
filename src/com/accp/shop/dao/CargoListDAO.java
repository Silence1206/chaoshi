package com.accp.shop.dao;

import com.accp.shop.pojo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.accp.shop.connection.*;
import com.accp.shop.pojo.CargoListPojo;

/**
 * @author 刑鹏飞
 *
 */
public class CargoListDAO {
	Connection conn = null;

	PreparedStatement pstmt = null;

	ResultSet rs = null;

	
	/**
	 *  获得所有商品的信息
	 * @return
	 */
	public List getCargoList() {
		String sql = "Select cargo.Cargo_ID, cargo.Cargo_Name, cargo.Cargo_Type, sell.Sell_Num, sell.Sell_Price From cargo, sell Where cargo.Cargo_ID = sell.Cargo_ID";
		ArrayList array = new ArrayList();
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CargoListPojo CPojo = new CargoListPojo();
				CPojo.setCargo_id(rs.getString(1));
				CPojo.setCargo_name(rs.getString(2));
				CPojo.setCargo_type(rs.getString(3));
				CPojo.setSell_num(rs.getInt(4));
				CPojo.setSell_price(rs.getDouble(5));
				array.add(CPojo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return array;

	}

	
	/**
	 * 返回编辑商品信息
	 * @param id
	 * @return
	 */
	public ArrayList eidtCargoInf(String id) {
		String sql = "Select cargo.Cargo_ID, cargo.Cargo_Name, cargo.Cargo_Type, sell.Sell_Num, sell.Sell_Price From cargo, sell Where cargo.Cargo_ID = sell.Cargo_ID and cargo.Cargo_ID=?";
		ArrayList list = new ArrayList();
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CargoListPojo CPojo = new CargoListPojo();
				CPojo.setCargo_id(rs.getString(1));
				CPojo.setCargo_name(rs.getString(2));
				CPojo.setCargo_type(rs.getString(3));
				CPojo.setSell_num(rs.getInt(4));
				CPojo.setSell_price(rs.getDouble(5));
				
				list.add(CPojo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;

	}

	
	/**
	 * 在数据库中更新数据
	 * @param id
	 * @param name
	 * @param type
	 * @param num
	 * @param price
	 */
	public void updateCargoInf(String id, String name, String type, int num,
			double price) {
		String updateCargo = "update cargo set Cargo_Name=?,Cargo_Type=? where Cargo_ID=? ";
		String updateSell = "update sell set Sell_Num=?,Sell_Price=? where Cargo_ID=?";
		try {
			conn = Connect.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(updateCargo);
			pstmt.setString(1, name);
			pstmt.setString(2, type);
			pstmt.setString(3, id);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement(updateSell);
			pstmt.setInt(1, num);
			pstmt.setDouble(2, price);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	 
	/**
	 * 删除商品信息
	 * @param id
	 */
	public void deleteInf(String id) {

		String delSell = "delete from sell where Cargo_ID=?";
		try {
			conn = Connect.getConnection();
			conn.setAutoCommit(false);



			pstmt = conn.prepareStatement(delSell);
			pstmt.setString(1, id);
			pstmt.executeUpdate();

			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	/**
	 * 模糊查询
	 * @param inf
	 * @return
	 */
	public ArrayList blurSearch(String inf) {

		String sql = "Select cargo.Cargo_ID, cargo.Cargo_Name, cargo.Cargo_Type, sell.Sell_Num, sell.Sell_Price From cargo, sell Where cargo.Cargo_ID = sell.Cargo_ID and (cargo.Cargo_ID like ? or cargo.Cargo_Name like ? or cargo.Cargo_Type like ? or sell.Sell_Num like ? or sell.Sell_Price like ?)";
		ArrayList arry = new ArrayList();
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + inf + "%");
			pstmt.setString(2, "%" + inf + "%");
			pstmt.setString(3, "%" + inf + "%");
			pstmt.setString(4, "%" + inf + "%");
			pstmt.setString(5, "%" + inf + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CargoListPojo cargoInf = new CargoListPojo();
				cargoInf.setCargo_id(rs.getString(1));
				cargoInf.setCargo_name(rs.getString(2));
				cargoInf.setCargo_type(rs.getString(3));
				cargoInf.setSell_num(rs.getInt(4));
				cargoInf.setSell_price(rs.getDouble(5));

				arry.add(cargoInf);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return arry;
	}

	
	/**
	 * 精确查询
	 * @param type
	 * @param inf
	 * @return
	 */
	public ArrayList rigourSearch(String type, String inf) {
		String sql = "Select cargo.Cargo_ID, cargo.Cargo_Name, cargo.Cargo_Type, sell.Sell_Num, sell.Sell_Price From cargo, sell Where cargo.Cargo_ID = sell.Cargo_ID and "
				+ type + "=" + "'" + inf + "'";
		ArrayList array = new ArrayList();
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			// pstmt.setString(1, inf);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CargoListPojo cargo = new CargoListPojo();
				cargo.setCargo_id(rs.getString(1));
				cargo.setCargo_name(rs.getString(2));
				cargo.setCargo_type(rs.getString(3));
				cargo.setSell_num(rs.getInt(4));
				cargo.setSell_price(rs.getDouble(5));
				array.add(cargo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return array;
	}
}
