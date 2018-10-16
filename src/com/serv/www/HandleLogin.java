package com.serv.www;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class HandleLogin extends HttpServlet{
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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("gb2312");
		resp.setCharacterEncoding("gb2312");
		Connection conn;
		Statement sql;
		String user=req.getParameter("user").trim();
		String password=req.getParameter("password").trim();
		String uri="jdbc:mysql://localhost/chaoshi?user=root&password=12345678";
		boolean boo=(user.length()>0)&&(password.length()>0);
		try{
			conn=DriverManager.getConnection(uri);
			String condition="select * from yonghu where user='"+user+"' and password='"+password+"'";
			sql=conn.createStatement();
			if(boo){
				ResultSet rs=sql.executeQuery(condition);
				boolean m=rs.next();
				if(m==true){
					success(req, resp, user, password);
					RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
					dispatcher.forward(req, resp);
				}else{
					String backNews="用户名或密码错误";
					fail(req, resp, user, backNews);
				}
			}else{
				String backNews="请输入用户名和密码";
				fail(req, resp, user, backNews);
			}
			conn.close();
		}catch(Exception e){
			String backNews=""+e;
			fail(req, resp, user, backNews);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	public void success(HttpServletRequest req, HttpServletResponse resp, String logname, String password){
		Login loginBean=null;
		HttpSession session=req.getSession(true);
		try{
			loginBean=(Login)session.getAttribute("loginBean");
			if(loginBean==null){
				loginBean=new Login();
				session.setAttribute("loginBean", loginBean);
				loginBean=(Login)session.getAttribute("loginBean");
			}
			String name=loginBean.getLogname();
			if(name.equals(logname)){
				loginBean.setBackNews(logname+"已经登录");
				loginBean.setLogname(logname);
			}else{
				loginBean.setBackNews(logname+"登录成功");
				loginBean.setLogname(logname);
			}
		}catch(Exception e){
			loginBean=new Login();
			session.setAttribute("loginBean", loginBean);
			loginBean.setBackNews(logname+"登录成功");
			loginBean.setLogname(logname);
		}
	}
	public void fail(HttpServletRequest req, HttpServletResponse resp, String logname, String backNews){
		resp.setContentType("text/html; charset=gb2312");
		try{
			PrintWriter out=resp.getWriter();
			out.println("<html><body>");
			out.println("<h2>"+logname+"登录反馈结果：<br/>"+backNews+"</h2>");
			out.println("返回登录界面或主页<br/>");
			out.println("<a href=\"login.jsp\">登录界面</a>");
			out.println("<br/><a href=\"index.jsp\">主页</a>");
			out.println("</body></html>");
		}catch(Exception e){}
	}
}