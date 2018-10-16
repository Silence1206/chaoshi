package com.serv.www;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandleSale extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			//System.out.print("cheng");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("gb2312");
		resp.setCharacterEncoding("gb2312");
		String uri="jdbc:mysql://localhost/chaoshi?user=root&password=12345678";
		Connection conn,co;
		Statement sql,sq;
		ResultSet rs,r;
		Stock userBean=new Stock();
		req.setAttribute("userBean", userBean); 
		String saleshopname=req.getParameter("shopname").trim();
		float saleprice=Float.parseFloat(req.getParameter("saleprice").trim());
		int salenum=Integer.valueOf(req.getParameter("salenum").trim());
		String backNews="";
		try{
		conn=DriverManager.getConnection(uri);
		sql=conn.createStatement();
		co=DriverManager.getConnection(uri);
		sq=co.createStatement();
		String cdn="select stockprice,stocknum,total,last,lirun from shangpin where shopname='"+saleshopname+"'";
		//System.out.print(cdn);
		rs=sql.executeQuery(cdn);
			if(rs.next())
			{
				//System.out.print(rs);
				String stockpric=rs.getString(1);
				//System.out.print(stockpric);
				String stocknu=rs.getString(2);
				//System.out.print(stocknu);
				String tota=rs.getString(3);
				//System.out.print(tota);
				String las=rs.getString(4);
				//System.out.print(las);
				String liru=rs.getString(5);
				//System.out.print(liru);
				float stockprice=Float.parseFloat(stockpric);
				int stocknum=Integer.valueOf(stocknu);
				if(stocknum<salenum)
				{
					backNews="库存不足！";
					userBean.setBackNews(backNews);
				}
				else
				{
					if((tota==null)&&(liru==null))
					{
						tota="0";liru="0";
					}
					float total=Float.parseFloat(tota);
					int last=Integer.valueOf(las);
					float lirun=Float.parseFloat(liru);	
					//System.out.print(rs);
					String cd="update shangpin set " +
							"saleprice='"+saleprice+"',"+
							"salenum='"+salenum+"',"+
							"total = '"+(total+(saleprice*salenum))+"'," +
							"lirun = '"+(lirun+((saleprice-stockprice)*salenum))+"'," +
							"last = '"+(last-salenum)+"' "+
							"where shopname='"+saleshopname+"'";
					//System.out.print(cd);
					int m=sql.executeUpdate(cd);
					if(m!=0)
					{
						backNews="销售成功";
						String c="select total,lirun,last from shangpin where shopname='"+saleshopname+"'";
						r=sq.executeQuery(c);
						System.out.print(c);
						userBean.setBackNews(backNews);
						userBean.setTotal(r.getString(1));
						userBean.setLirun(r.getString(2));
						userBean.setLast(r.getString(3));
						
					}
				}
			}
			else
			{
				backNews="没有找到该商品！";
				userBean.setBackNews(backNews);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			backNews="连接数据库失败！";
			userBean.setBackNews(backNews);
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("sale.jsp");
		dispatcher.forward(req, resp);
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}