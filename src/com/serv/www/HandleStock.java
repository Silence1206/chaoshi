package com.serv.www;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandleStock extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){}
	}
	@SuppressWarnings({ })
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("gb2312");
		resp.setCharacterEncoding("gb2312");
		String uri="jdbc:mysql://localhost/chaoshi?user=root&password=12345678";
		Stock userBean=new Stock();
		req.setAttribute("userBean", userBean);
		String shopname=req.getParameter("shopname").trim();
		String stockprice=req.getParameter("stockprice").trim();
		String stocknum=req.getParameter("stocknum").trim();
		String date=req.getParameter("date").trim();
		String address=req.getParameter("address").trim();
		String cashier=req.getParameter("cashier").trim();
		Connection conn,con=null;
		PreparedStatement sql;
		Statement sq;
		ResultSet rs;
		String backNews="";
		try {
			conn=DriverManager.getConnection(uri);
			sq=conn.createStatement();
			String cdn="select stocknum,last from shangpin where shopname='"+shopname+"'";
			rs=sq.executeQuery(cdn);
			//System.out.print(cdn);
			if(rs.next()){
				int stockn=Integer.valueOf(rs.getString(1));
				int stocknu=Integer.valueOf(stocknum);
				int last=Integer.valueOf(rs.getString(2));
				String cd="update shangpin set last="+(last+stocknu)+",stocknum="+(stocknu+stockn)+" where shopname='"+shopname+"'";
				int m=sq.executeUpdate(cd);
				if(m!=0){
					backNews="进货成功";
					userBean.setBackNews(backNews);
					userBean.setShopname(shopname);
					userBean.setLast(rs.getString(last));
					}
				else{
					backNews="进货信息不正确或有非法字符";
					userBean.setBackNews(backNews);
					}
				conn.close();
			}
			else{
				conn.close();
				con=DriverManager.getConnection(uri);
				String insertCondition="insert into shangpin(shopname,stockprice,stocknum,date,address,cashier) values(?, ?, ?, ?, ?, ?)";
				sql=con.prepareStatement(insertCondition);
				sql.setString(1, shopname);
				sql.setString(2, stockprice);
				sql.setString(3, stocknum); 
				sql.setString(4, date);
				sql.setString(5, address);
				sql.setString(6, cashier); 
				int m=sql.executeUpdate();
				if(m!=0){
					backNews="进货成功";
					String cd="update shangpin set last='"+stocknum+"' where shopname='"+shopname+"'";
					sql.executeUpdate(cd);
					userBean.setBackNews(backNews);
					userBean.setShopname(shopname);
					userBean.setLast(stocknum);
				}else{
					backNews="进货信息不正确或有非法字符";
					userBean.setBackNews(backNews);
				}
			con.close();
			}
		}
		catch(Exception e){
			backNews="日期，地址或出纳员填写不正确！";
			userBean.setBackNews(backNews);
			userBean.setShopname(shopname);
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("stock.jsp");
		dispatcher.forward(req, resp);
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
