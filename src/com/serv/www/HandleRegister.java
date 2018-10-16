package com.serv.www;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandleRegister extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){}
	}
	public String handleString(String s) {
		// TODO Auto-generated method stub
		try{byte bb[]=s.getBytes("utf-8");
			s=new String(bb);
		}catch(Exception ee){}
		return s;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req.setCharacterEncoding("gb2312");
		//resp.setCharacterEncoding("gb2312");
		String uri="jdbc:mysql://localhost/chaoshi?user=root&password=12345678";
		Connection conn;
		PreparedStatement sql;
		Register userBean=new Register();
		req.setAttribute("userBean", userBean);
		String user=req.getParameter("user").trim();
		String password=req.getParameter("password").trim();
		String again_password=req.getParameter("again_password").trim();
		String address=req.getParameter("address").trim();
		String phone=req.getParameter("phone").trim();
		String realname=req.getParameter("realname").trim();
		if(user==null)
		{
			user="";
		}
		if(password==null)
		{
			password="";
		}
		if(!password.equals(again_password)){
			userBean.setBackNews("两次密码不同，注册失败");
			RequestDispatcher dispatcher=req.getRequestDispatcher("inputRegisterMess.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		boolean isLD=true;
		for(int i=0;i<user.length();i++){ 
			char c=user.charAt(i);
			if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0')))
				isLD=false;
		}
		boolean boo=user.length()>0&&password.length()>0&&isLD;
		String backNews="";
		try{
			conn=DriverManager.getConnection(uri);
			String insertCondition="insert into yonghu(user,password,address,phone,realname) values(?, ?, ?, ?, ?)";
			sql=conn.prepareStatement(insertCondition);
			if(boo){
				sql.setString(1, handleString(user));
				sql.setString(2, handleString(password));
				sql.setString(3, handleString(address)); 
				sql.setString(4, handleString(phone));
				sql.setString(5, handleString(realname)); 
				int m=sql.executeUpdate();
				if(m!=0){
					backNews="注册成功";
					userBean.setBackNews(backNews);
					userBean.setUser(user);
					userBean.setAddress(address);
				}
			}else{
				backNews="用户名信息不正确或有非法字符";
				userBean.setBackNews(backNews);
			}
			conn.close();
		}catch(Exception e){
			backNews="该会员名已被注册";
			userBean.setBackNews(backNews);
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("inputRegisterMess.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
