package com.accp.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.shop.dao.ManaDAO;
import com.accp.shop.pojo.Manager;

public class newMana extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public newMana() {
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
Manager  mana=new Manager();
mana.setMana_name(request.getParameter("name"));
mana.setMana_pwd(request.getParameter("pwd"));
mana.setMana_sex(request.getParameter("sex"));
mana.setMana_age(request.getParameter("age"));
mana.setMana_dep(request.getParameter("Mana_DepID"));
mana.setMana_tel(request.getParameter("tel"));
mana.setMana_address(request.getParameter("address"));
try{
	ManaDAO manaDAO=new ManaDAO();
	manaDAO.newManager(mana);
	javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/manaView");
	requestDispatcher.forward(request,response);
}catch(SQLException eb){
	request.setAttribute("newMana","1");
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
