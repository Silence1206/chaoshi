package com.accp.shop.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accp.shop.connection.Connect;
import com.accp.shop.pojo.*;

/**
 * 2007-12-3
 * 版本1.0
 * @author 孔国安
 *
 */
public class providerDAO {
	Connection con = null;

	/**
	 * 查询（模糊和精确）
	 * @param type 类型
	 * @param comp 模糊或精确
	 * @param value 查询的条件值
	 * @return
	 */
	public ArrayList seletepro(String type, String comp, String value) {
		ResultSet rs;
		ArrayList lt = new ArrayList();
		provider pro;
		try {
			con = Connect.getConnection();
		} catch (Exception e) {

		}
		if(!comp.equals("like")){
			System.out.print(comp.equals("like"));
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from provider where "+type+"=?");
			pstmt.setString(1, value);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pro = new provider();
				pro.setPro_Id(rs.getString(1));
				pro.setPro_Name(rs.getString(2));
				pro.setPro_Tel(rs.getString(3));
				pro.setPro_Address(rs.getString(4));
				pro.setCargo_Type(rs.getString(5));
				pro.setPro_Date(rs.getString(6));
				lt.add(pro);
			}
			return lt;
		} catch (SQLException ex) {
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}else{
			try {
				PreparedStatement pstmt = con
						.prepareStatement("select * from provider where "+type+" like ?");
				value="%"+value+"%";
				pstmt.setString(1, value);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					pro = new provider();
					pro.setPro_Id(rs.getString(1));
					pro.setPro_Name(rs.getString(2));
					pro.setPro_Tel(rs.getString(3));
					pro.setPro_Address(rs.getString(4));
					pro.setCargo_Type(rs.getString(5));
					pro.setPro_Date(rs.getString(6));
					lt.add(pro);
				}
				return lt;
			} catch (SQLException ex) {
				return null;
			} finally {
				try {
					if (con != null) {
						con.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
//
	/**
	 * 返回所有指定类型的供应商信息
	 * @param type
	 * @return
	 */
	public ArrayList type(String type) {
		ResultSet rs;
		ArrayList lt = new ArrayList();
		provider pro;
		try {
			con = Connect.getConnection();
		} catch (Exception e) {

		}
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from provider where Cargo_Type=?");
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pro = new provider();
				pro.setPro_Id(rs.getString(1));
				pro.setPro_Name(rs.getString(2));
				pro.setPro_Tel(rs.getString(3));
				pro.setPro_Address(rs.getString(4));
				pro.setCargo_Type(rs.getString(5));
				pro.setPro_Date(rs.getString(6));
				lt.add(pro);
			}
			return lt;
		} catch (SQLException ex) {
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
//
	/**
	 * 添加新的供应商
	 * @param pro
	 * @throws SQLException
	 */
	public void newpro(provider pro)throws SQLException {
		try {
			con = Connect.getConnection();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {

			PreparedStatement pstmt = con
					.prepareStatement("insert into provider (Pro_ID,Pro_Name,Pro_Tel,Pro_Address,Cargo_Type,Pro_Date) VALUES (?,?,?,?,?,?)");

			pstmt.setString(1, pro.getPro_Id());
			pstmt.setString(2, pro.getPro_Name());
			pstmt.setString(3, pro.getPro_Tel());
			pstmt.setString(4, pro.getPro_Address());
			pstmt.setString(5, pro.getCargo_Type());			
			pstmt.setDate(6, new java.sql.Date(System.currentTimeMillis()));
			pstmt.executeUpdate();
		} catch (SQLException eb) {
			throw eb;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
//
	/**
	 * 更新修改过的信息
	 * @param pro
	 * @param id
	 */
	public void update(provider pro, String id) {
		ResultSet rs;

		// provider pro = new provider();
		try {
			con = Connect.getConnection();
		} catch (Exception e) {

		}
		try {

			PreparedStatement pstmt = con
					.prepareStatement("update provider set Pro_Name=?,Pro_Tel=?,Pro_Address=?,Cargo_Type=?,Pro_Date=?  where Pro_ID=? ");

			pstmt.setString(1, pro.getPro_Name());
			pstmt.setString(2, pro.getPro_Tel());
			pstmt.setString(3, pro.getPro_Address());
			pstmt.setString(4, pro.getCargo_Type());
			pstmt.setString(5, pro.getPro_Date());
			pstmt.setString(6, id);

			// pstmt.executeUpdate();
			// pstmt.execute();
			//			
			int c = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (con != null)
					con.close();
			} catch (Exception e2) {
			}
		}
	}
//返回要修该的供应商信息
	public ArrayList edit(String id) {
		ResultSet rs;
		ArrayList lt = new ArrayList();
		provider pro;
		try {
			con = Connect.getConnection();
		} catch (Exception e) {

		}
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from provider where Pro_ID=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pro = new provider();
				pro.setPro_Id(rs.getString(1));
				pro.setPro_Name(rs.getString(2));
				pro.setPro_Tel(rs.getString(3));
				pro.setPro_Address(rs.getString(4));
				pro.setCargo_Type(rs.getString(5));
				pro.setPro_Date(rs.getString(6));
				lt.add(pro);
			}
			return lt;
		} catch (SQLException ex) {
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
//删除指定供应商
	public void delectPro(provider pro) {
		try {
			con = Connect.getConnection();

		} catch (Exception ex) {

		}
		try {

			PreparedStatement pstmt = con
					.prepareStatement("delete From provider Where Pro_ID=?");

			pstmt.setString(1, pro.getPro_Id());

			pstmt.execute();

		} catch (SQLException eb) {
			eb.printStackTrace();

		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) {
			}
		}
	}

	// 显示所有供应商信息
	public ArrayList login(provider pro) {
		ResultSet rs;
		ArrayList lt = new ArrayList();
		try {
			con = Connect.getConnection();
		} catch (Exception e) {

		}
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from provider");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pro = new provider();
				pro.setPro_Id(rs.getString(1));
				pro.setPro_Name(rs.getString(2));
				pro.setPro_Tel(rs.getString(3));
				pro.setPro_Address(rs.getString(4));
				pro.setCargo_Type(rs.getString(5));
				pro.setPro_Date(rs.getString(6));
				lt.add(pro);
			}
			return lt;
		} catch (SQLException ex) {
			return null;
		}

	}
}
