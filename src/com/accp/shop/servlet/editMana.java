package com.accp.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accp.shop.dao.ManaDAO;

public class editMana extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public editMana() {
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
ManaDAO manaDAO=new ManaDAO();
ArrayList lt=new ArrayList();
String mana_name=request.getParameter("mana_name");
HttpSession session=request.getSession();
if(request.getParameter("mana_name")==null){
try{

	
	lt=manaDAO.editMana((String)session.getAttribute("manager"));
	request.setAttribute("list",lt);
	  javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editMana.jsp");
      requestDispatcher.forward(request,response);
}catch(Exception e){
	
}}else {
	lt=manaDAO.editMana(mana_name);
	session.setAttribute("mana_name",mana_name);
	request.setAttribute("list",lt);
	  javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editMana.jsp");
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
