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

public class HandleCz extends HttpServlet{
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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("gb2312");
		resp.setCharacterEncoding("gb2312");
		String uri="jdbc:mysql://localhost/chaoshi?user=root&password=12345678";
		Connection conn;
		Statement sql;
		ResultSet rs;
		Register userBean=new Register();
		req.setAttribute("userBean", userBean); 
		String phone=req.getParameter("phone").trim();
		String money=req.getParameter("money").trim();
		String backNews="";
		//System.out.print(phone);
		try{
		conn=DriverManager.getConnection(uri);
		sql=conn.createStatement();
		String cdn="select user,money from yonghu where phone='"+phone+"'";
		//System.out.print(cdn);
		rs=sql.executeQuery(cdn);
			if(rs.next()){
				String user=rs.getString(1);
				String mone=rs.getString(2);
				//System.out.print(rs);
				if((mone==null))
				{
					mone="0";
				}	
				float mon=Float.parseFloat(money);
				String cd="update yonghu set money='"+(mone+mon)+"' where phone='"+phone+"'";
				int m=sql.executeUpdate(cd);
				if(m!=0){
					backNews="充值成功";
					userBean.setBackNews(backNews);
					userBean.setUser(user);
					userBean.setMoney(money);
				}
			}
			else
			{
				backNews="您输入的手机号有误！";
				userBean.setBackNews(backNews);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			backNews="连接数据库失败！";
			userBean.setBackNews(backNews);
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("cz.jsp");
		dispatcher.forward(req, resp);
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}