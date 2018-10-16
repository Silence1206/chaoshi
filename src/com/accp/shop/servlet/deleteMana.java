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

public class deleteMana extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public deleteMana() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name=request.getParameter("mana_name");
		ManaDAO manaDAO=new ManaDAO();
	
		Manager mana=new Manager();
		mana.setMana_name(name);
		HttpSession session=request.getSession();
		String sessionValue=(String)session.getAttribute("manager");
	
		if(!sessionValue.equals(name)){
		try{
			manaDAO.deleinfo(mana);
		      javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/manaView");
	             requestDispatcher.forward(request,response);
		}catch (Exception e) {
			// TODO: handle exception
		}
		}else{
			request.setAttribute("error","1");
		      javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/manaView");
	             requestDispatcher.forward(request,response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
