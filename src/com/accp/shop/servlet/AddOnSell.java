package com.accp.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.shop.dao.StorageDAO;

public class AddOnSell extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddOnSell() {
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

			doPost(request,response);
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
		String id=request.getParameter("id");
		StorageDAO check=new StorageDAO();
		boolean exit=check.checkID(id);
		if(exit){
			ArrayList list=check.IDIsExist(id);
			request.setAttribute("list", list);
			this.getServletContext().getRequestDispatcher("/AddSell_do.jsp").forward(request, response);
		}else{
			int storageNum=check.getStorageNum(id);
			request.setAttribute("id", id);
			request.setAttribute("num", storageNum);
//			System.out.println(request.getAttribute("num"));
			this.getServletContext().getRequestDispatcher("/AddSell_new.jsp").forward(request, response);
			
		}
		//request.setAttribute("addlist", list);
		
		
		
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
