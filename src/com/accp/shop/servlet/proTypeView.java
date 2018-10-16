package com.accp.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.shop.dao.providerDAO;
import com.accp.shop.pojo.provider;

public class proTypeView extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public proTypeView() {
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

		ArrayList lt = new ArrayList();
		provider pro = new provider();
	String type=request.getParameter("type");
	String typeView=(String) request.getAttribute("typeView");
	System.out.println("++++++++++++++");
	System.out.println(type);
	request.setAttribute("errorMessage",request.getAttribute("errorMessage"));
	if(type!=null){
		try {
			// 实例话DAO
			providerDAO proBean = new providerDAO();
			// 調用
			lt = proBean.type(type);
			request.setAttribute("list", lt);

		} catch (Exception e) {

		}
		javax.servlet.RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/proTypeView.jsp");
		requestDispatcher.forward(request, response);
	}
	if(typeView!=null){
		try {
			// 实例话DAO
			providerDAO proBean = new providerDAO();
			// 調用
			lt = proBean.type(typeView);
			request.setAttribute("list", lt);

		} catch (Exception e) {

		}
		javax.servlet.RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/proTypeView.jsp");
		requestDispatcher.forward(request, response);
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
