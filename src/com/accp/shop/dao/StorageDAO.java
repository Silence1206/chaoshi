package com.accp.shop.dao;

import com.accp.shop.connection.*;
import com.accp.shop.pojo.IDExistPojo;
import com.accp.shop.pojo.StoragePojo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StorageDAO {
	Connection conn = null;

	PreparedStatement pstmt = null;

	ResultSet rs = null;

	//String sql = "select sell.Cargo_ID,sell.Sell_Num,sell.Sell_Price,storage.Cargo_Num from sell,storage where sell.Cargo_ID=storage.Cargo_ID";
//库存信息的显示
	public List storage() {
		String sql="select cargo.Cargo_ID,Cargo_Name,Cargo_Type,Storage_Num from cargo,storage where cargo.Cargo_ID=storage.Cargo_ID";
		ArrayList alist = new ArrayList();
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				StoragePojo ad=new StoragePojo();
				ad.setCargo_id(rs.getString(1));
				ad.setCargo_name(rs.getString(2));
				ad.setCargo_type(rs.getString(3));
				ad.setStorage_num(rs.getInt(4));
				alist.add(ad);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return alist;

	}
	//将上架商品的数量和价格存到数据库里
	public void addSell_Num(String id,int sellNum,double price, int addNum,int storageNum){
		String sql="update sell,storage set Sell_Num=?,Sell_Price=?,Storage_Num=? where sell.Cargo_ID=storage.Cargo_ID and sell.Cargo_ID=?";
		try{
			conn=Connect.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sellNum+addNum);
			pstmt.setDouble(2, price);
			pstmt.setInt(3, storageNum-addNum);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	//判断商品编号是否存在
	public boolean checkID(String id){
		String sql="select sell.Cargo_ID,Sell_Num,Sell_Price from sell where sell.Cargo_ID=?";
		conn=Connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	//商品编号存在，返回商品的信息
	public ArrayList IDIsExist(String id){
		String sql="select sell.Cargo_ID,Sell_Num,Sell_Price,Storage_Num from sell,storage where sell.Cargo_ID=storage.Cargo_ID and  sell.Cargo_ID=?";
		ArrayList idExist=new ArrayList();
		conn=Connect.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				IDExistPojo exist=new IDExistPojo();
				exist.setCargo_id(rs.getString(1));
				exist.setSell_num(rs.getInt(2));
				exist.setSell_price(rs.getDouble(3));
				exist.setStorage_num(rs.getInt(4));
				idExist.add(exist);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return idExist;
	}
	//返回库存数量
	public int getStorageNum(String id){
		String sql="select Cargo_ID,Storage_Num from storage where Cargo_ID=?";
		int storageNum=0;
		conn=Connect.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			rs.next();
			storageNum=rs.getInt(2);
				
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
//		System.out.println(storageNum);
		return storageNum;
	}
	//商品编号不存在于sell表的上架方法
	public void idNotExistOnSell(String id, String cargoName, String cargoType, int addNum, double price, int storageNum){
//		String insertCargo="insert into cargo values(?,?,?)";
		String insertSell="insert into sell values(?,?,?)";
		String updateStorage="update storage set Storage_Num=? where Cargo_ID=?";
		try{
		
		conn=Connect.getConnection();
		conn.setAutoCommit(false);
//		pstmt=conn.prepareStatement(insertCargo);
//		pstmt.setString(1, id);
//		pstmt.setString(2, cargoName);
//		pstmt.setString(3, cargoType);
//		pstmt.executeUpdate();
		
		pstmt=conn.prepareStatement(insertSell);
		pstmt.setString(1, id);
		pstmt.setInt(2, addNum);
		pstmt.setDouble(3, price);
		pstmt.executeUpdate();
		
		pstmt=conn.prepareStatement(updateStorage);
		pstmt.setInt(1, storageNum-addNum);
		pstmt.setString(2,id);
		pstmt.executeUpdate();
		
		conn.commit();
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
