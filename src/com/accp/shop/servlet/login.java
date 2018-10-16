package com.accp.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accp.shop.dao.ManaDAO;
import com.accp.shop.pojo.Manager;

public class login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public login() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		Manager mana=new Manager();
		try{	
			ManaDAO manDAO=new ManaDAO();
			mana=manDAO.Check(name,pwd);
			if(mana!=null){
			HttpSession session=request.getSession();
			session.setAttribute("manager",name);
			session.setAttribute("popedom",mana.getPopedom());
			}else{
				request.setAttribute("error","请检查你的用户命和密码！");
		        javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
		           requestDispatcher.forward(request,response);
			}
			   javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/CargoListConf");
	           requestDispatcher.forward(request,response);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
