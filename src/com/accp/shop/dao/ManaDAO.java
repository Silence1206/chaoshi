package com.accp.shop.dao;

import java.sql.*;
import java.util.*;
import com.accp.shop.pojo.*;
import com.accp.shop.connection.*;


/**
 * 2007-12-3
 *  版本1.0
 * @author 孔国安
 *
 */
public class ManaDAO {

	private Connection con;
	String Sql = "select * from manager";

	String checkSql = "select * from manager where Mana_Name=? and Mana_PWD=?";

	String newMana = "insert into manager (Mana_Name,Mana_PWD,Popedom,Mana_Sex,Mana_Age,Mana_DepID,Mana_Tel,Mana_Address) VALUES (?,?,?,?,?,?,?,?)";

	String editMana = "select * from manager where Mana_Name=?";
String manaUpdate="update manager set Mana_PWD=?,Popedom=?,Mana_Sex=?,Mana_Age=?,Mana_DepID=?,Mana_Tel=?,Mana_Address=?  where Mana_Name=?";
	public ManaDAO() {

	}
	
	/**
	 * 更新修改过的管理员信息
	 * @param mana
	 * @param name
	 */
	public void manaUpdate(Manager mana ,String name){
		try {
			con = Connect.getConnection();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {

			PreparedStatement ptmt = con
					.prepareStatement(manaUpdate);

		
		ptmt.setString(1,mana.getMana_pwd());
		ptmt.setString(2,mana.getPopedom());
		ptmt.setString(3, mana.getMana_sex());
		ptmt.setString(4,mana.getMana_age());
		ptmt.setString(5,mana.getMana_dep());
		ptmt.setString(6,mana.getMana_tel());
		ptmt.setString(7,mana.getMana_address());
		ptmt.setString(8,name);
			int i=ptmt.executeUpdate();

		} catch (SQLException eb) {
			eb.printStackTrace();
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
 * 返回需要编辑管理员的信息
 * @param name 
 * @return 
 */
public ArrayList editMana(String name){
	Manager mana = null;
	ArrayList list = new ArrayList();
	ResultSet rs = null;
	try {
		con = Connect.getConnection();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	try {
		PreparedStatement ptmt = con.prepareStatement(editMana);
		ptmt.setString(1,name);
		rs = ptmt.executeQuery();
		while (rs.next()) {
			mana = new Manager();
			mana.setMana_name(rs.getString(1));
			mana.setMana_pwd(rs.getString(2));
			mana.setPopedom(rs.getString(3));
			mana.setMana_sex(rs.getString(4));
			mana.setMana_age(rs.getString(5));
			mana.setMana_dep(rs.getString(6));
			mana.setMana_tel(rs.getString(7));
			mana.setMana_address(rs.getString(8));
			list.add(mana);
		}
		return list;
	} catch (Exception ex) {
		ex.printStackTrace();
		return null;
	} finally {
		try {
			if (con != null)
				con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
	/**
	 * 删除指定管理员
	 * @param mana
	 */
	public void deleinfo(Manager mana) {
		try {
			con = Connect.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			PreparedStatement ptmt = con
					.prepareStatement("delete from manager where Mana_Name=?");
			ptmt.setString(1, mana.getMana_name());
			ptmt.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 判断用户名是否存在
	 * @param mana_Name
	 * @param mana_PWD
	 * @return
	 */
	public Manager Check(String mana_Name, String mana_PWD) {
		Manager mana = new Manager();
		try {
			con =  Connect.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {

			PreparedStatement ptmt = con.prepareStatement(checkSql);
			ptmt.setString(1, mana_Name);
			ptmt.setString(2, mana_PWD);
			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) {
				mana.setMana_name(rs.getString(1));
				mana.setPopedom(rs.getString(3));

				return mana;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}


	
	/**
	 * 返回所有管理员信息
	 * @return
	 */
	public ArrayList getInfo() {
		Manager mana = null;
		ArrayList list = new ArrayList();
		ResultSet rs = null;
		try {
			con = Connect.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			PreparedStatement ptmt = con.prepareStatement(Sql);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				mana = new Manager();
				mana.setMana_name(rs.getString(1));
				mana.setMana_pwd(rs.getString(2));
				mana.setPopedom(rs.getString(3));
				mana.setMana_sex(rs.getString(4));
				mana.setMana_age(rs.getString(5));
				mana.setMana_dep(rs.getString(6));
				mana.setMana_tel(rs.getString(7));
				mana.setMana_address(rs.getString(8));
				list.add(mana);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	/**
	 * 增加管理员
	 * @param mana
	 * @throws SQLException
	 */
	public void newManager(Manager mana) throws SQLException {
		try {
			con =  Connect.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {

			PreparedStatement ptmt = con.prepareStatement(newMana);
			ptmt.setString(1, mana.getMana_name());
			ptmt.setString(2, mana.getMana_pwd());
			ptmt.setInt(3, 2);
			ptmt.setString(4, mana.getMana_sex());
			ptmt.setString(5, mana.getMana_age());
			ptmt.setString(6, mana.getMana_dep());
			ptmt.setString(7, mana.getMana_tel());
			ptmt.setString(8, mana.getMana_address());
			int a = ptmt.executeUpdate();

		} catch (SQLException ex) {
			throw ex;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
