package com.accp.shop.servlet;

import com.accp.shop.pojo.provider;
import com.accp.shop.dao.providerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deleteProType extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public deleteProType() {
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
		  provider pro1=new provider();
		  //为jopo传值
		        pro1.setPro_Id(request.getParameter("id"));

		       
		        try
		        {
		        	//实例话DAO
		         providerDAO proBean=new providerDAO();
		         //調用
		           proBean.delectPro(pro1);
		        }
		        catch(Exception e)
		        {
		        }
		        javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/proType");
	             requestDispatcher.forward(request,response);
	
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
